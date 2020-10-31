package featureSelection.research.web.service.execution.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import featureSelection.research.web.entity.execution.visitor.DatasetForm;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.entity.execution.visitor.TaskResultFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Execution系统中有关表单Service
 * @author Stephen
 * @date 2020/4/21 17:23
 */
public interface IExecutionFormsService {

    /**
     * 上传算法任务表单
     * @param dataset 数据集表单对象
     * @param uploadFile 数据集文件
     * @param path 数据集文件存储路径
     * @return String "success"或者"failed"
     */
    String uploadDatasetForm(DatasetForm dataset, MultipartFile uploadFile, String path);

    /**
     * 通过用户id获取数据集上传对象
     * @param accountId 算法id
     * @return List<DatasetForm> 数据集上传表单对象数组
     */
    List<DatasetForm> getDatasetForms(int accountId);

    /**
     * 上传算法任务表单
     * @param task 算法任务对象
     * @param uploadFile 数据集文件
     * @param path 数据集文件存储路径
     * @return String "success"或"failed"
     * @throws JsonProcessingException
     */
    String submitTaskForm(TaskInfo task, MultipartFile uploadFile, String path) throws IOException;

    /**
     * 通过用户id获取所有算法任务
     * @param accountId 用户id
     * @return List<TaskInfo> 算法任务对象数组
     */
    List<TaskInfo> getTaskListByAccountId(int accountId);

    /**
     * 查询数据库中是否含有某数据集名称
     * @param datasetName 待查询的数据集名称
     * @return String "0"或"exist"
     */
    String queryDatasetName(String datasetName);

    /**
     * 查询数据库中某用户是否含有某算法任务名称
     * @param taskName 算法任务名称
     * @param accountId 用户od
     * @return String "0"或"exist"
     */
    String queryTaskName(String taskName, int accountId);

    /**
     * 更新算法任务
     * @param taskId 算法任务id
     * @param taskName 算法任务名称
     * @param taskEmail 邮箱
     * @param taskComment 算法任务备注
     * @return String "success"或"failed"
     */
    String updateTask(int taskId, String taskName, String taskEmail, String taskComment);

    /**
     * 删除算法任务
     * @param taskId 算法任务id
     * @return String "0"或"1"
     */
    String deleteTask(int taskId);

    /**
     * 获取算法结果
     * @param taskId 算法任务id
     * @return List<TaskResult>算法结果对象数组
     */
    TaskResultFormat getTaskResults(int taskId) throws JsonProcessingException;

    int uploadAlgDoc (Integer algorithmId,MultipartFile file,String path);
}
