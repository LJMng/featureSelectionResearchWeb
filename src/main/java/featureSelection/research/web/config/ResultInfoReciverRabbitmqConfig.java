package featureSelection.research.web.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : ResultInfoReciverRabbitmqConfig
 * @Description : 接收任务处理的rabbitmq服务的配置类
 * @Author : WDD
 * @Date: 2020-05-18 14:51
 */
@Configuration
public class ResultInfoReciverRabbitmqConfig {
//    @Value(value ="${spring.rabbitmq.localResultReciverExchange}")
//    private String localResultReciverExchange;
//    @Value(value ="${spring.rabbitmq.localDemoResultReciverRoutingkey}")
//    private String localDemoResultReciverRoutingkey;
//    @Value(value ="${spring.rabbitmq.localExecutionResultReciverRoutingkey}")
//    private String localExecutionResultReciverRoutingkey;
//    //demo任务接收队列
//    @Bean
//    public Queue demoResultReciverQueue(){
//        return new Queue("demoResultReciverQueue");
//    }
//
//    //execution任务接受队列
//    @Bean
//    public Queue executionResultReciverQueue(){
//        return new Queue("executionResultReciverQueue");
//    }
//
//    //实例化ResultReciver交换机
//    @Bean
//    public DirectExchange resultReciverExchange(){
//        return new DirectExchange(localResultReciverExchange);
//    }
//
//    //将demo任务接收队列绑定至ResultReciver交换机,路由键为demoResultReciverRoutingkey
//    @Bean
//    Binding bindingDemo() {
//        return BindingBuilder.bind(demoResultReciverQueue()).to(resultReciverExchange()).with(
//                localDemoResultReciverRoutingkey);
//    }
//
//    //将execution任务接受队列绑定至ResultReciver交换机,路由键为executionResultReciverRoutingkey
//    @Bean
//    Binding bindingExecution() {
//        return BindingBuilder.bind(executionResultReciverQueue()).to(resultReciverExchange()).with(
//                localExecutionResultReciverRoutingkey);
//    }
//


}
