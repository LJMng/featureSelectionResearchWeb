package featureselection.research.web.entity;


/**
 * @author BuTTer
 */
public class Parameter {

  private long parameterId;
  private long algorithmId;
  private String parameterName;
  private String parameterDescription;
  private String parameterType;
  private String parameterDefaultValue;
  private String parameterValidityCheckInterface;
  private String parameterValidityDescription;
  private java.sql.Timestamp ut;

  public Parameter() {
  }

  public Parameter(long parameterId, long algorithmId, String parameterName, String parameterDescription, String parameterType, String parameterDefaultValue) {
    this.parameterId = parameterId;
    this.algorithmId = algorithmId;
    this.parameterName = parameterName;
    this.parameterDescription = parameterDescription;
    this.parameterType = parameterType;
    this.parameterDefaultValue = parameterDefaultValue;
  }

  public long getParameterId() {
    return parameterId;
  }

  public void setParameterId(long parameterId) {
    this.parameterId = parameterId;
  }


  public long getAlgorithmId() {
    return algorithmId;
  }

  public void setAlgorithmId(long algorithmId) {
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

}
