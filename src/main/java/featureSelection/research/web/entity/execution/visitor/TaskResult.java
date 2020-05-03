package featureSelection.research.web.entity.execution.visitor;


public class TaskResult {

  private int taskId;
  private int resultId;
  private String resultVal;


  public int getTaskId() {
    return taskId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }


  public int getResultId() {
    return resultId;
  }

  public void setResultId(int resultId) {
    this.resultId = resultId;
  }


  public String getResultVal() {
    return resultVal;
  }

  public void setResultVal(String resultVal) {
    this.resultVal = resultVal;
  }

}
