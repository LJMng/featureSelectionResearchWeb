package featureSelection.research.web.service.execution.admin.impl;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.EmailUtil;
import featureSelection.research.web.entity.execution.admin.*;
import featureSelection.research.web.mybatisMapper.execution.admin.AccountMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.AlgorithmMapper;
import featureSelection.research.web.service.execution.admin.AccountBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class AccountBusinessImpl implements AccountBusiness {
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private EmailUtil emailUtil;
    @Autowired
    private AlgorithmMapper algorithmMapper;

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
        System.out.println(account);
        account.setAccountPower("{\"user:download\":[],\"user:upload\":[]}");
        accountMapper.addAccount(account);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountMapper.deleteAccount(accountId);
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
        account.setAccountPower("{\"user:download\":[],\"user:upload\":[]}");
        //调用添加用户的方法
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

    @Override
    public void setAccountPower(SetAccountPowerInfo setAccountPowerInfo) {
        //获取accountPower字符串
        String accountPower=accountMapper.getAccountPowerById(setAccountPowerInfo.getAccountId());
        //将要设置权限的算法Id转成字符串
        int addPowerAlgorithmId = algorithmMapper.getAlgorithmIdByName(setAccountPowerInfo.getAlgorithmName());
        String currAlgorithmId = addPowerAlgorithmId+"";
        //解析accountPower字符串，将accountPower转化为字符串数组
        JSONObject accountPowerJsonObject = JSONObject.parseObject(accountPower);
        String[] downLoadAlgorithmDocArr = accountPowerJsonObject.get("user:download").toString().replace("[","").replace("]","").split(",");
        String[] upLoadAlgorithmDocArr = accountPowerJsonObject.get("user:upload").toString().replace("[","").replace("]","").split(",");
        boolean addDownLoadDocPower = true;
        boolean addUploadDocPower = true;
        //设置下载权限
        if (setAccountPowerInfo.getHaveDownloadDocPower().equals("true")){
            for (String algorithmId:downLoadAlgorithmDocArr){
                if(algorithmId.equals(currAlgorithmId)){
                    addDownLoadDocPower = false;
                }
            }
            if (addDownLoadDocPower){
                String[] currentDownLoadAlgorithmDocArr =new String[downLoadAlgorithmDocArr.length+1];
                for (int i=0;i<downLoadAlgorithmDocArr.length;i++){
                    currentDownLoadAlgorithmDocArr[i] = downLoadAlgorithmDocArr[i];
                }
                currentDownLoadAlgorithmDocArr[downLoadAlgorithmDocArr.length]=currAlgorithmId;
                downLoadAlgorithmDocArr = currentDownLoadAlgorithmDocArr;
            }
        }else{
            //确定当前数组长度
            int a=0;
            for (int i=0;i<downLoadAlgorithmDocArr.length;i++) {
                if (downLoadAlgorithmDocArr[i].equals(currAlgorithmId)) {
                    continue;
                } else {
                    a++;
                }
            }
            //定义新的下载权限数组
            String[] currDownLoadAlgorithmDocArr = new String[a];
            int j = 0;
            //给新的数组赋值
            for (int i=0;i<downLoadAlgorithmDocArr.length;i++){
                if(downLoadAlgorithmDocArr[i].equals(currAlgorithmId)){
                    continue;
                }else {
                    currDownLoadAlgorithmDocArr [j] = downLoadAlgorithmDocArr[i];
                    j++;
                }
            }
            //数组替换
            downLoadAlgorithmDocArr = currDownLoadAlgorithmDocArr;
        }
        //设置上传权限
        if (setAccountPowerInfo.getHaveUploadDocPower().equals("true")){
            for (String algorithmId:upLoadAlgorithmDocArr){
                if(algorithmId.equals(currAlgorithmId)){
                    addUploadDocPower = false;
                }
            }
            if (addUploadDocPower){
                String[] currentUpLoadAlgorithmDocArr =new String[upLoadAlgorithmDocArr.length+1];
                for (int i=0;i<upLoadAlgorithmDocArr.length;i++){
                    currentUpLoadAlgorithmDocArr[i] = upLoadAlgorithmDocArr[i];
                }
                currentUpLoadAlgorithmDocArr[upLoadAlgorithmDocArr.length]=currAlgorithmId;
                upLoadAlgorithmDocArr = currentUpLoadAlgorithmDocArr;
            }
        }else{
            //确定当前数组长度
            int uploadArrLen=0;
            for (int i=0;i<upLoadAlgorithmDocArr.length;i++) {
                if (upLoadAlgorithmDocArr[i].equals(currAlgorithmId)) {
                    continue;
                } else {
                    uploadArrLen++;
                }
            }
            //定义新的下载权限数组
            String[] currUploadAlgorithmDocArr = new String[uploadArrLen];
            int j = 0;
            //给新的数组赋值
            for (int i=0;i<upLoadAlgorithmDocArr.length;i++){
                if(upLoadAlgorithmDocArr[i].equals(currAlgorithmId)){
                    continue;
                }else {
                    currUploadAlgorithmDocArr [j] = upLoadAlgorithmDocArr[i];
                    j++;
                }
            }
            //数组替换
                upLoadAlgorithmDocArr = currUploadAlgorithmDocArr;
        }
        //将上传与下载的权限数组转成JSON字符串，存入数据库
        StringBuilder downLoadSb= new StringBuilder();
        StringBuilder upLoadSb = new StringBuilder();
        for (int i=0;i<downLoadAlgorithmDocArr.length;i++){
            downLoadSb.append(downLoadAlgorithmDocArr[i]);
            if (i != downLoadAlgorithmDocArr.length-1 && !downLoadAlgorithmDocArr[0].equals("")){
                downLoadSb.append(",");
            }
        }
        for (int i=0;i<upLoadAlgorithmDocArr.length;i++){
            upLoadSb.append(upLoadAlgorithmDocArr[i]);
            System.out.println(upLoadAlgorithmDocArr.length-1);
            if (i != upLoadAlgorithmDocArr.length-1 && !upLoadAlgorithmDocArr[0].equals("")){
                upLoadSb.append(",");
            }
        }
        String downLoadAlgorithmString = downLoadSb.toString();
        String upLoadAlgorithmString = upLoadSb.toString();
        String accountPowerJsonString = "{\"user:download\":[" +
                downLoadAlgorithmString + "],\"user:upload\":[" +
                upLoadAlgorithmString + "]}";
        accountMapper.updateAccountPower(setAccountPowerInfo.getAccountId(),accountPowerJsonString);
    }

    @Override
    public SetAccountPowerInfo getAccountPower(SetAccountPowerInfo setAccountPowerInfo) {
        Integer algorithmId = algorithmMapper.getAlgorithmIdByName(setAccountPowerInfo.getAlgorithmName());
        setAccountPowerInfo.setAlgorithmId(algorithmId);
        Account account = accountMapper.getAccountById(setAccountPowerInfo.getAccountId());
        String accountPower = account.getAccountPower();
        JSONObject accountPowerJSONObject = JSONObject.parseObject(accountPower);
        String [] accountDownLoadPower = accountPowerJSONObject.get("user:download").toString()
                .replace("[","")
                .replace("]","")
                .split(",");
        String [] accountUploadPower = accountPowerJSONObject.get("user:upload").toString()
                .replace("[","")
                .replace("]","")
                .split(",");
        setAccountPowerInfo.setHaveDownloadDocPower("false");
        setAccountPowerInfo.setHaveUploadDocPower("false");
        if ( !accountDownLoadPower[0].equals("")){
            for (String downloadPowerAlgorithmId:accountDownLoadPower){
                if (Integer.parseInt(downloadPowerAlgorithmId) ==
                        setAccountPowerInfo.getAlgorithmId()){
                    setAccountPowerInfo.setHaveDownloadDocPower("true");
                }
            }
        }
        if (!accountUploadPower[0].equals("")){
            for (String uploadPowerAlgorithmId:accountUploadPower){
                if (Integer.parseInt(uploadPowerAlgorithmId) ==
                        setAccountPowerInfo.getAlgorithmId()){
                    setAccountPowerInfo.setHaveUploadDocPower("true");
                }
            }
        }
        SetAccountPowerInfo currentSetAccountPowerInfo = new SetAccountPowerInfo();
        currentSetAccountPowerInfo =setAccountPowerInfo;
        return currentSetAccountPowerInfo;
    }
}
