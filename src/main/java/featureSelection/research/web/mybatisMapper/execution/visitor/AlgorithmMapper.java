package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.Algorithm;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/27 14:17
 */
@Mapper
@Repository
public interface AlgorithmMapper {

    @Select("select algorithm_name from algorithm where algorithm_id = #{id}")
    String getAlgorithmNameById(int id);

    /**
     * 获取所有算法的信息
     * @return List<Map<String,Object>>
     */
    @Select("select * from algorithm")
    @MapKey("algorithmId")
    Map<Integer, Algorithm> getAlgorithmsList();

    @Select("select algorithm_name_mapper from test_fs.algorithm where algorithm_id = #{algorithmId}")
    String getAlgorithmNameMapperById(int algorithmId);
}
