package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.WebAlgorithmMapperEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WebAlgorithmMapper {
    @Insert("insert into web_algorithm_mapper (algorithm_id,procedure_setting_id,web_key,algorithm_value) " +
            " values (#{algorithmId},#{procedureSettingId},#{webKey},#{algorithmValue})")
    public void insertProcedureAlgorithmOption(WebAlgorithmMapperEntity webAlgorithmMapperEntity);

    @Insert("insert into web_algorithm_mapper (algorithm_id,parameter_id,web_key,algorithm_value) " +
            " values (#{algorithmId},#{parameterId},#{webKey},#{algorithmValue})")
    public void insertParameterAlgorithmValue(WebAlgorithmMapperEntity webAlgorithmMapperEntity);

    @Select("select algorithm_value from web_algorithm_mapper where algorithm_id=#{algorithmId} and procedure_setting_id=#{procedureSettingId} and web_key=#{webKey}")
    public String getProcedureValue(int algorithmId, int procedureSettingId, String webKey);

    @Select("select algorithm_value from web_algorithm_mapper where algorithm_id=#{algorithmId} and parameter_id=#{parameterId} and web_key=#{webKey}")
    public String getParameterValue(int algorithmId, int parameterId, String webKey);
}
