package featureselection.research.web.controller.execution.visitor;

import featureselection.research.web.entity.HtmlElementControl;
import featureselection.research.web.mybatismapper.ElementsLanguageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/3/27 22:41
 */
@RestController
public class ElementsController {

    @Autowired
    ElementsLanguageMapper languageMapper;

    @GetMapping("/htmlElements")
    public List<HtmlElementControl> getHtmlElements(){
        return languageMapper.getElements();
    }
}
