package featureSelection.research.web.entity.communicationJson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @ClassName : AlgorithmSetting
 * @Description : 算法设置
 * @Author : WDD
 * @Date: 2020-04-14 15:11
 */
public class AlgorithmSetting {
    @JSONField(name = "basic")
    private Map<String,Map<String,Object>> basic;
    @JSONField(name = "procedure")
    private Map<String,Map<String,Object>>procedure;

    public Map<String, Map<String, Object>> getBasic() {
        return basic;
    }

    public void setBasic(Map<String, Map<String, Object>> basic) {
        this.basic = basic;
    }

    public Map<String, Map<String, Object>> getProcedure() {
        return procedure;
    }

    public void setProcedure(Map<String, Map<String, Object>> procedure) {
        this.procedure = procedure;
    }

    @Override
    public String toString() {
        return "AlgorithmSetting{" +
                "basic=" + basic +
                ", procedure=" + procedure +
                '}';
    }
}
