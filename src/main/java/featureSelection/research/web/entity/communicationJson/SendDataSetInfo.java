package featureSelection.research.web.entity.communicationJson;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName : SendDataSetInfo
 * @Description :
 * @Author : WDD
 * @Date: 2020-10-12 11:08
 */
public class SendDataSetInfo {
    private String id;
    @JSONField(name = "dataset-name")
    private String datasetName;
    private int part;
    private int line;
    @JSONField(name = "part-total-line")
    private int partTotalLine;
    private int[]data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getPartTotalLine() {
        return partTotalLine;
    }

    public void setPartTotalLine(int partTotalLine) {
        this.partTotalLine = partTotalLine;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
}
