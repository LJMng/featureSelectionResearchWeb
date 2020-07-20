package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.common.util.ResultUtil;
import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.mybatisMapper.demo.visitor.AccountMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ApplyAccountMapper;
import featureSelection.research.web.service.demo.visitor.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @ClassName : ApplyAccountServiceimpl
 * @Description :会员服务层
 * @Author : WDD
 * @Date: 2020-04-13 15:17
 */
@Service
public class IAccountServiceImpl implements IAccountService {

    @Autowired private ApplyAccountMapper applyAccountMapper;

    @Autowired private AccountMapper accountMapper;
    /**
     * 会员账号申请
     * @param applyAccount 账号信息
     */
    @Override
    public Result apply(ApplyAccount applyAccount){
        if(accountMapper.getAccountByEmail(applyAccount.getApplyEmail())!=null){
            return ResultUtil.error(400,"this email had registered");
        }
        //md5加密密码
        String md5password=DigestUtils.md5DigestAsHex(applyAccount.getapplyPassword().getBytes());
        applyAccount.setapplyPassword(md5password);
        applyAccountMapper.insertApplyAccount(applyAccount);
        return ResultUtil.success();
    }

    /**
     * 登陆验证
     * @param email
     * @param password
     * @return
     */
    @Override
    public Result loginByEmail(String email, String password) {

        Account account=accountMapper.getAccountByEmail(email);
        if(account==null){
            return ResultUtil.error(404,"no register this account");
    }
        if(account.getAccountPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
            return ResultUtil.success(account);

        }
        else {
            return ResultUtil.error(400,"password error");
        }
    }

    @Override
    public int getAccountIdByEmail(String email) {
        return accountMapper.getAccountIdByEmail(email);
    }
}
