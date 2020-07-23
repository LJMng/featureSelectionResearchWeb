package featureSelection.research.web.entity.execution.admin;

import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Algorithm
 * @Description: 算法实体类
 * @Author: 马凯健
 * @Date: 2020-07-18
 */
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
    private String algorithmCallDemoRoutingkey;
    private String algorithmCallExecutionSendRoutingkey;
    private String algorithmCallExecutionConnectRoutingkey;
    private String algorithmCallPort;
    private String algorithmCallUsername;
    private String algorithmCallPassword;
    private String algorithmNameMapper;
    private String algorithmUsage;
    //算法参数
    private List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin;
    //存放参数名称
    private List<String> list;
    //存放参数类型
    private List<String> list2;

    public List<AlgorithmParameterDemoAdmin> getAlgorithmParameterDemoAdmin() {
        return algorithmParameterDemoAdmin;
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

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
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

    public String getAlgorithmCallDemoRoutingkey() {
        return algorithmCallDemoRoutingkey;
    }

    public void setAlgorithmCallDemoRoutingkey(String algorithmCallDemoRoutingkey) {
        this.algorithmCallDemoRoutingkey = algorithmCallDemoRoutingkey;
    }

    public String getAlgorithmCallExecutionSendRoutingkey() {
        return algorithmCallExecutionSendRoutingkey;
    }

    public void setAlgorithmCallExecutionSendRoutingkey(String algorithmCallExecutionSendRoutingkey) {
        this.algorithmCallExecutionSendRoutingkey = algorithmCallExecutionSendRoutingkey;
    }

    public String getAlgorithmCallExecutionConnectRoutingkey() {
        return algorithmCallExecutionConnectRoutingkey;
    }

    public void setAlgorithmCallExecutionConnectRoutingkey(String algorithmCallExecutionConnectRoutingkey) {
        this.algorithmCallExecutionConnectRoutingkey = algorithmCallExecutionConnectRoutingkey;
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

    public void setAlgorithmParameterDemoAdmin(List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin) {
        this.algorithmParameterDemoAdmin = algorithmParameterDemoAdmin;
    }

    public String getAlgorithmUsage() {
        return algorithmUsage;
    }

    public void setAlgorithmUsage(String algorithmUsage) {
        this.algorithmUsage = algorithmUsage;
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

    public String getAlgorithmNameMapper() {
        return algorithmNameMapper;
    }

    public void setAlgorithmNameMapper(String algorithmNameMapper) {
        this.algorithmNameMapper = algorithmNameMapper;
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
                ", algorithmCallDemoRoutingkey='" + algorithmCallDemoRoutingkey + '\'' +
                ", algorithmCallExecutionSendRoutingkey='" + algorithmCallExecutionSendRoutingkey + '\'' +
                ", algorithmCallExecutionConnectRoutingkey='" + algorithmCallExecutionConnectRoutingkey + '\'' +
                ", algorithmCallPort='" + algorithmCallPort + '\'' +
                ", algorithmCallUsername='" + algorithmCallUsername + '\'' +
                ", algorithmCallPassword='" + algorithmCallPassword + '\'' +
                ", algorithmNameMapper='" + algorithmNameMapper + '\'' +
                ", algorithmUsage='" + algorithmUsage + '\'' +
                ", algorithmParameterDemoAdmin=" + algorithmParameterDemoAdmin +
                ", list=" + list +
                ", list2=" + list2 +
                '}';
    }
}
