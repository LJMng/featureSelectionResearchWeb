package featureSelection.research.web.mybatismapper.execution.visitor;

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
    int[] getParamsIdByAlgorithmId(long algorithmId);


    /**
     * 获取所有参数信息
     * @return List<Map<String,Object>>
     */
    @Select("select parameter_id,algorithm_id,parameter_name,parameter_type,parameter_description,parameter_default_value,parameter_setting_info from parameter")
    List<Map<String,Object>> getParameterList();
}
