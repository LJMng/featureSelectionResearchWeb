package featureSelection.research.web.config.shiro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import featureSelection.research.web.entity.UserType;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.Administrator;
import featureSelection.research.web.mybatisMapper.demo.visitor.AccountMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.AdministratorLoginMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description: AccountRealm
 * @date: 2020/8/22 14:46
 * @author: Stephen
 */
public class AccountRealm extends AuthorizingRealm {


    @Autowired
    AccountMapper accountMapper;

    @Autowired
    AdministratorLoginMapper administratorLoginMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        CustomUsernamePasswordToken token = (CustomUsernamePasswordToken)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (token.getUserType().equals(UserType.account)){
            Account account = accountMapper.getAccountByEmail(token.getUsername());
            Map<String, List<Integer>> map = new HashMap<>();
            String accountPowerStr = account.getAccountPower();
            try {
                map = objectMapper.readValue(accountPowerStr, map.getClass());
                if (map.containsKey("user:download")) {
                    List<Integer> ids = map.get("user:download");
                    if (ids!=null){
                        Iterator<Integer> idsIterator = ids.iterator();
                        while (idsIterator.hasNext()) {
                            String id = idsIterator.next().toString();
                            info.addStringPermission("user:"+id+":download");
                        }
                    }
                }
                if (map.containsKey("user:upload")) {
                    List<Integer> ids = map.get("user:upload");
                    if (ids!=null){
                        Iterator<Integer> idsIterator = ids.iterator();
                        while (idsIterator.hasNext()) {
                            String id = idsIterator.next().toString();
                            info.addStringPermission("user:"+id+":upload");
                        }
                    }
                }
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            info.addRole("user");
        } else {
            info.addRole("admin");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        CustomUsernamePasswordToken token = (CustomUsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if (token != null) {
            if (token.getUserType().equals(UserType.account)) {
                Account account = accountMapper.getAccountByEmail(username);
                if (account == null) {
                    return null;
                }
                return new SimpleAuthenticationInfo(token, account.getAccountPassword(), "");
            } else if (token.getUserType().equals(UserType.admin)) {
                Administrator admin = administratorLoginMapper.findByAdministratorName(username);
                return new SimpleAuthenticationInfo(token, admin.getAdministratorPassword(), "");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
