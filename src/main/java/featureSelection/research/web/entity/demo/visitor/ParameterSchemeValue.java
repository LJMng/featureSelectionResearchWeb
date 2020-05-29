package featureSelection.research.web.entity.demo.visitor;

/**
 * @ClassName : ParameterSchemeValue
 * @Description : 参数方案值实体类
 * @Author : WDD
 * @Date: 2020-03-30 22:11
 */
public class ParameterSchemeValue {
    private String parameterInputValue;
    private String parameterOptionValue;
    private Parameter parameter;
    private ParameterScheme parameterScheme;

    public String getParameterInputValue() {
        return parameterInputValue;
    }

    public void setParameterInputValue(String parameterInputValue) {
        this.parameterInputValue = parameterInputValue;
    }

    public String getParameterOptionValue() {
        return parameterOptionValue;
    }

    public void setParameterOptionValue(String parameterOptionValue) {
        this.parameterOptionValue = parameterOptionValue;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public ParameterScheme getParameterScheme() {
        return parameterScheme;
    }

    public void setParameterScheme(ParameterScheme parameterScheme) {
        this.parameterScheme = parameterScheme;
    }

}
