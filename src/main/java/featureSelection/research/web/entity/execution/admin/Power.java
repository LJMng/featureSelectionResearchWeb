package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class Power implements Serializable {
    private int accountPower;
    private int accountId;
    private boolean executionAlgorithm1;
    private boolean executionAlgorithm2;

    public int getAccountPower() {
        return accountPower;
    }

    public void setAccountPower(int accountPower) {
        this.accountPower = accountPower;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean isExecutionAlgorithm1() {
        return executionAlgorithm1;
    }

    public void setExecutionAlgorithm1(boolean executionAlgorithm1) {
        this.executionAlgorithm1 = executionAlgorithm1;
    }

    public boolean isExecutionAlgorithm2() {
        return executionAlgorithm2;
    }

    public void setExecutionAlgorithm2(boolean executionAlgorithm2) {
        this.executionAlgorithm2 = executionAlgorithm2;
    }

    @Override
    public String toString() {
        return "AccountPower{" +
                "accountPower=" + accountPower +
                ", accountId=" + accountId +
                ", executionAlgorithm1=" + executionAlgorithm1 +
                ", executionAlgorithm2=" + executionAlgorithm2 +
                '}';
    }
}
