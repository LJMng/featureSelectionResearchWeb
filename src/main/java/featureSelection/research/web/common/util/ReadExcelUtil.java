package featureSelection.research.web.common.util;

import featureSelection.research.web.entity.execution.admin.*;
import featureSelection.research.web.mybatisMapper.execution.admin.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.WebAlgorithmMapper;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReadExcelUtil {
    @Autowired
    private AlgorithmMapper algorithmMapper;

    @Autowired
    private WebAlgorithmMapper webAlgorithmMapper;


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
//                System.out.println("firstRowIndex: "+firstRowIndex);
//                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
//                    System.out.println("rIndex: " + rIndex);
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
//                                System.out.println(cell.toString());
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
//                System.out.println("firstRowIndex: "+firstRowIndex);
//                System.out.println("lastRowIndex: "+lastRowIndex);
                List<ProcedureSettings> excelProcedureSettingList = new ArrayList<>();

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
//                    System.out.println("rIndex: " + rIndex);
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
//                                System.out.println(cell.toString());
                            }
                        }
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
                    //定义是否已经完成该options的拼接
                    boolean readerAdd = false;
                    for(ProduceProcedureSettingOptions ReaderProduceProcedureSettingOptions:produceProcedureSettingOptionsList){
                        if (produceProcedureSettingOptions.getProcedureName().equals(ReaderProduceProcedureSettingOptions.getProcedureName()) &&
                            produceProcedureSettingOptions.getAlgorithmId() == ReaderProduceProcedureSettingOptions.getAlgorithmId()){
                            readerAdd = true;
                        }
                    }
                    //判断produceProcedureSettingOptionsList中是否已经存在算法Id、步骤名称为当前produceProcedureSettingOptions的对象
                    if (!readerAdd){
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


    public Map<String,Object> readParameterInfoByExcelFile(File excel){
        Map<String,Object> algorithmInfoMapper = new HashMap<>();
        List<Parameter> parameters = new ArrayList<>();
        List<ParameterExcelRowObject> parameterExcelRowObjectList = new ArrayList<>();
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
                Sheet sheet = wb.getSheetAt(1);     //读取sheet 1

                int firstRowIndex = sheet.getFirstRowNum()+3;   //第一行添加算法的标题，第二行是算法信息的列名，所以从第三行开始读取数据
                int lastRowIndex = sheet.getLastRowNum();
//                System.out.println("firstRowIndex: "+firstRowIndex);
//                System.out.println("lastRowIndex: "+lastRowIndex);

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
//                    System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        ParameterExcelRowObject parameterExcelRowObject = new ParameterExcelRowObject();
                        //封装单个算法信息的数组,数组的最大长度为16即可支持所有信息的添加
                        String [] parameterExcelRowObjectArray = new String[11];
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell != null) {
                                parameterExcelRowObjectArray[cIndex-1]=cell.toString();
                            }
                        }
                        parameterExcelRowObject.setAlgorithmName(parameterExcelRowObjectArray[0]);
                        parameterExcelRowObject.setParameterName(parameterExcelRowObjectArray[1]);
                        parameterExcelRowObject.setParameterDescription(parameterExcelRowObjectArray[2]);
                        parameterExcelRowObject.setParameterDefaultValue(parameterExcelRowObjectArray[3]);
                        parameterExcelRowObject.setParameterNameMapper(parameterExcelRowObjectArray[4]);
                        parameterExcelRowObject.setParameterType(parameterExcelRowObjectArray[5]);
                        parameterExcelRowObject.setParameterValue(parameterExcelRowObjectArray[6]);
                        parameterExcelRowObject.setParameterExtraType(parameterExcelRowObjectArray[7]);
                        parameterExcelRowObject.setParameterExtraValue(parameterExcelRowObjectArray[8]);
                        parameterExcelRowObject.setParameterValueMapper(parameterExcelRowObjectArray[9]);
                        parameterExcelRowObject.setParameterExtraValueMapper(parameterExcelRowObjectArray[10]);
                        parameterExcelRowObjectList.add(parameterExcelRowObject);
                    }
                }
                //遍历parameterExcelRowObjectList,将算法名称，步骤名称一样的excelRow对象封装在一个数组中
                List<List<ParameterExcelRowObject>> allParameterInfo = new ArrayList<>();
                for (int i=0;i<parameterExcelRowObjectList.size();i++){
//                    System.out.println("运行次数"+i);
                    ParameterExcelRowObject parameterExcelRowObject = parameterExcelRowObjectList.get(i);
                    //遍历allParameterInfo 判断是否已经存在当前参数parameterExcelRowObject信息
                    boolean isExistParameterInfo = false;
                    for (List<ParameterExcelRowObject> parameterReaderExcelRowObjectList:allParameterInfo){
                        if (parameterReaderExcelRowObjectList.get(0).getAlgorithmName().equals(parameterExcelRowObject.getAlgorithmName()) &&
                                parameterReaderExcelRowObjectList.get(0).getParameterName().equals(parameterExcelRowObject.getParameterName())){
                            isExistParameterInfo = true;
                        }
                    }
                   //如果不存在 则向allParameterInfo 中加入parameterExcelRowObject信息
                    if (!isExistParameterInfo){
                        List<ParameterExcelRowObject> oneParameterInfo = new ArrayList<>();
                        oneParameterInfo.add(parameterExcelRowObjectList.get(i));
                        for (int j=i+1;j<parameterExcelRowObjectList.size();j++){
                            if (parameterExcelRowObjectList.get(i).getParameterName().equals(parameterExcelRowObjectList.get(j).getParameterName())
                                && parameterExcelRowObjectList.get(i).getAlgorithmName().equals(parameterExcelRowObjectList.get(j).getAlgorithmName())){
                                oneParameterInfo.add(parameterExcelRowObjectList.get(j));
                            }
                        }
                        allParameterInfo.add(oneParameterInfo);
                    }
                }
                //遍历allParameterInfo列表，获取每个oneParameterInfo信息，根据oneParameterInfo列表信息生成一个Parameter对象。
                for (List<ParameterExcelRowObject> oneParameterInfo:allParameterInfo){
                    //取出一个ParameterExcelRowObject,判断其参数类型，根据参数类型进行parameterSettingInfo的拼接
                    ParameterExcelRowObject parameterExcelRowObject = oneParameterInfo.get(0);
                    //参数类型为text时的情况
                    if (parameterExcelRowObject.getParameterType().equals("text")){
                        String parameterSettingInfo = "{\"type\":\"text\",\"options\":[],\"optionExtra\":null}";
                        Parameter parameter = new Parameter();
                        int algorithmId = algorithmMapper.getAlgorithmIdByName(parameterExcelRowObject.getAlgorithmName());
                        parameter.setAlgorithmId(algorithmId);
                        parameter.setParameterName(parameterExcelRowObject.getParameterName());
                        parameter.setParameterNameMapper(parameterExcelRowObject.getParameterNameMapper());
                        parameter.setParameterDefaultValue(parameterExcelRowObject.getParameterDefaultValue());
                        parameter.setParameterType(parameterExcelRowObject.getParameterType());
                        parameter.setParameterDescription(parameterExcelRowObject.getParameterDescription());
                        parameter.setParameterSettingInfo(parameterSettingInfo);
                        //将parameter信息添加至要返回的parameters列表中
                        parameters.add(parameter);
                    }
                    //参数类型为selection时的情况
                    else if (parameterExcelRowObject.getParameterType().equals("selection")){
                        //生成parameterSettingInfo 的头部信息
                        String parameterSettingInfo = "{\"type\":\"selection\",\"options\":[";
                        //遍历oneParameterInfo 生成options数组信息
                        String options=produceOptions(oneParameterInfo);
                        //拼接上options部分的parameterSettingInfo信息
                        parameterSettingInfo = parameterSettingInfo + options + "],\"optionExtra\":{";
                        //定义一个字符串，用于存贮optionExtra对象的内容
                        String optionExtraInfo="";
                        //遍历oneParameterInfo列表,将参数值相当的ParameterExcelObject对象封装在一个列表对象中
                        List<List<ParameterExcelRowObject>> allOptionExtraInfoObject = new ArrayList<>();
                        for (int i=0;i<oneParameterInfo.size();i++){
                            //获取当前遍历的ParameterExcelRowObject对象
                            ParameterExcelRowObject currParameterExcelRowObject = oneParameterInfo.get(i);
                            boolean isExist = false;
                            //遍历查看allOptionExtraInfoObject中是否存在值与produceOptionExtraInfoExcelObject相同的对象
                            for (List<ParameterExcelRowObject> checkOneOptionExtraInfoObject:allOptionExtraInfoObject){
                                if (checkOneOptionExtraInfoObject.get(0).getParameterValue()
                                        .equals(currParameterExcelRowObject.getParameterValue())){
                                    isExist = true;
                                }
                            }
                            //如果没有存在，则遍历oneParameterInfo中ParameterValue相同的对象添加至allOptionExtraInfoObject中
                            if (! isExist){
                                List<ParameterExcelRowObject> oneOptionExtraInfoObject = new ArrayList<>();
                                oneOptionExtraInfoObject.add(currParameterExcelRowObject);
                                for (int j=i+1;j<oneParameterInfo.size();j++){
                                    //如果参数值相同的话则添加至oneOptionExtraInfoObject列表中
                                    if (oneParameterInfo.get(j).getParameterValue().
                                            equals(currParameterExcelRowObject.getParameterValue())){
                                        oneOptionExtraInfoObject.add(oneParameterInfo.get(j));
                                    }
                                }
                                allOptionExtraInfoObject.add(oneOptionExtraInfoObject);
                            }
                        }
                        String extraInfo="";
                        String selectionExtraOption="";
                        //遍历allOptionExtraInfoObject列表,生成Extra信息
                        for (List<ParameterExcelRowObject> oneOptionExtraInfoObject:allOptionExtraInfoObject){
                            String extraOption = "";
                            //遍历oneOptionExtraInfoObject列表信息,获取单个值对应的Extra信息
                            for (ParameterExcelRowObject produceExtra:oneOptionExtraInfoObject){
                                //判断produceExtra中Extra的类型
                                //第二个Extra类型为null的情况
                                if (produceExtra.getParameterExtraType().equals("null")){
                                    //如果当前的Extra信息不是最后一个
                                    if (allOptionExtraInfoObject.indexOf(oneOptionExtraInfoObject) != allOptionExtraInfoObject.size()-1){
                                        extraInfo =extraInfo+"\""+ produceExtra.getParameterValue() + "\":null,";
                                    }else{
                                        extraInfo =extraInfo+"\""+ produceExtra.getParameterValue() + "\":null";
                                    }
                                }
                                //第二个Extra类型为为text的情况
                                else if (produceExtra.getParameterExtraType().equals("text")){
                                    //如果是最后一个
                                    if (allOptionExtraInfoObject.indexOf(oneOptionExtraInfoObject) == allOptionExtraInfoObject.size()-1){
                                        extraInfo = extraInfo + "\"" + produceExtra.getParameterValue() + "\":{\"type\":\"text\",\"options\":[]}";
                                    }else {
                                        extraInfo = extraInfo + "\"" + produceExtra.getParameterValue() + "\":{\"type\":\"text\",\"options\":[]},";
                                    }
                                }
                                //第二个Extra类型为selection
                                else{
                                    //生成extraOption信息
                                    extraOption = extraOption + "\""+produceExtra.getParameterExtraValue()+"\"";
                                   //如果不是最后一个
                                   if (oneOptionExtraInfoObject.indexOf(produceExtra) !=oneOptionExtraInfoObject.size()-1){
                                       extraOption = extraOption + ",";
                                   }
                                   //如果为最后一个，根据extraOption拼接extraInfo信息
                                   else {
                                       //如果当前的Extra信息不是最后一个
                                       if (allOptionExtraInfoObject.indexOf(oneOptionExtraInfoObject) != allOptionExtraInfoObject.size()-1){
                                           extraInfo = extraInfo + "\"" + produceExtra.getParameterValue() + "\":{\"type\":\"selection\",\"options\":["+extraOption+"]},";
                                       }
                                       //如果最后一个，则直接拼接
                                       else{
                                           extraInfo = extraInfo + "\"" + produceExtra.getParameterValue() + "\":{\"type\":\"selection\",\"options\":["+extraOption+"]}";
                                       }

                                   }

                                }
                            }
                        }
                        parameterSettingInfo = parameterSettingInfo + extraInfo + "}}";
                        Parameter parameter = new Parameter();
                        int algorithmId = algorithmMapper.getAlgorithmIdByName(parameterExcelRowObject.getAlgorithmName());
                        parameter.setAlgorithmId(algorithmId);
                        parameter.setParameterName(parameterExcelRowObject.getParameterName());
                        parameter.setParameterNameMapper(parameterExcelRowObject.getParameterNameMapper());
                        parameter.setParameterDefaultValue(parameterExcelRowObject.getParameterDefaultValue());
                        parameter.setParameterType(parameterExcelRowObject.getParameterType());
                        parameter.setParameterDescription(parameterExcelRowObject.getParameterDescription());
                        parameter.setParameterSettingInfo(parameterSettingInfo);
                        //将parameter信息添加至要返回的parameters列表中
                        parameters.add(parameter);

                    }
                    //参数类型为radio、checkbox的情况
                    else{
                        //生成parameterSettingInfo的头部信息
                        String parameterSettingInfo = "{\"type\":\"";
                        parameterSettingInfo = parameterSettingInfo + parameterExcelRowObject.getParameterType() + "\",\"options\":[";
                        //遍历oneParameterInfo 生成option数组信息
                        String options=produceOptions(oneParameterInfo);
                        //根据options生成实际的parameterSettingInfo
                        parameterSettingInfo = parameterSettingInfo + options + "],\"optionExtra\":null}";
                        Parameter parameter = new Parameter();
                        int algorithmId = algorithmMapper.getAlgorithmIdByName(parameterExcelRowObject.getAlgorithmName());
                        parameter.setAlgorithmId(algorithmId);
                        parameter.setParameterName(parameterExcelRowObject.getParameterName());
                        parameter.setParameterNameMapper(parameterExcelRowObject.getParameterNameMapper());
                        parameter.setParameterDefaultValue(parameterExcelRowObject.getParameterDefaultValue());
                        parameter.setParameterType(parameterExcelRowObject.getParameterType());
                        parameter.setParameterDescription(parameterExcelRowObject.getParameterDescription());
                        parameter.setParameterSettingInfo(parameterSettingInfo);
                        //将parameter信息添加至要返回的parameters列表中
                        parameters.add(parameter);
                    }

                }
                //调用添加参数映射值关系的方法，添加映射关系
