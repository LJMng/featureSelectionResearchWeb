package featureselection.research.web.service.execution.visitor.impl;

import featureselection.research.web.common.FileUploadUtil;
import featureselection.research.web.entity.DatasetForm;
import featureselection.research.web.entity.TaskInfo;
import featureselection.research.web.entity.TaskResult;
import featureselection.research.web.mybatismapper.ExecutionFormsMapper;
import featureselection.research.web.service.execution.visitor.IExecutionFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/21 17:27
 */
@Service
public class ExecutionFormsServiceImpl implements IExecutionFormsService {

    @Autowired
    ExecutionFormsMapper formsMapper;

    @Autowired
    FileUploadUtil fileUpload;


    @Override
    public String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path) {
        String uploadResult = fileUpload.uploadFIle(uploadFile, path);
        if (!"fail".equals(uploadFile)) {
            dataset.setInputFile(uploadResult);
            formsMapper.addDatasetForm(dataset);
            return "success";
        }
        return "fail";
    }

    @Override
    public List<DatasetForm> getDatasetForms(long accountId) {
        return formsMapper.getDatasetForm(accountId);
    }

    @Override
    public String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path) {
        if (task.getDatasetId() == 0) {
            String resultPath = fileUpload.uploadFIle(uploadFile, path);
            task.setDatasetUpload(resultPath);
            task.setDatasetId(null);
        }
        formsMapper.addTaskInfo(task);
        return String.valueOf(task.getTaskId());
    }

    @Override
    public List<TaskInfo> getTaskListByAccountId(long accountId) {
        return formsMapper.getTaskListByAccountId(accountId);
    }

    @Override
    public String queryDatasetName(String datasetName) {
        if (formsMapper.queryDatasetName(datasetName) == 0) {
            if (formsMapper.queryDatasetFormName(datasetName) == 0) {
                return "0";
            }
        }
        return "exist";
    }

    @Override
    public String queryTaskName(String taskName, long accountId) {
        if (formsMapper.queryTaskName(taskName, accountId) == 0) {
            return "0";
        }
        return "exist";
    }

    @Override
    public String updateTask(long taskId, String taskName, String taskEmail, String taskComment) {
        if (formsMapper.updateTaskInfo(taskId, taskName, taskEmail, taskComment) == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @Override
    public String deleteTask(long taskId) {
        return String.valueOf(formsMapper.deleteTask(taskId));
    }

    @Override
    public List<TaskResult> getTaskResults(long taskId) {
        return formsMapper.getTaskResults(taskId);
    }

}
