package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * @ClassName: Administrator
 * @Description: 管理员实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class Administrator implements Serializable {
    private String administratorId;
    //管理员账号
    private String administratorName;
    private String administratorPassword;
    private String confirmAdministratorPassword;

    public String getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(String administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    public String getConfirmAdministratorPassword() {
        return confirmAdministratorPassword;
    }

    public void setConfirmAdministratorPassword(String confirmAdministratorPassword) {
        this.confirmAdministratorPassword = confirmAdministratorPassword;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId='" + administratorId + '\'' +
                ", administratorName='" + administratorName + '\'' +
                ", administratorPassword='" + administratorPassword + '\'' +
                ", confirmAdministratorPassword='" + confirmAdministratorPassword + '\'' +
                '}';
    }
}
