package featureselection.research.web.mybatismapper;

import featureselection.research.web.entity.DatasetForm;
import featureselection.research.web.entity.TaskInfo;
import featureselection.research.web.entity.TaskResult;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/11 15:03
 */
@Mapper
@Repository
public interface ExecutionFormsMapper {

    @Insert("insert into dataset_form(account_id,input_name,input_description,input_href,input_preprocess,input_algorithm,input_file) " +
            "values (#{accountId},#{inputName},#{inputDescription},#{inputHref},#{inputPreprocess},#{inputAlgorithm},#{inputFile})")
    void addDatasetForm(DatasetForm datasetForm);

    @Select("select * from dataset_form where account_id = #{accountId}")
    List<DatasetForm> getDatasetForm(long accountId);

    @Insert("insert into task_info(account_id,task_name,task_comment,task_email,algorithm_id,algorithm_parameters,dataset_id,dataset_upload)" +
            "values (#{accountId},#{taskName},#{taskComment},#{taskEmail},#{algorithmId},#{algorithmParameters},#{datasetId},#{datasetUpload})")
    @SelectKey(statement = "select last_insert_id()" ,keyProperty = "taskId",keyColumn = "task_id",resultType = long.class,before = false)
    void addTaskInfo(TaskInfo taskInfo);

    @Select("select * from task_info where account_id = #{accountId}")
    List<TaskInfo> getTaskListByAccountId(long accountId);

    @Select("select count(dataset_name) from dataset where dataset_name = #{datasetName}")
    int queryDatasetName(String datasetName);

    @Select("select count(input_name) from dataset_form where input_name = #{datasetName}")
    int queryDatasetFormName(String datasetName);

    @Select("select count(task_name) from task_info where task_name = #{taskName} and account_id = #{accountId}")
    int queryTaskName(String taskName,long accountId);

    @Insert("update task_info set task_name = #{taskName},task_email = #{taskEmail},task_comment = #{taskComment} where task_id = #{taskId};")
    int updateTaskInfo(long taskId,String taskName,String taskEmail,String taskComment);

    @Delete("delete from task_info where task_id = #{taskId}")
    int deleteTask(long taskId);

    @Select("select * from task_result where task_id = #{taskId}")
    List<TaskResult> getTaskResults(long taskId);
}
