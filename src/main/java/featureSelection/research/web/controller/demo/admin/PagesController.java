package featureSelection.research.web.controller.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/DemoAdmin")
@Controller
public class PagesController {

    //管理页面登录页面
    @GetMapping("/login")
    public String toLoginAdminPage(){
        return "/DemoAdminLogin.html";
    }

    //管理页面首页
    @GetMapping("/index")
    public String toIndexAdminPage(){
        return "/index.html";
    }

    //方案管理页面
    @GetMapping("/SchemeAdmin")
    public String toSchemeAdminPage(){
        return "/SchemeDemoAdmin.html";
    }

    //算法管理页面
    @GetMapping("/AlgorithmAdmin")
    public String toAlgorithmAdminPage(){
        return "/AlgorithmDemoAdmin.html";
    }

    //关于我们管理页面
    @GetMapping("/AboutusAdmin")
    public String toAboutusAdmin(){
        return "/AboutusDemoAdmin.html";
    }

    @GetMapping("/pageAdmin")
    public String getPages(){
        return "/pageadmin/index.html";
    }
}
