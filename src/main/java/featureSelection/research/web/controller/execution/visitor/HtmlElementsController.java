package featureselection.research.web.controller.execution.visitor;

import featureselection.research.web.entity.HtmlElementControl;
import featureselection.research.web.entity.Parameter;
import featureselection.research.web.mybatismapper.HtmlElementsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/3/27 22:41
 */
@RestController
public class HtmlElementsController {

    @Autowired
    HtmlElementsMapper html;

    @GetMapping("/htmlElements")
    public List<HtmlElementControl> getHtmlElements(){
        return html.getLanguageElements();
    }

    @GetMapping("/getAlgorithmsList")
    public List<Map<String,Object>> getAlgorithmsList() {
        return html.getAlgorithmsList();
    }

    @GetMapping("/getParameterList")
    public Map<Long, List<Parameter>> getParametersList() {
        List<Map<String, Object>> parameterList = html.getParameterList();
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
}
