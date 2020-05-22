package featureSelection.research.web.controller.demo.visitor;
import featureSelection.research.web.common.service.DemoRabbitmqComServiceSingleton;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.service.demo.visitor.impl.AlgorithmServiceImpl;
import featureSelection.research.web.service.demo.visitor.impl.DatasetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

import static java.lang.Thread.sleep;

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
    private AlgorithmServiceImpl algorithmserviceImpl;
    @Autowired
    private DatasetServiceImpl datasetServiceImpl;

    @PostMapping(value = "/transmitExcuteInfo")
    @ResponseBody
    public Object reciveExecuteInfo(@RequestParam("algorithmId") String algorithmId,
                                    @RequestParam("parameterSchemeId") String parameterSchemeId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object resultJson=new Object();
        DemoRabbimqComInfo demoRabbimqComInfo=new DemoRabbimqComInfo(Integer.parseInt(parameterSchemeId),
                Integer.parseInt(algorithmId));
        DemoRabbitmqComServiceSingleton.addDemoRabbitmqComInfo(demoRabbimqComInfo);
        while(true){
        if (demoRabbimqComInfo.getResultInfo()!=null){
            resultJson=demoRabbimqComInfo.getResultInfo();
            //任务结束后删除连接
            DemoRabbitmqComServiceSingleton.deleteRabbitmqComInfo(demoRabbimqComInfo.getDemoRabbimqComTaskId());
            return resultJson;

        }else{
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

    @ResponseBody
    @GetMapping("getAllAlgorithmInfo")
    public List<Algorithm>getAllAlgorithmInfo(){
        return algorithmserviceImpl.getAllAlgorithmInfo();
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
