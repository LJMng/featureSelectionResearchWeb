package featureSelection.research.web.service.demo.visitor;

import com.alibaba.fastjson.JSONObject;

public interface AlgotithRpcService {
    public Object send(int algorithmid, int schemeid);
    public JSONObject getTransferData(String algorithmName, int schemeid);
}
