package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class Parameter implements Serializable {
    private Integer algorithmId;
    private String parameterName;
    private String parameterDescription;
    private String parameterType;
    private String parameterDefaultValue;
    private String parameterSettingInfo;

    public Integer getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(Integer algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterDescription() {
        return parameterDescription;
    }

    public void setParameterDescription(String parameterDescription) {
        this.parameterDescription = parameterDescription;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterDefaultValue() {
        return parameterDefaultValue;
    }

    public void setParameterDefaultValue(String parameterDefaultValue) {
        this.parameterDefaultValue = parameterDefaultValue;
    }

    public String getParameterSettingInfo() {
        return parameterSettingInfo;
    }

    public void setParameterSettingInfo(String parameterSettingInfo) {
        this.parameterSettingInfo = parameterSettingInfo;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "algorithmId=" + algorithmId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterDescription='" + parameterDescription + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterDefaultValue='" + parameterDefaultValue + '\'' +
                ", parameterSettingInfo='" + parameterSettingInfo + '\'' +
                '}';
    }
}
