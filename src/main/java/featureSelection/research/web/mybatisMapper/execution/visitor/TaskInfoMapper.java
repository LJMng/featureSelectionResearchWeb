package featureSelection.research.web.mybatismapper.execution.visitor;

import featureSelection.research.web.entity.TaskInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/28 15:50
 */
@Mapper
@Repository
public interface TaskInfoMapper {

    @Insert("insert into task_info(account_id,task_name,task_comment,task_email,algorithm_id,algorithm_parameters,dataset_id,dataset_upload)" +
            "values (#{accountId},#{taskName},#{taskComment},#{taskEmail},#{algorithmId},#{algorithmParameters},#{datasetId},#{datasetUpload})")
    @SelectKey(statement = "select last_insert_id()" ,keyProperty = "taskId",keyColumn = "task_id",resultType = long.class,before = false)
    void addTaskInfo(TaskInfo taskInfo);

    @Select("select * from task_info where account_id = #{accountId}")
    List<TaskInfo> getTaskListByAccountId(long accountId);

    @Select("select count(task_name) from task_info where task_name = #{taskName} and account_id = #{accountId}")
    int queryTaskName(String taskName,long accountId);

    @Insert("update task_info set task_name = #{taskName},task_email = #{taskEmail},task_comment = #{taskComment} where task_id = #{taskId};")
    int updateTaskInfo(long taskId,String taskName,String taskEmail,String taskComment);

    @Delete("delete from task_info where task_id = #{taskId}")
    int deleteTask(long taskId);
}
