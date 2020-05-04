package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.DatasetDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/SchemeDemoAdmin")
@RestController
public class SchemeController {

    @Autowired
    SchemeDemoAdminMapper schemeDemoAdminMapper;

    //提供查询所有方案的接口
    @GetMapping("/findAll")
    public List<SchemeDemoAdmin> findAll(){
        return schemeDemoAdminMapper.findAll();
    }

    //提供通过ID查询方案的接口
    @GetMapping("/find/{id}")
    public SchemeDemoAdmin getSchemeDemoAdminById(@PathVariable("id") Integer id){
        return schemeDemoAdminMapper.getSchemeDemoAdminById(id);
    }

    //提供增加方案的接口
    @PostMapping("/insert")
    public String insertScheme(@RequestBody SchemeDemoAdmin schemeDemoAdmin){
        //将数据插入参数方案表
        schemeDemoAdminMapper.insertSchemeDemoAdmin(schemeDemoAdmin);
        //将数据插入参数方案值表
        schemeDemoAdminMapper.insertSchemeParameterSchemeIdAndParameterId(schemeDemoAdmin);
        return null;
    }

    //提供更新方案的接口
    @PostMapping("/update")
    public String updateSchemeDemoAdmin(@RequestBody SchemeDemoAdmin schemeDemoAdmin){
        schemeDemoAdminMapper.updateSchemeDemoAdmin(schemeDemoAdmin);
        schemeDemoAdminMapper.updateSchemeParameterDemoAdmin(schemeDemoAdmin);
        return null;
    }

    //提供删除方案的接口
    @PostMapping("/delete/{id}")
    public String deleteSchemeDemoAdmin(@PathVariable("id") Integer id){
        schemeDemoAdminMapper.deleteSchemeParameterValue(id);
        schemeDemoAdminMapper.deleteScheme(id);
        return null;
    }
    //查询所有数据集ID和名称提供方案调用接口
    @GetMapping("/findAllIdAndName")
    public List<DatasetDemoAdmin> findAllIdAndName(){
        return schemeDemoAdminMapper.findAllIdAndName();
    }
}


