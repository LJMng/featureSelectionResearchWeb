package featureSelection.research.web.mybatisMapper.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.HtmlElementControl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stephen
 * @date 2020/4/28 16:00
 */
@Mapper
@Repository
public interface HtmlElementControlMapper {

    /**
     * 获取页面元素的内容
     * @return List<HtmlElementsControl> 页面元素对象数组
     */
    @Select("select * from html_element_control")
    List<HtmlElementControl> getLanguageElements();
}
