package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * 封装excel文件添加算法参数信息的实体类
 * @Author: 马凯健
 */
public class ParameterExcelRowObject implements Serializable {
    private String algorithmName;
    private String parameterName;
    private String parameterDescription;
    private String parameterDefaultValue;
    private String parameterNameMapper;
    private String parameterType;
    private String parameterValue;
    private String parameterExtraType;
    private String parameterExtraValue;
    private String parameterValueMapper;
    private String parameterExtraValueMapper;

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
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

    public String getParameterDefaultValue() {
        return parameterDefaultValue;
    }

    public void setParameterDefaultValue(String parameterDefaultValue) {
        this.parameterDefaultValue = parameterDefaultValue;
    }

    public String getParameterNameMapper() {
        return parameterNameMapper;
    }

    public void setParameterNameMapper(String parameterNameMapper) {
        this.parameterNameMapper = parameterNameMapper;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterExtraType() {
        return parameterExtraType;
    }

    public void setParameterExtraType(String parameterExtraType) {
        this.parameterExtraType = parameterExtraType;
    }

    public String getParameterExtraValue() {
        return parameterExtraValue;
    }

    public void setParameterExtraValue(String parameterExtraValue) {
        this.parameterExtraValue = parameterExtraValue;
    }

    public String getParameterValueMapper() {
        return parameterValueMapper;
    }

    public void setParameterValueMapper(String parameterValueMapper) {
        this.parameterValueMapper = parameterValueMapper;
    }

    public String getParameterExtraValueMapper() {
        return parameterExtraValueMapper;
    }

    public void setParameterExtraValueMapper(String parameterExtraValueMapper) {
        this.parameterExtraValueMapper = parameterExtraValueMapper;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public String toString() {
        return "ParameterExcelRowObject{" +
                "algorithmName='" + algorithmName + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", parameterDescription='" + parameterDescription + '\'' +
                ", parameterDefaultValue='" + parameterDefaultValue + '\'' +
                ", parameterNameMapper='" + parameterNameMapper + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterValue='" + parameterValue + '\'' +
                ", parameterExtraType='" + parameterExtraType + '\'' +
                ", parameterExtraValue='" + parameterExtraValue + '\'' +
                ", parameterValueMapper='" + parameterValueMapper + '\'' +
                ", parameterExtraValueMapper='" + parameterExtraValueMapper + '\'' +
                '}';
    }
}
