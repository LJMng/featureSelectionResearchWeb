package featureSelection.research.web.common.util;


import featureSelection.research.web.mybatisMapper.execution.admin.WebAlgorithmMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlgorithmMapperValueUtil {
    @Autowired
    private WebAlgorithmMapper webAlgorithmMapper;
    public String getProcedureValue(int algorithmId,int procedureSettingId,String webKey){
        return webAlgorithmMapper.getProcedureValue(algorithmId,procedureSettingId,webKey);
    }

    public String getParameterValue(int algorithmId,int parameterId,String parameterValue1,String parameterValue2){
        if (parameterValue2==null){
            String webKey=parameterValue1;
            return webAlgorithmMapper.getParameterValue(algorithmId,parameterId,webKey);
        }else {
            String webKey=parameterValue1+"_"+parameterValue2;
            return webAlgorithmMapper.getParameterValue(algorithmId,parameterId,webKey);
        }
    }
}
