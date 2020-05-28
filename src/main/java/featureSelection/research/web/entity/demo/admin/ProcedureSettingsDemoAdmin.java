package featureSelection.research.web.entity.demo.admin;

public class ProcedureSettingsDemoAdmin {
    private Integer id;
    private Integer algorithmId;
    private String name;
    private String state;
    private String options;
    private String defaultOption;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(Integer algorithmId) {
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

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }

    @Override
    public String toString() {
        return "ProcedureSettingsDemoAdmin{" +
                "id=" + id +
                ", algorithmId=" + algorithmId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", options='" + options + '\'' +
                ", defaultOption='" + defaultOption + '\'' +
                '}';
    }
}
