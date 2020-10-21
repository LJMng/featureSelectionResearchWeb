package featureSelection.research.web.controller.execution.admin;

import featureSelection.research.web.entity.execution.admin.PageElement;
import featureSelection.research.web.service.execution.admin.PageElementBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PageElementController {

    @Autowired
    private PageElementBusiness pageElementBusiness;


    /**
     *
     * 跳转到管理员用户首页
     * @return
     */
    @GetMapping("/manage")
    public String getExecutionManageIndex(){
        return "/pages/execution/admin/executionAdminLogin.html";
    }
    @PostMapping("/htmlElements")
    public String createPageElement(@RequestBody PageElement pageElement){
        pageElementBusiness.createPageElement(pageElement);
        return "redirect:/pages/execution/admin/htmlElementList.html";
    }

    @GetMapping("/getHtmlElements")
    public @ResponseBody List<PageElement> findAll(){
        List<PageElement> pageElements=pageElementBusiness.findAll();
        return pageElements;
    }

    @PostMapping("/updateElement")
    public String updateElement(@RequestBody PageElement pageElement){
        pageElementBusiness.updateElement(pageElement);
        return "redirect: /pages/execution/admin/htmlElementList.html";
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
    @PostMapping("/deletePageElement")
    public String deletePageElement(@RequestBody PageElement pageElement){
        String htmlName=pageElement.getHtmlName();
        String moduleKey=pageElement.getModuleKey();
        pageElementBusiness.delete(htmlName,moduleKey);
        return "redirect: /pages/execution/admin/htmlElementList.html";
    }

}
