package featureSelection.research.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan({"featureSelection.research.web.mybatismapper"})
@EnableScheduling
@ServletComponentScan({"featureSelection.research.web.controller"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
