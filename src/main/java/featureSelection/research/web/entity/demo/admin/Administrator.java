package featureSelection.research.web.entity.demo.admin;
/**
 * @author jjz
 * */
public class Administrator {
    private String administratorId;
    private String administratorName;
    private String administratorPassword;

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

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId='" + administratorId + '\'' +
                ", administratorName='" + administratorName + '\'' +
                ", administratorPassword='" + administratorPassword + '\'' +
                '}';
    }
}
