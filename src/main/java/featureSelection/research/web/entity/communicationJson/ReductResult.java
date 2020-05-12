package featureSelection.research.web.entity.communicationJson;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @author Stephen
 * @date 2020/5/11 10:23
 */
public class ReductResult {
    private String databaseUniqueID;
    private String reducts;
    private int partIndex;
    private Map componentTagSumTimeMap;
    private Map extraInfo;
    private Map reduciCoding;
    private Map exitInfos;

    public String getDatabaseUniqueID() {
        return databaseUniqueID;
    }

    public void setDatabaseUniqueID(String databaseUniqueID) {
        this.databaseUniqueID = databaseUniqueID;
    }

    public String getReducts() {
        return reducts;
    }

    public void setReducts(String reducts) {
        this.reducts = reducts;
    }

    public int getPartIndex() {
        return partIndex;
    }

    public void setPartIndex(int partIndex) {
        this.partIndex = partIndex;
    }

    public Map getComponentTagSumTimeMap() {
        return componentTagSumTimeMap;
    }

    public void setComponentTagSumTimeMap(Map componentTagSumTimeMap) {
        this.componentTagSumTimeMap = componentTagSumTimeMap;
    }

    public Map getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Map extraInfo) {
        this.extraInfo = extraInfo;
    }

    public Map getReduciCoding() {
        return reduciCoding;
    }

    public void setReduciCoding(Map reduciCoding) {
        this.reduciCoding = reduciCoding;
    }

    public Map getExitInfos() {
        return exitInfos;
    }

    public void setExitInfos(Map exitInfos) {
        this.exitInfos = exitInfos;
    }
}
