package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.DatasetDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.service.demo.admin.impl.SchemeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author jjz
 * */
@RequestMapping("/SchemeDemoAdmin")
@RestController
public class SchemeController {

    @Autowired
    SchemeServiceImpl schemeService;

    /**
     * @return 返回所有的方案的信息，返回格式为json
     * */
    //提供查询所有方案的接口
    @GetMapping("/findAll")
    public List<SchemeDemoAdmin> findAll(){
        return schemeService.findAll();
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来查找对应的方案
     * @return 返回通过ID查找到的方案的信息，返回格式为json
     * */
    //提供通过ID查询方案的接口
    @GetMapping("/find/{id}")
    public SchemeDemoAdmin getSchemeDemoAdminById(@PathVariable("id") Integer id){
        return schemeService.getSchemeDemoAdminById(id);
    }

    /**
     * @return 返回空值
     * */
    //提供增加方案的接口
    @PostMapping("/insert")
    public String insertScheme(@RequestBody SchemeDemoAdmin schemeDemoAdmin){
        schemeService.insertScheme(schemeDemoAdmin);
        return null;
    }

    /**
     * @param schemeDemoAdmin
     *      接受前端返回的方案信息，用于更新修改后的信息
     * @return 返回空值
     * */
    //提供更新方案的接口
    @PostMapping("/update")
    public String updateSchemeDemoAdmin(@RequestBody SchemeDemoAdmin schemeDemoAdmin){
        schemeService.updateSchemeDemoAdmin(schemeDemoAdmin);
        return null;
    }

    /**
     * @param id
     *      前端点击的按钮都会对应一个id，返回的id就能用来删除对应方案
     * @return 返回空值
     * */
    //提供删除方案的接口
    @PostMapping("/delete/{id}")
    public String deleteSchemeDemoAdmin(@PathVariable("id") Integer id){
        schemeService.deleteSchemeDemoAdmin(id);
        return null;
    }

    /**
     * @return 返回所有的数据集Id和名称，用来方案管理中选取数据集并记录，返回格式为json
     * */
    //查询所有数据集ID和名称提供方案调用接口
    @GetMapping("/findAllIdAndName")
    public List<DatasetDemoAdmin> findAllIdAndName(){
        return schemeService.findAllIdAndName();
    }
}


