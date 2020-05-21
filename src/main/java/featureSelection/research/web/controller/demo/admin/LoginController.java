package featureSelection.research.web.controller.demo.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author jjz
 * */
@Controller
public class LoginController {

    /**
     * @param username
     *      前端登录输入的用户名
     * @param password
     *      前端登录输入的密码
     * @return 根据情况返回不同的路径，如果成功进入管理页面首页，失败返回登陆页面
     * */
    @RequestMapping("/demoAdminLogin")
    public String login(String username, String password){
        //获取Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登录方法
        try {
            subject.login(token);
            return "/DemoAdmin/index";
        }catch (AuthenticationException e){
            return "/DemoAdmin/login";
        }
    }

}
