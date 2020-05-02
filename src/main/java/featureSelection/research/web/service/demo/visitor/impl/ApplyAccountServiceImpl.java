package featureSelection.research.web.service.demo.visitor.impl;

import featureSelection.research.web.entity.demo.visitor.ApplyAccount;
import featureSelection.research.web.mybatisMapper.demo.visitor.ApplyAccountMapper;
import featureSelection.research.web.service.demo.visitor.ApplyAccountService;
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
public class ApplyAccountServiceImpl implements ApplyAccountService {

    @Autowired private ApplyAccountMapper applyAccountMapper;

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
}
