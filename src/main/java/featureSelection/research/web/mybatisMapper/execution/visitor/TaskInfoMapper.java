package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.TaskInfo;
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

    /**
     * 向算法任务表中新增一个算法任务
     * @param taskInfo 算法任务对象
     */
    @Insert("insert into task_info(account_id,task_name,task_comment,task_email,algorithm_id,algorithm_parameters,dataset_id,dataset_upload)" +
            "values (#{accountId},#{taskName},#{taskComment},#{taskEmail},#{algorithmId},#{algorithmParameters},#{datasetId},#{datasetUpload})")
    @SelectKey(statement = "select last_insert_id()" ,keyProperty = "taskId",keyColumn = "task_id",resultType = int.class,before = false)
    void addTaskInfo(TaskInfo taskInfo);

    /**
     * 通过用户id获取所有算法任务
     * @param accountId 用户id
     * @return List<TaskInfo> 算法任务数组
     */
    @Select("select * from task_info where account_id = #{accountId}")
    List<TaskInfo> getTaskListByAccountId(int accountId);

    /**
     * 通过算法任务id和算法任务名称，查询该用户是否含有相同的算法任务名称
     * @param taskName 算法任务名称
     * @param accountId 用户id
     * @return int 某用户含有的算法任务中与待查询算法任务名称相同的个数
     */
    @Select("select count(task_name) from task_info where task_name = #{taskName} and account_id = #{accountId}")
    int queryTaskName(String taskName, int accountId);

    /**
     * 更新算法任务记录
     * @param taskId 算法id
     * @param taskName 更新后算法名称
     * @param taskEmail 更新后邮箱
     * @param taskComment 更新后的算法任务备注
     * @return int 更新的记录数
     */
    @Insert("update task_info set task_name = #{taskName},task_email = #{taskEmail},task_comment = #{taskComment} where task_id = #{taskId};")
    int updateTaskInfo(int taskId, String taskName, String taskEmail, String taskComment);

    /**
     * 删除算法任务
     * @param taskId 算法任务id
     * @return int 更新的记录数
     */
    @Delete("delete from task_info where task_id = #{taskId}")
    int deleteTask(int taskId);

    /**
     * 通过算法id获取算法任务信息
     * @param taskId 算法id
     * @return TaskInfo 算法任务对象
     */
    @Select("select * from task_info where task_id=#{taskId}")
    TaskInfo getTaskInfoByTaskId(int taskId);

    /**
     * 更新算法任务的状态
     * @param status 算法任务状态
     * @param taskId 算法任务id
     */
    @Update("update task_info set task_status =#{status} where task_id=#{taskId} ")
    void updateTaskInfoStatus(@Param("status") String status,@Param("taskId") int taskId);

}
