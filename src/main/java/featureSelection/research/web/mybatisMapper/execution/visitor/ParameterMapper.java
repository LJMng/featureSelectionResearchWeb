package featureSelection.research.web.mybatisMapper.execution.visitor;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/27 14:56
 */
@Mapper
@Repository
public interface ParameterMapper {

    @Select("select parameter_id from parameter where algorithm_id = #{algorithmId}")
    int[] getParamsIdByAlgorithmId(int algorithmId);


    /**
     * 获取所有参数信息
     * @return List<Map<String,Object>>
     */
    @Select("select parameter_id,algorithm_id,parameter_name,parameter_type,parameter_description,parameter_default_value,parameter_setting_info,parameter_name_mapper from parameter")
    List<Map<String,Object>> getParameterList();
}
