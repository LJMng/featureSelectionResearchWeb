package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RequestMapping("/HtmlElementDemoAdmin")
@RestController
public class HtmlElementController {
    //改为项目地址
    private static String UPLOAD_FOLDER = "C:\\Users\\jiang\\Desktop\\featureSelection - 副本 - 副本 - 副本\\src\\main\\resources\\public\\images\\";

    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    @GetMapping("/findAll")
    public List<HtmlElementDemoAdmin> getAll(){
        return htmlElementDemoAdminMapper.findAll();
    }

    @GetMapping("/findAllImages")
    public List<HtmlElementDemoAdmin> getAllImages(){
        return htmlElementDemoAdminMapper.findAllImages();
    }

    @GetMapping("/findByKey/{key}")
    public HtmlElementDemoAdmin findByKey(@PathVariable("key") String key){
        return htmlElementDemoAdminMapper.findByKey(key);
    }

    @PostMapping("/save")
    public String saveHtmlElement(@RequestBody List<HtmlElementDemoAdmin> list) {
        htmlElementDemoAdminMapper.saveHtmlElement(list);
        return null;
    }

    @PostMapping("/delete/{key}")
    public String deleteImage(@PathVariable("key") String key) {
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
}
