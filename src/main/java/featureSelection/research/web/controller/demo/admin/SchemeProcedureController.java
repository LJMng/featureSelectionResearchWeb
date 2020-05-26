package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.SchemeProcedureDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeProcedureDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schemeProcedureDemoAdmin")
@RestController
public class SchemeProcedureController {

    @Autowired
    SchemeProcedureDemoAdminMapper schemeProcedureDemoAdminMapper;

    //提供查询所有步骤的接口
    @GetMapping("/findAll")
    public List<SchemeProcedureDemoAdmin> findAll(){
        return schemeProcedureDemoAdminMapper.findAll();
    }

    //提供通过ID查询步骤的接口
    @GetMapping("/find/{id}")
    public List<SchemeProcedureDemoAdmin> getSchemeProcedureDemoAdminById(@PathVariable("id") Integer id){
        return schemeProcedureDemoAdminMapper.getSchemeProcedureDemoAdminById(id);
    }

    //提供增加步骤的接口
    @PostMapping("/insert")
    public String insertSchemeProcedureDemoAdmin(){
        //将数据插入方案步骤表
        schemeProcedureDemoAdminMapper.insertSchemeProcedureDemoAdmin();
        return null;
    }

    //提供更新步骤的接口
    @PostMapping("/update")
    public String updateSchemeProcedureDemoAdmin(@RequestBody List<SchemeProcedureDemoAdmin> list){
        schemeProcedureDemoAdminMapper.updateSchemeProcedureDemoAdmin(list);
        return null;
    }

    //提供删除步骤的接口
    @PostMapping("/delete/{id}")
    public String deleteSchemeProcedureDemoAdmin(@PathVariable("id") Integer id){
        schemeProcedureDemoAdminMapper.deleteSchemeProcedureDemoAdmin(id);
        return null;
    }
}
