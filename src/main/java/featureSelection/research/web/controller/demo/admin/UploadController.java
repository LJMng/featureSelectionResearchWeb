package featureSelection.research.web.controller.demo.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class UploadController {

    private static String UPLOAD_FOLDER = "C:\\Users\\jiang\\Desktop\\featureSelection - 副本 - 副本 - 副本\\src\\main\\resources\\public\\images\\";

    @PostMapping("/formUpload")
    public String uploadForm(@RequestParam("title") String title,
                             @RequestParam("body") String body,
                             @RequestParam("phone") String phone,
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
            System.out.println("添加成功");
            image.delete();
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/DemoAdmin/AboutusAdmin";
    }

    @ResponseBody
    @PostMapping("/deleteFormUpload")
    public String deleteUploadForm(String path){
        int lastIndexOf = path.lastIndexOf("/");
        String img_path = path.substring(lastIndexOf + 1, path.length());
        File file = new File(UPLOAD_FOLDER+img_path);
        if(file.exists()){
            boolean flag = file.delete();
        }
        return null;
    }
}