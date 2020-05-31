package featureSelection.research.web.service.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;

import java.io.IOException;
import java.util.List;

public interface HtmlElementService {
    //获取所有htmlImages
    public List<HtmlElementDemoAdmin> findAllImages();
    //获取单个图片
    public HtmlElementDemoAdmin findByKey(String key);
    //删除图片信息
    public int deleteImage(String moduleKey) throws IOException;
    //设为默认值
    public int setDefault();
    //插入关于我们页面的信息
    public int saveAboutUsPages(String html, String title);
}
