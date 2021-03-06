package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.ProcedureSettingsDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import featureSelection.research.web.entity.demo.admin.SchemeProcedureDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchemeProcedureDemoAdminMapper {
    //查询所有步骤
    public List<SchemeProcedureDemoAdmin> findAll();
    //通过ID查询步骤
    public List<SchemeProcedureDemoAdmin> getSchemeProcedureDemoAdminById(Integer id);
    //增加步骤
    public int insertSchemeProcedureDemoAdmin(String name,Integer procedureSettingsId);
    //增加步骤(步骤被删除后)
    public List<SchemeProcedureDemoAdmin> findSchemeProcedureAfterDeleteSchemeId();
    public int insertSchemeProcedureAfterDeleteDemoAdmin(SchemeProcedureDemoAdmin schemeProcedureDemoAdmin);
    public ProcedureSettingsDemoAdmin findNewProcedureAlgorithmId();
    //更新被绑定ID的步骤
    public int updateSchemeProcedureDemoAdmin(List<SchemeProcedureDemoAdmin> list);
    //删除被绑定ID的步骤
    public int deleteSchemeProcedureDemoAdmin(Integer id);
}