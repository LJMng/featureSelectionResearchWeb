package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/HtmlElementDemoAdmin")
@RestController
public class HtmlElementController {
    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    @GetMapping("/findAll")
    public List<HtmlElementDemoAdmin> getAll(){
        return htmlElementDemoAdminMapper.findAll();
    }

    @PostMapping("/save")
    public String saveHtmlElement(@RequestBody List<HtmlElementDemoAdmin> list){
        htmlElementDemoAdminMapper.saveHtmlElement(list);
        return null;
    }
}
