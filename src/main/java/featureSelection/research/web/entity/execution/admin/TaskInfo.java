package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TaskInfo implements Serializable {
    private int taskId;
    private int accountId;
    private String taskName;
    private String taskStatus;
    private String taskComment;
    private String taskReviewer;
    private Date taskReviewedTime;
    private Date taskStartTime;
    private Date taskEndTime;
    private String taskEmail;
    private int algorithmId;
    private String algorithmParameters;
    private int datasetId;
    private Date algorithmStartTime;
    private Date algorithmEndTime;
    private String algorithmStatus;
    private Timestamp updateTime;

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

    public Date getTaskReviewedTime() {
        return taskReviewedTime;
    }

    public void setTaskReviewedTime(Date taskReviewedTime) {
        this.taskReviewedTime = taskReviewedTime;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
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

    public int getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(int datasetId) {
        this.datasetId = datasetId;
    }

    public Date getAlgorithmStartTime() {
        return algorithmStartTime;
    }

    public void setAlgorithmStartTime(Date algorithmStartTime) {
        this.algorithmStartTime = algorithmStartTime;
    }

    public Date getAlgorithmEndTime() {
        return algorithmEndTime;
    }

    public void setAlgorithmEndTime(Date algorithmEndTime) {
        this.algorithmEndTime = algorithmEndTime;
    }

    public String getAlgorithmStatus() {
        return algorithmStatus;
    }

    public void setAlgorithmStatus(String algorithmStatus) {
        this.algorithmStatus = algorithmStatus;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    @Override
    public String toString() {
        return "Algorithm{" +
                "taskId=" + taskId +
                ", accountId='" + accountId + '\'' +
                ", taskName='" + taskName + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskComment='" + taskComment + '\'' +
                ", taskReviewer='" + taskReviewer + '\'' +
                ", taskReviewedTime=" + taskReviewedTime +
                ", taskStartTime=" + taskStartTime +
                ", taskEndTime=" + taskEndTime +
                ", taskEmail='" + taskEmail + '\'' +
                ", algorithmId=" + algorithmId +
                ", algorithmParameters='" + algorithmParameters + '\'' +
                ", datasetId=" + datasetId +
                ", algorithmStartTime=" + algorithmStartTime +
                ", algorithmEndTime=" + algorithmEndTime +
                ", algorithmStatus='" + algorithmStatus + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
