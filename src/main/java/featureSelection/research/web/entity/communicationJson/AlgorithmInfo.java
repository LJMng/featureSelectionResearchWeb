package featureSelection.research.web.entity.communicationJson;

/**
 * @ClassName : AlgorithmInfo
 * @Description : 传输用算法信息
 * @Author : WDD
 * @Date: 2020-04-14 15:03
 */
public class AlgorithmInfo {
    private String alg;
    private AlgorithmSetting setting;

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public AlgorithmSetting getSetting() {
        return setting;
    }

    public void setSetting(AlgorithmSetting setting) {
        this.setting = setting;
    }

    @Override
    public String toString() {
        return "AlgorithmInfo{" +
                "alg='" + alg + '\'' +
                ", setting=" + setting +
                '}';
    }
}
