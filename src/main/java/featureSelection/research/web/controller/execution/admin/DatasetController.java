package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Dataset;
import featureSelection.research.web.entity.execution.admin.DatasetForm;
import featureSelection.research.web.service.execution.admin.DatasetBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class DatasetController {
    @Autowired
    private DatasetBusiness datasetBusiness;

    @PostMapping("/createDataset")
    public String createDataset(@RequestParam("datasetName") String datasetName,
                                @RequestParam("datasetDescription")String datasetDescription,
                                @RequestParam("datasetCount") long datasetCount,
                                @RequestParam("datasetSource") String datasetSource,
                                @RequestParam("datasetDimension") long datasetDimension,
                                @RequestParam("isCommon") boolean isCommon,
                                @RequestParam("File") MultipartFile File) throws Exception {
        Dataset dataset=new Dataset();
        dataset.setDatasetName(datasetName);
        dataset.setDatasetDescription(datasetDescription);
        dataset.setDatasetCount(datasetCount);
        dataset.setDatasetSource(datasetSource);
        dataset.setDatasetDimension(datasetDimension);
        dataset.setCommon(isCommon);
        dataset.setDatasetFile(File.getOriginalFilename());
        datasetBusiness.createDataset(dataset,File);
        return "redirect:/pages/execution/admin/datasetManage.html";
    }

    @GetMapping("/getDatasetMap")
    public @ResponseBody List<Dataset> getDataset(){
        List<Dataset> datasetList=datasetBusiness.getDatasetList();
        return datasetList;
    }
    @PostMapping("/deleteDataset")
    public String deleteDatasetById(@RequestBody Dataset dataset){
        datasetBusiness.deleteDatasetById(dataset.getDatasetId());
        return "redirect:/pages/execution/admin/datasetManage.html";
    }

    @PostMapping("/updateDataset")
    public String updateDataset(@RequestBody Dataset dataset){
        datasetBusiness.updateDataset(dataset);
        return "redirect:/pages/execution/admin/datasetManage.html";
    }

    @GetMapping("/getDatasetForms")
    public @ResponseBody List<DatasetForm> getDatasetFroms(){
        List<DatasetForm> datasetForms=datasetBusiness.getDatasetForms();
        return datasetForms;
    }

    @GetMapping("/passDatasetForm")
    public String passDatasetForm(int inputId,String administrator) throws MessagingException {
        datasetBusiness.passDatasetForm(inputId,administrator);
        return "redirect:/pages/execution/admin/datasetManage.html";
    }

    @GetMapping("/unPassDatasetForm")
    public String unPassDatasetForm(int inputId,String advice,String administrator){
        datasetBusiness.unPassDatasetForm(inputId,advice,administrator);
        return "redirect:/pages/execution/admin/datasetManage.html";
    }

}
