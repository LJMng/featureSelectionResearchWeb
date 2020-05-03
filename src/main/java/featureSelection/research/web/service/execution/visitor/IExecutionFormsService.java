package featureSelection.research.web.service.execution.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import featureSelection.research.web.entity.execution.visitor.DatasetForm;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.entity.execution.visitor.TaskResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/21 17:23
 */
public interface IExecutionFormsService {

    String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path);

    List<DatasetForm> getDatasetForms(int accountId);

    String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path) throws JsonProcessingException;

    List<TaskInfo> getTaskListByAccountId(int accountId);

    String queryDatasetName(String datasetName);

    String queryTaskName(String taskName, int accountId);

    String updateTask(int taskId, String taskName, String taskEmail, String taskComment);

    String deleteTask(int taskId);

    List<TaskResult> getTaskResults(int taskId);
}
