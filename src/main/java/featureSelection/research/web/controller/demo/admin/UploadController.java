package featureSelection.research.web.controller.demo.admin;

import featureSelection.research.web.mybatisMapper.demo.admin.HtmlElementDemoAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/**
 * @author jjz
 * */
@Controller
public class UploadController {

    @Autowired
    HtmlElementDemoAdminMapper htmlElementDemoAdminMapper;

    @ResponseBody
    @RequestMapping("/img")
    public Map<String,Object> uploadImgQiniu(@RequestParam("files") MultipartFile
                                                     file) throws IOException {

        Resource resource = new ClassPathResource("");
        Map<String,Object> map = new HashMap<String,Object>();
        String returnName = null;
        if(!file.isEmpty()) {
            //获取后缀
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            //生成图片唯一名
            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            String imageName = str.substring(0,8)+str.substring(9,13)+str.substring(14, 18)+str.substring(19, 23)+str.substring(24);
            String relativeAddr = imageName + extension;
            returnName = relativeAddr;

            // fileName处理
            relativeAddr = resource.getFile().getAbsolutePath() + "\\static\\images\\" + relativeAddr;
            // 文件对象
            File dest = new File(relativeAddr);
            // 创建路径
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdir();
            }
            try {
                //保存文件
                file.transferTo(dest);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("filename", "/images/"+returnName);
        return map;
    }
}
