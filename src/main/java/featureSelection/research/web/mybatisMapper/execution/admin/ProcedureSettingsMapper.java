package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import org.apache.ibatis.annotations.Insert;

public interface ProcedureSettingsMapper {
    @Insert("insert into procedure_settings (algorithm_id,name,state,options,default_option,description) values (#{algorithmId},#{name},#{state},#{options},#{defaultOption},#{description})")
    public void addProcedureSetting(ProcedureSettings procedureSettings);
}
