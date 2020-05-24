package featureSelection.research.web.common.service;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.ExecutionRabbitmqComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : ExecutionRabbitmqComServiceSingleton
 * @Description : Execution系统进行通信服务单例
 * @Author : WDD
 * @Date: 2020-05-20 11:27
 */
@Component
public class ExecutionRabbitmqComServiceSingleton {
    private final static Logger log = LoggerFactory.getLogger(ExecutionRabbitmqComServiceSingleton.class);

    //放置Rabbitmq连接信息
    private static Map<String, ExecutionRabbitmqComInfo> executionRabbimqComInfos = new HashMap<>();

    public static void addExecutionRabbitmqComInfo(ExecutionRabbitmqComInfo executionRabbitmqComInfo) {
        executionRabbimqComInfos.put(executionRabbitmqComInfo.getExecutionRabbimqComTaskId(), executionRabbitmqComInfo);
        //开始发送rabbitmq连接信息
        executionRabbitmqComInfo.sendRabbitmqConnectRequestInfo();
    }

    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
        executionRabbimqComInfos.remove(rabbitmqComInfoTaskId);
    }

    @RabbitListener(queues = "executionResultReciverQueue")
    public void listen(JSONObject info) {
        log.info("reciver connect response" + info);
        //判断连接任务是否存在
        if (executionRabbimqComInfos.get(info.get("id")) != null) {
            //获取请求连接信息类
            ExecutionRabbitmqComInfo executionRabbitmqComInfo = executionRabbimqComInfos.get(info.get("id"));

            //判断是否为连接请求结果
            if (info.get("connect-status") != null) {
                //判断连接请求是否成功
                if (info.get("connect-status").equals(200)) {

                    //判断状态是否为准备状态（即服务等待连接状态）
                    if (executionRabbitmqComInfo.getStatues().equals("READY")) {
                        try {
                            log.info("connected");
                            //连接成功，开始发送数据
                            executionRabbitmqComInfo.sendDataset();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //设置状态为连接状态
                        executionRabbitmqComInfo.setStatues("CONNECTED");
                    } else {
                        log.info("repeat connect");
                    }
                }
                //连接失败
                else if (info.get("connect-status").equals(404)) {
                    log.info("connect falied");
                }
            }
            //判断是否存在数据传输错误信息
            if (info.get("data-error-info") != null) {
                executionRabbimqComInfos.get(info.get("id")).setStatues("dataerror");
                log.error(info.get("data-error-info").toString());
            }
            //若无连接信息以及错误信息，该消息即为任务结果信息，接收任务结果并设置任务完成
            executionRabbitmqComInfo.setResultInfo(info);
            executionRabbitmqComInfo.setStatues("FINISH");
        }
    }
}
