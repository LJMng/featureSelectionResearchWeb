package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;


public class Dataset implements Serializable {
    private int datasetId;
    private String datasetName;
    private String datasetDescription;
    private long datasetCount;
    private String datasetSource;
    private long datasetDimension;
    private boolean isCommon;
    private String datasetFile;


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

    public long getDatasetDimension() {
        return datasetDimension;
    }

    public void setDatasetDimension(long datasetDimension) {
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
