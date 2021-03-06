package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.*;
import featureSelection.research.web.service.demo.admin.impl.ProcedureServiceImpl;
import featureSelection.research.web.service.execution.admin.AlgorithmBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AlgorithmController {
    @Autowired
    private AlgorithmBusiness algorithmBusiness;

    @Autowired
    private ProcedureServiceImpl procedureService;

    @RequestMapping(value = "/addAlgorithm")
    public void addAlgorithm(@RequestBody String algorithm){
        System.out.println(algorithm);
        String[] algorithmParam=algorithm.split("},");
        Map<Integer,String> algorithmMap=new HashMap<>();
        /*
        处理字符串数组：
        1.对第一个以及最后一个进行特殊处理，第一个的去除前面的[，然后添加一个}，最后一个去除后面的]
        2.遍历数组的所有元素，为每个元素添加 } 是其成为一个json对象的格式
        3.对每个json对象格式的字符串进行处理，取出algorithm对应的value
        4.根据每个value,json字符串，制成HashMap,调用Business的方法，添加到参数表中
         */
        for(int i=0;i<algorithmParam.length;i++){
            String beginAlgorithmJson=algorithmParam[i];

            if(i==0){
                String algorithmJson=beginAlgorithmJson.substring(1);
                algorithmJson=algorithmJson+"}";
                //根据改字符串分割获得algorithmId与对应的parameter_setting_info
                String[] params=algorithmJson.split(",");
                Integer algorithmId=1;
                String parameterSettingInfo="{";
                //遍历params字符串数组，分别获得algorithmId,parameterSettingInfo
                for (int j=0;j<params.length;j++){
                    //如果第一个,处理字符串获得算法Id
                    if (j==0){
                        String[] algorithmIdJson=params[j].split(":");
                        String[] algorithmIdArr=algorithmIdJson[1].split("\"");
                        String algorithmIdStr=algorithmIdArr[1];
                        System.out.println(algorithmIdStr);
                        algorithmId=Integer.parseInt(algorithmIdStr);
                    }else if(j==params.length-1){
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j];
                    }else {
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j]+",";
                    }
                }
                algorithmMap.put(algorithmId,parameterSettingInfo);



            }else if (i==algorithmParam.length-1){
                int lastIndex=beginAlgorithmJson.length()-1;
                String algorithmJson=beginAlgorithmJson.substring(0,lastIndex);

                //根据改字符串分割获得algorithmId与对应的parameter_setting_info
                String[] params=algorithmJson.split(",");
                Integer algorithmId=1;
                String parameterSettingInfo="{";
                //遍历params字符串数组，分别获得algorithmId,parameterSettingInfo
                for (int j=0;j<params.length;j++){
                    //如果第一个,处理字符串获得算法Id
                    if (j==0){
                        String[] algorithmIdJson=params[j].split(":");
                        String[] algorithmIdArr=algorithmIdJson[1].split("\"");
                        String algorithmIdStr=algorithmIdArr[1];
                        algorithmId=Integer.parseInt(algorithmIdStr);
                    }else if(j==params.length-1){
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j];
                    }else {
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j]+",";
                    }
                }
                algorithmMap.put(algorithmId,parameterSettingInfo);
                System.out.println(algorithmJson);


            }else {
                String algorithmJson=beginAlgorithmJson+"}";

                //根据改字符串分割获得algorithmId与对应的parameter_setting_info
                String[] params=algorithmJson.split(",");
                Integer algorithmId=1;
                String parameterSettingInfo="{";
                //遍历params字符串数组，分别获得algorithmId,parameterSettingInfo
                for (int j=0;j<params.length;j++){
                    //如果第一个,处理字符串获得算法Id
                    if (j==0){
                        String[] algorithmIdJson=params[j].split(":");
                        String[] algorithmIdArr=algorithmIdJson[1].split("\"");
                        String algorithmIdStr=algorithmIdArr[1];
                        algorithmId=Integer.parseInt(algorithmIdStr);
                    }else if(j==params.length-1){
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j];
                    }else {
                        System.out.println(params[j]);
                        parameterSettingInfo=parameterSettingInfo+params[j]+",";
                    }
                }
                algorithmMap.put(algorithmId,parameterSettingInfo);
                System.out.println(algorithmJson);
            }
        }
        algorithmBusiness.createParamSettingInfo(algorithmMap);
        System.out.println(algorithmMap);

    }

    @PostMapping("/addProcedureSetting")
   public @ResponseBody String addProcedureSettings(@RequestBody ProcedureSettings procedureSettings){
        algorithmBusiness.addProcedureSettings(procedureSettings);
        procedureService.insertSchemeProcedureAfterDeleteDemoAdmin(procedureSettings);
        return "success";
   }

   @GetMapping("/findAllProcedureSetting")
   public List<ProcedureSettings> findAllProcedureSettings(){
        return algorithmBusiness.findAllProcedureSettings();
   }

   @PostMapping("/updateProcedureSetting")
   public void updateProcedureSettings(@RequestBody ProcedureSettings procedureSettings){
        algorithmBusiness.updateProcedureSettings(procedureSettings);
        //execution将步骤名字修改后同步到方案步骤表的名字
        procedureService.updateProcedureNameAfterChangedByExecutionAdmin(procedureSettings);
   }

   @PostMapping("/createParameters")
   public @ResponseBody String createParameters(@RequestBody ParameterInfo parameterInfo){
         return algorithmBusiness.createParameters(parameterInfo);
   }

   @GetMapping(value = "/getAlgorithms")
   public @ResponseBody List<Algorithm> getAlgorithms(){
        return algorithmBusiness.getAlgorithms();
   }

   @GetMapping(value = "/getParameters")
    public @ResponseBody List<Parameter> getParameters(){
        return algorithmBusiness.getParameters();
   }
   @PostMapping(value = "/updateParameter")
   public void updateParameter(@RequestBody Parameter parameter){
       algorithmBusiness.updateParameter(parameter);
    }

    @PostMapping(value = "/deleteParameter")
    public String deleteParameter(@RequestBody Parameter parameter){
        algorithmBusiness.deleteParameter(parameter.getParameterId());
        return "redirect:/pages/execution/admin/algorithm.html";
    }

    @PostMapping(value = "/deleteProcedureSetting")
    public String deleteProcedureSetting(@RequestBody ProcedureSettings procedureSettings){
        algorithmBusiness.deleteProcedureSetting(procedureSettings.getId());
        return "redirect:/pages/execution/admin/algorithm.html";
    }
    @PostMapping(value = "/setAvailableDataset4Algorithm")
    public void setAvailableDataset4Algorithm(@RequestBody AvailableDataset4Algorithm availableDataset4Algorithm){
        System.out.println(availableDataset4Algorithm);
        algorithmBusiness.setAvailableDataset4Algorithm(availableDataset4Algorithm);
    }


    @PostMapping(value = "/addAlgorithmInfoByExcelFile")
    public @ResponseBody String addAlgorithmInfoByExcelFile(@RequestParam("algorithmInfoExcel") MultipartFile excel) throws Exception {
        return algorithmBusiness.addAlgorithmInfoByExcelFile(excel);
    }

    @GetMapping(value = "/getParametersInfoByAlgorithmId")
    public @ResponseBody List<Parameter> getParametersInfoByAlgorithmId(@RequestParam("algorithmId")int algorithmId){
        return algorithmBusiness.getParametersInfoByAlgorithmId(algorithmId);
    }

    @GetMapping(value = "/getParameterInfoByParameterId")
    public ParameterInfo getParameterInfoByParameterId(@RequestParam("parameterId") int parameterId){
        return algorithmBusiness.getParameterInfoByParameterId(parameterId);
    }

    @PostMapping(value = "updateParameters")
    public String updateParameters(@RequestBody ParameterInfo parameterInfo){
        algorithmBusiness.updateParameterInfo(parameterInfo);
        return "redirect:/pages/execution/admin/algorithm.html";
    }

    @GetMapping(value = "/getProcedureInfosByAlgorithmId")
    public List<ProcedureSettings> getProcedureInfosByAlgorithmId(@RequestParam("algorithmId")int algorithmId){
        return algorithmBusiness.getProcedureInfosByAlgorithmId(algorithmId);

    }

    @GetMapping(value = "/getProcedureSettingByNameAndAlgorithmId")
    public ProcedureSettings getProcedureSettingByNameAndAlgorithmId(@RequestParam("name") String name,@RequestParam("algorithmId") int algorithmId){
        return algorithmBusiness.getProcedureSettingByName(name,algorithmId);
    }

    @PostMapping(value = "/updateProcedure")
    public void updateProcedure(@RequestBody ProcedureSettings procedureSettings){
        algorithmBusiness.updateProcedure(procedureSettings);
    }

    @GetMapping(value = "/getAlgorithmAvailableDatasetByAlgorithmId")
    public @ResponseBody List<Boolean> getAlgorithmAvailableDatasetByAlgorithmId(@RequestParam("algorithmId") int algorithmId){
        return algorithmBusiness.getAlgorithmAvailableDatasetByAlgorithmId(algorithmId);
    }

}
