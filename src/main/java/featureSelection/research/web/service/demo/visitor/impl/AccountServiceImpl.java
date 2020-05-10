package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.mybatisMapper.demo.visitor.AccountMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ApplyAccountMapper;
import featureSelection.research.web.service.demo.visitor.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : ApplyAccountServiceimpl
 * @Description :会员服务层
 * @Author : WDD
 * @Date: 2020-04-13 15:17
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired private ApplyAccountMapper applyAccountMapper;

    @Autowired private AccountMapper accountMapper;
    /**
     * 会员账号申请
     * @param applyAccount
     */
    @Override
    public void apply(ApplyAccount applyAccount){
        //md5加密密码
        String md5password=DigestUtils.md5DigestAsHex(applyAccount.getapplyPassword().getBytes());
        applyAccount.setapplyPassword(md5password);
        applyAccountMapper.insertApplyAccount(applyAccount);
    }

    @Override
    public Map<String,Object> loginByEmail(String email, String password) {
        Map<String,Object> result=new HashMap<>();
        Account account=accountMapper.getAccountByEmail(email);
        if(account==null){
            result.put("status",400);
            result.put("reason","no register this account");
            return result;
        }
        if(account.getAccountPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            result.put("status",200);
            result.put("user",account);
            System.out.println(DigestUtils.md5DigestAsHex(password.getBytes()));
        }
        else{
            result.put("status",400);
            result.put("reason","password error");
        }
        return result;
    }
}