//                addParameterMapper(parameterExcelRowObjectList);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        algorithmInfoMapper.put("parameters",parameters);
        algorithmInfoMapper.put("parameterExcelRowObjectList",parameterExcelRowObjectList);
        algorithmInfoMapper.get("parameters");
        return algorithmInfoMapper;
    }

    //遍历oneParameterInfo信息生成options
    public static String produceOptions(List<ParameterExcelRowObject> oneParameterInfo){
        List<String> firstValueList= new ArrayList<>();
        String options="";
        firstValueList.add(oneParameterInfo.get(0).getParameterValue());
        for (int i=0;i<oneParameterInfo.size();i++){
            boolean isContent = false;
            //取出当前ExcelObject对象
            ParameterExcelRowObject currExcelRowObject=oneParameterInfo.get(i);
            for (int j=0;j<firstValueList.size();j++) {
                if (currExcelRowObject.getParameterValue().equals(firstValueList.get(j))) {
                    isContent = true;
                }
            }
                if ( !isContent){
                    firstValueList.add(currExcelRowObject.getParameterValue());
                }

        }
        for (String firstValue : firstValueList){
            options = options+ "\""+firstValue+"\"";
            //获取当前ParameterExcelRowObject 对象的索引下标
            int index=firstValueList.indexOf(firstValue);
            //如果当前下标不是最后一个,则需要添加”,“
            if (index != firstValueList.size()-1){
                options = options+",";
            }
        }
        return options;
    }

    //遍历所有的excelRow对象，生成
    public void addParameterMapper(List<ParameterExcelRowObject> parameterExcelRowObjectList){
        //遍历parameterExcelRowObject 生成算法参数映射值列表
        List<WebAlgorithmMapperEntity> webAlgorithmMapperEntityList = new ArrayList<>();
        for (ParameterExcelRowObject parameterExcelRowObject:parameterExcelRowObjectList){
            WebAlgorithmMapperEntity webAlgorithmMapperEntity = new WebAlgorithmMapperEntity();
            webAlgorithmMapperEntity.setAlgorithmId(algorithmMapper.getAlgorithmIdByName(parameterExcelRowObject.getAlgorithmName()));
            webAlgorithmMapperEntity.setParameterId(algorithmMapper.getParameterIdByName(parameterExcelRowObject.getParameterName()));
            webAlgorithmMapperEntity.setWebKey(parameterExcelRowObject.getParameterValue());
            webAlgorithmMapperEntity.setAlgorithmValue(parameterExcelRowObject.getParameterValueMapper());
            webAlgorithmMapperEntityList.add(webAlgorithmMapperEntity);
            //判断第二个值是否为null,如果不为null则添加第二个值的信息
            if (parameterExcelRowObject.getParameterExtraValue() != null){
                WebAlgorithmMapperEntity webAlgorithmMapperEntityAddExtraValue = new WebAlgorithmMapperEntity();
                webAlgorithmMapperEntityAddExtraValue.setAlgorithmId(algorithmMapper.getAlgorithmIdByName(parameterExcelRowObject.getAlgorithmName()));
                webAlgorithmMapperEntityAddExtraValue.setParameterId(algorithmMapper.getParameterIdByName(parameterExcelRowObject.getParameterName()));
                webAlgorithmMapperEntityAddExtraValue.setWebKey(parameterExcelRowObject.getParameterValue()+"_"+parameterExcelRowObject.getParameterExtraValue());
                webAlgorithmMapperEntityAddExtraValue.setAlgorithmValue(parameterExcelRowObject.getParameterExtraValueMapper());
                webAlgorithmMapperEntityList.add(webAlgorithmMapperEntityAddExtraValue);
            }

        }
        List<WebAlgorithmMapperEntity> addAlgorithmValueList = new ArrayList<>();

        //遍历刚生成的webAlgorithmMapperEntityList,生成信的无重复的webAlgorithmMapperEntityList
        for (WebAlgorithmMapperEntity webAlgorithmMapperEntity:webAlgorithmMapperEntityList){
            WebAlgorithmMapperEntity addAlgorithmValueMapper = webAlgorithmMapperEntity;
            //遍历addValue列表，如果web_key algorithmId parameterId都相同则不添加
            boolean isContain=false;
            for (WebAlgorithmMapperEntity currentMapper:addAlgorithmValueList){
                if (currentMapper.getAlgorithmId() == addAlgorithmValueMapper.getAlgorithmId() &&
                    currentMapper.getParameterId() == addAlgorithmValueMapper.getParameterId() &&
                    currentMapper.getAlgorithmValue().equals(addAlgorithmValueMapper.getAlgorithmValue())){
                    isContain = true;
                }
                if (! isContain){
                    addAlgorithmValueList.add(addAlgorithmValueMapper);
                }
            }
        }
//        System.out.println(webAlgorithmMapperEntityList);
        //遍历webAlgorithmEntityList,添加参数值映射信息
        for (WebAlgorithmMapperEntity webAlgorithmMapperEntity:addAlgorithmValueList){
            webAlgorithmMapper.insertParameterAlgorithmValue(webAlgorithmMapperEntity);
        }

    }
}

