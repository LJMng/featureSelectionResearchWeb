package featureSelection.research.web.common.service;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.ExecutionRabbitmqComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : ExecutionRabbitmqComServiceSingleton
 * @Description : Execution系统进行通信服务单例
 * @Author : WDD
 * @Date: 2020-05-20 11:27
 */
public class ExecutionRabbitmqComServiceSingleton {
    private final static Logger log= LoggerFactory.getLogger(ExecutionRabbitmqComServiceSingleton.class);

    //放置Rabbitmq连接信息
    private static Map<String, ExecutionRabbitmqComInfo> executionRabbimqComInfos = new HashMap<>();

    public static void addExecutionRabbitmqComInfo(ExecutionRabbitmqComInfo executionRabbitmqComInfo) {
        executionRabbimqComInfos.put(executionRabbitmqComInfo.getExecutionRabbimqComTaskId(),executionRabbitmqComInfo);
        //开始发送rabbitmq连接信息
        executionRabbitmqComInfo.sendRabbitmqConnectRequestInfo();
    }

    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
        executionRabbimqComInfos.remove(rabbitmqComInfoTaskId);
    }

    @RabbitListener(queues="executionResultReciverQueue")
    public void listen(JSONObject info){
        log.info("接受连接信息");
        if (info.get("id")!=null){
            ExecutionRabbitmqComInfo executionRabbitmqComInfo=executionRabbimqComInfos.get(info.get("id"));
            if(executionRabbitmqComInfo.getStatues().equals("READY")){
                try {
                    executionRabbitmqComInfo.sendDataset();
                    log.info("连接已建立");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                executionRabbitmqComInfo.setStatues("CONNECTED");
            }
            if(executionRabbitmqComInfo.getStatues().equals("CONNECTED")){
                executionRabbitmqComInfo.setResultInfo(info);
                executionRabbitmqComInfo.sendEmailAndWriteResult();
            }
        }
    }
}
