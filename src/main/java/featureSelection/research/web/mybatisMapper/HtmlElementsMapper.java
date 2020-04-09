package featureselection.research.web.mybatismapper;


import featureselection.research.web.entity.HtmlElementControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/3/27 22:56
 */
@Mapper
public interface HtmlElementsMapper {

    /**
     * 获取页面元素的内容
     * @return List<HtmlElementsControl>
     */
    @Select("select * from html_element_control")
    List<HtmlElementControl> getLanguageElements();

    /**
     * 获取所有算法的信息
     * @return
     */
    @Select("select algorithm_id,algorithm_name,algorithm_description,algorithm_paper_reference,algorithm_paper_link from algorithm")
    List<Map<String,Object>> getAlgorithmsList();

    /**
     * 获取所有参数
     * @return
     */
    @Select("select parameter_id,algorithm_id,parameter_name,parameter_type,parameter_description,parameter_default_value from parameter")
    List<Map<String,Object>> getParameterList();
}
