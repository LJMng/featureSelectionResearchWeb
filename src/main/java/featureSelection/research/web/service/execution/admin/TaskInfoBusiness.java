package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.TaskInfo;

import java.util.List;

public interface TaskInfoBusiness {

    public List<TaskInfo> getTaskInfos();


    public void updateTaskInfo(TaskInfo taskInfo);
}
