package featureSelection.research.web.entity.demo.admin;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author jjz
 * @create 2020-07-19 8:53
 **/
public class UpdateInfoDemoAdmin {
    //id
    private Integer updateId;
    //更新的中文内容
    private String updateContent;
    //更新时间
    private Date ut;
    //更新的英文内容
    private String updateEnContent;

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    public Date getUt() {
        return ut;
    }

    public void setUt(Date ut) {
        this.ut = ut;
    }

    public String getUpdateEnContent() {
        return updateEnContent;
    }

    public void setUpdateEnContent(String updateEnContent) {
        this.updateEnContent = updateEnContent;
    }

    @Override
    public String toString() {
        return "UpdateInfoDemoAdmin{" +
                "updateId=" + updateId +
                ", updateContent='" + updateContent + '\'' +
                ", ut=" + ut +
                ", updateEnContent='" + updateEnContent + '\'' +
                '}';
    }
}
