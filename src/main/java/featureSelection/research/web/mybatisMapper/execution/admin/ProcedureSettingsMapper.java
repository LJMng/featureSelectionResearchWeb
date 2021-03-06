package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProcedureSettingsMapper {
    @Insert("insert into procedure_settings (algorithm_id,name,name_mapper,state,options,default_option,description) values (#{algorithmId},#{name},#{nameMapper},#{state},#{options},#{defaultOption},#{description})")
    public void addProcedureSetting(ProcedureSettings procedureSettings);

    @Select("select * from procedure_settings")
    public List<ProcedureSettings> findAllProcedureSetting();

    @Update("update procedure_settings set name=#{name},name_mapper=#{nameMapper},state=#{state},options=#{options},default_option=#{defaultOption},description=#{description} where id=#{id}")
    public void updateProcedureSetting(ProcedureSettings procedureSettings);

    @Delete("delete from procedure_settings where id=#{id}")
    public void deleteProcedureSetting(int id);

    @Select("select max(id) from procedure_settings")
    public int getMaxProcedureSettingId();

    @Select("select * from procedure_settings where algorithm_id =#{algorithmId}")
    public List<ProcedureSettings> getProcedureInfosByAlgorithmId(int algorithmId);

    @Select("select * from procedure_settings where name = #{name} and algorithm_id = #{algorithmId}")
    public ProcedureSettings getProcedureSettingByName(String name,int algorithmId);

    @Update("update procedure_settings set name_mapper=#{nameMapper},state=#{state},options=#{options},default_option=#{defaultOption},description=#{description} where name=#{name}")
    public void updateProcedureSettingByProcedureSettingName(ProcedureSettings procedureSettings);

    @Select("select * from procedure_settings where algorithm_id = #{algorithmId} and name = #{name} ")
    public ProcedureSettings getProcedureSettingByAlgorithmIdAndName(Integer algorithmId, String name);
}
