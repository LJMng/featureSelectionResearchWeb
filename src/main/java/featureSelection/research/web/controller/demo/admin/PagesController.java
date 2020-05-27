package featureSelection.research.web.controller.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author jjz
 * */
@RequestMapping("/DemoAdmin")
@Controller
public class PagesController {

    /**
     * @return 进入管理页面登录页面
     * */
    //管理页面登录页面
    @GetMapping("/login")
    public String toLoginAdminPage(){
        return "/demoAdmin/DemoAdminLogin.html";
    }

    /**
     * @return 进入管理页面首页
     * */
    //管理页面首页
    @GetMapping("/index")
    public String toIndexAdminPage(){
        return "/demoAdmin/index.html";
    }

    /**
     * @return 进入方案管理页面
     * */
    //方案管理页面
    @GetMapping("/SchemeAdmin")
    public String toSchemeAdminPage(){
        return "/demoAdmin/SchemeDemoAdmin.html";
    }

    /**
     * @return 进入关于我们管理页面
     * */
    //关于我们管理页面
    @GetMapping("/AboutusAdmin")
    public String toAboutusAdmin(){
        return "/demoAdmin/AboutusDemoAdmin.html";
    }
}
