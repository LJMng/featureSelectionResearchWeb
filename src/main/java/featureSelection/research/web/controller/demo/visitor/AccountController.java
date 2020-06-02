package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.common.util.ResultUtil;
import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import featureSelection.research.web.service.demo.visitor.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : AccountController
 * @Description : 账号控制类
 * @Author : WDD
 * @Date: 2020-04-13 15:19
 */
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/applyAccount")
    public Result applyAccount(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               @RequestParam("apply") String apply) {

        ApplyAccount applyAccount = new ApplyAccount();
        applyAccount.setApplyEmail(email);
        applyAccount.setApplyReason(apply);
        applyAccount.setapplyPassword(password);
        accountService.apply(applyAccount);
        return ResultUtil.success();

    }

    @PostMapping("/demologinbyemail")
    public Result loginByEmail(@RequestParam("email") String email,
                               @RequestParam("password") String password) {
        return accountService.loginByEmail(email, password);
    }
}
