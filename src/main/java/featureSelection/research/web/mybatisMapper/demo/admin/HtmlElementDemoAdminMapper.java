package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HtmlElementDemoAdminMapper {
    //获取所有html
    public List<HtmlElementDemoAdmin> findAll();
    //保存更改
    public int saveHtmlElement(@Param("list") List<HtmlElementDemoAdmin> list);
}
