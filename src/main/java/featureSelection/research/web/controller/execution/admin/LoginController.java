package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.mybatisMapper.execution.admin.AdministratorMapper;
import featureSelection.research.web.service.execution.admin.AdministratorLoginBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    @Autowired
    private AdministratorLoginBusiness administratorLoginBusiness;
    @PostMapping("/login")
    public String login(@RequestParam("administratorName") String administratorName,
                        @RequestParam("administratorPassword") String administratorPassword,
                        HttpServletRequest request,
                        HttpServletResponse response){
        Administrator administrator=new Administrator();
        administrator.setAdministratorName(administratorName);
        administrator.setAdministratorPassword(administratorPassword);
        if(administratorLoginBusiness.administratorLogin(administrator)){
            request.getSession().setAttribute("administrator", administrator);
            Cookie cookie=new Cookie("administratorName",administrator.getAdministratorName());
            response.addCookie(cookie);
            return "redirect:/pages/execution/admin/execution.html";
        }else {
            return "redirect:/pages/execution/admin/executionAdminLogin.html";
        }
    }
}
