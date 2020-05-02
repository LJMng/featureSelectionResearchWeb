package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.entity.demo.visitor.PageElement;
import featureSelection.research.web.service.demo.visitor.PageElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName : PageElementController
 * @Description : 页面元素控制层
 * @Author : WDD
 * @Date: 2020-04-24 11:48
 */
@RequestMapping("/demo")
@RestController
public class PageElementController {
    @Autowired
    private PageElementService pageElementService;

    @GetMapping("/getPageelementByHtmlName")
    public List<PageElement>getPageElementByHtmlName(@RequestParam("htmlname")String htmlname){
        return pageElementService.findelemetsByHtml(htmlname);
    }
}
