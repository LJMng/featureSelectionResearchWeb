package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class Algorithm implements Serializable {
    private int algorithmId;
    private String algorithmName;
    private String algorithmType;
    private String algorithmPaperReference;
    private String algorithmPaperLink;
    private String algorithmDescription;
    private String algorithmCallInterface;
    private String algorithmCallHost;
    private String algorithmCallExchange;
    private String algorithmCallRoutingkey;
    private String algorithmCallPort;
    private String algorithmCallUsername;
    private String algorithmCallPassword;


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

    public String getAlgorithmCallHost() {
        return algorithmCallHost;
    }

    public void setAlgorithmCallHost(String algorithmCallHost) {
        this.algorithmCallHost = algorithmCallHost;
    }

    public String getAlgorithmCallExchange() {
        return algorithmCallExchange;
    }

    public void setAlgorithmCallExchange(String algorithmCallExchange) {
        this.algorithmCallExchange = algorithmCallExchange;
    }

    public String getAlgorithmCallRoutingkey() {
        return algorithmCallRoutingkey;
    }

    public void setAlgorithmCallRoutingkey(String algorithmCallRoutingkey) {
        this.algorithmCallRoutingkey = algorithmCallRoutingkey;
    }

    public String getAlgorithmCallPort() {
        return algorithmCallPort;
    }

    public void setAlgorithmCallPort(String algorithmCallPort) {
        this.algorithmCallPort = algorithmCallPort;
    }

    public String getAlgorithmCallUsername() {
        return algorithmCallUsername;
    }

    public void setAlgorithmCallUsername(String algorithmCallUsername) {
        this.algorithmCallUsername = algorithmCallUsername;
    }

    public String getAlgorithmCallPassword() {
        return algorithmCallPassword;
    }

    public void setAlgorithmCallPassword(String algorithmCallPassword) {
        this.algorithmCallPassword = algorithmCallPassword;
    }

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmType='" + algorithmType + '\'' +
                ", algorithmPaperReference='" + algorithmPaperReference + '\'' +
                ", algorithmPaperLink='" + algorithmPaperLink + '\'' +
                ", algorithmDescription='" + algorithmDescription + '\'' +
                ", algorithmCallInterface='" + algorithmCallInterface + '\'' +
                ", algorithmCallHost='" + algorithmCallHost + '\'' +
                ", algorithmCallExchange='" + algorithmCallExchange + '\'' +
                ", algorithmCallRoutingkey='" + algorithmCallRoutingkey + '\'' +
                ", algorithmCallPort='" + algorithmCallPort + '\'' +
                ", algorithmCallUsername='" + algorithmCallUsername + '\'' +
                ", algorithmCallPassword='" + algorithmCallPassword + '\'' +
                '}';
    }
}
