package featureSelection.research.web.controller.execution.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import featureSelection.research.web.entity.DatasetForm;
import featureSelection.research.web.entity.TaskInfo;
import featureSelection.research.web.entity.TaskResult;
import featureSelection.research.web.service.execution.visitor.IExecutionFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/11 15:02
 */
@RestController
public class ExecutionFormsController {

    public final static String tempPath = "static\\dataset\\temp\\";
    public final static String taskPath = "static\\dataset\\task\\";
    public final static String publicDatasetPath = "static\\dataset\\publicDataset\\";

    @Autowired
    IExecutionFormsService formsService;

    @PostMapping("/uploadDatasetForm")
    public String uploadDatasetForm(DatasetForm dataset,
            @RequestParam(name = "file") MultipartFile uploadFile) {
        return formsService.uploadDatasetForm(dataset,uploadFile,tempPath);
    }

    @PostMapping("/getDatasetForms")
    public List<DatasetForm> getDatasetForms(@RequestParam("accountId")long accountId){
        return formsService.getDatasetForms(accountId);
    }

    @PostMapping("/uploadTaskForm")
    public String submitTaskForm(TaskInfo task,
             @RequestParam(name = "file",required = false) MultipartFile uploadFile) throws JsonProcessingException {
        return formsService.submitTaskForm(task,uploadFile,taskPath);
    }

    @PostMapping("/getTaskListByAccountId")
    public List<TaskInfo> getTaskListByAccountId(@RequestParam("accountId")long accountId){
        return formsService.getTaskListByAccountId(accountId);
    }

    @GetMapping("/queryDatasetName")
    public String queryDatasetName(@RequestParam("datasetName") String datasetName) {
        return formsService.queryDatasetName(datasetName);
    }

    @GetMapping("/queryTaskName")
    public String queryTaskName(@RequestParam("taskName")String taskName,@RequestParam("accountId")long accountId){
        return formsService.queryTaskName(taskName,accountId);
    }

    @PostMapping("/updateTask")
    public String updateTask(
            @RequestParam("taskId")long taskId,
            @RequestParam("taskName")String taskName,
            @RequestParam("taskEmail")String taskEmail,
            @RequestParam("taskComment")String taskComment){
        return formsService.updateTask(taskId,taskName,taskEmail,taskComment);
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId")long taskId){
        return formsService.deleteTask(taskId);
    }

    @GetMapping("/getTaskResult")
    public List<TaskResult> getTaskResults(@RequestParam("taskId")long taskId) {
        return formsService.getTaskResults(taskId);
    }
}
