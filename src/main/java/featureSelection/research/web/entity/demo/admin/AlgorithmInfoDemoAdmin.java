package featureSelection.research.web.entity.demo.admin;

import java.util.List;

public class AlgorithmInfoDemoAdmin {

    //算法ID
    private Integer algorithmId;
    //算法名称
    private String algorithmName;
    //算法简介
    private String algorithmDescription;
    //算法引用论文信息
    private String algorithmPaperReference;
    //算法引用论文链接
    private String algorithmPaperLink;
    //算法接口
    private String algorithmCallInterface;
    //算法参数
    private List<AlgorithmParameterDemoAdmin> algorithmParameterDemoAdmin;
    //存放参数名称
    private List<String> list;
    //存放参数类型
    private List<String> list2;

    //各种getter/setter以及toString方法
    public Integer getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(Integer algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmDescription() {
        return algorithmDescription;
    }

    public void setAlgorithmDescription(String algorithmDescription) {
        this.algorithmDescription = algorithmDescription;
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

    @Override
    public String toString() {
        return "AlgorithmInfoDemoAdmin{" +
                "algorithmId=" + algorithmId +
                ", algorithmName='" + algorithmName + '\'' +
                ", algorithmDescription='" + algorithmDescription + '\'' +
                ", algorithmPaperReference='" + algorithmPaperReference + '\'' +
                ", algorithmPaperLink='" + algorithmPaperLink + '\'' +
                ", algorithmCallInterface='" + algorithmCallInterface + '\'' +
                ", algorithmParameterDemoAdmin=" + algorithmParameterDemoAdmin +
                ", list=" + list +
                ", list2=" + list2 +
                '}';
    }
}
