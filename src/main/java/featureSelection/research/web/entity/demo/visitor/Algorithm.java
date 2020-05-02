package featureSelection.research.web.entity.demo.visitor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @ClassName : Algorithm
 * @Description : 算法实体类
 * @Author : WDD
 * @Date: 2020-03-30 21:16
 */
public class Algorithm {
    private int  algorithmId;
    private String algorithmName;
    private String algorithmPaperReference;
    private String algorithmPaperLink;
    private String algorithmCallInterface;
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

    @Override
    public String toString() {
        return "Algorithm{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmPaperReference='" + algorithmPaperReference + '\'' +
                ", algorithmPaperLink='" + algorithmPaperLink + '\'' +
                ", algorithmCallInterface='" + algorithmCallInterface + '\'' +
                ", ut=" + ut +
                ", parameterSchemes=" + parameterSchemes +
                ", parameters=" + parameters +
                ", datasets=" + datasets +
                ", parameterSchemeIndex='" + parameterSchemeIndex + '\'' +
                '}';
    }
}
