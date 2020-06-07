package featureSelection.research.web.entity.execution.visitor;


public class Parameter {

  private int parameterId;
  private int algorithmId;
  private String parameterName;
  private String parameterDescription;
  private String parameterType;
  private String parameterDefaultValue;
  private String parameterValidityCheckInterface;
  private String parameterValidityDescription;
  private java.sql.Timestamp ut;
  private String parameterSettingInfo;
  private String parameterNameMapper;

  public Parameter(int parameterId, int algorithmId, String parameterName, String parameterDescription, String parameterType, String parameterDefaultValue, String parameterSettingInfo, String parameterNameMapper) {
    this.parameterId = parameterId;
    this.algorithmId = algorithmId;
    this.parameterName = parameterName;
    this.parameterDescription = parameterDescription;
    this.parameterType = parameterType;
    this.parameterDefaultValue = parameterDefaultValue;
    this.parameterSettingInfo = parameterSettingInfo;
    this.parameterNameMapper = parameterNameMapper;
  }

  public int getParameterId() {
    return parameterId;
  }

  public void setParameterId(int parameterId) {
    this.parameterId = parameterId;
  }


  public int getAlgorithmId() {
    return algorithmId;
  }

  public void setAlgorithmId(int algorithmId) {
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


  public java.sql.Timestamp getUt() {
    return ut;
  }

  public void setUt(java.sql.Timestamp ut) {
    this.ut = ut;
  }


  public String getParameterSettingInfo() {
    return parameterSettingInfo;
  }

  public void setParameterSettingInfo(String parameterSettingInfo) {
    this.parameterSettingInfo = parameterSettingInfo;
  }


  public String getParameterNameMapper() {
    return parameterNameMapper;
  }

  public void setParameterNameMapper(String parameterNameMapper) {
    this.parameterNameMapper = parameterNameMapper;
  }

}
