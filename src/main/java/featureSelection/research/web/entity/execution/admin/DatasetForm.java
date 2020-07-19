package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @ClassName: DatasetForm
 * @Description: 申请数据集实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class DatasetForm implements Serializable {
    private int inputId;
    private int accountId;
    private String inputName;
    private String inputHref;
    private int inputRecord;
    private String inputDimension;
    private String inputTag;
    private String inputType;
    private Date inputStartTime;
    private String inputStatus;
    private String inputReviewer;
    private String inputFile;
    private Date inputReviewTime;
    private Date inputEndTime;
    private Timestamp updateTime;
    private String inputPreprocess;
    private String inputAlgorithm;
    private String inputDescription;

    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputHref() {
        return inputHref;
    }

    public void setInputHref(String inputHref) {
        this.inputHref = inputHref;
    }

    public int getInputRecord() {
        return inputRecord;
    }

    public void setInputRecord(int inputRecord) {
        this.inputRecord = inputRecord;
    }

    public String getInputDimension() {
        return inputDimension;
    }

    public void setInputDimension(String inputDimension) {
        this.inputDimension = inputDimension;
    }

    public String getInputTag() {
        return inputTag;
    }

    public void setInputTag(String inputTag) {
        this.inputTag = inputTag;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Date getInputStartTime() {
        return inputStartTime;
    }

    public void setInputStartTime(Date inputStartTime) {
        this.inputStartTime = inputStartTime;
    }

    public String getInputStatus() {
        return inputStatus;
    }

    public void setInputStatus(String inputStatus) {
        this.inputStatus = inputStatus;
    }

    public String getInputReviewer() {
        return inputReviewer;
    }

    public void setInputReviewer(String inputReviewer) {
        this.inputReviewer = inputReviewer;
    }

    public Date getInputReviewTime() {
        return inputReviewTime;
    }

    public void setInputReviewTime(Date inputReviewTime) {
        this.inputReviewTime = inputReviewTime;
    }

    public Date getInputEndTime() {
        return inputEndTime;
    }

    public void setInputEndTime(Date inputEndTime) {
        this.inputEndTime = inputEndTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getInputPreprocess() {
        return inputPreprocess;
    }

    public void setInputPreprocess(String inputPreprocess) {
        this.inputPreprocess = inputPreprocess;
    }

    public String getInputAlgorithm() {
        return inputAlgorithm;
    }

    public void setInputAlgorithm(String inputAlgorithm) {
        this.inputAlgorithm = inputAlgorithm;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    @Override
    public String toString() {
        return "DatasetFrom{" +
                "inputId=" + inputId +
                ", accountId=" + accountId +
                ", inputName='" + inputName + '\'' +
                ", inputHref='" + inputHref + '\'' +
                ", inputRecord=" + inputRecord +
                ", inputDimension='" + inputDimension + '\'' +
                ", inputTag='" + inputTag + '\'' +
                ", inputType='" + inputType + '\'' +
                ", inputStartTime=" + inputStartTime +
                ", inputStatus='" + inputStatus + '\'' +
                ", inputReviewer='" + inputReviewer + '\'' +
                ", inputReviewTime=" + inputReviewTime +
                ", inputEndTime=" + inputEndTime +
                ",inputFile="+inputFile+'\''+
                ",inputPreprocess="+inputPreprocess+'\''+
                ",inputAlgorithm="+inputAlgorithm+'\''+
                ",inputDescription"+inputDescription+'\''+
                ", updateTime=" + updateTime +
                '}';
    }


}
