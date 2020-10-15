package featureSelection.research.web.controller.demo.visitor;

import featureSelection.research.web.common.service.DemoRabbitmqComServiceSingleton;
import featureSelection.research.web.common.util.DemoCsvUtil;
import featureSelection.research.web.common.util.ResultUtil;
import featureSelection.research.web.entity.Result;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.service.demo.visitor.impl.DatasetServiceImpl;
import featureSelection.research.web.service.demo.visitor.impl.IAlgorithmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

/**
 * @ClassName : AlgorithmEexecuteController
 * @Description : A Controller For external execution
 * @Author : WDD
 * @Date: 2020-03-31 18:09
 */


@RestController
@RequestMapping(value = "/demo/visitor")
public class AlgorithmEexecuteController {
    @Autowired
    private IAlgorithmServiceImpl algorithmserviceImpl;
    @Autowired
    private DatasetServiceImpl datasetServiceImpl;

    @PostMapping(value = "/transmitExcuteInfo")
    public Result reciveExecuteInfo(@RequestParam("algorithmId") String algorithmId,
                                    @RequestParam("parameterSchemeId") String parameterSchemeId,
                                    @RequestParam("datasetId") String datasetId) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        DemoRabbimqComInfo demoRabbimqComInfo = new DemoRabbimqComInfo(Integer.parseInt(parameterSchemeId),
                Integer.parseInt(algorithmId), Integer.parseInt(datasetId));
        DemoRabbitmqComServiceSingleton.addDemoRabbitmqComInfo(demoRabbimqComInfo);
        while (true) {
            if (demoRabbimqComInfo.getStatues().equals("FINISH")) {
                //任务结束后删除连接
                Result result = ResultUtil.success(demoRabbimqComInfo.getResultInfo());
                DemoRabbitmqComServiceSingleton.deleteRabbitmqComInfo(demoRabbimqComInfo.getDemoRabbimqComTaskId());
                return result;

            } else if (demoRabbimqComInfo.getStatues().equals("dataerror")) {
                Result result = ResultUtil.error(400, (String) demoRabbimqComInfo.getResultInfo());
            } else {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @GetMapping("getAllAlgorithmInfo")
    public List<Algorithm> getAllAlgorithmInfo() {
        return algorithmserviceImpl.getAllAlgorithmInfo();
    }


    /**
     * 下载方案使用的数据集 接口
     *
     * @param datasetid
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/download")
    public void download(@RequestParam(value = "datasetid") String datasetid,
                         HttpServletResponse response) throws IOException {
        Dataset datasetinfo = datasetServiceImpl.getDatesetInfo(Integer.parseInt(datasetid));
        String fileRelativeInfo = datasetinfo.getdatasetFile();
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        StringBuilder jarPathSb = new StringBuilder(datasetinfo.getdatasetFile());
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
        String datasetname = datasetinfo.getDatasetName();
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

    @GetMapping(value = "/reviewCsvDataSet")
    public Result reviewCsvDataSet(@RequestParam(value = "datasetid") String datasetid){
        Dataset datasetinfo = datasetServiceImpl.getDatesetInfo(Integer.parseInt(datasetid));
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        StringBuilder jarPathSb = new StringBuilder(datasetinfo.getdatasetFile());
        jarPathSb.insert(0, jarF.getParentFile().toString() + "\\");
        String jarPath = jarPathSb.toString();
        File jarfile = new File(jarPath.toString());
        String aimsFilePath;
        if (jarfile.exists()) {
            aimsFilePath = jarPath.toString();
        } else {
            String noJarPath = jarPath.toString();
            noJarPath = noJarPath.replace("\\target", "");
            aimsFilePath=noJarPath;
        }

        DemoCsvUtil csvUtil;
        try {
            csvUtil=new DemoCsvUtil(aimsFilePath);
        } catch (IOException e) {
            return ResultUtil.error(404, "could not find this dataset");
        }
        List<String> datasetList = csvUtil.csvToListString();
        Map<String, Object> Resultmap=new HashMap<>();
        Resultmap.put("fileName",datasetinfo.getDatasetName());
        Resultmap.put("datasetList",datasetList);
        return ResultUtil.success(Resultmap);
    }

}
