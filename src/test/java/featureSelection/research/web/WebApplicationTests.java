package featureSelection.research.web;

import featureSelection.research.web.common.CSVUtill;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WebApplicationTests {

    @Test
    void contextLoads() throws IOException {

        CSVUtill csv = new CSVUtill("src\\main\\resources\\static\\dataset\\publicDataset\\iris.csv");
        System.out.println(csv.getRecords());
        System.out.println(csv.getDimension());
    }
}
