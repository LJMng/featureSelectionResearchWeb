package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.BSettingsDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SettingsDemoAdminMapper {
    //通过ID查询基本设置
    public List<BSettingsDemoAdmin> getBSettingsBySchemeId(Integer id);
}
