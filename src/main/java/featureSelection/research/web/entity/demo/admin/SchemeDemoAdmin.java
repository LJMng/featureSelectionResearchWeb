package featureSelection.research.web.entity.demo.admin;

import java.util.List;

public class SchemeDemoAdmin {
    //方案ID
    private Integer schemeId;
    //方案名称
    private String schemeName;
    //方案描述
    private String schemeDescription;
    //方案备注
    private String schemeRemark;
    //数据集ID
    private Integer datasetId;
    //数据集名称
    private String datasetName;
    //方案算法ID
    private String algorithmId;
    //方案算法名称
    private String algorithmName;
    //算法参数
    private List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin;

    //各种getter/setter以及toString()方法
    public Integer getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Integer schemeId) {
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

    public String getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(String algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public List<AlgorithmParameterDemoAdmin> getAlgorithmParameterDemoAdmin() {
        return algorithmParameterDemoAdmin;
    }

    public void setAlgorithmParameterDemoAdmin(List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin) {
        this.algorithmParameterDemoAdmin = algorithmParameterDemoAdmin;
    }

    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }

    @Override
    public String toString() {
        return "SchemeDemoAdmin{" +
                "schemeId=" + schemeId +
                ", schemeName='" + schemeName + '\'' +
                ", schemeDescription='" + schemeDescription + '\'' +
                ", schemeRemark='" + schemeRemark + '\'' +
                ", datasetId=" + datasetId +
                ", datasetName='" + datasetName + '\'' +
                ", algorithmId='" + algorithmId + '\'' +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmParameterDemoAdmin=" + algorithmParameterDemoAdmin +
                '}';
    }
}
