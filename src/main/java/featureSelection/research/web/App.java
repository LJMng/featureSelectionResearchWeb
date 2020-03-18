package featureselection.reasearch.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan({"featureSelection.research.web.mybatisMapper"})
//@EnableScheduling
//@ServletComponentScan({"featureSelection.research.web.controller"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
