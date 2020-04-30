package featureSelection.research.web.entity;


public class ProcedureSettings {

  private long id;
  private long algorithmId;
  private String name;
  private String state;
  private String[] options;
  private String defaultOption;
  private String description;

  public ProcedureSettings(long id, long algorithmId, String name, String state, String[] options, String defaultOption, String description) {
    this.id = id;
    this.algorithmId = algorithmId;
    this.name = name;
    this.state = state;
    this.options = options;
    this.defaultOption = defaultOption;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAlgorithmId() {
    return algorithmId;
  }

  public void setAlgorithmId(long algorithmId) {
    this.algorithmId = algorithmId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String[] getOptions() {
    return options;
  }

  public void setOptions(String[] options) {
    this.options = options;
  }


  public String getDefaultOption() {
    return defaultOption;
  }

  public void setDefaultOption(String defaultOption) {
    this.defaultOption = defaultOption;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
