package featureSelection.research.web.common.service;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.controller.demo.visitor.AlgorithmEexecuteController;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : DemoRabbitmqComServiceSingleton
 * @Description : demo 进行rabbitmq通讯的单例服务类，管理所有的通讯信息类
 * 监听算法服务端返回的信息，找到对应的通讯信息类进行下一步处理（发送数据或完成任务）
 * @Author : WDD
 * @Date: 2020-05-19 15:49
 */
@Component
public class DemoRabbitmqComServiceSingleton {
    private final static Logger log = LoggerFactory.getLogger(DemoRabbitmqComServiceSingleton.class);

    /**
     * Rabbitmq服务处理类集合
     * String:DemoRabbimqComInfo中的demoRabbimqComTaskId，由调用算法名+调用时间戳组成
     */
    private static Map<String, DemoRabbimqComInfo> demoRabbimqComInfos = new ConcurrentHashMap<>(64);


    /**
     * 将Rabbitmq服务处理类放入哈希表中，并向算法服务端发送连接信息
     * @param demoRabbimqComInfo
     */
    public static void addDemoRabbitmqComInfo(DemoRabbimqComInfo demoRabbimqComInfo) {
        demoRabbimqComInfos.put(demoRabbimqComInfo.getDemoRabbimqComTaskId(), demoRabbimqComInfo);
        //Rabbitmq服务处理类开始发送rabbitmq连接信息
        demoRabbimqComInfo.sendRabbitmqConnectRequestInfo();
        log.info(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+
                "send connectInfo");
    }

    /**
     * 根据rabbitmqComInfoTaskId删除通讯信息类
     * @param rabbitmqComInfoTaskId
     */
    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
        demoRabbimqComInfos.remove(rabbitmqComInfoTaskId);
        log.info(new Date().toString()+"--"+"demoService:"+rabbitmqComInfoTaskId+
                "destroy");
    }

    /**
     * 监听算法服务端返回队列中的返回的信息
     * @param info：返回的信息
     */
    @RabbitListener(queues = "demoResultReciverQueue")
    public void listen(JSONObject info) {
        log.info("reciver connect response" + info);
        //1.判断连接任务是否存在
        if (demoRabbimqComInfos.get(info.get("id")) != null) {
            //2.1获取请求连接信息类
            DemoRabbimqComInfo demoRabbimqComInfo = demoRabbimqComInfos.get(info.get("id"));
            //2.2判断是否为连接请求结果
            if (info.get("connect-status") != null) {
                //3.判断连接请求是否成功
                if (info.get("connect-status").equals(200)) {
                    //4.判断状态是否为准备状态（即服务等待连接状态）
                    if (demoRabbimqComInfo.getStatues().equals("READY")) {
                        try {
                            log.info(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+"connected");
                            //连接成功，开始发送数据
                            demoRabbimqComInfo.sendDataset();
                        } catch (IOException e) {
                           e.printStackTrace();
                            ExceptionHistroyService.addDemoExceptionCount();
                            log.error(new Date().toString()+"---"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+":datasetIoProblem in"+demoRabbimqComInfo.getDatasetName());

                        }
                        //设置状态为连接状态
                        demoRabbimqComInfo.setStatues("CONNECTED");
                    } else {
                        log.info(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+
                                ":reconnect");
                    }
                }
                //连接失败
                else if (info.get("connect-status").equals(404)) {
                    ExceptionHistroyService.addDemoExceptionCount();
                    log.error(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+
                            "connect falied");
                }
            }
            //5.判断是否存在数据传输错误信息
            if (info.get("data-error-info") != null) {
                demoRabbimqComInfos.get(info.get("id")).setStatues("dataerror");
                log.error(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+
                        ":"+info.get("data-error-info").toString());
                ExceptionHistroyService.addDemoExceptionCount();
                demoRabbimqComInfo.setResultInfo(info.get("data-error-info").toString());
            }
            //6.如果信息中包含退出信息，则任务完成，接收任务结果并设置任务完成
            if (info.get("exitInfos")!=null){
                int DatasetDimension=Integer.parseInt(demoRabbimqComInfo.getDataset().getDatasetDimension());
                JSONArray reductJSONArray=JSONArray.parseArray(info.get("reducts").toString());
                int reductSize=reductJSONArray.size();
                String reductPrecentage = "";// 接受百分比的值
                double DatasetDimension_d = DatasetDimension * 1.0;
                double reductSize_d = reductSize * 1.0;
                double fen = reductSize_d / DatasetDimension_d;
                DecimalFormat df1 = new DecimalFormat("##.00%");
                reductPrecentage = df1.format(fen);
                info.put("reductSize",reductSize);
                info.put("reductPrecentage",reductPrecentage);
                info.put("notreductSize",DatasetDimension-reductSize);
                demoRabbimqComInfo.setResultInfo(info);
                demoRabbimqComInfo.setStatues("FINISH");
                log.info(new Date().toString()+"--"+"demoService:"+demoRabbimqComInfo.getDemoRabbimqComTaskId()+"FINISH");
            }

        }else {
            log.warn(new Date().toString()+"--"+"demoService:task ");
        }
    }
}
