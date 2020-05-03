package featureSelection.research.web.controller.demo.visitor;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.service.demo.visitor.impl.AlgorithmServiceImpl;
import featureSelection.research.web.service.demo.visitor.impl.AlgotithRpcServiceImpl;
import featureSelection.research.web.service.demo.visitor.impl.DatasetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @ClassName : AlgorithmEexecuteController
 * @Description : A Controller For external execution
 * @Author : WDD
 * @Date: 2020-03-31 18:09
 */


@Controller
@RequestMapping(value = "/demo")
public class  AlgorithmEexecuteController {
    @Autowired
    private AlgorithmServiceImpl algorithmservice;
    @Autowired
    private DatasetServiceImpl datasetServiceImpl;
    @Autowired
    private AlgotithRpcServiceImpl algotithRpcService;

    @PostMapping(value = "/transmitExcuteInfo")
    @ResponseBody
    public Object reciveExecuteInfo(@RequestParam("algorithmId") String algorithmId,
                                    @RequestParam("parameterSchemeId") String parameterSchemeId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object resultJson=algotithRpcService.send(Integer.parseInt(algorithmId),Integer.parseInt(parameterSchemeId));

        return resultJson;
    }

    @ResponseBody
    @GetMapping("getAllAlgorithmInfo")
    public List<Algorithm>getAllAlgorithmInfo(){
        return algorithmservice.getAllAlgorithmInfo();
    }

    @GetMapping(value="/download")
    public void download(@RequestParam(value="datasetid")String datasetid,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        Dataset datasetinfo= datasetServiceImpl.getDatesetInfo(Integer.parseInt(datasetid));
        System.out.println(datasetinfo.toString());
        String path = this.getClass().getClassLoader().getResource(datasetinfo.getdatasetFile()).getPath();
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        //转码，免得文件名中文乱码
        String datasetname=datasetinfo.getDatasetName();
        datasetname = URLEncoder.encode(datasetname,"UTF-8");
        //获取文件后缀
        String  fileSuffix = path.substring(path.lastIndexOf(".")+1);
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + datasetname+"."+fileSuffix);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
    }
