package featureSelection.research.web.common.util;


import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class DemoCsvUtil {
    String csvPath;
    //csv文件间隔符号，默认逗号
    char csvChar = ',';
    CsvReader csvReader;

    public DemoCsvUtil(String csvPath) throws IOException {
        this.csvPath = csvPath;
    }
//
//    /**
//     * 相对路径转绝对路径
//     *
//     * @return
//     */
//    public String relativePathtoAboslute(String path) {
//        String apppath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//        String aboslutePath = apppath + path;
//        return aboslutePath;
//    }

    /**
     * 将csv文件转化为int二位数组
     *
     * @return int[][]
     * @throws IOException
     */
    public int[][] csvToIntArray() throws IOException {
        this.csvReader = new CsvReader(this.csvPath);
        List<int[]> list = new ArrayList<int[]>();
        while (this.csvReader.readRecord()) {
            int[] ints = (int[]) ConvertUtils.convert(this.csvReader.getValues(), int.class);
            list.add(ints);
        }
        int[][] intArray = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }
        this.csvReader.close();
        return intArray;
    }

    /**
     * 将csv文件转化为string二位数组
     *
     * @return String[][]
     */
    public String[][] csvToStringArray() throws IOException {
        this.csvReader = new CsvReader(this.csvPath);
        List<String[]> list = new ArrayList<String[]>();
        while (this.csvReader.readRecord()) {
            String[] strings = this.csvReader.getValues();
            list.add(strings);
        }
        String[][] stringsArray = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            stringsArray[i] = list.get(i);
        }
        this.csvReader.close();
        return stringsArray;
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

    public char getCsvChar() {
        return csvChar;
    }

    public void setCsvChar(char csvChar) {
        this.csvChar = csvChar;
    }

    //将二维数组转为csv文件并存储
    public static void Arrays2Csv(String[][] arry, String filename) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        char c = ',';
        File file = new File("E:\\eclipse\\eclipse\\workspace\\algorithmweb\\src\\main\\webapp\\WEB-INF\\result" + filename + ".csv");
        CsvWriter csvWriter = new CsvWriter("E:\\eclipse\\eclipse\\workspace\\algorithmweb\\src\\main\\webapp\\WEB-INF\\result\\" + filename + ".csv", c, charset);
        for (int i = 0; i < arry.length; i++) {
            csvWriter.writeRecord(arry[i]);
        }
        csvWriter.close();
    }


    public List<String> csvToListString() {

        List<String> result = new ArrayList<>();
        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(csvPath);
            while (csvReader.readRecord()){
                // 读取每一行数据，以逗号分开
                result.add(csvReader.getRawRecord());
            }
            csvReader.close();
            return result;

        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }
    }


}
