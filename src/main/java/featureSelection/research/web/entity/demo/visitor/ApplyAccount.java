package featureSelection.research.web.entity.demo.visitor;

import java.sql.Timestamp;

/**
 * @ClassName : ApplyAccount
 * @Description : VIP申请单
 * @Author : WDD
 * @Date: 2020-04-13 15:00
 */
public class ApplyAccount {
    private int applyId;
    private String applyEmail;
    private String applyReason;
    private String applyCondition;
    private String adminstratorReason;
    private Timestamp ut;
    private String applyPassword;
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

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getAdminstratorReason() {
        return adminstratorReason;
    }

    public void setAdminstratorReason(String adminstratorReason) {
        this.adminstratorReason = adminstratorReason;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    public String getapplyPassword() {
        return applyPassword;
    }

    public void setapplyPassword(String applyPassword) {
        this.applyPassword = applyPassword;
    }

    @Override
    public String toString() {
        return "ApplyAccount{" +
                "applyId=" + applyId +
                ", applyEmail='" + applyEmail + '\'' +
                ", applyReason='" + applyReason + '\'' +
                ", applyCondition='" + applyCondition + '\'' +
                ", adminstratorReason='" + adminstratorReason + '\'' +
                ", ut=" + ut +
                ", applyPassword='" + applyPassword + '\'' +
                '}';
    }
}
