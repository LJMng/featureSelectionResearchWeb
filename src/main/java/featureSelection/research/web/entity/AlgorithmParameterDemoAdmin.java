package featureSelection.research.web.entity;

public class AlgorithmParameterDemoAdmin {
    //参数方案对应的算法对应的参数ID
    private Integer parameterId;
    //参数方案对应的算法对应的参数名字
    private String parameterName;
    //参数对应的参数类型
    private String parameterType;
    //参数方案对应的算法对应的参数取值
    private String parameterValue;
    //参数是否使用
    private boolean isSelected;
    //参数步骤
    private Integer executeStep;
    //参数对应的算法名称
    private String algorithmName;
    //参数对应的方案ID
    private String schemeId;
    //参数对应的方案名称
    private String schemeName;

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
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

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Integer getExecuteStep() {
        return executeStep;
    }

    public void setExecuteStep(Integer executeStep) {
        this.executeStep = executeStep;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String  getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    @Override
    public String toString() {
        return "AlgorithmParameterDemoAdmin{" +
                "parameterId=" + parameterId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterValue='" + parameterValue + '\'' +
                ", isSelected=" + isSelected +
                ", executeStep=" + executeStep +
                ", algorithmName='" + algorithmName + '\'' +
                ", schemeId='" + schemeId + '\'' +
                ", schemeName='" + schemeName + '\'' +
                '}';
    }
}
