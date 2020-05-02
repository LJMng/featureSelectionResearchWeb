package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class Algorithm implements Serializable {
    private int algorithmId;
    private String algorithmName;
    private String algorithmType;
    private String algorithmPaperReference;
    private String algorithmPaperLink;
    private String algorithmCallInterface;

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

    public String getAlgorithmPaperReference() {
        return algorithmPaperReference;
    }

    public void setAlgorithmPaperReference(String algorithmPaperReference) {
        this.algorithmPaperReference = algorithmPaperReference;
    }

    public String getAlgorithmPaperLink() {
        return algorithmPaperLink;
    }

    public void setAlgorithmPaperLink(String algorithmPaperLink) {
        this.algorithmPaperLink = algorithmPaperLink;
    }

    public String getAlgorithmCallInterface() {
        return algorithmCallInterface;
    }

    public void setAlgorithmCallInterface(String algorithmCallInterface) {
        this.algorithmCallInterface = algorithmCallInterface;
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmType='" + algorithmType + '\'' +
                ", algorithmPaperReference='" + algorithmPaperReference + '\'' +
                ", algorithmPaperLink='" + algorithmPaperLink + '\'' +
                ", algorithmCallInterface='" + algorithmCallInterface + '\'' +
                '}';
    }
}
