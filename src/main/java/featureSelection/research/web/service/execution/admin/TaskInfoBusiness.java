package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.TaskInfo;

import java.util.List;

/**
 * 任务信息管理接口
 * @Author: 马凯健
 * @Data: 2020-07-18
 */
public interface TaskInfoBusiness {

    /**
     * 获取所有任务单信息。
     * @return List<TaskInfo> 封装任务单信息实体类的线性表
     */
    public List<TaskInfo> getTaskInfos();

    /**
     * 修改任务单信息，根据任务单信息，在数据库中对应修改任务单信息
     * @param taskInfo 封装任务单信息的实体类
     */
    public void updateTaskInfo(TaskInfo taskInfo);

    /**
     * 删除任务单信息，根据任务单信息实体类，在数据库中删除对应的任务单信息
     * @param taskInfo 封装任务单信息的实体类
     */
    public void deleteTaskInfo(TaskInfo taskInfo);
}
