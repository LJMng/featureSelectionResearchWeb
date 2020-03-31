package featureselection.research.web;

import featureselection.research.web.mybatismapper.ElementsLanguageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebApplicationTests {

    @Autowired
    ElementsLanguageMapper elementsLanguageMapper;

    @Test
    void contextLoads() {
        System.out.println("11");
    }

}
