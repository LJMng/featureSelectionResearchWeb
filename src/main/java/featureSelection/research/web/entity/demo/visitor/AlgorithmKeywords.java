package featureSelection.research.web.entity.demo.visitor;

import java.sql.Timestamp;

/**
 * @ClassName : AlgorithmKeywords
 * @Description : 算法关键词实体类
 * @Author : WDD
 * @Date: 2020-04-01 16:53
 */
public class AlgorithmKeywords {
    private Algorithm algorithm;
    private String keyword;
    private Timestamp ut;

    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Timestamp getUt() {
        return ut;
    }

    public void setUt(Timestamp ut) {
        this.ut = ut;
    }

    @Override
    public String toString() {
        return "AlgorithmKeywords{" +
                "algorithm=" + algorithm +
                ", keyword='" + keyword + '\'' +
                ", ut=" + ut +
                '}';
    }
}
