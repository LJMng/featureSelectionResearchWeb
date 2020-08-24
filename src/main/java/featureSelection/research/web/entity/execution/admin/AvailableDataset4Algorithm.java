package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

/**
 * @ClassName: AvailableDataset4Algorithm
 * @Description: 算法可用数据集实体类
 * @Author: 马凯健
 * @Date: 2020-08-24
 */
public class AvailableDataset4Algorithm implements Serializable {
    //算法Id
    private int algorithmId;
    //算法可用数据集
    private String availableDatasets;

    public int getAlgorithmId() {
        return algorithmId;
    }

    public void setAlgorithmId(int algorithmId) {
        this.algorithmId = algorithmId;
    }

    public String getAvailableDatasets() {
        return availableDatasets;
    }

    public void setAvailableDatasets(String availableDatasets) {
        this.availableDatasets = availableDatasets;
    }

    @Override
    public String toString() {
        return "AvailableDataset4Algorithm{" +
                "algorithmId=" + algorithmId +
                ", availableDatasets='" + availableDatasets + '\'' +
                '}';
    }
}
