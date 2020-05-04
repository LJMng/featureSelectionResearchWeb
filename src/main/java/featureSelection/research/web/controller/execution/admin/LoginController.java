package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.service.execution.admin.AdministratorLoginBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @Autowired
    private AdministratorLoginBusiness administratorLoginBusiness;
    @GetMapping("/login")
    public String login(Administrator administrator){
        if(administratorLoginBusiness.administratorLogin(administrator)){
            return "redirect:/pages/execution/admin/execution.html";
        }else {
            return "redirect:/pages/execution/admin/executionVistiorLogin.html";
        }
    }
}
