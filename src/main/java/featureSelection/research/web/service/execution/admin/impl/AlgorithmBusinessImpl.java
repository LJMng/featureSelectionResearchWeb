package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import featureSelection.research.web.mybatisMapper.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.AlgorithmParamMapper;
import featureSelection.research.web.mybatisMapper.ProcedureSettingsMapper;
import featureSelection.research.web.service.execution.admin.AlgorithmBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AlgorithmBusinessImpl implements AlgorithmBusiness {
    @Autowired
    private AlgorithmParamMapper algorithmParamMapper;
    @Autowired
    private ProcedureSettingsMapper procedureSettingsMapper;
    @Autowired
    private AlgorithmMapper algorithmMapper;
    @Override
    public void createParamSettingInfo(Map<Integer, String> algorithmMap) {
        for (Map.Entry<Integer, String> algorithmParam : algorithmMap.entrySet()) {
            int algorithmId=algorithmParam.getKey();
            String parameterSettingInfo=algorithmParam.getValue();
            algorithmParamMapper.createParamSettingInfo(algorithmId,parameterSettingInfo);
            System.out.println("Key = " + algorithmParam.getKey() + ", Value = " + algorithmParam.getValue());

        }

    }

    @Override
    public void addProcedureSettings(ProcedureSettings procedureSettings) {
        procedureSettingsMapper.addProcedureSetting(procedureSettings);
    }

    @Override
    public List<Algorithm> getAlgorithms() {
        return algorithmMapper.getAlgorithms();
    }
}
