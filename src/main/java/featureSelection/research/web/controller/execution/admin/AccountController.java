package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;
import featureSelection.research.web.service.execution.admin.AccountBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountBusiness accountBusiness;
    @GetMapping("/getAccounts")
    public @ResponseBody List<Account> getAccounts(){
        int[] arr={0,10,15,10};
        System.out.println(1);
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

    @PostMapping("/passApplyAccount")
    public String passApplyAccount(ApplyAccount applyAccount) throws MessagingException {
        accountBusiness.passApplyAccount(applyAccount);
        return "redirect: /pages/execution/admin/account.html";
    }
    @PostMapping("/unPassApplyAccount")
    public String unPassApplyAccount(ApplyAccount applyAccount){
        return "redirect: /pages/account.html";
    }
}
