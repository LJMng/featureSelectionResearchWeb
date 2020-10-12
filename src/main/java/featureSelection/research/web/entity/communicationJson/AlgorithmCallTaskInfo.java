package featureSelection.research.web.entity.communicationJson;

import com.alibaba.fastjson.annotation.JSONField;
import featureSelection.research.web.entity.communicationJson.localrabbitmqinfo.LocalRabbitmqInfo;
import java.util.Arrays;

/**
 * 示例：
 * {
   "id": " Client1-GA-IP-NEC-1586701877",
   "dataset-name": "test.data",
   "part": 0,
   "column": 5,
   "part-data-size": 30,
   "algorithm-info": {
   "alg": "GA-IP-NEC(Dynamic)-External",
   "setting": {
   "basic": {
   "[GA] Population": {
   "input": "100",
   "option": null
     },
   "[GA] Chromosome switch number": {
   "input": "0.9",
   "option": null
   },
   },
   "procedure": {
   "[GA] Initiate": {
   "data":
   "tester.impl.optimization.geneticAlgorithm.component.roughEquivalentClassBased.
    original.gaInitiate.GeneticAlgorithmInitiateProcedureContainer4REC",
   "selected": true
   },
   }
   }
   },
   "previous-reducts": null,
   "run-times": 1,
   "attributes": [ 1, 2, 3, 4] }
 * @ClassName : AlgorithmCallTaskInfo
 * @Description : 调用服务器算法服务数据传输格式实体类
 * @Author : WDD
 * @Date: 2020-04-13 21:32
 */
public class AlgorithmCallTaskInfo {
    private String id;
    @JSONField(name = "dataset-name")
    private String datasetName;
    private int part;
    private int column;
    @JSONField(name = "part-data-size")
    private int partDataSize;
    @JSONField(name = "algorithm-info")
    private AlgorithmInfo algorithmInfo;
    @JSONField(name = "previous-reducts")
    private String previousReducts;
    @JSONField(name = "run-times")
    private String runTimes;

    private int[] attributes;
    @JSONField(name = "rabbitmqInfo")

    private LocalRabbitmqInfo localRabbitmqInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPartDataSize() {
        return partDataSize;
    }

    public void setPartDataSize(int partDataSize) {
        this.partDataSize = partDataSize;
    }

    public AlgorithmInfo getAlgorithmInfo() {
        return algorithmInfo;
    }

    public void setAlgorithmInfo(AlgorithmInfo algorithmInfo) {
        this.algorithmInfo = algorithmInfo;
    }

    public String getPreviousReducts() {
        return previousReducts;
    }

    public void setPreviousReducts(String previousReducts) {
        this.previousReducts = previousReducts;
    }

    public String getRunTimes() {
        return runTimes;
    }

    public void setRunTimes(String runTimes) {
        this.runTimes = runTimes;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }


    public LocalRabbitmqInfo getLocalRabbitmqInfo() {
        return localRabbitmqInfo;
    }

    public void setLocalRabbitmqInfo(LocalRabbitmqInfo localRabbitmqInfo) {
        this.localRabbitmqInfo = localRabbitmqInfo;
    }
}