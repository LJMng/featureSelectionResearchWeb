package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.WebAlgorithmMapperEntity;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface WebAlgorithmMapper {
    @Insert("insert into web_algorithm_mapper (algorithm_id,procedure_setting_id,web_key,algorithm_value) " +
            " values (#{algorithmId},#{procedureSettingId},#{webKey},#{algorithmValue})")
    public void insertProcedureAlgorithmOption(WebAlgorithmMapperEntity webAlgorithmMapperEntity);

    @Insert("insert into web_algorithm_mapper (algorithm_id,parameter_id,web_key,algorithm_value) " +
            " values (#{algorithmId},#{parameterId},#{webKey},#{algorithmValue})")
    public void insertParameterAlgorithmValue(WebAlgorithmMapperEntity webAlgorithmMapperEntity);
}
