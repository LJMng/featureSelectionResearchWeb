package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.App;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;
import featureSelection.research.web.service.execution.admin.AccountBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountBusiness accountBusiness;
    @GetMapping("/getAccounts")
    public @ResponseBody List<Account> getAccounts(){
        int[] arr={0,10,15,10};
        List<Account> accounts=accountBusiness.getAccounts();
        return accounts;
    }

    @PostMapping("/updateAccount")
    public String updateAccount(@RequestBody Account account){
        accountBusiness.updateAccount(account);
        return "redirect: /pages/execution/admin/account.html";
    }

    @PostMapping("/administratorAddAccount")
    public String addAccount(@RequestBody Account account){
        String md5Password= DigestUtils.md5DigestAsHex(account.getAccountPassword().getBytes());
        account.setAccountPassword(md5Password);
        accountBusiness.addAccount(account);

        return "redirect: /pages/execution/admin/account.html";
    }

    @GetMapping("/deleteAccount")
    public String deleteAccount(int accountId){
        accountBusiness.deleteAccount(accountId);
        return "redirect: /pages/execution/admin/account.html";
    }

    @PostMapping("/updateAccountPower")
    public String updateAccountPower(Power power){
        accountBusiness.updateAccountPower(power);
        return "redirect: /pages/execution/admin/account.html";
}

    @GetMapping("/getApplyAccounts")
    public @ResponseBody List<ApplyAccount> getApplyAccounts(){
        List<ApplyAccount> applyAccounts=accountBusiness.getApplyAccounts();
        return applyAccounts;
    }

//    @PostMapping("/passApplyAccount")
//    public String passApplyAccount(ApplyAccount applyAccount) throws MessagingException {
//        accountBusiness.passApplyAccount(applyAccount);
//        return "redirect: /pages/execution/admin/account.html";
//    }

    /**
     * 通过用户申请,将申请用户信息添加至用户表，修改申请表信息
     * @param applyAccount
     * @return String 返回审核结果字符串  "success" or "fail"
     * @throws MessagingException 邮件发送异常
     * @Auther 马凯健
     */
    @PostMapping(value = "/passAccountAdult")
    public String passAccountAdult(@RequestBody ApplyAccount applyAccount)
            throws MessagingException {
        accountBusiness.passApplyAccount(applyAccount);
        return "redirect: /pages/execution/admin/account.html";
    }

    @PostMapping(value = "/unPassAccountAdult")
    public String unPassAccountAdult(@RequestBody ApplyAccount applyAccount) throws MessagingException {
        accountBusiness.unPassAccountAdult(applyAccount);
        return "redirect: /pages/execution/admin/account.html";
    }
}
