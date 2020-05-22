package featureSelection.research.web.entity.communicationJson;

import com.alibaba.fastjson.annotation.JSONField;
import featureSelection.research.web.entity.communicationJson.localrabbitmqinfo.LocalRabbitmqInfo;

import java.util.Arrays;

/**
 * @ClassName : AlgorithmCallTaskInfo
 * @Description : 调用服务器算法服务数据传输格式
 * @Author : WDD
 * @Date: 2020-04-13 21:32
 */
public class AlgorithmCallTaskInfo {
    private String id;
    @JSONField(name = "dataset-name")
    private String datasetName;
    private int part;
    private String column;
    @JSONField(name = "part-data-size")
    private String partDataSize;
    @JSONField(name = "algorithm-info")
    private AlgorithmInfo algorithmInfo;
    @JSONField(name = "previous-reducts")
    private String previousReducts;
    @JSONField(name = "run-times")
    private String runTimes;
    private int line;
    @JSONField(name = "part-total-line")
    private int partTotalLine;
    private int[]data;
    private String attributes;
    @JSONField(name = "rabbitmqInfo")
    private LocalRabbitmqInfo localRabbitmqInfo;
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

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getPartDataSize() {
        return partDataSize;
    }

    public void setPartDataSize(String partDataSize) {
        this.partDataSize = partDataSize;
    }

    public AlgorithmInfo getAlgorithmInfo() {
        return algorithmInfo;
    }

    public void setAlgorithmInfo(AlgorithmInfo algorithmInfo) {
        this.algorithmInfo = algorithmInfo;
    }

    public String getPreviousReducts() {
        return previousReducts;
    }

    public void setPreviousReducts(String previousReducts) {
        this.previousReducts = previousReducts;
    }

    public String getRunTimes() {
        return runTimes;
    }

    public void setRunTimes(String runTimes) {
        this.runTimes = runTimes;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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

    public LocalRabbitmqInfo getLocalRabbitmqInfo() {
        return localRabbitmqInfo;
    }

    public void setLocalRabbitmqInfo(LocalRabbitmqInfo localRabbitmqInfo) {
        this.localRabbitmqInfo = localRabbitmqInfo;
    }

    @Override
    public String toString() {
        return "AlgorithmCallTaskInfo{" +
                "id='" + id + '\'' +
                ", datasetName='" + datasetName + '\'' +
                ", part=" + part +
                ", column='" + column + '\'' +
                ", partDataSize='" + partDataSize + '\'' +
                ", algorithmInfo=" + algorithmInfo +
                ", previousReducts='" + previousReducts + '\'' +
                ", runTimes='" + runTimes + '\'' +
                ", line=" + line +
                ", partTotalLine=" + partTotalLine +
                ", data=" + Arrays.toString(data) +
                ", attributes='" + attributes + '\'' +
                ", localRabbitmqInfo=" + localRabbitmqInfo +
                '}';
    }
}
