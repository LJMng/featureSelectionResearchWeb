package featureSelection.research.web.entity.execution.visitor;


public class Dataset {

  private int datasetId;
  private String datasetName;
  private String datasetDescription;
  private String datasetSize;
  private String datasetSource;
  private String datasetDimension;
  private String datasetRecords;
  private String datasetTags;
  private String datasetType;
  private String datasetFile;
  private String isCommon;
  private java.sql.Timestamp ut;


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


  public String getDatasetFile() {
    return datasetFile;
  }

  public void setDatasetFile(String datasetFile) {
    this.datasetFile = datasetFile;
  }


  public String getIsCommon() {
    return isCommon;
  }

  public void setIsCommon(String isCommon) {
    this.isCommon = isCommon;
  }


  public java.sql.Timestamp getUt() {
    return ut;
  }

  public void setUt(java.sql.Timestamp ut) {
    this.ut = ut;
  }

}
