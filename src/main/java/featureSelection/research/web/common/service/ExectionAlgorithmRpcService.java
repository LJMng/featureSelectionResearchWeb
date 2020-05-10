package featureSelection.research.web.common.service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.DemoCsvUtil;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.entity.communicationJson.AlgorithmCallTaskInfo;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.mybatisMapper.execution.visitor.TaskInfoMapper;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName : ExectionAlgorithmRpcServiceImpl
 * @Description : 供exection系统使用的rpc服务（异步）
 * @Author : WDD
 * @Date: 2020-05-08 15:05
 */
@Service
@EnableAsync
public class ExectionAlgorithmRpcService {


    @Autowired
    private AlgorithmMapper algorithmMapper;
    @Autowired
    private TaskInfoMapper taskInfoMapper;
    @Autowired
    private DatasetMapper datasetMapper;

    /**
     *
     * @param taskId
     * @return
     */
    @Async("executionThread")
    public void send(int taskId){
        TaskInfo taskInfo=taskInfoMapper.getTaskInfoByTaskId(taskId);
        int algorithmid =taskInfo.getAlgorithmId();
        //1.获取算法信息
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmid);
        //2.获取rabbitmq的connectionFactory
        String routingkey = algorithm.getAlgorithmCallRoutingkey();
        String host=algorithm.getAlgorithmCallHost();
        String exchange=algorithm.getAlgorithmCallExchange();
        int port=Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username=algorithm.getAlgorithmCallUsername();
        String password=algorithm.getAlgorithmCallPassword();
        CachingConnectionFactory connectionFactory= RabbitmqUtil.getConnectionFactory(host,port,username,password,exchange);
        //3.根据任务信息封装参数信息实体
        AlgorithmCallTaskInfo connectenity=new AlgorithmCallTaskInfo();
        // 3.1当前时间戳
        Long startTs = System.currentTimeMillis();
        //3.2设置算法调用任务信息id
        String requestTaskId = algorithm.getAlgorithmName()+ startTs;
        connectenity.setId(requestTaskId);
        //3.3 将算法参数实体信息对象转换为json字符串
        String jsonString = JSONObject.toJSONString(connectenity);
        //3.4 将json字符串转换为json对象
        JSONObject connectJsondata = JSONObject.parseObject(jsonString);
        //4.初步发送算法信息
        RabbitTemplate rabbitTemplate=RabbitmqUtil.getRabbitTemplate(connectionFactory);
        rabbitTemplate.setReplyTimeout(-1);
        //5.接受第一次返回结果（连接结果）
        Object firstresponse = rabbitTemplate.convertSendAndReceive(exchange,routingkey,connectJsondata);
        JSONObject connectresult=(JSONObject)firstresponse;
        int Partresult = (Integer) connectresult.get("part");
        //6.判断请求结果
        if (connectenity.getPart()== Partresult) {
            System.out.println("请求结果："+firstresponse.toString()+"\n"+"成功建立连接");
            //7.建立通讯后开始发送数据
            try {
                Dataset dataset = datasetMapper.getDatasetInfo(taskInfo.getDatasetId());
                int[][] data = new DemoCsvUtil(dataset.getdatasetFile()).csvToIntArray();
                //请求数据实体
                AlgorithmCallTaskInfo requestDataCommonInfo = new AlgorithmCallTaskInfo();
                //时间戳与任务建立时保持一致
                requestDataCommonInfo.setId(requestTaskId);
                requestDataCommonInfo.setDatasetName(dataset.getDatasetName());
                Object reductResult=new Object();
                System.out.println("开始发送数据");
                //7.1 根据数据量确定消息数
                for (int i=0;i<data.length-2;i++){
                    JSONObject requestData = RequestJsonData(i,data[i],requestDataCommonInfo);
                    rabbitTemplate.convertSendAndReceive(exchange, routingkey, requestData);
                    System.out.println("发送第"+i+"条数据："+requestData.toJSONString());
                }

                JSONObject RequestData = RequestJsonData(data.length,data[data.length-1],requestDataCommonInfo);
                //8.获得约简结果
                reductResult=rabbitTemplate.convertSendAndReceive(exchange, routingkey, RequestData);
                System.out.println("接受处理结果"+reductResult.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //9.写返回结果后的处理逻辑,比如将结果存储至数据库中，发送短信进行通知
        System.out.println("写入任务结果");
        System.out.println("发送邮箱");

    }

    /**
     * 根据任务封装请求信息类实体
     * @param taskid
     * @return
     */
    public AlgorithmCallTaskInfo taskInfoInfoToRequestEnity(int taskid){
        TaskInfo taskInfo=taskInfoMapper.getTaskInfoByTaskId(taskid);
        Algorithm algorithm=algorithmMapper.getAlgorithmInfoById(taskInfo.getAlgorithmId());
        AlgorithmCallTaskInfo algorithmCallTaskInfo=new AlgorithmCallTaskInfo();
        return algorithmCallTaskInfo;
    }

    /**
     *
     * @param row 数据为数据集第几行
     * @param data 数据
     * @param requestCommonData(数据实体)
     * @return
     * @throws IOException
     */
    public JSONObject RequestJsonData(int row,int[]data,AlgorithmCallTaskInfo requestCommonData) throws IOException {
        requestCommonData.setLine(row);
        requestCommonData.setPartTotalLine(data.length);
        requestCommonData.setData(data);
        String jsonString = JSONObject.toJSONString(requestCommonData);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;
    }
}
