package featureselection.research.web.service.execution.visitor;

import featureselection.research.web.entity.DatasetForm;
import featureselection.research.web.entity.TaskInfo;
import featureselection.research.web.entity.TaskResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/21 17:23
 */
public interface IExecutionFormsService {

    String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path);

    List<DatasetForm> getDatasetForms(long accountId);

    String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path);

    List<TaskInfo> getTaskListByAccountId(long accountId);

    String queryDatasetName(String datasetName);

    String queryTaskName(String taskName, long accountId);

    String updateTask(long taskId, String taskName, String taskEmail, String taskComment);

    String deleteTask(long taskId);

    List<TaskResult> getTaskResults(long taskId);
}
