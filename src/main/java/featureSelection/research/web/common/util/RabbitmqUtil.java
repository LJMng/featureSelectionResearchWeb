package featureSelection.research.web.common.util;


import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName : RabbitmqUtil
 * @Description :
 * @Author : WDD
 * @Date: 2020-05-05 21:20
 */
public class RabbitmqUtil {

    public static CachingConnectionFactory getConnectionFactory(String host,
                                                         int port,
                                                         String username,
                                                         String password,
                                                         String exchangename) {
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        RabbitAdmin admin = new RabbitAdmin(factory);
        DirectExchange directExchange = new DirectExchange(exchangename);
        admin.declareExchange(directExchange);
        return factory;
    }

    public static RabbitTemplate getRabbitTemplate(CachingConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        return rabbitTemplate;
    }

}
