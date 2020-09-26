package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Account;
import featureSelection.research.web.entity.execution.admin.ApplyAccount;
import featureSelection.research.web.entity.execution.admin.Power;
import featureSelection.research.web.entity.execution.admin.ToEmail;

import featureSelection.research.web.mybatisMapper.execution.admin.AccountMapper;
import featureSelection.research.web.service.execution.admin.AccountBusiness;
import featureSelection.research.web.common.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Random;

@Service
public class AccountBusinessImpl implements AccountBusiness {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private EmailUtil emailUtil;
    @Override
    public List<Account> getAccounts() {
        List<Account> accounts=accountMapper.getAccounts();
        return accounts;
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateAccount(account);
    }

    @Override
    public void addAccount(Account account) {
        //先生成一个powerID,随机六位数
        Random random=new Random();
        int accountPower= random.nextInt(999999);
        System.out.println(accountPower);
        //判断powerId是否已经存在
        Power Power=accountMapper.findPowerById(accountPower);
        //递归调用，直至没有重复accountPower
        if(Power!=null){
            addAccount(account);
        }else{
            //创建Power表
            featureSelection.research.web.entity.execution.admin.Power newPower=new Power();
            newPower.setAccountPower(accountPower);
            newPower.setAccountId(account.getAccountId());
            accountMapper.addPower(newPower);
            //创建新用户
            account.setAccountPower(accountPower);
            accountMapper.addAccount(account);

        }

    }

    @Override
    public void deleteAccount(int accountId) {
        accountMapper.deleteAccount(accountId);
    }

    @Override
    public void updateAccountPower(Power power) {
        accountMapper.updateAccountPower(power);
    }

    @Override
    public List<ApplyAccount> getApplyAccounts() {
        List<ApplyAccount> applyAccounts=accountMapper.getApplyAccounts();
        return applyAccounts;
    }

    @Override
    public void passApplyAccount(ApplyAccount applyAccount) throws MessagingException {
        //通过applyId获取申请者信息
        ApplyAccount passApplyAccount=accountMapper.findApplyAccountById(applyAccount.getApplyId());
        //设置审批人信息，审批意见,更新信息
        System.out.println(applyAccount);
        passApplyAccount.setAdministratorId(applyAccount.getAdministratorId());
        passApplyAccount.setAdministratorReason(applyAccount.getAdministratorReason());
        passApplyAccount.setApplyCondition("通过审核");
        //创建新的Account对象，添加新用户
        Account account=new Account();
        account.setAccountEmail(passApplyAccount.getApplyEmail());
        account.setAccountId(passApplyAccount.getApplyId());
        account.setAccountPassword(passApplyAccount.getApplyPassword());
        account.setAccountName("用户");
        this.addAccount(account);
        //更新inputApply表
        accountMapper.updateApplyAccount(passApplyAccount);
        //发送邮件至用户邮箱通知结果
        /**
         * 邮件内容：
         * 1.恭喜你成功注册XXX平台的XX账户
         * 2.账户Id:xxxxxxxx
         * 3.账户功能介绍
         * 4.欢迎使用本平台功能
         */
        String content="<html>\n" +
                "\t<body>\n" +
                "\t\t<h2 text-align=\"center\">这里是featureSelection平台 恭喜您的账号注册成功！！</h2>\n" +
                "\t\t<div class=\"container\">\n" +
                "\t\t\t<p>账号："+account.getAccountEmail()+"</p><br />\n" +
                "\t\t\t<p>账户功能介绍：您可以登陆featureSelection平台，然后使用平台算法运行以及数据集下载等功能。</p><br />\n" +
                "\t\t\t<p align=\"center\">欢迎登陆并使用平台功能。</p>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";
        ToEmail toEmail=new ToEmail(passApplyAccount.getApplyEmail(),"注册账户成功",content);
        emailUtil.htmlEmail(toEmail);

    }

    @Override
    public void passAccountAdult(int applyAccountId,String applyReason) throws MessagingException {
        //根据用户申请Id获取用户申请单对象
        ApplyAccount passApplyAccount=accountMapper.findApplyAccountById(applyAccountId);
        //设置审批人信息，审批意见,更新信息
        passApplyAccount.setAdministratorId("6");
        passApplyAccount.setAdministratorReason(applyReason);
        passApplyAccount.setApplyCondition("通过审核");
//创建新的Account对象，添加新用户
        Account account=new Account();
        account.setAccountEmail(passApplyAccount.getApplyEmail());
        account.setAccountId(passApplyAccount.getApplyId());
        account.setAccountPassword(passApplyAccount.getApplyPassword());
        account.setAccountName("用户");
        this.addAccount(account);
        //更新inputApply表
        accountMapper.updateApplyAccount(passApplyAccount);
        //发送邮件至用户邮箱通知结果
        /**
         * 邮件内容：
         * 1.恭喜你成功注册XXX平台的XX账户
         * 2.账户Id:xxxxxxxx
         * 3.账户功能介绍
         * 4.欢迎使用本平台功能
         */
        String content="<html>\n" +
                "\t<body>\n" +
                "\t\t<h2 text-align=\"center\">这里是xxx平台 恭喜您的账号注册成功！！</h2>\n" +
                "\t\t<div class=\"container\">\n" +
                "\t\t\t<p>账号："+account.getAccountEmail()+"</p><br />\n" +
                "\t\t\t<p>账户功能介绍：您可以登陆XX平台，然后XXXXXXX</p><br />\n" +
                "\t\t\t<p align=\"center\">欢迎登陆并使用平台功能</p>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";
        ToEmail toEmail=new ToEmail(passApplyAccount.getApplyEmail(),"注册账户成功",content);
        emailUtil.htmlEmail(toEmail);

    }

    @Override
    public void unPassAccountAdult(ApplyAccount applyAccount) throws MessagingException {
        //通过applyId获取申请者信息
        ApplyAccount unPassApplyAccount=accountMapper.findApplyAccountById(applyAccount.getApplyId());
        //设置审批人信息，审批意见,更新信息
        System.out.println(applyAccount);
        unPassApplyAccount.setAdministratorId(applyAccount.getAdministratorId());
        unPassApplyAccount.setAdministratorReason(applyAccount.getAdministratorReason());
        unPassApplyAccount.setApplyCondition("不通过审核");
        //更新inputApply表
        accountMapper.updateApplyAccount(unPassApplyAccount);
        //发送邮件至用户邮箱通知结果
        /**
         * 邮件内容：
         * 1.恭喜你成功注册XXX平台的XX账户
         * 2.账户Id:xxxxxxxx
         * 3.账户功能介绍
         * 4.欢迎使用本平台功能
         */
        String content="<html>\n" +
                "\t<body>\n" +
                "\t\t<h2 text-align=\"center\">这里是featureSelection平台 很遗憾您没通过账号注册！！</h2>\n" +
                "\t\t<div class=\"container\">\n" +
                "\t\t\t<p>账号："+unPassApplyAccount.getApplyEmail()+"</p><br />\n" +
                "\t\t\t<p>不通过原因："+unPassApplyAccount.getAdministratorReason()+"</p>\n" +
                "\t\t\t<p align=\"center\">欢迎继续登陆并使用平台的功能。</p>\n" +
                "\t\t</div>\n" +
                "\t</body>\n" +
                "</html>";
        ToEmail toEmail=new ToEmail(unPassApplyAccount.getApplyEmail(),"注册账户成功",content);
        emailUtil.htmlEmail(toEmail);
    }
}
