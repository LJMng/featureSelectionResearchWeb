package featureSelection.research.web.entity.execution.admin;



import java.io.Serializable;

/**
 * @ClassName: PageElement
 * @Description: 页面元素实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
public class PageElement implements Serializable {
    private String htmlName;
    private String moduleKey;
    private String chValue;
    private String enValue;
    private String type;

    public PageElement() {
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey;
    }

    public String getChValue() {
        return chValue;
    }

    public void setChValue(String chValue) {
        this.chValue = chValue;
    }

    public String getEnValue() {
        return enValue;
    }

    public void setEnValue(String enValue) {
        this.enValue = enValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PageElement{" +
                "htmlName='" + htmlName + '\'' +
                ", moduleKey='" + moduleKey + '\'' +
                ", chValue='" + chValue + '\'' +
                ", enValue='" + enValue + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
