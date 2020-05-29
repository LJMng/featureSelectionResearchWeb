package featureSelection.research.web.entity.demo.visitor;



import java.io.Serializable;

public class PageElement{
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
