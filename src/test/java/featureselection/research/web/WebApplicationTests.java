package featureselection.research.web;

import featureselection.research.web.mybatismapper.ExecutionFormsMapper;
import featureselection.research.web.mybatismapper.HtmlElementsMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WebApplicationTests {

    @Autowired
    HtmlElementsMapper html;

    @Autowired
    ExecutionFormsMapper formsMapper;

    @Test
    void contextLoads() {
        System.out.println("111");
    }

}
