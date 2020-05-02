package featureSelection.research.web.entity.demo.admin;

public class DatasetDemoAdmin{
        //方案对应数据集ID
        private Integer datasetId;
        //方案对应数据集名称
        private String datasetName;
        //方案对应数据集介绍
        private String datasetDescription;
        //方案对应数据集记录数
        private long datasetCount;
        //方案对应数据集来源
        private String datasetSource;
        //方案对应数据集维度
        private long datasetDimension;

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

        public String getDatasetDescription() {
                return datasetDescription;
        }

        public void setDatasetDescription(String datasetDescription) {
                this.datasetDescription = datasetDescription;
        }

        public long getDatasetCount() {
                return datasetCount;
        }

        public void setDatasetCount(long datasetCount) {
                this.datasetCount = datasetCount;
        }

        public String getDatasetSource() {
                return datasetSource;
        }

        public void setDatasetSource(String datasetSource) {
                this.datasetSource = datasetSource;
        }

        public long getDatasetDimension() {
                return datasetDimension;
        }

        public void setDatasetDimension(long datasetDimension) {
                this.datasetDimension = datasetDimension;
        }

        @Override
        public String toString() {
                return "DatasetDemoAdmin{" +
                        "datasetId=" + datasetId +
                        ", datasetName='" + datasetName + '\'' +
                        ", datasetDescription='" + datasetDescription + '\'' +
                        ", datasetCount=" + datasetCount +
                        ", datasetSource='" + datasetSource + '\'' +
                        ", datasetDimension=" + datasetDimension +
                        '}';
        }
}
