package featureSelection.research.web.entity.demo.visitor;

import java.util.List;

/**
 * @ClassName : Parameter
 * @Description : 参数实体类
 * @Author : WDD
 * @Date: 2020-03-30 21:37
 */
public class Parameter {
    private int parameterId;
    private String parameterName;
    private String parameterDescription;
    private String parameterType;
    private String parameterDefaultValue;
    private String parameterValidityCheckInterface;
    private String parameterValidityDescription;
    private Algorithm algorithm;
    private List<ParameterSchemeValue> parameterSchemeValues;

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
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

    public String getParameterValidityCheckInterface() {
        return parameterValidityCheckInterface;
    }

    public void setParameterValidityCheckInterface(String parameterValidityCheckInterface) {
        this.parameterValidityCheckInterface = parameterValidityCheckInterface;
    }

    public String getParameterValidityDescription() {
        return parameterValidityDescription;
    }

    public void setParameterValidityDescription(String parameterValidityDescription) {
        this.parameterValidityDescription = parameterValidityDescription;
    }

    public List<ParameterSchemeValue> getParameterSchemeValues() {
        return parameterSchemeValues;
    }

    public void setParameterSchemeValues(List<ParameterSchemeValue> parameterSchemeValues) {
        this.parameterSchemeValues = parameterSchemeValues;
    }

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "parameterId=" + parameterId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterDescription='" + parameterDescription + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterDefaultValue='" + parameterDefaultValue + '\'' +
                ", parameterValidityCheckInterface='" + parameterValidityCheckInterface + '\'' +
                ", parameterValidityDescription='" + parameterValidityDescription + '\'' +
                ", algorithm=" + algorithm +
                ", parameterSchemeValues=" + parameterSchemeValues +
                '}';
    }
}
