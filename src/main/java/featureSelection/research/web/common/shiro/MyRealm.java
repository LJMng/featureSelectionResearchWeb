//package featureSelection.research.web.common.shiro;
//
//import featureSelection.research.web.entity.demo.admin.Administrator;
//import featureSelection.research.web.mybatisMapper.demo.admin.AdministratorDemoAdminMapper;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
///**
// * @author jjz
// * */
//public class MyRealm extends AuthorizingRealm {
//
//    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    @Autowired
//    AdministratorDemoAdminMapper administratorDemoAdminMapper;
//
//
//    //认证
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        Administrator administrator = administratorDemoAdminMapper.getAdministratorByName(token.getUsername());
//        if(administrator==null){
//            return null;
//        }
//        Subject currentSubject = SecurityUtils.getSubject();
//        Session session = currentSubject.getSession();
//        session.setAttribute("loginUser",administrator.getAdministratorName());
//        return new SimpleAuthenticationInfo("",administrator.getAdministratorPassword(),"");
//    }
//}
