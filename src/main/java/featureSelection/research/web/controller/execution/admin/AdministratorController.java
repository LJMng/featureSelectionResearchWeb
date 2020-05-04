package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.service.execution.admin.AdministratorBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String updateAdministrator(Administrator administrator){
        administratorBusiness.updateAdministrator(administrator);
        return "redirect: /pages/execution/admin/administrator.html";
    }

    @GetMapping("/deleteAdministrator")
    public String deleteAdministratorById(String administratorId){
        administratorBusiness.deleteAdministratorById(administratorId);
        return "redirect: /pages/execution/admin/administrator.html";
    }

    @PostMapping("/addAdministrator")
    public String addAdministrator(Administrator administrator){
        administratorBusiness.addAdministrator(administrator);
        return "redirect: /pages/execution/admin/administrator.html";
    }


}
