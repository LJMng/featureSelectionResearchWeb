package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.TaskInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskInfoMapper {
    @Select("select * from task_info")
    public List<TaskInfo> getTaskInfos();

    @Update("update task_info set account_id=#{accountId},task_email=#{taskEmail},task_comment=#{taskComment}" +
            " where task_id=#{taskId}")
    public void updateTaskInfo(TaskInfo taskInfo);

    @Delete("delete from task_info where task_id=#{taskId}")
    public void deleteTaskInfo(TaskInfo taskInfo);
}
