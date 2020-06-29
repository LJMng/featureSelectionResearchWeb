package featureSelection.research.web.entity.demo.visitor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName : Dataset
 * @Description : 数据集实体类
 * @Author : WDD
 * @Date: 2020-03-30 21:33
 */
public class Dataset{
    private int datasetId;
    private String datasetName;
    private String datasetDescription;
    private String datasetSize;
    private String datasetSource;
    private String datasetDimension;
    private String datasetFile;
    private boolean isCommmon;
    private Timestamp ut;
    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public String getDatasetDescription() {
        return datasetDescription;
    }

    public void setDatasetDescription(String datasetDescription) {
        this.datasetDescription = datasetDescription;
    }

    public String getDatasetSize() {
        return datasetSize;
    }

    public void setDatasetSize(String datasetSize) {
        this.datasetSize = datasetSize;
    }

    public String getDatasetSource() {
        return datasetSource;
    }

    public void setDatasetSource(String datasetSource) {
        this.datasetSource = datasetSource;
    }

    public String getDatasetDimension() {
        return datasetDimension;
    }

    public void setDatasetDimension(String datasetDimension) {
        this.datasetDimension = datasetDimension;
    }

    public boolean isCommmon() {
        return isCommmon;
    }

    public void setCommmon(boolean commmon) {
        isCommmon = commmon;
    }

    public Timestamp isUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    public String getdatasetFile() {
        return datasetFile;
    }

    public void setdatasetFile(String datasetFile) {
        this.datasetFile = datasetFile;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetId=" + datasetId +
                ", datasetName='" + datasetName + '\'' +
                ", datasetDescription='" + datasetDescription + '\'' +
                ", datasetSize='" + datasetSize + '\'' +
                ", datasetSource='" + datasetSource + '\'' +
                ", datasetDimension='" + datasetDimension + '\'' +
                ", datasetFile='" + datasetFile + '\'' +
                ", isCommmon=" + isCommmon +
                ", ut=" + ut +
                '}';
    }
}
