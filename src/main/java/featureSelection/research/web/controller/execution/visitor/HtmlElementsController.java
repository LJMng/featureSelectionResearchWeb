package featureSelection.research.web.controller.execution.visitor;

import featureSelection.research.web.entity.*;
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

    @GetMapping("/getProcedureSettingsList")
    public Map<Long,List<ProcedureSettings>> getProcedureSettingsList() {
        return htmlElementsServiceImpl.getProcedureSettingList();
    }
}
