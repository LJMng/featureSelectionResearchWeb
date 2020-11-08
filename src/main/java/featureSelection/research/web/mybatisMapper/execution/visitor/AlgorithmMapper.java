package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.Algorithm;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/27 14:17
 */
@Mapper
@Repository
public interface AlgorithmMapper {

    /**
     * 通过Id查询算法名称
     * @param id 算法id
     * @return AlgorithmId 算法名称
     */
    @Select("select algorithm_name from algorithm where algorithm_id = #{id}")
    String getAlgorithmNameById(int id);

    /**
     * 获取所有算法的信息
     * @return Map<Integer, Algorithm> 返回一个Map对象以算法id作为key
     */
    @Select("select * from algorithm")
    @MapKey("algorithmId")
    Map<Integer, Algorithm> getAlgorithmsList();

    /**
     * 通过算法id查询算法名称映射的值
     * @param algorithmId 算法id
     * @return String 算法名称映射的值
     */
    @Select("select algorithm_name_mapper from algorithm where algorithm_id = #{algorithmId}")
    String getAlgorithmNameMapperById(int algorithmId);

    @Select("select algorithm_doc from algorithm where algorithm_id = #{id}")
    String getAlgorithmDocById(Integer id);

    @Update("update algorithm set algorithm_doc = #{path} where algorithm.algorithm_id = #{id}")
    int uploadAlgDocById(Integer id,String path);

    @Select("select algorithm_id,algorithm_doc from algorithm")
    @MapKey("algorithmId")
    Map<Integer, Algorithm> getAllAlgDocsMap();

}
