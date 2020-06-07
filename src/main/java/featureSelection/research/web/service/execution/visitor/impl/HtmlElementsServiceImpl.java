package featureSelection.research.web.service.execution.visitor.impl;

import featureSelection.research.web.entity.execution.visitor.*;
import featureSelection.research.web.mybatisMapper.execution.visitor.*;
import featureSelection.research.web.service.execution.visitor.IHtmlElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/21 16:25
 */
@Service
public class HtmlElementsServiceImpl implements IHtmlElementService {

    @Autowired
    private HtmlElementControlMapper htmlElementsMapper;

    @Autowired
    private AlgorithmMapper algorithmMapper;

    @Autowired
    private ParameterMapper parameterMapper;

    @Autowired
    private DatasetMapper datasetMapper;

    @Autowired
    private DatasetFormMapper datasetFormMapper;
    
    @Autowired
    private ProcedureSettingsMapper procedureSettingsMapper;

    @Override
    public List<HtmlElementControl> getElementsContext(){
        return htmlElementsMapper.getLanguageElements();
    }

    @Override
    public Map<Integer, Algorithm> getAlgorithmsList() {
        Map<Integer, Algorithm> algorithmsList = algorithmMapper.getAlgorithmsList();
        for (int key: algorithmsList.keySet()){
            Algorithm algorithm = algorithmsList.get(key);
            String tempUt = algorithm.getUt().substring(0,10);
            algorithm.setUt(tempUt);
            algorithmsList.put(key,algorithm);
        }
        return algorithmsList;
    }

    @Override
    public Map<Integer, List<Parameter>> getParametersList() {
        List<Map<String, Object>> parameterList = parameterMapper.getParameterList();
        Map<Integer,List<Parameter>> resultMap = new HashMap<>();
        Parameter parameter = null;
        List<Parameter> parameters = null;
        for (int i = 0; i < parameterList.size(); i++) {
            Map<String, Object> parameterMap = parameterList.get(i);
            if (!resultMap.containsKey(Integer.parseInt(parameterMap.get("algorithm_id").toString()))){
                parameter = new Parameter(
                        Integer.parseInt(parameterMap.get("parameter_id").toString()),
                        Integer.parseInt(parameterMap.get("algorithm_id").toString()),
                        parameterMap.get("parameter_name").toString(),
                        parameterMap.get("parameter_description").toString(),
                        parameterMap.get("parameter_type").toString(),
                        parameterMap.get("parameter_default_value").toString(),
                        parameterMap.get("parameter_setting_info").toString(),
                        parameterMap.get("parameter_name_mapper").toString()
                );
                parameters = new ArrayList<>();
                parameters.add(parameter);
                resultMap.put(parameter.getAlgorithmId(),parameters);
            }else {
                parameter = new Parameter(
                        Integer.parseInt(parameterMap.get("parameter_id").toString()),
                        Integer.parseInt(parameterMap.get("algorithm_id").toString()),
                        parameterMap.get("parameter_name").toString(),
                        parameterMap.get("parameter_description").toString(),
                        parameterMap.get("parameter_type").toString(),
                        parameterMap.get("parameter_default_value").toString(),
                        parameterMap.get("parameter_setting_info").toString(),
                        parameterMap.get("parameter_name_mapper").toString()
                );
                parameters = resultMap.get(parameter.getAlgorithmId());
                parameters.add(parameter);
                resultMap.put(parameter.getAlgorithmId(),parameters);
            }
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Dataset> getDatasetList() {
        return datasetMapper.getDatasetList();
    }

    @Override
    public Map<Integer, List<ProcedureSettings>> getProcedureSettingList() {
        List<Map<String, Object>> procedureSettingList = procedureSettingsMapper.getProcedureSettingList();
        Map<Integer, List<ProcedureSettings>> resultMap = new HashMap<>();
        List<ProcedureSettings> settingsList = null;
        ProcedureSettings procedureSettings = null;
        for (int i = 0; i < procedureSettingList.size(); i++) {
            Map<String,Object> tempMap = procedureSettingList.get(i);
            if (!resultMap.containsKey(Integer.parseInt(tempMap.get("algorithm_id").toString()))){
                settingsList = new ArrayList<>();
                settingsList.add(new ProcedureSettings(
                        Integer.parseInt(tempMap.get("id").toString()),
                        Integer.parseInt(tempMap.get("algorithm_id").toString()),
                        tempMap.get("name").toString(),
                        tempMap.get("state").toString(),
                        tempMap.get("options").toString().split(","),
                        tempMap.get("default_option").toString(),
                        tempMap.get("description").toString()
                ));
                resultMap.put(Integer.parseInt(tempMap.get("algorithm_id").toString()),settingsList);
            }else {
                procedureSettings = new ProcedureSettings(
                        Integer.parseInt(tempMap.get("id").toString()),
                        Integer.parseInt(tempMap.get("algorithm_id").toString()),
                        tempMap.get("name").toString(),
                        tempMap.get("state").toString(),
                        tempMap.get("options").toString().split(","),
                        tempMap.get("default_option").toString(),
                        tempMap.get("description").toString()
                );
                List<ProcedureSettings> settingsListTemp = resultMap.get(procedureSettings.getAlgorithmId());
                settingsListTemp.add(procedureSettings);
                resultMap.put(procedureSettings.getAlgorithmId(),settingsListTemp);
            }
        }
        return resultMap;
    }
}
