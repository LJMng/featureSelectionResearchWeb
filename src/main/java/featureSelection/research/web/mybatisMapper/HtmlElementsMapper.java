package featureselection.research.web.mybatismapper;


import featureselection.research.web.entity.Algorithm;
import featureselection.research.web.entity.Dataset;
import featureselection.research.web.entity.HtmlElementControl;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/3/27 22:56
 */
@Mapper
@Repository
public interface HtmlElementsMapper {

    /**
     * 获取页面元素的内容
     * @return List<HtmlElementsControl>
     */
    @Select("select * from html_element_control")
    List<HtmlElementControl> getLanguageElements();

    /**
     * 获取所有算法的信息
     * @return List<Map<String,Object>>
     */
    @Select("select * from algorithm")
    @MapKey("algorithmId")
    Map<Long, Algorithm> getAlgorithmsList();

    /**
     * 获取所有参数信息
     * @return List<Map<String,Object>>
     */
    @Select("select parameter_id,algorithm_id,parameter_name,parameter_type,parameter_description,parameter_default_value from parameter")
    List<Map<String,Object>> getParameterList();

    /**
     * 获取所有公共数据集
     * @return Map<Long,Dataset>
     */
    @Select("select dataset_id,dataset_name,dataset_description,dataset_size,dataset_source,dataset_dimension,dataset_records,dataset_tags,dataset_type,dataset_file from dataset")
    @MapKey("datasetId")
    Map<Long,Dataset> getDatasetList();
}
