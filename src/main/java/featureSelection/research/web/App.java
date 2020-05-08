package featureSelection.research.web;

import featureSelection.research.web.common.util.UniqueNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;


@SpringBootApplication
@EnableAsync
@ComponentScan(nameGenerator = UniqueNameGenerator.class)
@MapperScan(basePackages="featureselection.research.web.mybatisMapper",nameGenerator =UniqueNameGenerator.class )
@EnableScheduling
@ServletComponentScan({"featureselection.research.web.controller"})
public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext  context = SpringApplication.run(App.class, args);
    }
}
