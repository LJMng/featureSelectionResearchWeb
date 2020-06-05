package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.Parameter;
import featureSelection.research.web.entity.execution.admin.WebAlgorithmMapperEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AlgorithmMapper {
    @Select("select * from algorithm")
    public List<Algorithm> getAlgorithms();

    @Insert("insert into parameter (algorithm_id,parameter_name,parameter_name_mapper,parameter_description,parameter_type,parameter_default_value,parameter_setting_info)" +
            " values (#{algorithmId},#{parameterName},#{parameterNameMapper},#{parameterDescription},#{parameterType},#{parameterDefaultValue},#{parameterSettingInfo})")
    public void createParameter(Parameter parameter);

}
