package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class ProcedureSettings implements Serializable {
    private int id;
    private int algorithmId;
    private String name;
    private String state;
    private String options;
    private String defaultOption;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProcedureSettings{" +
                "id=" + id +
                ", algorithmId=" + algorithmId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", options='" + options + '\'' +
                ", defaultOption='" + defaultOption + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
