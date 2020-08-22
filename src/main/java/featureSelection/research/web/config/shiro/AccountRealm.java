package featureSelection.research.web.config.shiro;

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
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
                return new SimpleAuthenticationInfo(account, account.getAccountPassword(), "");
            } else if (token.getUserType().equals(UserType.admin)) {
                Administrator admin = administratorLoginMapper.findByAdministratorName(username);
                return new SimpleAuthenticationInfo(admin, admin.getAdministratorPassword(), "");
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
