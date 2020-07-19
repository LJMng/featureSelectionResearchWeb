package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @ClassName: ApplyAccount
 * @Description: 申请用户实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class ApplyAccount implements Serializable {
    private int applyId;
    private String applyEmail;
    private String applyPassword;
    private String applyReason;
    private String administratorId;
    private String applyCondition;
    private String administratorReason;
    private Timestamp ut;

    @Override
    public String toString() {
        return "ApplyAccount{" +
                "applyId=" + applyId +
                ", applyEmail='" + applyEmail + '\'' +
                ", applyPassword='" + applyPassword + '\'' +
                ", applyReason='" + applyReason + '\'' +
                ", administratorId='" + administratorId + '\'' +
                ", applyCondition='" + applyCondition + '\'' +
                ", administratorReason='" + administratorReason + '\'' +
                ", ut=" + ut +
                '}';
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getApplyEmail() {
        return applyEmail;
    }

    public void setApplyEmail(String applyEmail) {
        this.applyEmail = applyEmail;
    }

    public String getApplyPassword() {
        return applyPassword;
    }

    public void setApplyPassword(String applyPassword) {
        this.applyPassword = applyPassword;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getAdministratorReason() {
        return administratorReason;
    }

    public void setAdministratorReason(String administratorReason) {
        this.administratorReason = administratorReason;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }
}
