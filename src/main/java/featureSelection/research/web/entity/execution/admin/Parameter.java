package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.util.Arrays;

public class Parameter implements Serializable {
    private Integer algorithmId;
    private Integer parameterId;
    private String parameterName;
    private String parameterDescription;
    private String parameterDefaultValue;
    private String parameterType;
    private String parameterSettingInfo;
    private String parameterNameMapper;

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

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterNameMapper() {
        return parameterNameMapper;
    }

    public void setParameterNameMapper(String parameterNameMapper) {
        this.parameterNameMapper = parameterNameMapper;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "algorithmId=" + algorithmId +
                ", parameterId=" + parameterId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterDescription='" + parameterDescription + '\'' +
                ", parameterDefaultValue='" + parameterDefaultValue + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterSettingInfo='" + parameterSettingInfo + '\'' +
                ", parameterNameMapper='" + parameterNameMapper + '\'' +
                '}';
    }
}
