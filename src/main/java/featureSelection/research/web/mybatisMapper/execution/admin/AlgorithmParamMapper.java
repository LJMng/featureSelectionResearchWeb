package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Parameter;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AlgorithmParamMapper {
    @Select("select * from parameter")
    public List<Parameter> getParameters() ;

    @Update("update parameter set parameter_setting_info=#{parameterSettingInfo}  where  algorithm_id=#{algorithmId}")
    public void createParamSettingInfo(int algorithmId, String parameterSettingInfo);

    @Update("update parameter set parameter_name=#{parameterName},parameter_name_mapper=#{parameterNameMapper},parameter_type=#{parameterType},parameter_default_value=#{parameterDefaultValue},parameter_description=#{parameterDescription} where parameter_id=#{parameterId}")
    public void updateParameter(Parameter parameter);

    @Delete("delete from parameter where parameter_id=#{parameterId}")
    public void deleteParameter(int parameterId);

    @Select("select max(parameter_id) from parameter")
    public Integer getMaxParameterId();
}
