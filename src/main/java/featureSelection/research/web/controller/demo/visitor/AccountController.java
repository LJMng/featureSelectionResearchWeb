package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.common.util.ResultUtil;
import featureSelection.research.web.config.shiro.CustomUsernamePasswordToken;
import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.UserType;
import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.service.demo.visitor.impl.IAccountServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : AccountController
 * @Description : 账号控制类
 * @Author : WDD
 * @Date: 2020-04-13 15:19
 */
@RestController
public class AccountController {

    @Autowired
    private IAccountServiceImpl accountService;

    /**
     * 申请账号接口：
     * @param email：email账号
     * @param password：密码
     * @param apply：申请理由
     * @return Result类信息
     */
    @PostMapping("/applyAccount")
    public Result applyAccount(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("apply") String apply) {

        ApplyAccount applyAccount = new ApplyAccount();
        applyAccount.setApplyEmail(email);
        applyAccount.setApplyReason(apply);
        applyAccount.setapplyPassword(password);
        return accountService.apply(applyAccount);

    }


    @PostMapping("/demologinbyemail")
    public Result loginByEmail(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               HttpServletRequest request,
                               HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(email, password, UserType.account);
        try {
            subject.login(token);
            Account account = new Account();
            account.setAccountEmail(email);
            request.getSession().setAttribute("account", account);
            Cookie cookie = new Cookie("accountId", String.valueOf(accountService.getAccountIdByEmail(email)));
            response.addCookie(cookie);
            return ResultUtil.success();
        } catch (UnknownAccountException e) {
            return ResultUtil.error(404, "no register this account");
        } catch (IncorrectCredentialsException e) {
            return ResultUtil.error(400, "password error");
        }
//        Result result = accountService.loginByEmail(email, password);
//        if (result.getCode() == 200) {
//            Account account = new Account();
//            account.setAccountEmail(email);
//            request.getSession().setAttribute("account", account);
//            Cookie cookie = new Cookie("accountId", String.valueOf(accountService.getAccountIdByEmail(email)));
//            response.addCookie(cookie);
//        }
//        return result;
    }

    @GetMapping("/signout/{page}/{account}")
    public void signOut(@PathVariable String account, @PathVariable String page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (account != null) {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            request.getSession().removeAttribute("account");
            Cookie cookie = new Cookie("account", null);
            cookie.setPath("/");
            cookie.setMaxAge(0);
            Cookie cookie2 = new Cookie("accountId", null);
            cookie2.setPath("/");
            cookie2.setMaxAge(0);
            response.addCookie(cookie);
            response.addCookie(cookie2);
            if (page.equals("index")) {
                response.sendRedirect("/");
            } else {
                response.sendRedirect("/"+page);
            }
        }
    }
}
