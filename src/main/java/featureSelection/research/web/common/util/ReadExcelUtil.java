package featureSelection.research.web.common.util;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import featureSelection.research.web.entity.execution.admin.ProduceProcedureSettingOptions;
import featureSelection.research.web.mybatisMapper.execution.admin.AlgorithmMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReadExcelUtil {
    @Autowired
    private AlgorithmMapper algorithmMapper;


    //读取excel文件，获取算法信息列表对象
    public List<Algorithm> readAlgorithmInfoByExcelFile(File excel){
        List<Algorithm> algorithms=new ArrayList<>();
        try {
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return null;
                }
                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+3;   //第一行添加算法的标题，第二行是算法信息的列名，所以从第三行开始读取数据
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        Algorithm algorithm=new Algorithm();
                        //封装单个算法信息的数组,数组的最大长度为16即可支持所有信息的添加
                        String [] algorithmInfo = new String[17];
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {

                                algorithmInfo[cIndex-1]=cell.toString();
                                System.out.println(cell.toString());
                            }
                        }
                        algorithm.setAlgorithmName(algorithmInfo[0]);
                        algorithm.setAlgorithmNameMapper(algorithmInfo[1]);
                        algorithm.setAlgorithmType(algorithmInfo[2]);
                        algorithm.setAlgorithmPaperLink(algorithmInfo[3]);
                        algorithm.setAlgorithmPaperReference(algorithmInfo[4]);
                        algorithm.setAlgorithmUsage(algorithmInfo[5]);
                        algorithm.setAlgorithmDescription(algorithmInfo[6]);
                        algorithm.setAlgorithmEnDescription(algorithmInfo[7]);
                        algorithm.setAlgorithmCallInterface(algorithmInfo[8]);
                        algorithm.setAlgorithmCallHost(algorithmInfo[9]);
                        algorithm.setAlgorithmCallPort(algorithmInfo[10]);
                        algorithm.setAlgorithmCallUsername(algorithmInfo[11]);
                        algorithm.setAlgorithmCallPassword(algorithmInfo[12]);
                        algorithm.setAlgorithmCallExchange(algorithmInfo[13]);
                        algorithm.setAlgorithmCallDemoRoutingkey(algorithmInfo[14]);
                        algorithm.setAlgorithmCallExecutionSendRoutingkey(algorithmInfo[15]);
                        algorithm.setAlgorithmCallExecutionConnectRoutingkey(algorithmInfo[16]);
                        algorithms.add(algorithm);
                }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return algorithms;
    }


    public List<ProcedureSettings> readProcedureSettingInfoByExcelFile(File excel) {
        List <ProcedureSettings> procedureSettings=new ArrayList<>();
        try {
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在
                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ( "xls".equals(split[1])){
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                }else if ("xlsx".equals(split[1])){
                    wb = new XSSFWorkbook(excel);
                }else {
                    System.out.println("文件类型错误!");
                    return null;
                }
                //开始解析
                Sheet sheet = wb.getSheetAt(2);     //读取sheet 3

                int firstRowIndex = sheet.getFirstRowNum()+3;   //第一行添加算法的标题，第二行是算法信息的列名，所以从第三行开始读取数据
                int lastRowIndex = sheet.getLastRowNum();
                System.out.println("firstRowIndex: "+firstRowIndex);
                System.out.println("lastRowIndex: "+lastRowIndex);
                List<ProcedureSettings> excelProcedureSettingList = new ArrayList<>();

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        ProcedureSettings procedureSetting=new ProcedureSettings();
                        //封装单个算法步骤信息的数组,数组的最大长度为8即可支持所有信息的添加
                        String [] procedureSettingsInfo = new String[9];
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                procedureSettingsInfo[cIndex]=cell.toString();
                                System.out.println(cell.toString());
                            }
                        }
                        System.out.println(procedureSettingsInfo);
                        //根据封装成的数组，给procedureSetting对象对应的属性赋值
                        int algorithmId=algorithmMapper.getAlgorithmIdByName(procedureSettingsInfo[1]);
                        procedureSetting.setAlgorithmId(algorithmId);
                        procedureSetting.setName(procedureSettingsInfo[2]);
                        procedureSetting.setNameMapper(procedureSettingsInfo[3]);
                        procedureSetting.setState(procedureSettingsInfo[4]);
                        procedureSetting.setOption(procedureSettingsInfo[5]);
                        procedureSetting.setOptionMapper(procedureSettingsInfo[6]);
                        procedureSetting.setDefaultOption(procedureSettingsInfo[7]);
                        procedureSetting.setDescription(procedureSettingsInfo[8]);
                        //将excel文件中每一行封装成procedureSetting对象，并且存入列表excelProcedureSettingList中。
                        excelProcedureSettingList.add(procedureSetting);

                        //将算法步骤对象ProcedureSetting添加至步骤对象列表procedureSettings中
//                        procedureSettings.add(procedureSetting);
                    }
                }
                List<ProduceProcedureSettingOptions> produceProcedureSettingOptionsList = new ArrayList<>();
                //遍历excelProcedureSettingList根据相同的算法Id 步骤名称,拼接获取options信息。
                for (int i=0;i<excelProcedureSettingList.size();i++){
                    //取出algorithmId,步骤名称，option封装成ProduceProcedureSettingOptions对象
                    ProduceProcedureSettingOptions produceProcedureSettingOptions=new ProduceProcedureSettingOptions();
                    produceProcedureSettingOptions.setAlgorithmId(excelProcedureSettingList.get(i).getAlgorithmId());
                    produceProcedureSettingOptions.setProcedureName(excelProcedureSettingList.get(i).getName());
                    produceProcedureSettingOptions.setProcedureOptions(excelProcedureSettingList.get(i).getOption());
                    //判断produceProcedureSettingOptionsList中是否已经存在算法Id、步骤名称为当前produceProcedureSettingOptions的对象
                    if (!produceProcedureSettingOptionsList.contains(produceProcedureSettingOptions)){
                        //如果存在 则跳过生成options的步骤，如果不存在则遍历调用生成options的方法
                        for (int j=i+1;j<excelProcedureSettingList.size();j++){
                            if (produceProcedureSettingOptions.getAlgorithmId() == excelProcedureSettingList.get(j).getAlgorithmId() &&
                                    produceProcedureSettingOptions.getProcedureName().equals(excelProcedureSettingList.get(j).getName())){
                                produceProcedureSettingOptions.setProcedureOptions(produceProcedureSettingOptions.getProcedureOptions()+
                                        ","+excelProcedureSettingList.get(j).getOption());
                            }
                        }
                        produceProcedureSettingOptionsList.add(produceProcedureSettingOptions);
                    }
                }
                //遍历produceProcedureSettingOptionsList,生成可以添加的procedureSetting对象
                for (ProduceProcedureSettingOptions produceProcedureSettingOptions:produceProcedureSettingOptionsList){
                    for (int i=0;i<excelProcedureSettingList.size();i++){
                        if (produceProcedureSettingOptions.getAlgorithmId() == excelProcedureSettingList.get(i).getAlgorithmId() &&
                             produceProcedureSettingOptions.getProcedureName().equals(excelProcedureSettingList.get(i).getName())){
                            excelProcedureSettingList.get(i).setOptions(produceProcedureSettingOptions.getProcedureOptions());
                            ProcedureSettings procedureSetting=excelProcedureSettingList.get(i);
                            procedureSettings.add(procedureSetting);
                            break;
                        }
                    }
                }


            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return procedureSettings;
    }


}

