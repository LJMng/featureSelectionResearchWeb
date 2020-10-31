package featureSelection.research.web.controller.execution.visitor;

import featureSelection.research.web.entity.execution.visitor.*;
import featureSelection.research.web.mybatisMapper.execution.visitor.AlgorithmMapper;
import featureSelection.research.web.service.execution.visitor.IHtmlElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/3/27 22:41
 */
@RestController
public class HtmlElementsController {

    @Autowired
    IHtmlElementService htmlElementsServiceImpl;
    
    @Autowired
    AlgorithmMapper algorithmMapper;

    @GetMapping("/htmlElements")
    public List<HtmlElementControl> getElementsContext(){
        return htmlElementsServiceImpl.getElementsContext();
    }

    @GetMapping("/execution/getAlgorithmsList")
    public Map<Integer, Algorithm> getAlgorithmsList() {
        return htmlElementsServiceImpl.getAlgorithmsList();
    }

    @GetMapping("/execution/getParameterList")
    public Map<Integer, List<Parameter>> getParametersList() {
        return htmlElementsServiceImpl.getParametersList();
    }

    @GetMapping("/execution/getDatasetList")
    public Map<Integer, Dataset> getDatasetList(){
        return htmlElementsServiceImpl.getDatasetList();
    }

    @GetMapping("/execution/getProcedureSettingsList")
    public Map<Integer,List<ProcedureSettings>> getProcedureSettingsList() {
        return htmlElementsServiceImpl.getProcedureSettingList();
    }

    @GetMapping("/execution/download/{datasetId}")
    public void downloadDataset(HttpServletResponse response, @PathVariable("datasetId") int datasetId) throws IOException {
        response.sendRedirect("/demo/visitor/download?datasetid=" + datasetId);
    }

    @GetMapping("/execution/downloadAlgorithmDocument/{algorithmId}")
    public void downloadAlgorithmDocument(HttpServletResponse response,@PathVariable String algorithmId) throws IOException {
        String docPath = algorithmMapper.getAlgorithmDocById(Integer.parseInt(algorithmId));
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        StringBuilder jarPathSb = new StringBuilder(docPath);
        jarPathSb.insert(0, jarF.getParentFile().toString() + "\\");
        String jarPath = jarPathSb.toString();
        File jarfile = new File(jarPath.toString());
        File aimsFile;
        if (jarfile.exists()) {
            aimsFile = jarfile;
        } else {
            String noJarPath = jarPath.toString();
            noJarPath = noJarPath.replace("\\target", "");
            aimsFile = new File(noJarPath);
        }
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(aimsFile));
        //转码，免得文件名中文乱码
        String datasetname = algorithmMapper.getAlgorithmNameById(Integer.parseInt(algorithmId));
        datasetname = URLEncoder.encode(datasetname, "UTF-8");
        //获取文件后缀
        String fileSuffix = jarPath.substring(jarPath.lastIndexOf(".") + 1);
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + datasetname + "." + fileSuffix);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();

    }

    @GetMapping("/execution/authorizationDownloadAlgDocs/")
    public List<Integer> authorizationDownloadAlgDocs(@RequestParam("accountId")int accountId) {
        return htmlElementsServiceImpl.getAuthorizationDownloadAlgDocs(accountId);
    }

    @GetMapping("/execution/authorizationUploadAlgDocs/")
    public List<Integer> authorizationUploadAlgDocs(@RequestParam("accountId")int accountId) {
        return htmlElementsServiceImpl.getAuthorizationUploadAlgDocs(accountId);
    }


}
