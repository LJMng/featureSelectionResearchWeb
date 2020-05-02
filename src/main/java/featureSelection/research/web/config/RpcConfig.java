package featureSelection.research.web.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : RpcConfig
 * @Description :rabbitmq Rpc 配置类
 * @Author : WDD
 * @Date: 2020-04-11 22:38
 */
@Configuration
public class RpcConfig {

    @Bean
    DirectExchange TestRpcExchange() {
        return new DirectExchange("tut.rpc");
    }
}
