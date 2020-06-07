package featureSelection.research.web.entity.execution.visitor;


public class WebAlgorithmMapper {

  private long webAlgorithmMapperId;
  private long parameterId;
  private long algorithmId;
  private long procedureSettingId;
  private String webKey;
  private String algorithmValue;


  public long getWebAlgorithmMapperId() {
    return webAlgorithmMapperId;
  }

  public void setWebAlgorithmMapperId(long webAlgorithmMapperId) {
    this.webAlgorithmMapperId = webAlgorithmMapperId;
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


  public long getProcedureSettingId() {
    return procedureSettingId;
  }

  public void setProcedureSettingId(long procedureSettingId) {
    this.procedureSettingId = procedureSettingId;
  }


  public String getWebKey() {
    return webKey;
  }

  public void setWebKey(String webKey) {
    this.webKey = webKey;
  }


  public String getAlgorithmValue() {
    return algorithmValue;
  }

  public void setAlgorithmValue(String algorithmValue) {
    this.algorithmValue = algorithmValue;
  }

}
