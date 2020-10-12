package featureSelection.research.web.service.execution.visitor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import featureSelection.research.web.common.service.ExecutionRabbitmqComServiceSingleton;
import featureSelection.research.web.common.util.CSVUtill;
import featureSelection.research.web.common.util.FileUploadUtil;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.ExecutionRabbitmqComInfo;
import featureSelection.research.web.entity.execution.visitor.DatasetForm;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.entity.execution.visitor.TaskResult;
import featureSelection.research.web.entity.execution.visitor.TaskResultFormat;
import featureSelection.research.web.entity.execution.visitor.parameterFormat.AlgorithmInfo;
import featureSelection.research.web.entity.execution.visitor.parameterFormat.ParameterFormat;
import featureSelection.research.web.mybatisMapper.execution.visitor.*;
import featureSelection.research.web.service.execution.visitor.IExecutionFormsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/21 17:27
 */
@Service
public class ExecutionFormsServiceImpl implements IExecutionFormsService {

    @Autowired
    private AlgorithmMapper algorithmMapper;

    @Autowired
    private DatasetMapper datasetMapper;

    @Autowired
    private DatasetFormMapper datasetFormMapper;

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Autowired
    private TaskResultMapper taskResult;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ParameterMapper parameterMapper;

    @Autowired
    private FileUploadUtil fileUpload;

    @Autowired
    private CSVUtill csvUtill;

    private Logger logger = LoggerFactory.getLogger(ExecutionFormsServiceImpl.class);

    @Override
    public String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path) {
        //存储数据集到本地
        String uploadResult = fileUpload.uploadFIle(uploadFile, path);
        if (!"fail".equals(uploadResult)) {
            dataset.setInputFile(uploadResult);
            datasetFormMapper.addDatasetForm(dataset);
            logger.info("向DatasetForm表添加一个id为："+dataset.getInputId() + "字段");
            return "success";
        }
        return "fail";
    }

    @Override
    public List<DatasetForm> getDatasetForms(int accountId) {
        return datasetFormMapper.getDatasetForm(accountId);
    }

    @Override
    public String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path) throws JsonProcessingException {
        String filePath = null;
        ParameterFormat parameterFormat = new ParameterFormat();
        //判断算法任务是否是使用用户上传的数据集
        if (task.getDatasetId() == 0) {
            //存储数据集到本地
            filePath = fileUpload.uploadFIle(uploadFile, path);
            task.setDatasetUpload(filePath);
            task.setDatasetId(null);
            parameterFormat.setColumn(csvUtill.getDimensionByFilePath("src\\main\\resources\\"+filePath));
            parameterFormat.setDatasetName(filePath.substring(filePath.lastIndexOf(File.separator)+1));
        }else {
            parameterFormat.setColumn(datasetMapper.getDatasetDimensionById(task.getDatasetId()));
            parameterFormat.setDatasetName(datasetMapper.getDatasetNameById(task.getDatasetId()));
        }
        //获取算法名称映射的值
        String algorithmName = algorithmMapper.getAlgorithmNameMapperById(task.getAlgorithmId());
        parameterFormat.setId(algorithmName+"-"+String.valueOf(System.currentTimeMillis()).substring(0,10));
        parameterFormat.setPart(0);
        parameterFormat.setPartDataSize(0);
        AlgorithmInfo algorithmInfo = new AlgorithmInfo(algorithmName,objectMapper.readValue(task.getAlgorithmParameters(),Object.class));
        parameterFormat.setAlgorithmInfo(algorithmInfo);
        parameterFormat.setPreviousReducts(null);
        parameterFormat.setRunTimes(1);
        parameterFormat.setAttributes(parameterMapper.getParamsIdByAlgorithmId(task.getAlgorithmId()));
        task.setAlgorithmParameters(objectMapper.writeValueAsString(parameterFormat));
        //加入到任务队列中
        taskInfoMapper.addTaskInfo(task);
        ExecutionRabbitmqComInfo executionRabbitmqComInfo=new ExecutionRabbitmqComInfo(task.getTaskId());
        ExecutionRabbitmqComServiceSingleton.addExecutionRabbitmqComInfo(executionRabbitmqComInfo);

        return String.valueOf(task.getTaskId());
    }

    @Override
    public List<TaskInfo> getTaskListByAccountId(int accountId) {
        return taskInfoMapper.getTaskListByAccountId(accountId);
    }

    @Override
    public String queryDatasetName(String datasetName) {
        if (datasetMapper.queryDatasetName(datasetName) == 0) {
            if (datasetFormMapper.queryDatasetFormName(datasetName) == 0) {
                return "0";
            }
        }
        return "exist";
    }

    @Override
    public String queryTaskName(String taskName, int accountId) {
        if (taskInfoMapper.queryTaskName(taskName, accountId) == 0) {
            return "0";
        }
        return "exist";
    }

    @Override
    public String updateTask(int taskId, String taskName, String taskEmail, String taskComment) {
        if (taskInfoMapper.updateTaskInfo(taskId, taskName, taskEmail, taskComment) == 1) {
            logger.info("TaskId为" + taskId + "被修改了");

            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public String deleteTask(int taskId) {
        int i = taskInfoMapper.deleteTask(taskId);
        if (i == 1) {
            logger.info("TaskId为" + taskId + "被删除了");
        }
        return String.valueOf(i);
    }

    @Override
    public TaskResultFormat getTaskResults(int taskId) throws JsonProcessingException {
        List<int[]> resultList = new ArrayList<>();
        TaskResultFormat resultFormat = new TaskResultFormat();

        String taskSetting = taskInfoMapper.getTaskSettingById(taskId);
        JsonNode taskSettingTree = objectMapper.readTree(taskSetting);
        int column = taskSettingTree.get("column").asInt();
        resultFormat.setDatasetDimension(column);

        List<TaskResult> taskResults = taskResult.getTaskResults(taskId);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, int[].class);
        for (TaskResult taskResult : taskResults) {
            JsonNode jsonNode = objectMapper.readTree(taskResult.getResultVal());
            JsonNode reductsNode = jsonNode.findValue("reducts");
            if (reductsNode.isObject()) {
                Iterator<JsonNode> reductsNodeIterator = reductsNode.iterator();
                if (reductsNodeIterator.hasNext()) {
                    JsonNode reductsNodeNext = reductsNodeIterator.next();
                    Iterator<JsonNode> reductsIterator = reductsNodeNext.elements();
                    while (reductsIterator.hasNext()) {
                        JsonNode reductsNext = reductsIterator.next();
                        int[] result = objectMapper.readValue(reductsNext.toString(), int[].class);
                        resultList.add(result);
                    }
                }

            } else {
                Iterator<JsonNode> reductsIterator = jsonNode.withArray("reducts").elements();
                while (reductsIterator.hasNext()) {
                    JsonNode reductsNext = reductsIterator.next();
                    int[] result = objectMapper.readValue(reductsNext.toString(), int[].class);
                    resultList.add(result);
                }
            }
        }

        resultFormat.setResultList(resultList);
        return resultFormat;
    }

}
