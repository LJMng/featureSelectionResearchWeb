package featureSelection.research.web.mybatisMapper.execution.admin;

import featureSelection.research.web.entity.execution.admin.PageElement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PageElementMapper {

    @Select("select * from html_element_control")
    public List<PageElement> findAll();

    @Insert("insert into html_element_control (html_name,module_key,type,ch_value,en_value)" +
            "values (#{htmlName},#{moduleKey},#{type},#{chValue},#{enValue})")
    public void createPageElement(PageElement pageElement);

    @Update("update html_element_control set " +
            "type=#{type},ch_value=#{chValue},en_value=#{enValue} where " +
            "html_name=#{htmlName} and module_key=#{moduleKey}")
    public void updatePageElement(PageElement pageElement);


    @Delete("delete  from html_element_control where html_name=#{htmlName} and module_key=#{moduleKey}")
    public void deletePageElement(String htmlName, String moduleKey);

    @Delete("delete from html_element_control where module_key=#{moduleKey}")
    public void deletePageElementByModuleKey(String moduleKey);
}
