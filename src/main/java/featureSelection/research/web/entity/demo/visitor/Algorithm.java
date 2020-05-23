package featureSelection.research.web.entity.demo.visitor;

import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName : Algorithm
 * @Description : 算法实体类
 * @Author : WDD
 * @Date: 2020-03-30 21:16
 */
public  class Algorithm {
    private int  algorithmId;
    private String algorithmName;
    private String algorithmPaperReference;
    private String algorithmPaperLink;
    private String algorithmDescription;
    private String algorithmCallInterface;
    private String algorithmCallHost;
    private String algorithmCallExchange;
    private String algorithmCallDemoRoutingkey;
    private String algorithmCallExecutionConnectRoutingkey;
    private String algorithmCallExecutionSendRoutingkey;
    private String algorithmCallPort;
    private String algorithmCallUsername;
    private String algorithmCallPassword;
    private Timestamp ut;
    private List<ParameterScheme>parameterSchemes;
    private List<Parameter>parameters;
    private List<Dataset>datasets;
    private String parameterSchemeIndex;

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

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }


    public List<ParameterScheme> getParameterSchemes() {
        return parameterSchemes;
    }

    public void setParameterSchemes(List<ParameterScheme> parameterSchemes) {
        this.parameterSchemes = parameterSchemes;
    }

    public String getParameterSchemeIndex() {
        return parameterSchemeIndex;
    }

    public void setParameterSchemeIndex(String parameterSchemeIndex) {
        this.parameterSchemeIndex = parameterSchemeIndex;
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

    public String getAlgorithmCallExecutionConnectRoutingkey() {
        return algorithmCallExecutionConnectRoutingkey;
    }

    public void setAlgorithmCallExecutionConnectRoutingkey(String algorithmCallExecutionConnectRoutingkey) {
        this.algorithmCallExecutionConnectRoutingkey = algorithmCallExecutionConnectRoutingkey;
    }

    public String getAlgorithmCallExecutionSendRoutingkey() {
        return algorithmCallExecutionSendRoutingkey;
    }

    public void setAlgorithmCallExecutionSendRoutingkey(String algorithmCallExecutionSendRoutingkey) {
        this.algorithmCallExecutionSendRoutingkey = algorithmCallExecutionSendRoutingkey;
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

    @Override
    public String toString() {
        return "Algorithm{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmPaperReference='" + algorithmPaperReference + '\'' +
                ", algorithmPaperLink='" + algorithmPaperLink + '\'' +
                ", algorithmDescription='" + algorithmDescription + '\'' +
                ", algorithmCallInterface='" + algorithmCallInterface + '\'' +
                ", algorithmCallHost='" + algorithmCallHost + '\'' +
                ", algorithmCallExchange='" + algorithmCallExchange + '\'' +
                ", algorithmCallDemoRoutingkey='" + algorithmCallDemoRoutingkey + '\'' +
                ", algorithmCallExecutionConnectRoutingkey='" + algorithmCallExecutionConnectRoutingkey + '\'' +
                ", algorithmCallExecutionSendRoutingkey='" + algorithmCallExecutionSendRoutingkey + '\'' +
                ", algorithmCallPort='" + algorithmCallPort + '\'' +
                ", algorithmCallUsername='" + algorithmCallUsername + '\'' +
                ", algorithmCallPassword='" + algorithmCallPassword + '\'' +
                ", ut=" + ut +
                ", parameterSchemes=" + parameterSchemes +
                ", parameters=" + parameters +
                ", datasets=" + datasets +
                ", parameterSchemeIndex='" + parameterSchemeIndex + '\'' +
                '}';
    }
}
