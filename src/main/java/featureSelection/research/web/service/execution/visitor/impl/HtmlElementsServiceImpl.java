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
            //设置算法信息中更新时间的格式
            String tempUt = algorithm.getUt().substring(0,10);
            algorithm.setUt(tempUt);
            algorithmsList.put(key,algorithm);
        }
        return algorithmsList;
    }

    @Override
    public Map<Integer, List<Parameter>> getParametersList() {
        /**
         * 将从数据库获取所有的算法信息转化为Map<Integer,List<Parameter>>对象进行存储，key为算法id，value为该算法含有的所有参数的信息
         */
        List<Map<String, Object>> parameterList = parameterMapper.getParameterList();
        Map<Integer,List<Parameter>> resultMap = new HashMap<>();
        Parameter parameter = null;
        List<Parameter> parameters = null;
        for (int i = 0; i < parameterList.size(); i++) {
            //获取一条记录
            Map<String, Object> parameterMap = parameterList.get(i);
            //判断resultMap的key中是否已经有某个算法id
            if (!resultMap.containsKey(Integer.parseInt(parameterMap.get("algorithm_id").toString()))){
                //将当前记录转化Parameter对象
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
        /*
            将从数据库中获取的所有算法步骤设置信息用Map<Integer, List<ProcedureSettings>>对象进行存储，key为算法id，value为算法步骤设置信息的数组
         */
        List<Map<String, Object>> procedureSettingList = procedureSettingsMapper.getProcedureSettingList();
        Map<Integer, List<ProcedureSettings>> resultMap = new HashMap<>();
        List<ProcedureSettings> settingsList = null;
        ProcedureSettings procedureSettings = null;
        for (int i = 0; i < procedureSettingList.size(); i++) {
            //获取一条记录
            Map<String,Object> tempMap = procedureSettingList.get(i);
            //判断resultMap中是否已经存在某算法id
            if (!resultMap.containsKey(Integer.parseInt(tempMap.get("algorithm_id").toString()))){
                settingsList = new ArrayList<>();
                //将当前记录转化为ProcedureSettings对象
                settingsList.add(new ProcedureSettings(
                        Integer.parseInt(tempMap.get("id").toString()),
                        Integer.parseInt(tempMap.get("algorithm_id").toString()),
                        tempMap.get("name").toString(),
                        tempMap.get("state").toString(),
                        tempMap.get("options").toString().split(","),
                        tempMap.get("default_option").toString(),
                        tempMap.get("description").toString(),
                        tempMap.get("name_mapper").toString()
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
                        tempMap.get("description").toString(),
                        tempMap.get("name_mapper").toString()
                );
                List<ProcedureSettings> settingsListTemp = resultMap.get(procedureSettings.getAlgorithmId());
                settingsListTemp.add(procedureSettings);
                resultMap.put(procedureSettings.getAlgorithmId(),settingsListTemp);
            }
        }
        return resultMap;
    }
}
