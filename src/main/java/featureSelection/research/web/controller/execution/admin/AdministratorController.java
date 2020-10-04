package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.service.execution.admin.AdministratorBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdministratorController {

    @Autowired
    private AdministratorBusiness administratorBusiness;
    @GetMapping("/getAdministrators")
    public @ResponseBody List<Administrator> getAdministrators(){
        List<Administrator> administrators=administratorBusiness.getAdministrators();
        return administrators;
    }

    @PostMapping("/updateAdministrator")
    @ResponseBody
    public String updateAdministrator(@RequestBody Administrator administrator){
        return administratorBusiness.updateAdministrator(administrator);

    }

    @PostMapping("/deleteAdministrator")
    @ResponseBody
    public String deleteAdministratorById(@RequestParam("administratorName") String  administratorName){
        if (administratorBusiness.deleteAdministratorByAdministratorName(administratorName)){
            return "success";
        }else {
            return "删除失败,root用户无法删除！";
        }
    }

    @PostMapping("/addAdministrator")
    @ResponseBody
    public String addAdministrator(@RequestBody Administrator administrator){
        return administratorBusiness.addAdministrator(administrator);
    }


}
