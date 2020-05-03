package featureSelection.research.web.entity.execution.visitor;


public class TaskInfo {

  private int taskId;
  private int accountId;
  private String taskName;
  private String taskStatus;
  private String taskComment;
  private String taskReviewer;
  private java.sql.Timestamp taskReviewedTime;
  private java.sql.Timestamp taskStartTime;
  private java.sql.Timestamp taskEndTime;
  private String taskEmail;
  private int algorithmId;
  private String algorithmParameters;
  private Integer datasetId;
  private String datasetUpload;
  private java.sql.Timestamp algorithmStartTime;
  private java.sql.Timestamp algorithmEndTime;
  private String algorithmStatus;
  private java.sql.Timestamp updateTime;


  public int getTaskId() {
    return taskId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }


  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }


  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }


  public String getTaskComment() {
    return taskComment;
  }

  public void setTaskComment(String taskComment) {
    this.taskComment = taskComment;
  }


  public String getTaskReviewer() {
    return taskReviewer;
  }

  public void setTaskReviewer(String taskReviewer) {
    this.taskReviewer = taskReviewer;
  }


  public java.sql.Timestamp getTaskReviewedTime() {
    return taskReviewedTime;
  }

  public void setTaskReviewedTime(java.sql.Timestamp taskReviewedTime) {
    this.taskReviewedTime = taskReviewedTime;
  }


  public java.sql.Timestamp getTaskStartTime() {
    return taskStartTime;
  }

  public void setTaskStartTime(java.sql.Timestamp taskStartTime) {
    this.taskStartTime = taskStartTime;
  }


  public java.sql.Timestamp getTaskEndTime() {
    return taskEndTime;
  }

  public void setTaskEndTime(java.sql.Timestamp taskEndTime) {
    this.taskEndTime = taskEndTime;
  }


  public String getTaskEmail() {
    return taskEmail;
  }

  public void setTaskEmail(String taskEmail) {
    this.taskEmail = taskEmail;
  }


  public int getAlgorithmId() {
    return algorithmId;
  }

  public void setAlgorithmId(int algorithmId) {
    this.algorithmId = algorithmId;
  }


  public String getAlgorithmParameters() {
    return algorithmParameters;
  }

  public void setAlgorithmParameters(String algorithmParameters) {
    this.algorithmParameters = algorithmParameters;
  }


  public Integer getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(Integer datasetId) {
    this.datasetId = datasetId;
  }


  public String getDatasetUpload() {
    return datasetUpload;
  }

  public void setDatasetUpload(String datasetUpload) {
    this.datasetUpload = datasetUpload;
  }


  public java.sql.Timestamp getAlgorithmStartTime() {
    return algorithmStartTime;
  }

  public void setAlgorithmStartTime(java.sql.Timestamp algorithmStartTime) {
    this.algorithmStartTime = algorithmStartTime;
  }


  public java.sql.Timestamp getAlgorithmEndTime() {
    return algorithmEndTime;
  }

  public void setAlgorithmEndTime(java.sql.Timestamp algorithmEndTime) {
    this.algorithmEndTime = algorithmEndTime;
  }


  public String getAlgorithmStatus() {
    return algorithmStatus;
  }

  public void setAlgorithmStatus(String algorithmStatus) {
    this.algorithmStatus = algorithmStatus;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
