package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.config.shiro.CustomUsernamePasswordToken;
import featureSelection.research.web.entity.UserType;
import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.service.execution.admin.AdministratorLoginBusiness;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        Subject subject = SecurityUtils.getSubject();
        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(administratorName, administratorPassword, UserType.admin);
        try {
            subject.login(token);
            request.getSession().setAttribute("administrator", administrator);
            Cookie cookie=new Cookie("administratorName",administrator.getAdministratorName());
            response.addCookie(cookie);
            return "redirect:/pages/execution/admin/execution.html";
        }catch (AuthenticationException e){
            return "redirect:/pages/execution/admin/executionAdminLogin.html";
        }
    }
}
