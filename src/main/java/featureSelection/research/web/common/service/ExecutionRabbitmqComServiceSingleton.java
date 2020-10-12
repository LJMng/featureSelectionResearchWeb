package featureSelection.research.web.common.service;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.DemoRabbimqComInfo;
import featureSelection.research.web.entity.communicationJson.rabbitmqcominfo.ExecutionRabbitmqComInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : ExecutionRabbitmqComServiceSingleton
 * @Description : Execution系统通过rabbitmq进行通信服务单例,管理所有的通讯信息类
 * 监听算法服务端返回的信息，找到对应的通讯信息类进行下一步处理（发送数据或完成任务）
 * @Author : WDD
 * @Date: 2020-05-20 11:27
 */
@Component
public class ExecutionRabbitmqComServiceSingleton {
    private final static Logger log = LoggerFactory.getLogger(ExecutionRabbitmqComServiceSingleton.class);

    /**
     * Rabbitmq服务处理类集合
     * String:ExecutionRabbitmqComInfo中的executionRabbimqComInfos，由调用算法名+调用时间戳组成
     * return:int 排队号
     */
    private static Map<String, ExecutionRabbitmqComInfo> executionRabbimqComInfos = new ConcurrentHashMap<>(64);

    public static int addExecutionRabbitmqComInfo(ExecutionRabbitmqComInfo executionRabbitmqComInfo) {

        executionRabbimqComInfos.put(executionRabbitmqComInfo.getExecutionRabbimqComTaskId(), executionRabbitmqComInfo);
        //开始发送rabbitmq连接信息
        executionRabbitmqComInfo.sendRabbitmqConnectRequestInfo();
        log.info("excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":"+"send connectInfo");
        return executionRabbimqComInfos.size();
    }

    public static void deleteRabbitmqComInfo(String rabbitmqComInfoTaskId) {
        executionRabbimqComInfos.remove(rabbitmqComInfoTaskId);
        log.info(new Date().toString()+"--"+"excutionService:"+rabbitmqComInfoTaskId+
                "destroy");
    }

    /**
     * 监听算法服务端返回队列中的返回的信息
     * @param message：返回的信息
     */
    @RabbitListener(queues = "executionResultReciverQueue")
    public void listen(JSONObject message) {

        JSONObject infoJSon=message;
        log.info("jsonInfo"+infoJSon.toJSONString());
        //判断连接任务是否存在
        if (executionRabbimqComInfos.get(infoJSon.get("id")) != null) {
            //获取请求连接信息类
            ExecutionRabbitmqComInfo executionRabbitmqComInfo = executionRabbimqComInfos.get(infoJSon.get("id"));

            //判断是否为连接请求结果
            if (infoJSon.get("connect-status") != null) {
                //判断连接请求是否成功
                if ((int)infoJSon.get("connect-status")==200) {
                    //判断状态是否为准备状态（即服务等待连接状态）
                    if (executionRabbitmqComInfo.getStatues().equals("READY")) {
                        try {
                            log.info("excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                                    +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":"+"connected");
                            //连接成功，开始发送数据
                            executionRabbitmqComInfo.sendDataset();

                        } catch (IOException e) {
                            e.printStackTrace();
                            log.error(new Date().toString()+"excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                                    +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":datasetIoProblem:"+executionRabbitmqComInfo.getDataSetName());
                            executionRabbimqComInfos.get(infoJSon.get("id")).setStatues("datasetIoError");
                        }
                        //设置状态为连接状态
                        executionRabbitmqComInfo.setStatues("CONNECTED");
                    } else {
                        log.info("excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                                +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":"+"reconnect");
                    }
                }
                //连接失败
                else if (infoJSon.get("connect-status").equals(404)) {
                    log.warn("excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                    +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":"+"connect " +
                        "falied");

                    executionRabbitmqComInfo.getTaskInfo().setAlgorithmStatus("alg client could not connect");
                }
            }
            //判断是否存在数据传输错误信息
            if (infoJSon.get("data-error-info") != null) {
                executionRabbimqComInfos.get(infoJSon.get("id")).setStatues("dataerror");
                log.error(infoJSon.get("data-error-info").toString());
                executionRabbitmqComInfo.setResultInfo(infoJSon.get("data-error-info").toString());
                executionRabbitmqComInfo.getTaskInfo().setAlgorithmStatus("data-error:"+infoJSon.get("data-error-info").toString());
            }
            //如果信息中包含退出信息，则任务完成，接收任务结果并设置任务完成
            if (infoJSon.get("exitInfos") != null) {
                executionRabbitmqComInfo.setResultInfo(infoJSon);
                executionRabbitmqComInfo.setStatues("FINISH");
                executionRabbitmqComInfo.sendEmailAndWriteResult();
                log.info("excutionService:"+executionRabbitmqComInfo.getTaskAccoutEmail()+"-"
                        +executionRabbitmqComInfo.getExecutionRabbimqComTaskId()+":"+"FINISH"+"  resultInfo:"+infoJSon.toJSONString());
            }
        }
    }
}
