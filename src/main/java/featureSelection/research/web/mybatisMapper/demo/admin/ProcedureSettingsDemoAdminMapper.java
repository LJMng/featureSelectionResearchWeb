package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.ProcedureSettingsDemoAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcedureSettingsDemoAdminMapper {
    public List<ProcedureSettingsDemoAdmin> count();
}
