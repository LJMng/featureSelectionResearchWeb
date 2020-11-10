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
import java.io.IOException;
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
    public String submitTaskForm(TaskInfo task, MultipartFile[] uploadFile, String path) throws IOException {
        List<String> filePath = null;
        ParameterFormat parameterFormat = new ParameterFormat();
        //判断算法任务是否是使用用户上传的数据集
        if (task.getDatasetId() == 0) {
            //存储数据集到本地
            filePath = fileUpload.uploadFiles(uploadFile, path);
            if (filePath.size() > 1) {
                parameterFormat.setPart(1);
                parameterFormat.setPartDataSize(1);
            } else {
                parameterFormat.setPart(0);
                parameterFormat.setPartDataSize(0);
            }
            //根据数据集的维度生成Attribute的值
            int columnNum = csvUtill.getDimensionByFilePath(filePath.get(0));
            int[] attributes = new int[columnNum-1];
            for (int i=0; i<attributes.length; i++){
                attributes[i] = i+1;
            }
            task.setDatasetUpload(objectMapper.writeValueAsString(filePath));
            task.setDatasetId(null);
            parameterFormat.setColumn(columnNum);
            parameterFormat.setDatasetName(filePath.get(0).substring(filePath.get(0).lastIndexOf(File.separator)+1));
            parameterFormat.setAttributes(attributes);
        }else {
            int columnNum = datasetMapper.getDatasetDimensionById(task.getDatasetId());
            int[] attributes = new int[columnNum-1];
            for (int i = 0; i<attributes.length; i++) {
                attributes[i] = i+1;
            }
            parameterFormat.setColumn(columnNum);
            parameterFormat.setDatasetName(datasetMapper.getDatasetNameById(task.getDatasetId()));
            parameterFormat.setAttributes(attributes);
            parameterFormat.setPartDataSize(0);
            parameterFormat.setPart(0);
        }
        //获取算法名称映射的值
        String algorithmName = algorithmMapper.getAlgorithmNameMapperById(task.getAlgorithmId());
        parameterFormat.setId(algorithmName+"-"+String.valueOf(System.currentTimeMillis()).substring(0,10));
        AlgorithmInfo algorithmInfo = new AlgorithmInfo(algorithmName,objectMapper.readValue(task.getAlgorithmParameters(),Object.class));
        parameterFormat.setAlgorithmInfo(algorithmInfo);
        parameterFormat.setPreviousReducts(null);
        parameterFormat.setRunTimes(1);
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
        for (TaskResult taskResult : taskResults) {
            JsonNode jsonNode = objectMapper.readTree(taskResult.getResultVal());
            if (jsonNode.isArray()) {
                Iterator<JsonNode> jsonIterator = jsonNode.iterator();
                while (jsonIterator.hasNext()) {
                    resultList.addAll(getTaskResultFormat(jsonIterator.next()));
                }
            } else {
                resultList.addAll(getTaskResultFormat(jsonNode));
            }
        }
        resultFormat.setResultList(resultList);
        return resultFormat;
    }

    @Override
    public int uploadAlgDoc(Integer algorithmId, MultipartFile file, String path) throws JsonProcessingException {
        String algorithmName = algorithmMapper.getAlgorithmNameById(algorithmId);
        String uploadedPath = fileUpload.uploadFIle(file, path+algorithmName+File.separator);
        String algorithmDoc = algorithmMapper.getAlgorithmDocById(algorithmId);
        List<String> currentDocs = null;
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, String.class);
        int i = 0;
        if (algorithmDoc == null || algorithmDoc.equals("")) {
            currentDocs = new ArrayList<>();
            currentDocs.add(uploadedPath);
        } else {
            currentDocs = objectMapper.readValue(algorithmDoc, javaType);
            currentDocs.add(uploadedPath);
        }
        i = algorithmMapper.uploadAlgDocById(algorithmId, objectMapper.writeValueAsString(currentDocs));
        return i;
    }

    private List<int[]> getTaskResultFormat(JsonNode jsonNode) throws JsonProcessingException {
        List<int[]> resultList = new ArrayList<> ();
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
        return resultList;
    }

}
