package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.TaskInfo;
import featureSelection.research.web.service.execution.admin.TaskInfoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskInfoController {
    @Autowired
    private TaskInfoBusiness taskInfoBusiness;

    @GetMapping("/getTaskInfos")
    public @ResponseBody List<TaskInfo> getTaskInfos(){
        List<TaskInfo> taskInfos= taskInfoBusiness.getTaskInfos();
        return taskInfos;

    }
    @PostMapping("/updateTaskInfo")
    public String updateTaskInfo(TaskInfo taskInfo){
        taskInfoBusiness.updateTaskInfo(taskInfo);
        return "redirect:/pages/execution/admin/taskInfo.html";
    }
    @PostMapping("/deleteTaskInfo")
    public String deleteTaskInfo(@RequestBody TaskInfo taskInfo){
        taskInfoBusiness.deleteTaskInfo(taskInfo);
        return "redirect:/pages/execution/admin/taskInfo.html";
    }
}
