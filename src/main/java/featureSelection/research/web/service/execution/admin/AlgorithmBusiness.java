package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.ParameterInfo;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;

import java.util.List;
import java.util.Map;

public interface AlgorithmBusiness {
    public void createParamSettingInfo(Map<Integer, String> algorithmMap);
    public void addProcedureSettings(ProcedureSettings procedureSettings);
    public List<Algorithm> getAlgorithms();

    public void createParameters(ParameterInfo parameterInfo);
}
