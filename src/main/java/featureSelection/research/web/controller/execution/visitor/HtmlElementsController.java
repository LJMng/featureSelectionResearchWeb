package featureSelection.research.web.controller.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.*;
import featureSelection.research.web.service.execution.visitor.IHtmlElementService;
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
    IHtmlElementService htmlElementsServiceImpl;

    @GetMapping("/htmlElements")
    public List<HtmlElementControl> getElementsContext(){
        return htmlElementsServiceImpl.getElementsContext();
    }

    @GetMapping("/execution/getAlgorithmsList")
    public Map<Integer, Algorithm> getAlgorithmsList() {
        return htmlElementsServiceImpl.getAlgorithmsList();
    }

    @GetMapping("/execution/getParameterList")
    public Map<Integer, List<Parameter>> getParametersList() {
        return htmlElementsServiceImpl.getParametersList();
    }

    @GetMapping("/execution/getDatasetList")
    public Map<Integer, Dataset> getDatasetList(){
        return htmlElementsServiceImpl.getDatasetList();
    }

    @GetMapping("/execution/getProcedureSettingsList")
    public Map<Integer,List<ProcedureSettings>> getProcedureSettingsList() {
        return htmlElementsServiceImpl.getProcedureSettingList();
    }
}
