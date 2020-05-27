package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jjz
 * */
@RequestMapping("/HtmlElementDemoAdmin")
@RestController
public class HtmlElementController {

    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    /**
     * @return 返回所有的页面元素的信息，返回格式为json
     * */
    //查找所有页面元素
    @GetMapping("/findAll")
    public List<HtmlElementDemoAdmin> getAll(){
        return htmlElementDemoAdminMapper.findAll();
    }

    /**
     * @return 返回所有图片与图片包含的信息，返回格式为json
     * */
    //查找所有图片与图片包含信息
    @GetMapping("/findAllImages")
    public List<HtmlElementDemoAdmin> getAllImages(){
        return htmlElementDemoAdminMapper.findAllImages();
    }

    /**
     * @param key
     *      前端点击的删除按钮都会对应一个key，返回的key就能用来查找
     * @return 返回通过key查找到的图片与图片的信息，返回格式为json
     * */
    //查找key对应图片与图片信息
    @GetMapping("/findByKey/{key}")
    public HtmlElementDemoAdmin findByKey(@PathVariable("key") String key){
        return htmlElementDemoAdminMapper.findByKey(key);
    }

    /**
     * @param list
     *      从前端接受的修改后的信息，接受的是多个HtmlElementDemoAdmin
     * @return 返回空值
     * */
    //保存修改后的页面元素
    @PostMapping("/save")
    public String saveHtmlElement(@RequestBody List<HtmlElementDemoAdmin> list) {
        htmlElementDemoAdminMapper.saveHtmlElement(list);
        return null;
    }

    /**
     * @param key
     *      前端点击的删除按钮都会对应一个key，返回的key就能用来确定删除的对象
     * @return 返回通过key查找到的图片与图片的信息并删除，返回格式为json
     * */
    //删除图片与图片信息
    @PostMapping("/delete/{key}")
    public String deleteImage(@PathVariable("key") String key) throws IOException {
        //获取当前项目下的路径
        Resource resource = new ClassPathResource("");
        HtmlElementDemoAdmin e = htmlElementDemoAdminMapper.findByKey(key);
        //获取图片路径
        String path = e.getEnValue();

        //匹配图片的名字
        Pattern p_img = Pattern.compile("<(img|IMG)(.*?)(/>|></img>|>)");
        Matcher m_img = p_img.matcher(path);
        boolean result_img = m_img.find();
        if (result_img) {
            while (result_img) {
                //获取到匹配的<img />标签中的内容
                String str_img = m_img.group(2);

                //开始匹配<img />标签中的src
                Pattern p_src = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
                Matcher m_src = p_src.matcher(str_img);
                if (m_src.find()) {
                    String str_src = m_src.group(3);
                    int lastIndexOf = str_src.lastIndexOf("/");
                    String img_path = str_src.substring(lastIndexOf);
                    File file = new File(resource.getFile().getAbsolutePath() + "\\static\\images\\" + img_path);
                    if (file.exists()) {
                        //删除图片
                        boolean flag = file.delete();
                    }
                }
                //结束匹配<img />标签中的src
                //匹配content中是否存在下一个<img />标签，有则继续以上步骤匹配<img />标签中的src
                result_img = m_img.find();
            }
        }
        htmlElementDemoAdminMapper.deleteImage(key);
        return null;
    }

    /**
     * @return 返回空值
     * */
    //将所有页面元素设置为默认值
    @PostMapping("/setDefault")
    public String setDefault(){
        htmlElementDemoAdminMapper.dropTable();
        htmlElementDemoAdminMapper.setDefault();
        return null;
    }

    @PostMapping("/saveAboutUsPages")
    public String saveAboutUsPages(@Param("html") String html,
                                   @Param("title") String title) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String moduleKey = str.substring(0, 8);
        HtmlElementDemoAdmin e = new HtmlElementDemoAdmin();
        e.setModuleKey(moduleKey);
        int l = 0;
        String h = html;
        do {
            l = html.indexOf("&lt;", l);
            if (l == -1) break;
            h = html.substring(0, l) + "<" + html.substring(l + "$lt;".length());
            l += "<".length();
            html = h;
        } while (true);
        do {
            l = html.indexOf("&gt;", l);
            if (l == -1) break;
            h = html.substring(0, l) + ">" + html.substring(l + "$gt;".length());
            l += ">".length();
            html = h;
        } while (true);
        e.setEnValue(html);
        e.setChValue(title);
        htmlElementDemoAdminMapper.saveAboutUsPages(e);
        return null;
    }
}
