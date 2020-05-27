package featureSelection.research.web.mybatisMapper.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author jjz
 * */
@Mapper
public interface HtmlElementDemoAdminMapper {
    //获取所有html
    public List<HtmlElementDemoAdmin> findAll();
    //获取所有htmlImages
    public List<HtmlElementDemoAdmin> findAllImages();
    //获取单个图片
    public HtmlElementDemoAdmin findByKey(String key);
    //保存更改
    public int saveHtmlElement(@Param("list") List<HtmlElementDemoAdmin> list);
    //保存图片信息
    public int saveImage(HtmlElementDemoAdmin htmlElementDemoAdmin);
    //删除图片信息
    public int deleteImage(String moduleKey);
    //设为默认值
    //删除原表内容
    public int dropTable();
    //将默认值插到原表
    public int setDefault();
    //插入关于我们页面的信息
    public int saveAboutUsPages(HtmlElementDemoAdmin htmlElementDemoAdmin);
}
