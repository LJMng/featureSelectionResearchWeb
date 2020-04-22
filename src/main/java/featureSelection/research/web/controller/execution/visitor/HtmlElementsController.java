package featureselection.research.web.controller.execution.visitor;

import featureselection.research.web.entity.Algorithm;
import featureselection.research.web.entity.Dataset;
import featureselection.research.web.entity.HtmlElementControl;
import featureselection.research.web.entity.Parameter;
import featureselection.research.web.service.execution.visitor.impl.HtmlElementsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/3/27 22:41
 */
@RestController
public class HtmlElementsController {

    @Autowired
    HtmlElementsServiceImpl htmlElementsServiceImpl;

    @GetMapping("/htmlElements")
    public List<HtmlElementControl> getElementsContext(){
        return htmlElementsServiceImpl.getElementsContext();
    }

    @GetMapping("/getAlgorithmsList")
    public Map<Long, Algorithm> getAlgorithmsList() {
        return htmlElementsServiceImpl.getAlgorithmsList();
    }

    @GetMapping("/getParameterList")
    public Map<Long, List<Parameter>> getParametersList() {
        return htmlElementsServiceImpl.getParametersList();
    }

    @GetMapping("/getDatasetList")
    public Map<Long, Dataset> getDatasetList(){
        return htmlElementsServiceImpl.getDatasetList();
    }
}
