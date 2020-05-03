package featureSelection.research.web.mybatisMapper;

import featureSelection.research.web.entity.demo.admin.SchemeDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchemeDemoAdminMapper {
    //查询所有方案
    public List<SchemeDemoAdmin> findAll();
    //通过ID查询方案
    public SchemeDemoAdmin getSchemeDemoAdminById(Integer id);
    //增加方案
    public int insertSchemeDemoAdmin(SchemeDemoAdmin schemeDemoAdmin);
    //更新被绑定ID的方案信息
    public int updateSchemeDemoAdmin(SchemeDemoAdmin schemeDemoAdmin);
    //删除被绑定ID的方案(方案表)
    public int deleteScheme(Integer id);
    //删除方案对应的算法参数(参数方案值表)
    public int deleteSchemeParameterValue(Integer id);
    //更新方案对应的参数
    public int updateSchemeParameterDemoAdmin(SchemeDemoAdmin schemeDemoAdmin);
    //增加存储参数值的位置(参数方案值表)
    public int insertSchemeParameterSchemeIdAndParameterId(SchemeDemoAdmin schemeDemoAdmin);
}
