package featureSelection.research.web.common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author Stephen
 * @date 2020/4/28 17:30
 */
@Component
public class CSVUtill {

    private String filePath;

    private CSVFormat csvFormat;

    private CSVParser csvParser;

    public CSVUtill() {
    }

    public CSVUtill(String filePath) {
        this.filePath = filePath;
        this.csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            this.csvParser = new CSVParser(reader,this.csvFormat);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Integer> getHeaders() {
        return csvParser.getHeaderMap();
    }

    public int getDimension () {
        return csvParser.getHeaderMap().size();
    }

    public int getDimensionByFilePath(String filePath) {
        this.filePath = filePath;
        this.csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            this.csvParser = new CSVParser(reader,this.csvFormat);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.csvParser.getHeaderMap().size();
    }

    public long getRecords () {
        long recordNumber = 0;
        try {
            csvParser.getRecords();
            recordNumber = csvParser.getRecordNumber();
            csvParser.close();
        } catch (IOException e) {
            throw new RuntimeException("records not found");
        }

        return recordNumber;
    }
}
