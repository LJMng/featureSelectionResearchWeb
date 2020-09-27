package featureSelection.research.web.entity.execution.visitor;

import java.util.List;

/**
 * @description: TaskResultFormat
 * @date: 2020/9/27 19:52
 * @author: Stephen
 */
public class TaskResultFormat {
    int datasetDimension;
    List<int[]> resultList;

    public int getDatasetDimension() {
        return datasetDimension;
    }

    public void setDatasetDimension(int datasetDimension) {
        this.datasetDimension = datasetDimension;
    }

    public List<int[]> getResultList() {
        return resultList;
    }

    public void setResultList(List<int[]> resultList) {
        this.resultList = resultList;
    }
}
