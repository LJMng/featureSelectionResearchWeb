package featureSelection.research.web.entity.demo.admin;
/**
 * @author jjz
 * */
public class DatasetDemoAdmin{
        //方案对应数据集ID
        private Integer datasetId;
        //方案对应数据集名称
        private String datasetName;

        public Integer getDatasetId() {
                return datasetId;
        }

        public void setDatasetId(Integer datasetId) {
                this.datasetId = datasetId;
        }

        public String getDatasetName() {
                return datasetName;
        }

        public void setDatasetName(String datasetName) {
                this.datasetName = datasetName;
        }

        @Override
        public String toString() {
                return "DatasetDemoAdmin{" +
                        "datasetId=" + datasetId +
                        ", datasetName='" + datasetName + '\'' +
                        '}';
        }
}
