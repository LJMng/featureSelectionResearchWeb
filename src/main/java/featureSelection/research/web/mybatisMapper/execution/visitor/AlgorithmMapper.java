package featureSelection.research.web.mybatismapper.execution.visitor;

import featureSelection.research.web.entity.Algorithm;
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
    String getAlgorithmNameById(long id);

    /**
     * 获取所有算法的信息
     * @return List<Map<String,Object>>
     */
    @Select("select * from algorithm")
    @MapKey("algorithmId")
    Map<Long, Algorithm> getAlgorithmsList();
}
