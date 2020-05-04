package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.TaskInfo;
import featureSelection.research.web.mybatisMapper.execution.admin.TaskInfoMapper;
import featureSelection.research.web.service.execution.admin.TaskInfoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskInfoBusinessImpl implements TaskInfoBusiness {
    @Autowired
    private TaskInfoMapper taskInfoMapper;
    @Override
    public List<TaskInfo> getTaskInfos() {
        List<TaskInfo> taskInfos=taskInfoMapper.getTaskInfos();
        return taskInfos;
    }

    @Override
    public void updateTaskInfo(TaskInfo taskInfo) {
        taskInfoMapper.updateTaskInfo(taskInfo);
    }


}
