package featureselection.research.web.service.execution.visitor.impl;

import featureselection.research.web.entity.Algorithm;
import featureselection.research.web.entity.Dataset;
import featureselection.research.web.entity.HtmlElementControl;
import featureselection.research.web.entity.Parameter;
import featureselection.research.web.mybatismapper.HtmlElementsMapper;
import featureselection.research.web.service.execution.visitor.IHtmlElementService;
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
    HtmlElementsMapper htmlElementsMapper;

    @Override
    public List<HtmlElementControl> getElementsContext(){
        return htmlElementsMapper.getLanguageElements();
    }

    @Override
    public Map<Long, Algorithm> getAlgorithmsList() {
        Map<Long, Algorithm> algorithmsList = htmlElementsMapper.getAlgorithmsList();
        for (long key: algorithmsList.keySet()){
            Algorithm algorithm = algorithmsList.get(key);
            String tempUt = algorithm.getUt().substring(0,10);
            algorithm.setUt(tempUt);
            algorithmsList.put(key,algorithm);
        }
        return algorithmsList;
    }

    @Override
    public Map<Long, List<Parameter>> getParametersList() {
        List<Map<String, Object>> parameterList = htmlElementsMapper.getParameterList();
        Map<Long,List<Parameter>> resultMap = new HashMap<>();
        Parameter parameter = null;
        List<Parameter> parameters = null;
        for (int i = 0; i < parameterList.size(); i++) {
            Map<String, Object> parameterMap = parameterList.get(i);
            if (!resultMap.containsKey(Long.parseLong(parameterMap.get("algorithm_id").toString()))){
                parameter = new Parameter(
                        Long.parseLong(parameterMap.get("parameter_id").toString()),
                        Long.parseLong(parameterMap.get("algorithm_id").toString()),
                        parameterMap.get("parameter_name").toString(),
                        parameterMap.get("parameter_description").toString(),
                        parameterMap.get("parameter_type").toString(),
                        parameterMap.get("parameter_default_value").toString()
                );
                parameters = new ArrayList<>();
                parameters.add(parameter);
                resultMap.put(parameter.getAlgorithmId(),parameters);
            }else {
                parameter = new Parameter(
                        Long.parseLong(parameterMap.get("parameter_id").toString()),
                        Long.parseLong(parameterMap.get("algorithm_id").toString()),
                        parameterMap.get("parameter_name").toString(),
                        parameterMap.get("parameter_description").toString(),
                        parameterMap.get("parameter_type").toString(),
                        parameterMap.get("parameter_default_value").toString()
                );
                parameters = resultMap.get(parameter.getAlgorithmId());
                parameters.add(parameter);
                resultMap.put(parameter.getAlgorithmId(),parameters);
            }
        }
        return resultMap;
    }

    @Override
    public Map<Long, Dataset> getDatasetList() {
        return htmlElementsMapper.getDatasetList();
    }
}
