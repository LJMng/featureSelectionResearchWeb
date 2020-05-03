package featureSelection.research.web.entity;

public class HtmlElementDemoAdmin {
    public String moduleKey;
    public String htmlName;
    public String type;
    public String chValue;
    public String enValue;

    public String getModuleKey() {
        return moduleKey;
    }

    public void setModuleKey(String moduleKey) {
        this.moduleKey = moduleKey;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "htmlElementDemoAdmin{" +
                "moduleKey='" + moduleKey + '\'' +
                ", htmlName='" + htmlName + '\'' +
                ", type='" + type + '\'' +
                ", chValue='" + chValue + '\'' +
                ", enValue='" + enValue + '\'' +
                '}';
    }
}
