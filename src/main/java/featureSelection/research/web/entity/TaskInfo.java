package featureselection.reasearch.web.entity;


public class TaskInfo {

    private String queueNumber;
    private String userEmail;
    private java.sql.Timestamp beginTime;
    private String state;
    private java.sql.Timestamp endTime;
    private String algorithmInfo;
    private String result;
    private String dataUrl;


    public String getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(String queueNumber) {
        this.queueNumber = queueNumber;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public java.sql.Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(java.sql.Timestamp beginTime) {
        this.beginTime = beginTime;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }


    public String getAlgorithmInfo() {
        return algorithmInfo;
    }

    public void setAlgorithmInfo(String algorithmInfo) {
        this.algorithmInfo = algorithmInfo;
    }


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

}
