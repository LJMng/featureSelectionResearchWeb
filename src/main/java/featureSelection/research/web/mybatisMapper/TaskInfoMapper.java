package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.execution.admin.TaskInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TaskInfoMapper {
    @Select("select * from task_info")
    public List<TaskInfo> getTaskInfos();

    @Update("update task_info set account_id=#{accountId},task_email=#{taskEmail},task_comment=#{taskComment}" +
            " where task_id=#{taskId}")
    public void updateTaskInfo(TaskInfo taskInfo);
}
