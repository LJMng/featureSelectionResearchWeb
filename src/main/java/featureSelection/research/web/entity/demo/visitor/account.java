package featureSelection.research.web.entity.demo.visitor;

import java.io.Serializable;

/**
 * @ClassName : account
 * @Description : 用户实体类
 * @Author : WDD
 * @Date: 2020-05-04 20:44
 */
public class account implements Serializable {
    private int accountId;
    private String accountName;
    private String accountPassword;
    private String accountEmail;
    private String accountPower;

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

    public String getAccountPower() {
        return accountPower;
    }

    public void setAccountPower(String accountPower) {
        this.accountPower = accountPower;
    }

    @Override
    public String toString() {
        return "account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountEmail='" + accountEmail + '\'' +
                ", accountPower='" + accountPower + '\'' +
                '}';
    }
}
