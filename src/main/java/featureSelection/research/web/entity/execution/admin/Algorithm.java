package featureSelection.research.web.entity.execution.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;

import java.io.Serializable;
import java.util.List;

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
    //算法参数
    private List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin;
    //存放参数名称
    private List<String> list;
    //存放参数类型
    private List<String> list2;

    public List<AlgorithmParameterDemoAdmin> getAlgorithmParameterDemoAdmin() {
        return algorithmParameterDemoAdmin;
    }

    public void setAlgorithmParameterDemoAdmin(List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin) {
        this.algorithmParameterDemoAdmin = algorithmParameterDemoAdmin;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

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
                ", algorithmParameterDemoAdmin=" + algorithmParameterDemoAdmin +
                ", list=" + list +
                ", list2=" + list2 +
                '}';
    }
}
