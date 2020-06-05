package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class WebAlgorithmMapperEntity implements Serializable {
    private int webAlgorithmMapperId;
    private int algorithmId;
    private int parameterId;
    private int procedureSettingId;
    private String webKey;
    private String algorithmValue;

    public int getWebAlgorithmMapperId() {
        return webAlgorithmMapperId;
    }

    public void setWebAlgorithmMapperId(int webAlgorithmMapperId) {
        this.webAlgorithmMapperId = webAlgorithmMapperId;
    }

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
    }

    public int getProcedureSettingId() {
        return procedureSettingId;
    }

    public void setProcedureSettingId(int procedureSettingId) {
        this.procedureSettingId = procedureSettingId;
    }

    public String getWebKey() {
        return webKey;
    }

    public void setWebKey(String webKey) {
        this.webKey = webKey;
    }

    public String getAlgorithmValue() {
        return algorithmValue;
    }

    public void setAlgorithmValue(String algorithmValue) {
        this.algorithmValue = algorithmValue;
    }

    @Override
    public String toString() {
        return "WebAlgorithmMapper{" +
                "webAlgorithmMapperId=" + webAlgorithmMapperId +
                ", algorithmId=" + algorithmId +
                ", parameterId=" + parameterId +
                ", procedureSettingId=" + procedureSettingId +
                ", webKey='" + webKey + '\'' +
                ", algorithmValue='" + algorithmValue + '\'' +
                '}';
    }
}
