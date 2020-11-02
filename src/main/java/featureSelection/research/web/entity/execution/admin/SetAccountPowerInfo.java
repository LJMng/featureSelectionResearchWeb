package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class SetAccountPowerInfo implements Serializable {
    private int accountId;
    private int algorithmId;
    private String administratorName;
    private String algorithmName;
    private String haveUploadDocPower;
    private String haveDownloadDocPower;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getHaveUploadDocPower() {
        return haveUploadDocPower;
    }

    public void setHaveUploadDocPower(String haveUploadDocPower) {
        this.haveUploadDocPower = haveUploadDocPower;
    }

    public String getHaveDownloadDocPower() {
        return haveDownloadDocPower;
    }

    public void setHaveDownloadDocPower(String haveDownloadDocPower) {
        this.haveDownloadDocPower = haveDownloadDocPower;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    @Override
    public String toString() {
        return "setAccountPowerInfo{" +
                "accountId=" + accountId +
                ", algorithmId=" + algorithmId +
                ", administratorName='" + administratorName + '\'' +
                ", algorithmName='" + algorithmName + '\'' +
                ", haveUploadDocPower='" + haveUploadDocPower + '\'' +
                ", haveDownloadDocPower='" + haveDownloadDocPower + '\'' +
                '}';
    }
}
