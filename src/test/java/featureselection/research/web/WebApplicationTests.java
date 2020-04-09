package featureselection.research.web;

import featureselection.research.web.mybatismapper.HtmlElementsMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WebApplicationTests {

    @Autowired
    HtmlElementsMapper html;

    @Test
    void contextLoads() {
        List<Map<String, Object>> algorithmsList = html.getAlgorithmsList();
        System.out.println("132");
    }

}
