package featureSelection.research.web.entity.execution.visitor;


public class ProcedureSettings {

  private int id;
  private int algorithmId;
  private String name;
  private String state;
  private String[] options;
  private String defaultOption;
  private String description;
  private String nameMapper;

  public ProcedureSettings(int id, int algorithmId, String name, String state, String[] options, String defaultOption, String description, String nameMapper) {
    this.id = id;
    this.algorithmId = algorithmId;
    this.name = name;
    this.state = state;
    this.options = options;
    this.defaultOption = defaultOption;
    this.description = description;
    this.nameMapper = nameMapper;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getAlgorithmId() {
    return algorithmId;
  }

  public void setAlgorithmId(int algorithmId) {
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


  public String getNameMapper() {
    return nameMapper;
  }

  public void setNameMapper(String nameMapper) {
    this.nameMapper = nameMapper;
  }

}
