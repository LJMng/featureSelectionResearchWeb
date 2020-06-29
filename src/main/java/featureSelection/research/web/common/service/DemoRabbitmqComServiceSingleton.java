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
    private static Map<String, DemoRabbimqComInfo> demoRabbimqComInfos = new HashMap<>();


    /**
     * 将Rabbitmq服务处理类放入哈希表中，并向算法服务端发送连接信息
     * @param demoRabbimqComInfo
     */
    public static void addDemoRabbitmqComInfo(DemoRabbimqComInfo demoRabbimqComInfo) {
        demoRabbimqComInfos.put(demoRabbimqComInfo.getDemoRabbimqComTaskId(), demoRabbimqComInfo);
        //Rabbitmq服务处理类开始发送rabbitmq连接信息
        demoRabbimqComInfo.sendRabbitmqConnectRequestInfo();
    }

    /**
     * 根据rabbitmqComInfoTaskId删除通讯信息类
     * @param rabbitmqComInfoTaskId
     */
    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
        demoRabbimqComInfos.remove(rabbitmqComInfoTaskId);
    }

    /**
     * 监听算法服务端返回队列中的返回的信息
     * @param info：返回的信息
     */
    @RabbitListener(queues = "demoResultReciverQueue")
    public void listen(JSONObject info) {
        log.info("reciver connect response" + info);
        //判断连接任务是否存在
        if (demoRabbimqComInfos.get(info.get("id")) != null) {
            //获取请求连接信息类
            DemoRabbimqComInfo demoRabbimqComInfo = demoRabbimqComInfos.get(info.get("id"));
            //判断是否为连接请求结果
            if (info.get("connect-status") != null) {
                //判断连接请求是否成功
                if (info.get("connect-status").equals(200)) {
                    //判断状态是否为准备状态（即服务等待连接状态）
                    if (demoRabbimqComInfo.getStatues().equals("READY")) {
                        try {
                            log.info("connected");
                            //连接成功，开始发送数据
                            demoRabbimqComInfo.sendDataset();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //设置状态为连接状态
                        demoRabbimqComInfo.setStatues("CONNECTED");
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
                demoRabbimqComInfos.get(info.get("id")).setStatues("dataerror");
                log.error(info.get("data-error-info").toString());
            }
            //如果信息中包含退出信息，则任务完成，接收任务结果并设置任务完成
            if (info.get("exitInfos")!=null){
                demoRabbimqComInfo.setResultInfo(info);
                demoRabbimqComInfo.setStatues("FINISH");
                log.info("FINISH");
            }

        }
    }
}
