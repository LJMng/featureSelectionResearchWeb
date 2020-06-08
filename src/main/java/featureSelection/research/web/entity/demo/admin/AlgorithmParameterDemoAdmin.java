package featureSelection.research.web.entity.demo.admin;
/**
 * @author jjz
 * */
public class AlgorithmParameterDemoAdmin {
    //参数方案对应的算法对应的参数ID
    private Integer parameterId;
    //参数方案对应的算法对应的参数名字
    private String parameterName;
    //参数对应的参数类型
    private String parameterType;
    //参数方案对应的算法对应的参数取值
    private String parameterInputValue;
    private String parameterOptionValue;
    //参数对应的算法名称
    private String algorithmName;
    //参数对应的方案ID
    private Integer schemeId;
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

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
        this.schemeId = schemeId;
    }

    public String  getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
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

    @Override
    public String toString() {
        return "AlgorithmParameterDemoAdmin{" +
                "parameterId=" + parameterId +
                ", parameterName='" + parameterName + '\'' +
                ", parameterType='" + parameterType + '\'' +
                ", parameterInputValue='" + parameterInputValue + '\'' +
                ", parameterOptionValue='" + parameterOptionValue + '\'' +
                ", algorithmName='" + algorithmName + '\'' +
                ", schemeId=" + schemeId +
                ", schemeName='" + schemeName + '\'' +
                '}';
    }
}
