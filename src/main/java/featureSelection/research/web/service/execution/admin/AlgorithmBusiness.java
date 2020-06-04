package featureSelection.research.web.service.execution.admin;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.Parameter;
import featureSelection.research.web.entity.execution.admin.ParameterInfo;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;

import java.util.List;
import java.util.Map;

public interface AlgorithmBusiness {
    public void createParamSettingInfo(Map<Integer, String> algorithmMap);
    public void addProcedureSettings(ProcedureSettings procedureSettings);
    public List<ProcedureSettings> findAllProcedureSettings();
    public void updateProcedureSettings(ProcedureSettings procedureSettings);
    public List<Algorithm> getAlgorithms();

    public void createParameters(ParameterInfo parameterInfo);

    public List<Parameter> getParameters();

    public void updateParameter(Parameter parameter);

    public void deleteParameter(int parameterId);

    public void deleteProcedureSetting(int id);
}
