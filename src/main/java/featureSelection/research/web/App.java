package featureSelection.research.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"featureselection.research.web.mybatisMapper"})
@EnableScheduling
@ServletComponentScan({"featureselection.research.web.controller"})
public class App {
    public static void main(String[] args) {
    	SpringApplication.run(App.class, args);
    }
}
