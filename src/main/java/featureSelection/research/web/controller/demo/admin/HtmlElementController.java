package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.service.demo.admin.impl.HtmlElementServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author jjz
 * */
@RequestMapping("/HtmlElementDemoAdmin")
@RestController
public class HtmlElementController {

    @Autowired
    HtmlElementServiceImpl htmlElement;

    /**
     * @return 返回所有图片与图片包含的信息，返回格式为json
     * */
    //查找所有图片与图片包含信息
    @GetMapping("/findAllImages")
    public List<HtmlElementDemoAdmin> getAllImages(){
        return htmlElement.findAllImages();
    }

    /**
     * @param key
     *      前端点击的删除按钮都会对应一个key，返回的key就能用来查找
     * @return 返回通过key查找到的图片与图片的信息，返回格式为json
     * */
    //查找key对应图片与图片信息
    @GetMapping("/findByKey/{key}")
    public HtmlElementDemoAdmin findByKey(@PathVariable("key") String key){
        return htmlElement.findByKey(key);
    }

    /**
     * @param key
     *      前端点击的删除按钮都会对应一个key，返回的key就能用来确定删除的对象
     * @return 返回通过key查找到的图片与图片的信息并删除，返回格式为json
     * */
    //删除图片与图片信息
    @PostMapping("/delete/{key}")
    public String deleteImage(@PathVariable("key") String key) throws IOException {
        htmlElement.deleteImage(key);
        return null;
    }

    /**
     * @return 返回空值
     * */
    //将所有页面元素设置为默认值
    @PostMapping("/setDefault")
    public String setDefault(){
        htmlElement.setDefault();
        return null;
    }

    @PostMapping("/saveAboutUsPages")
    public String saveAboutUsPages(@Param("html") String html,
                                   @Param("title") String title) {
        htmlElement.saveAboutUsPages(html,title);
        return null;
    }
}
