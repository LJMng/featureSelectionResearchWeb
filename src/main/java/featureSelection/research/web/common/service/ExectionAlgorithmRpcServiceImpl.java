package featureSelection.research.web.common.service;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @ClassName : ExectionAlgorithmRpcServiceImpl
 * @Description : 供exection系统使用的rpc服务（异步）
 * @Author : WDD
 * @Date: 2020-05-08 15:05
 */
@Service
@EnableAsync
public class ExectionAlgorithmRpcServiceImpl {

    @Autowired
    private AlgorithmMapper algorithmMapper;

    /**
     *
     * @param data 数据
     * @param algorithmid 算法id
     * @return String
     */
    @Async("executionThread")
    public String send(Object data,int algorithmid){
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmid);
        String routingkey = algorithm.getAlgorithmCallRoutingkey();
        String host=algorithm.getAlgorithnCallHost();
        String exchange=algorithm.getAlgorithmCallExchange();
        int port=Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username=algorithm.getAlgorithmCallUsername();
        String password=algorithm.getAlgorithmCallPassword();
        CachingConnectionFactory connectionFactory= RabbitmqUtil.getConnectionFactory(host,port,username,password,exchange);
        RabbitTemplate rabbitTemplate=RabbitmqUtil.getRabbitTemplate(connectionFactory);
        rabbitTemplate.setReplyTimeout(-1);
        Object response = rabbitTemplate.convertSendAndReceive(exchange,routingkey,data);
        //写返回结果后的处理逻辑,比如将结果存储至数据库中，发送短信进行通知
        System.out.println("写入任务结果");
        return "ok";
    }



}
