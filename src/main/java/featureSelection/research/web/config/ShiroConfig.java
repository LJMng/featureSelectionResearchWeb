package featureSelection.research.web.config;

import featureSelection.research.web.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * anon:无需认证（登录）可以访问
         * authc:必须认证才可以访问
         * user:如果使用rememberMe的功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以访问
         */
        //拦截配置
        Map<String,String> filterMap = new LinkedHashMap<String,String>();

//        filterMap.put("/logout","logout");
//        filterMap.put("/","authc");
//        filterMap.put("/DemoAdmin/index","authc");
//        filterMap.put("/DemoAdmin/AlgorithmAdmin","authc");
//        filterMap.put("/DemoAdmin/SchemeAdmin","authc");
//        filterMap.put("/webjars/**","anon");
//        filterMap.put("/static/**","anon");

        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/DemoAdmin/login");
        //修改跳转成功页面
        shiroFilterFactoryBean.setSuccessUrl("/DemoAdmin/index");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        return shiroFilterFactoryBean;
    }

    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(myRealm);

        return securityManager;
    }

    @Bean(name="myRealm")
    public MyRealm getRealm(){
        //创建Realm
        return new MyRealm();
    }

}
