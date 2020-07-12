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

    /**
     * 通过算法id获取某算法所有参数的id
     * @param algorithmId 算法id
     * @return int[] 参数id数组
     */
    @Select("select parameter_id from parameter where algorithm_id = #{algorithmId}")
    int[] getParamsIdByAlgorithmId(int algorithmId);

    /**
     * 获取参数信息表中所有的参数
     * @return List<Map<String,Object>> Map对象数组，一个记录为一个Map对象，key为参数表的字段，value为该字段对应的具体值
     */
    @Select("select parameter_id,algorithm_id,parameter_name,parameter_type,parameter_description,parameter_default_value,parameter_setting_info,parameter_name_mapper from parameter")
    List<Map<String,Object>> getParameterList();
}
