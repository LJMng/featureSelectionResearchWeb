package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;


/**
 * @ClassName: Dataset
 * @Description: 数据集实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class Dataset implements Serializable {
    private int datasetId;
    private String datasetName;
    private String datasetDescription;
    private long datasetCount;
    private String datasetSource;
    private String datasetDimension;
    private boolean isCommon;
    private String datasetFile;
    private String datasetSize;
    private String datasetRecords;
    private String datasetTags;
    private String datasetType;



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

    public long getDatasetCount() {
        return datasetCount;
    }

    public void setDatasetCount(long datasetCount) {
        this.datasetCount = datasetCount;
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

    public boolean isCommon() {
        return isCommon;
    }

    public void setCommon(boolean common) {
        isCommon = common;
    }

    public String getDatasetFile() {
        return datasetFile;
    }

    public void setDatasetFile(String datasetFile) {
        this.datasetFile = datasetFile;
    }

    public String getDatasetSize() {
        return datasetSize;
    }

    public void setDatasetSize(String datasetSize) {
        this.datasetSize = datasetSize;
    }

    public String getDatasetRecords() {
        return datasetRecords;
    }

    public void setDatasetRecords(String datasetRecords) {
        this.datasetRecords = datasetRecords;
    }

    public String getDatasetTags() {
        return datasetTags;
    }

    public void setDatasetTags(String datasetTags) {
        this.datasetTags = datasetTags;
    }

    public String getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetId=" + datasetId +
                ", datasetName='" + datasetName + '\'' +
                ", datasetDescription='" + datasetDescription + '\'' +
                ", datasetCount=" + datasetCount +
                ", datasetSource='" + datasetSource + '\'' +
                ", datasetDimension=" + datasetDimension +
                ", isCommon=" + isCommon +
                ", datasetFile='" + datasetFile + '\'' +
                '}';
    }
}
