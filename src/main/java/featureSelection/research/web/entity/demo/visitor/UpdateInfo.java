package featureSelection.research.web.entity.demo.visitor;

import java.sql.Timestamp;

/**
 * @ClassName : UpdateInfo
 * @Description : 更新信息实体类
 * @Author : WDD
 * @Date: 2020-03-31 14:13
 */
public class UpdateInfo {
    private int updateId;
    private String updateContent;
    private Timestamp ut;

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    @Override
    public String toString() {
        return "UpdateInfo{" +
                "updateId=" + updateId +
                ", updateContent='" + updateContent + '\'' +
                ", ut=" + ut +
                '}';
    }
}
