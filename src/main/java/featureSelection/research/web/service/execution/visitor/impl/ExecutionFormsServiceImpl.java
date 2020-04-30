package featureSelection.research.web.service.execution.visitor.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import featureSelection.research.web.common.FileUploadUtil;
import featureSelection.research.web.entity.DatasetForm;
import featureSelection.research.web.entity.TaskInfo;
import featureSelection.research.web.entity.TaskResult;
import featureSelection.research.web.entity.parameterFormat.AlgorithmInfo;
import featureSelection.research.web.entity.parameterFormat.ParameterFormat;
import featureSelection.research.web.mybatismapper.execution.visitor.*;
import featureSelection.research.web.service.execution.visitor.IExecutionFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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


    @Override
    public String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path) {
        String uploadResult = fileUpload.uploadFIle(uploadFile, path);
        if (!"fail".equals(uploadFile)) {
            dataset.setInputFile(uploadResult);
            datasetFormMapper.addDatasetForm(dataset);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<DatasetForm> getDatasetForms(long accountId) {
        return datasetFormMapper.getDatasetForm(accountId);
    }

    @Override
    public String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path) throws JsonProcessingException {
        String filePath = null;
        ParameterFormat parameterFormat = new ParameterFormat();
        if (task.getDatasetId() == 0) {
            filePath = fileUpload.uploadFIle(uploadFile, path);
            task.setDatasetUpload(filePath);
            task.setDatasetId(null);
            parameterFormat.setColumn(11);
            parameterFormat.setDatasetName(filePath.substring(filePath.lastIndexOf(File.separator)+1));
        }
        String algorithmName = algorithmMapper.getAlgorithmNameById(task.getAlgorithmId());
        parameterFormat.setId(algorithmName+"-"+String.valueOf(System.currentTimeMillis()).substring(0,10));
        parameterFormat.setPart(0);
        parameterFormat.setColumn(datasetMapper.getDatasetDimensionById(task.getDatasetId()));
        parameterFormat.setPartDataSize(0);
        AlgorithmInfo algorithmInfo = new AlgorithmInfo(algorithmName,objectMapper.readValue(task.getAlgorithmParameters(),Object.class));
        parameterFormat.setAlgorithmInfo(algorithmInfo);
        parameterFormat.setPreviousReducts(null);
        parameterFormat.setRunTimes(1);
        parameterFormat.setAttributes(parameterMapper.getParamsIdByAlgorithmId(task.getAlgorithmId()));
        task.setAlgorithmParameters(objectMapper.writeValueAsString(parameterFormat));
        taskInfoMapper.addTaskInfo(task);
        return String.valueOf(task.getTaskId());
    }

    @Override
    public List<TaskInfo> getTaskListByAccountId(long accountId) {
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
    public String queryTaskName(String taskName, long accountId) {
        if (taskInfoMapper.queryTaskName(taskName, accountId) == 0) {
            return "0";
        }
        return "exist";
    }

    @Override
    public String updateTask(long taskId, String taskName, String taskEmail, String taskComment) {
        if (taskInfoMapper.updateTaskInfo(taskId, taskName, taskEmail, taskComment) == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public String deleteTask(long taskId) {
        return String.valueOf(taskInfoMapper.deleteTask(taskId));
    }

    @Override
    public List<TaskResult> getTaskResults(long taskId) {
        return taskResult.getTaskResults(taskId);
    }

}
