package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.Dataset;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/27 14:43
 */
@Mapper
@Repository
public interface DatasetMapper {

    @Select("select dataset_records from dataset where dataset_id = #{id}")
    int getDatasetRecordById(int id);

    /**
     * 通过数据集id获取数据集的维度数
     * @param id 数据集id
     * @return int 数据集的维度数
     */
    @Select("select dataset_dimension from dataset where dataset_id = #{id}")
    int getDatasetDimensionById(int id);

    /**
     * 查询数据集数据库中是否含有某数据集名称
     * @param datasetName 待查询的数据集名称
     * @return int 与待查询数据集名称重复的个数
     */
    @Select("select count(dataset_name) from dataset where dataset_name = #{datasetName}")
    int queryDatasetName(String datasetName);

    /**
     * 通过数据集id获取数据集名称
     * @param id 数据集id
     * @return String 数据集名称
     */
    @Select("select dataset_name from dataset where dataset_id = #{id}")
    String getDatasetNameById(int id);

    /**
     * 获取所有公共数据集
     * @return Map<Integer,Dataset> Map对象数据集id为key，数据集对象为value
     */
    @Select("select dataset_id,dataset_name,dataset_description,dataset_size,dataset_source,dataset_dimension,dataset_records,dataset_tags,dataset_type,dataset_file from dataset")
    @MapKey("datasetId")
    Map<Integer, Dataset> getDatasetList();
}
