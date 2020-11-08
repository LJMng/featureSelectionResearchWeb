package featureSelection.research.web.common.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;
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
        File jarF = new ApplicationHome(getClass()).getSource();
        String path = jarF.getParentFile().toString()+File.separator+filePath;
        if (new File(path).exists()) {
            this.filePath=path;
        } else {
            path.replace("\\target", "");
            this.filePath = path;
        }
        this.csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        FileReader reader = null;
        try {
            reader = new FileReader(this.filePath);
            this.csvParser = new CSVParser(reader,this.csvFormat);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读取某个csv的头部
     * @return Map<String, Integer>
     */
    public Map<String, Integer> getHeaders() {
        return csvParser.getHeaderMap();
    }

    /**
     * 获取某个数据集的维度数
     * @return int 维度数
     */
    public int getDimension () {
        return csvParser.getHeaderMap().size();
    }

    /**
     * 通过文件地址获取该数据集的维度数
     * @param filePath 文件地址
     * @return int 维度数
     */
    public int getDimensionByFilePath(String filePath) {
        this.filePath = filePath;
        this.csvFormat = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        File jarF = new ApplicationHome(getClass()).getSource();
        String path = jarF.getParentFile().toString()+File.separator+filePath;
        if (new File(path).exists()) {
            this.filePath=path;
        } else {
            this.filePath = path.replace("\\target", "");
        }
        FileReader reader = null;
        try {
            reader = new FileReader(this.filePath);
            this.csvParser = new CSVParser(reader,this.csvFormat);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this.csvParser.getHeaderMap().size();
    }

    /**
     * 获取某个数据集的记录数
     * @return long 记录数
     */
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
