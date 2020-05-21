package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
/**
 * @author jjz
 * */
@RequestMapping("/HtmlElementDemoAdmin")
@RestController
public class HtmlElementController {
    //改为项目地址
    private static String UPLOAD_FOLDER = "C:\\Users\\jiang\\Desktop\\featureSelection - 副本 - 副本 - 副本\\src\\main\\resources\\public\\images\\";

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
    public String deleteImage(@PathVariable("key") String key) {
        /**
         * @param e
         *      HtmlElementDemoAdmin的实例化
         * @param path
         *      存放图片的路径
         * @param lastIndexOf
         *      最后的"/"后面的字符信息
         * @param img_path
         *      图片的名字
         * @param flag
         *      用来判断文件是否删除
         * */
        HtmlElementDemoAdmin e = htmlElementDemoAdminMapper.findByKey(key);
        String path = e.getEnValue();
        int lastIndexOf = path.lastIndexOf("/");
        String img_path = path.substring(lastIndexOf);
        File file = new File(UPLOAD_FOLDER+img_path);
        if(file.exists()){
            boolean flag = file.delete();
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
}
