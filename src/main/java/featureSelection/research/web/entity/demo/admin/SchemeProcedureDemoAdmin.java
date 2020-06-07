package featureSelection.research.web.entity.demo.admin;

/**
 * @author jjz
 * */
public class SchemeProcedureDemoAdmin {
    public Integer schemeProcedureId;
    public Integer schemeId;
    public String procedureName;
    public String procedureSettingData;
    public Integer procedureSettingsId;

    public Integer getSchemeProcedureId() {
        return schemeProcedureId;
    }

    public void setSchemeProcedureId(Integer schemeProcedureId) {
        this.schemeProcedureId = schemeProcedureId;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureSettingData() {
        return procedureSettingData;
    }

    public void setProcedureSettingData(String procedureSettingData) {
        this.procedureSettingData = procedureSettingData;
    }

    public Integer getProcedureSettingsId() {
        return procedureSettingsId;
    }

    public void setProcedureSettingsId(Integer procedureSettingsId) {
        this.procedureSettingsId = procedureSettingsId;
    }

    @Override
    public String toString() {
        return "SchemeProcedureDemoAdmin{" +
                "schemeProcedureId=" + schemeProcedureId +
                ", schemeId=" + schemeId +
                ", procedureName='" + procedureName + '\'' +
                ", procedureSettingData='" + procedureSettingData + '\'' +
                ", procedureSettingsId=" + procedureSettingsId +
                '}';
    }
}
