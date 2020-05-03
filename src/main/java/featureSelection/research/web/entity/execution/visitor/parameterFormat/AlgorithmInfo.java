package featureSelection.research.web.entity.execution.visitor.parameterFormat;

/**
 * @author Stephen
 * @date 2020/4/27 12:15
 */
public class AlgorithmInfo {
    private String alg;
    private Object setting;

    public AlgorithmInfo() {
    }

    public AlgorithmInfo(String alg, Object setting) {
        this.alg = alg;
        this.setting = setting;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public Object getSetting() {
        return setting;
    }

    public void setSetting(Object setting) {
        this.setting = setting;
    }
}
