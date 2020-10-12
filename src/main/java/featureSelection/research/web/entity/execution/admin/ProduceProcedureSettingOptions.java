package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * 用于生成每个步骤的options信息的实体类
 * @Author 马凯健
 */
public class ProduceProcedureSettingOptions implements Serializable {
    private int algorithmId;
    private String procedureName;
    private String procedureOptions;

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureOptions() {
        return procedureOptions;
    }

    public void setProcedureOptions(String procedureOptions) {
        this.procedureOptions = procedureOptions;
    }

    @Override
    public String toString() {
        return "ProduceProcedureSettingOptions{" +
                "algorithmId=" + algorithmId +
                ", procedureName='" + procedureName + '\'' +
                ", procedureOptions='" + procedureOptions + '\'' +
                '}';
    }
}
