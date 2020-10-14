package featureSelection.research.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.common.util.SpringUtil;
import featureSelection.research.web.common.util.UniqueNameGenerator;
import featureSelection.research.web.entity.communicationJson.SendDataSetInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.SchemeProcedureMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.ClassUtils;

import java.io.IOException;


@SpringBootApplication
@EnableAsync
@ComponentScan(nameGenerator = UniqueNameGenerator.class)
@MapperScan(basePackages="featureSelection.research.web.mybatisMapper.**",nameGenerator =UniqueNameGenerator.class )
@EnableScheduling
@Import(SpringUtil.class)
@ServletComponentScan({"featureSelection.research.web.controller"})
public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext  context = SpringApplication.run(App.class, args);
    }
}
