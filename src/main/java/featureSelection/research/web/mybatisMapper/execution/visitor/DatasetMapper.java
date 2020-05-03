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

    @Select("select dataset_dimension from dataset where dataset_id = #{datasetId}")
    int getDatasetDimensionById(int datasetId);

    @Select("select count(dataset_name) from dataset where dataset_name = #{datasetName}")
    int queryDatasetName(String datasetName);

    @Select("select dataset_name from dataset where dataset_id = #{id}")
    String getDatasetNameById(int id);

    /**
     * 获取所有公共数据集
     * @return Map<Integer,Dataset>
     */
    @Select("select dataset_id,dataset_name,dataset_description,dataset_size,dataset_source,dataset_dimension,dataset_records,dataset_tags,dataset_type,dataset_file from dataset")
    @MapKey("datasetId")
    Map<Integer, Dataset> getDatasetList();
}
