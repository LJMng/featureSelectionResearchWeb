package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;
import featureSelection.research.web.entity.execution.admin.SetAccountPowerInfo;

import javax.mail.MessagingException;
import java.util.List;

/**
 * 业务层用户信息管理接口类
 * @Authod:马凯健
 * @Date: 2020-07-18
 */
public interface AccountBusiness {

    /**
     * 获取数据库中用户的信息列表
     * @Return List<Account>
     *     返回信息为包装好数据库中用户信息的线性表
     */
    public List<Account> getAccounts();

    /**
     * 修改用户信息，更新至数据库
     * @param account
     *    需要修改的用户信息
     */
    public void updateAccount(Account account);

    /**
     * 添加用户信息
     * @param account
     *   新增用户的详细信息
     */
    public void addAccount(Account account);

    /**
     * 删除用户信息，数据库中通过id唯一识别用户进行删除
     * @param accountId
     *   被删除用户的id
     */
    public void deleteAccount(int accountId);

    /**
     * 修改用户权限
     * @param power
     *   用户权限类，封装了用户权限信息
     */
//    public void updateAccountPower(Power power);

    /**
     * 在用户申请表中，获取用户申请信息的列表
     * @return List<ApplyAccount>
     *     封装用户申请信息的线性表
     */
    public List<ApplyAccount> getApplyAccounts();

    /**
     * 通过用户申请表的信息，对用户信息进行审核，通过则将用户信息添加至用户表，同时删除申请表中的用户信息，不通过则删除申请表中的用户信息
     * @param applyAccount
     *    用户申请类，封装用户申请理由，账户，初始密码等信息
     * @throws MessagingException
     */
    public void passApplyAccount(ApplyAccount applyAccount) throws MessagingException;

    /**
     * 根据用户申请的用户Id,通过用户申请，将用户信息添加至数据库。
     * @param applyAccountId
     */
    public void passAccountAdult(int applyAccountId,String applyReason) throws MessagingException;

    /**
     * 拒绝用户申请，修改审核表中用户的审核状态，发送邮件通知用户审核结果
     * @param applyAccount
     */
    public void unPassAccountAdult(ApplyAccount applyAccount) throws MessagingException;

    public void setAccountPower(SetAccountPowerInfo setAccountPowerInfo);
}
