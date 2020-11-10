package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * @ClassName: ProcedureSettings
 * @Description: 算法步骤实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class ProcedureSettings implements Serializable {
    private Integer id;
    private Integer algorithmId;
    private String name;
    private String state;
    private String options;
    private String optionsMapper;
    private String defaultOption;
    private String description;
    private String nameMapper;
    private String option;
    private String optionMapper;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getOptionsMapper() {
        return optionsMapper;
    }

    public void setOptionsMapper(String optionsMapper) {
        this.optionsMapper = optionsMapper;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getOptionMapper() {
        return optionMapper;
    }

    public void setOptionMapper(String optionMapper) {
        this.optionMapper = optionMapper;
    }

    @Override
    public String toString() {
        return "ProcedureSettings{" +
                "id=" + id +
                ", algorithmId=" + algorithmId +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", options='" + options + '\'' +
                ", optionsMapper='" + optionsMapper + '\'' +
                ", defaultOption='" + defaultOption + '\'' +
                ", description='" + description + '\'' +
                ", nameMapper='" + nameMapper + '\'' +
                ", option='" + option + '\'' +
                ", optionMapper='" + optionMapper + '\'' +
                '}';
    }
}
