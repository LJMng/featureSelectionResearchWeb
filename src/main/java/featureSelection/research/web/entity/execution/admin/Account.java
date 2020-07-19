package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * @ClassName: Account
 * @Description: 用户实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class Account implements Serializable {
    private int accountId;
    private String accountName;
    private String accountPassword;
    private String accountEmail;
    private int accountPower;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public int getAccountPower() {
        return accountPower;
    }

    public void setAccountPower(int accountPower) {
        this.accountPower = accountPower;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", accountPower=" + accountPower +
                '}';
    }

}
