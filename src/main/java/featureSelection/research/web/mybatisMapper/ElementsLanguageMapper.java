package featureselection.research.web.mybatismapper;


import featureselection.research.web.entity.HtmlElementControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/3/27 22:56
 */
@Mapper
public interface ElementsLanguageMapper {

    /**
     * 获取页面元素的内容
     * @return List<HtmlElementsControl>
     */
    @Select("select * from html_element_control")
    List<HtmlElementControl> getElements();

}
