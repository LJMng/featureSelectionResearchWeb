package featureSelection.research.web.config;

import org.springframework.amqp.core.*;
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

    @Bean
    public Queue demoResultReciverQueue(){
        return new Queue("demoResultReciverQueue");
    }

    @Bean
    public Queue executionResultReciverQueue(){
        return new Queue("executionResultReciverQueue");
    }

    @Bean
    public DirectExchange resultReciverExchange(){
        return new DirectExchange("resultReciverExchange");
    }

    @Bean
    Binding bindingDemo() {
        return BindingBuilder.bind(demoResultReciverQueue()).to(resultReciverExchange()).with(
                "demoResultReciverRoutingkey");
    }

    @Bean
    Binding bindingExecution() {
        return BindingBuilder.bind(executionResultReciverQueue()).to(resultReciverExchange()).with(
                "executionResultReciverRoutingkey");
    }



}
