package featureselection.research.web.entity;


public class TaskResult {

  private long taskId;
  private long resultId;
  private String resultVal;


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public long getResultId() {
    return resultId;
  }

  public void setResultId(long resultId) {
    this.resultId = resultId;
  }


  public String getResultVal() {
    return resultVal;
  }

  public void setResultVal(String resultVal) {
    this.resultVal = resultVal;
  }

}
