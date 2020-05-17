package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.entity.demo.admin.HtmlElementDemoAdmin;
import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class UploadController {

    //改为项目地址
    private static String UPLOAD_FOLDER = "C:\\Users\\jiang\\Desktop\\featureSelection - 副本 - 副本 - 副本\\src\\main\\resources\\public\\images\\";

    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    @PostMapping("/formUpload")
    public String uploadForm(@RequestParam("description") String description,
                             @RequestParam("file") MultipartFile file){
        try {
            //获取后缀
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            //生成图片唯一名
            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            String imageName = str.substring(0,8)+str.substring(9,13)+str.substring(14, 18)+str.substring(19, 23)+str.substring(24);
            String relativeAddr = imageName + extension;

            //保存图片
            File image = new File(UPLOAD_FOLDER+relativeAddr);
            file.transferTo(image);
            HtmlElementDemoAdmin e = new HtmlElementDemoAdmin();
            e.setModuleKey("aboutusimage"+str.substring(0,8));
            e.setEnValue("/images/"+relativeAddr);
            e.setChValue(description);
            htmlElementDemoAdminMapper.saveImage(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/DemoAdmin/AboutusAdmin";
    }
}
