package featureSelection.research.web.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Stephen
 * @date 2020/4/11 17:05
 */
@Component
public class FileUploadUtil {

    /**
     * 将文件存到指定的路径中
     * @param uploadFile 文件
     * @param UPLOAD_PATH_PREFIX 文件路径（相对路径）
     * @return
     */
    public String uploadFIle(MultipartFile uploadFile,String UPLOAD_PATH_PREFIX){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = UPLOAD_PATH_PREFIX;
        File file = null;
        System.out.println(realPath);
        String oldName = uploadFile.getOriginalFilename();
        System.out.println(oldName);
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        System.out.println(newName);
        if (realPath.equals("algorithmDocs\\")){
            file = new File(realPath);
        } else {
            String format = sdf.format(new Date());
            //存放上传文件的文件夹
            file = new File(realPath + format);
        }
        System.out.println(file);
        System.out.println(file.getAbsolutePath());
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            return file.getPath()+File.separator+newName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";
    }

    public List<String> uploadFiles(MultipartFile[] uploadFile,String UPLOAD_PATH_PREFIX) {
        List<String> result = new ArrayList<>();
        for (MultipartFile file : uploadFile) {
            result.add(uploadFIle(file, UPLOAD_PATH_PREFIX));
        }
        return result;
    }
}
