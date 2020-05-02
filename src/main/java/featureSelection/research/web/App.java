package featureSelection.research.web;

import featureSelection.research.web.service.demo.visitor.impl.AlgotithRpcServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@MapperScan({"featureselection.research.web.mybatisMapper"})
@EnableScheduling
@ServletComponentScan({"featureselection.research.web.controller"})
public class App {
    public static void main(String[] args) {
     SpringApplication.run(App.class, args);

    }
}
