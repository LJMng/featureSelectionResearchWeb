package featureselection.research.web;

import featureselection.research.web.mybatisMapper.TaskInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    TaskInfoMapper taskInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(taskInfoMapper.getState("33185080"));
    }

}
