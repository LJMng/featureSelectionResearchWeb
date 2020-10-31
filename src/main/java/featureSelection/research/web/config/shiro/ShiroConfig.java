package featureSelection.research.web.config.shiro;

import featureSelection.research.web.mybatisMapper.execution.visitor.AlgorithmMapper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: ShiroConfig2
 * @date: 2020/8/22 14:45
 * @author: Stephen
 */
@Configuration
public class ShiroConfig {
    
    @Autowired
    AlgorithmMapper algorithmMapper;
    
    
    @Bean
    public ShiroFilterFactoryBean getAdminShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/pages/execution/admin/**", "authc");
        filterMap.put("/pages/execution/admin/**", "roles[admin]");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/pages/execution/admin/executionAdminLogin.html");
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    @Bean
    public ShiroFilterFactoryBean getVisitorShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        Map<String, String> filterMap = new LinkedHashMap<>();
        Set<Integer> keySet = algorithmMapper.getAlgorithmsList().keySet();
        Iterator<Integer> keys = keySet.iterator();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            filterMap.put("/execution/downloadAlgorithmDocument/"+key, "perms[user:"+key+":download]");
            filterMap.put("/execution/uploadAlgorithmDocument/"+key, "perms[user:"+key+":upload]");
        }
        filterMap.put("/execution/**", "roles[user]");
        filterMap.put("/execution/**", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/accountLogin");
        bean.setUnauthorizedUrl("/unauthorized");
        return bean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("accountRealm")AccountRealm accountRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(accountRealm);
        return securityManager;
    }

    @Bean
    public AccountRealm accountRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher hashedCredentialsMatcher){
        AccountRealm accountRealm = new AccountRealm();
        accountRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return accountRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}
