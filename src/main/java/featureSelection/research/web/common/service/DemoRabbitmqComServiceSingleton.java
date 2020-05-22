package featureSelection.research.web.common.service;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.controller.demo.visitor.AlgorithmEexecuteController;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : DemoRabbitmqComServiceSingleton
 * @Description : demo 进行rabbitmq 通讯的单例服务类
 * @Author : WDD
 * @Date: 2020-05-19 15:49
 */
@Component
public class DemoRabbitmqComServiceSingleton{
    private final static Logger log= LoggerFactory.getLogger(DemoRabbitmqComServiceSingleton.class);

    //Rabbitmq服务处理类
    private static Map<String, DemoRabbimqComInfo> demoRabbimqComInfos = new HashMap<>();


    /**
     * 将Rabbitmq服务处理类放入哈希表中
     * @param demoRabbimqComInfo
     */
    public static void addDemoRabbitmqComInfo(DemoRabbimqComInfo demoRabbimqComInfo) {
        demoRabbimqComInfos.put(demoRabbimqComInfo.getDemoRabbimqComTaskId(), demoRabbimqComInfo);
        //Rabbitmq服务处理类开始发送rabbitmq连接信息
        demoRabbimqComInfo.sendRabbitmqConnectRequestInfo();
    }

    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
            demoRabbimqComInfos.remove(rabbitmqComInfoTaskId);
    }

    /**
     * 监听请求结果队列信息
     * @param info
     */
    @RabbitListener(queues="demoResultReciverQueue")
    public void listen(JSONObject info){
        log.info("reciver connect response"+info);
        if (info.get("id")!=null){
            DemoRabbimqComInfo demoRabbimqComInfo=demoRabbimqComInfos.get(info.get("id"));
            if(demoRabbimqComInfo.getStatues().equals("READY")){
                try {
                    log.info("connected");
                    demoRabbimqComInfo.sendDataset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                demoRabbimqComInfo.setStatues("CONNECTED");
            }
            else if(demoRabbimqComInfo.getStatues().equals("CONNECTED")){
                demoRabbimqComInfo.setResultInfo(info);
                deleteRabbitmqComInfo(demoRabbimqComInfo.getDemoRabbimqComTaskId());
                log.info("reciver result"+info);}
        }
    }
}
