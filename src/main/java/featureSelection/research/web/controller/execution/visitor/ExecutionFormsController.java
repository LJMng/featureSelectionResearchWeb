package featureSelection.research.web.controller.execution.visitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import featureSelection.research.web.common.util.AlgorithmMapperValueUtil;
import featureSelection.research.web.entity.execution.visitor.DatasetForm;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.entity.execution.visitor.TaskResult;
import featureSelection.research.web.service.execution.visitor.IExecutionFormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/11 15:02
 */
@RestController
public class ExecutionFormsController {

    public final static String tempPath = "dataset\\temp\\";
    public final static String taskPath = "dataset\\task\\";
    public final static String publicDatasetPath = "dataset\\publicDataset\\";

    @Autowired
    IExecutionFormsService formsService;

    @Autowired
    AlgorithmMapperValueUtil valueUtil;

    @PostMapping("/uploadDatasetForm")
    public String uploadDatasetForm(DatasetForm dataset,
            @RequestParam(name = "file") MultipartFile uploadFile) {
        return formsService.uploadDatasetForm(dataset,uploadFile,tempPath);
    }

    @PostMapping("/getDatasetForms")
    public List<DatasetForm> getDatasetForms(@RequestParam("accountId")int accountId){
        return formsService.getDatasetForms(accountId);
    }

    @PostMapping("/uploadTaskForm")
    public String submitTaskForm(TaskInfo task,
             @RequestParam(name = "file",required = false) MultipartFile uploadFile) throws JsonProcessingException {
        return formsService.submitTaskForm(task,uploadFile,taskPath);
    }

    @PostMapping("/getTaskListByAccountId")
    public List<TaskInfo> getTaskListByAccountId(@RequestParam("accountId")int accountId){
        return formsService.getTaskListByAccountId(accountId);
    }

    @GetMapping("/queryDatasetName")
    public String queryDatasetName(@RequestParam("datasetName") String datasetName) {
        return formsService.queryDatasetName(datasetName);
    }

    @GetMapping("/queryTaskName")
    public String queryTaskName(@RequestParam("taskName")String taskName,@RequestParam("accountId")int accountId){
        return formsService.queryTaskName(taskName,accountId);
    }

    @PostMapping("/updateTask")
    public String updateTask(
            @RequestParam("taskId")int taskId,
            @RequestParam("taskName")String taskName,
            @RequestParam("taskEmail")String taskEmail,
            @RequestParam("taskComment")String taskComment){
        return formsService.updateTask(taskId,taskName,taskEmail,taskComment);
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId")int taskId){
        return formsService.deleteTask(taskId);
    }

    @GetMapping("/getTaskResult")
    public List<TaskResult> getTaskResults(@RequestParam("taskId")int taskId) {
        return formsService.getTaskResults(taskId);
    }

    @GetMapping(value = {"/getValue/{algorithmId}/{parameterId}/{param1}/{param2}", "/getValue/{algorithmId}/{parameterId}/{param1}"})
    public String getParameterValue(@PathVariable(name = "algorithmId") int algorithmId,
                                    @PathVariable(name = "parameterId") int parameterId,
                                    @PathVariable(name = "param1") String param1,
                                    @PathVariable(name = "param2",required = false)String param2){
        return valueUtil.getParameterValue(algorithmId,parameterId,param1,param2);
    }
}
