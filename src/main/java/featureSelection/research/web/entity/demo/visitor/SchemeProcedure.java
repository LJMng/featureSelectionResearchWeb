package featureSelection.research.web.entity.demo.visitor;

/**
 * @ClassName : SchemeProcedure
 * @Description : 方案步骤实体类
 * @Author : WDD
 * @Date: 2020-05-23 17:07
 */
public class SchemeProcedure {
    private int schemeProcedureId;
    private ParameterScheme parameterScheme;
    private String procedureName;
    private String procedureSettingData;


    public int getSchemeProcedureId() {
        return schemeProcedureId;
    }

    public void setSchemeProcedureId(int schemeProcedureId) {
        this.schemeProcedureId = schemeProcedureId;
    }

    public ParameterScheme getParameterScheme() {
        return parameterScheme;
    }

    public void setParameterScheme(ParameterScheme parameterScheme) {
        this.parameterScheme = parameterScheme;
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

    @Override
    public String toString() {
        return "SchemeProcedure{" +
                "schemeProcedureId=" + schemeProcedureId +
                ", parameterScheme=" + parameterScheme +
                ", procedureName='" + procedureName + '\'' +
                ", procedureSettingData='" + procedureSettingData + '\'' +
                '}';
    }
}
