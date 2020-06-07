package featureSelection.research.web.entity.demo.visitor;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;

/**
 * @ClassName : SchemeProcedure
 * @Description : 方案步骤实体类
 * @Author : WDD
 * @Date: 2020-05-23 17:07
 */
public class SchemeProcedure {
    private ProcedureSettings procedureSettings;
    private int schemeProcedureId;
    private ParameterScheme parameterScheme;
    private String procedureName;
    private String procedureSettingData;
    private String settingData;
    private String settingSelect;

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
        JSONObject procedureSettingDataJson=JSONObject.parseObject(procedureSettingData);
        this.settingData=procedureSettingDataJson.getString("data");
        this.settingSelect=procedureSettingDataJson.getString("selected");
    }

    public String getSettingData() {
        return settingData;
    }

    public void setSettingData(String settingData) {
        this.settingData = settingData;
    }

    public String getSettingSelect() {
        return settingSelect;
    }

    public void setSettingSelect(String settingSelect) {
        this.settingSelect = settingSelect;
    }

    public ProcedureSettings getProcedureSettings() {
        return procedureSettings;
    }

    public void setProcedureSettings(ProcedureSettings procedureSettings) {
        this.procedureSettings = procedureSettings;
    }

    @Override
    public String toString() {
        return "SchemeProcedure{" +
                "schemeProcedureId=" + schemeProcedureId +
                ", parameterScheme=" + parameterScheme +
                ", procedureName='" + procedureName + '\'' +
                ", procedureSettingData='" + procedureSettingData + '\'' +
                ", settingData='" + settingData + '\'' +
                ", settingSelect='" + settingSelect + '\'' +
                '}';
    }
}
