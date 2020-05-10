package featureSelection.research.web.entity.demo.visitor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName : ParameterScheme
 * @Description : 参数方案实体类
 * @Author : WDD
 * @Date: 2020-03-30 22:07
 */
public class ParameterScheme {
    private int schemeId;
    private String schemeName;
    private String schemeDescription;
    private String schemeRemark;
    private Timestamp ut;
    private Dataset dataset;
    private List<ParameterSchemeValue>parameterSchemeValues;

    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeDescription() {
        return schemeDescription;
    }

    public void setSchemeDescription(String schemeDescription) {
        this.schemeDescription = schemeDescription;
    }

    public String getSchemeRemark() {
        return schemeRemark;
    }

    public void setSchemeRemark(String schemeRemark) {
        this.schemeRemark = schemeRemark;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    public List<ParameterSchemeValue> getParameterSchemeValues() {
        return parameterSchemeValues;
    }

    public void setParameterSchemeValues(List<ParameterSchemeValue> parameterSchemeValues) {
        this.parameterSchemeValues = parameterSchemeValues;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public String toString() {
        return "ParameterScheme{" +
                "schemeId=" + schemeId +
                ", schemeName='" + schemeName + '\'' +
                ", schemeDescription='" + schemeDescription + '\'' +
                ", schemeRemark='" + schemeRemark + '\'' +
                ", ut=" + ut +
                ", dataset=" + dataset +
                ", parameterSchemeValues=" + parameterSchemeValues +
                '}';
    }
}
