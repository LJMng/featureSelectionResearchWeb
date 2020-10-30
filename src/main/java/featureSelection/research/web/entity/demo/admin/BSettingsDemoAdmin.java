package featureSelection.research.web.entity.demo.admin;

public class BSettingsDemoAdmin {
    public Integer schemeId;
    public String parameterInputValue;
    public String parameterOptionValue;
    public String parameterName;
    public String parameterType;

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

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

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "BSettingsDemoAdmin{" +
                "schemeId=" + schemeId +
                ", parameterInputValue='" + parameterInputValue + '\'' +
                ", parameterOptionValue='" + parameterOptionValue + '\'' +
                ", parameterName='" + parameterName + '\'' +
                ", parameterType='" + parameterType + '\'' +
                '}';
    }
}
