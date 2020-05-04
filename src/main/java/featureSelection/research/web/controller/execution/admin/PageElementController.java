package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.PageElement;
import featureSelection.research.web.service.execution.admin.PageElementBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageElementController {

    @Autowired
    private PageElementBusiness pageElementBusiness;


    @PostMapping("/htmlElements")
    public String createPageElement(PageElement pageElement){
        pageElementBusiness.createPageElement(pageElement);
        return "redirect:/pages/execution/admin/htmlElementList.html";
    }

    @GetMapping("/getHtmlElements")
    public @ResponseBody List<PageElement> findAll(){
        List<PageElement> pageElements=pageElementBusiness.findAll();
//        System.out.println(pageElements);
        return pageElements;
    }

    @GetMapping("/updateElement")
    public String updateElement(PageElement pageElement){
        pageElementBusiness.updateElement(pageElement);
        return "htmlElementList";
    }

    @GetMapping("/elements")
    public @ResponseBody Map<String,String>
    getElementMap(@RequestParam String htmlName, @RequestParam String isCh){
        List<PageElement> pageElements=pageElementBusiness.findAll();
        Map<String,String> elements=new HashMap<>();

        for (PageElement pageElement:pageElements){
            if (isCh.equals("ch")){
            elements.put(pageElement.getModuleKey(),pageElement.getChValue());
            }else {
                elements.put(pageElement.getModuleKey(),pageElement.getEnValue());
            }
        }
        return elements;
    }
    @GetMapping("/deletePageElement")
    public String deletePageElement(String moduleKey){
        pageElementBusiness.delete(moduleKey);
        System.out.println("delete");
        return "redirect: /pages/execution/admin/htmlElementList.html";
    }

}
