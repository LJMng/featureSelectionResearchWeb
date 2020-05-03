package featureSelection.research.web.entity;

public class UpdateInfo {
    //记录执行的操作
    private String update_content;

    public String getUpdate_content() {
        return update_content;
    }

    public void setUpdate_content(String update_content) {
        this.update_content = update_content;
    }

    @Override
    public String toString() {
        return "UpdateInfo{" +
                "update_content='" + update_content + '\'' +
                '}';
    }
}
