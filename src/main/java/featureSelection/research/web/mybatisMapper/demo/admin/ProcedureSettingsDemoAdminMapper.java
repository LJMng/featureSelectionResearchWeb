package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.ProcedureSettingsDemoAdmin;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProcedureSettingsDemoAdminMapper {
    public List<ProcedureSettingsDemoAdmin> count();

    public int updateProcedureNameAfterChangedByExecutionAdmin(ProcedureSettings procedureSettings);
}
