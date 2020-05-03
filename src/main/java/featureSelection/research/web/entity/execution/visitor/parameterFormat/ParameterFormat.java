package featureSelection.research.web.entity.execution.visitor.parameterFormat;

import org.springframework.stereotype.Component;

/**
 * @author Stephen
 * @date 2020/4/27 12:05
 */
@Component
public class ParameterFormat {
    private String id;
    private String datasetName;
    private int part;
    private int column;
    private int partDataSize;
    private AlgorithmInfo algorithmInfo;
    private int[] previousReducts;
    private int runTimes;
    private int[] attributes;

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

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPartDataSize() {
        return partDataSize;
    }

    public void setPartDataSize(int partDataSize) {
        this.partDataSize = partDataSize;
    }

    public AlgorithmInfo getAlgorithmInfo() {
        return algorithmInfo;
    }

    public void setAlgorithmInfo(AlgorithmInfo algorithmInfo) {
        this.algorithmInfo = algorithmInfo;
    }

    public int[] getPreviousReducts() {
        return previousReducts;
    }

    public void setPreviousReducts(int[] previousReducts) {
        this.previousReducts = previousReducts;
    }

    public int getRunTimes() {
        return runTimes;
    }

    public void setRunTimes(int runTimes) {
        this.runTimes = runTimes;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }
}
