package featureSelection.research.web.service.execution.admin.impl;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.AlgorithmMapperValueUtil;
import featureSelection.research.web.common.util.FileUtil;
import featureSelection.research.web.common.util.ReadExcelUtil;
import featureSelection.research.web.entity.demo.admin.AlgorithmParameterDemoAdmin;
import featureSelection.research.web.entity.execution.admin.*;
import featureSelection.research.web.mybatisMapper.demo.admin.AlgorithmInfoDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.demo.admin.SchemeDemoAdminMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.*;
import featureSelection.research.web.service.demo.admin.SchemeService;
import featureSelection.research.web.service.execution.admin.AlgorithmBusiness;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class AlgorithmBusinessImpl implements AlgorithmBusiness {
    @Autowired
    private AlgorithmParamMapper algorithmParamMapper;
    @Autowired
    private ProcedureSettingsMapper procedureSettingsMapper;
    @Autowired
    private AlgorithmMapper algorithmMapper;
    @Autowired
    private WebAlgorithmMapper webAlgorithmMapper;
    @Autowired
    private SchemeDemoAdminMapper schemeDemoAdminMapper;
    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private ReadExcelUtil readExcelUtil;
    //注入添加算法的AlgorithmInfoDemoAdminMapper接口
    @Autowired
    private AlgorithmInfoDemoAdminMapper algorithmInfoDemoAdminMapper;

    @Override
    public void createParamSettingInfo(Map<Integer, String> algorithmMap) {
        for (Map.Entry<Integer, String> algorithmParam : algorithmMap.entrySet()) {
            int algorithmId=algorithmParam.getKey();
            String parameterSettingInfo=algorithmParam.getValue();
            algorithmParamMapper.createParamSettingInfo(algorithmId,parameterSettingInfo);
            System.out.println("Key = " + algorithmParam.getKey() + ", Value = " + algorithmParam.getValue());

        }

    }

    @Override
    public void addProcedureSettings(ProcedureSettings procedureSettings) {
        procedureSettingsMapper.addProcedureSetting(procedureSettings);
        String optionsString=procedureSettings.getOptions();
        String [] optionsArr=optionsString.split(",");
        String optionsMapperString=procedureSettings.getOptionsMapper();
        String[] optionsMapperArr=optionsMapperString.split(",");
        int algorithmId=procedureSettings.getAlgorithmId();
        int procedureSettingId=procedureSettingsMapper.getMaxProcedureSettingId();
        for (int i=0;i<optionsMapperArr.length;i++){
            WebAlgorithmMapperEntity webAlgorithmMapperEntity=new WebAlgorithmMapperEntity();
            webAlgorithmMapperEntity.setAlgorithmId(algorithmId);
            webAlgorithmMapperEntity.setProcedureSettingId(procedureSettingId);
            webAlgorithmMapperEntity.setWebKey(optionsArr[i]);
            webAlgorithmMapperEntity.setAlgorithmValue(optionsMapperArr[i]);
            //向web_algorithm_mapper表中插入参数值对应的算法映射值
            webAlgorithmMapper.insertProcedureAlgorithmOption(webAlgorithmMapperEntity);
        }

    }

    @Override
    public List<ProcedureSettings> findAllProcedureSettings() {
        List<ProcedureSettings> allProcedureSetting = procedureSettingsMapper.findAllProcedureSetting();
        return allProcedureSetting;
    }

    @Override
    public void updateProcedureSettings(ProcedureSettings procedureSettings) {
        procedureSettingsMapper.updateProcedureSetting(procedureSettings);
    }

    @Override
    public List<Algorithm> getAlgorithms() {
        return algorithmMapper.getAlgorithms();
    }

    @Override
    public void createParameters(ParameterInfo parameterInfo) {
        //遍历parameterInfo里面的一个数组 封装成parameter对象
        String[] parameterNames=parameterInfo.getParameterNames();
        //存放算法id
        int algorithmId=parameterInfo.getAlgorithmId();
        for(int i=0;i<parameterNames.length;i++){
            //定义一个存放映射值插入对象的列表
            List<WebAlgorithmMapperEntity> webAlgorithmMapperEntityList=new ArrayList<>();
            //参数Id
//            int parameterId;
//            if(algorithmParamMapper.getMaxParameterId() == null){
//                parameterId=1;
//            }else{
//                parameterId=algorithmParamMapper.getMaxParameterId()+1;
//            }
            Parameter parameter=new Parameter();
            parameter.setAlgorithmId(parameterInfo.getAlgorithmId());
            parameter.setParameterName(parameterInfo.getParameterNames()[i]);
            parameter.setParameterDescription(parameterInfo.getParameterDescriptions()[i]);
            parameter.setParameterDefaultValue(parameterInfo.getParameterDefaultValues()[i]);
            parameter.setParameterType(parameterInfo.getParameterTypes()[i]);
            parameter.setParameterNameMapper(parameterInfo.getParameterNamesMapper()[i]);
            /*
            设置三个数组：第一个参数值，第二个参数类型，第二个参数值
            1.判断参数类型是否为selection
            2.如果不是 parameterSettingInfo 设置对应的type,options属性，同时optionExtra赋值为空
            3.如果是  遍历secondParameterValue数组，取出每种第一个值的具体情况对位Key,取出secondParameterValue数组
              secondParameterValue中对应的值，拼接成json字符串
             */
//            String[] firstParameterValue=parameterInfo.getFirstParameterVales()[i];
//            String[] secondParameterType=parameterInfo.getSecondParameterTypes()[i];
//            String[] secondParameterValue=parameterInfo.getSecondParameterValues()[i];
            //取出算法层对应参数值的数组


            String parameterSettingInfo="{\"type\":";
            if (parameterInfo.getParameterTypes()[i].equals("selection")){
                String [] firstAlgorithmParameterValue=parameterInfo.getFirstAlgorithmParameterValues()[i];
                String [] secondAlgorithmParameterValue=parameterInfo.getSecondAlgorithmParameterValues()[i];
                String[] firstParameterValue=parameterInfo.getFirstParameterVales()[i];
                String[] secondParameterType=parameterInfo.getSecondParameterTypes()[i];
                String[] secondParameterValue=parameterInfo.getSecondParameterValues()[i];
                //开始的头部
                parameterSettingInfo=parameterSettingInfo+"\""+parameterInfo.getParameterTypes()[i]+"\",\"options\":[";
                //                遍历第一个值，取出对应的值
                for(int l=0;l<firstParameterValue.length;l++){
                    //如果为最后一个值
                    if (l==firstParameterValue.length-1){
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[l]+"\"],"+"\"optionExtra\":{";
                    }
                    //其他情况
                    else{
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[l]+"\",";
                    }
                    /*
                    将第一个算法参数值
                    1.取出web层的算法参数值作为key,算法层的算法值作为value
                    2.通过key,查询算法参数映射表中，是否存在该映射关系
                    3.如果存在，则不添加
                    4.如果不存在，则调用算法参数映射的Mapper,将参数添加入算法映射表
                     */
                    String webKey=firstParameterValue[l];
                    String algorithmValue=firstAlgorithmParameterValue[l];
                    WebAlgorithmMapperEntity webAlgorithmMapperEntity=new WebAlgorithmMapperEntity();
                    webAlgorithmMapperEntity.setAlgorithmId(algorithmId);
                    webAlgorithmMapperEntity.setWebKey(webKey);
                    webAlgorithmMapperEntity.setAlgorithmValue(algorithmValue);
                    webAlgorithmMapperEntityList.add(webAlgorithmMapperEntity);


                }
                for(int j=0;j<secondParameterType.length;j++){
                    //遍历到第二个值开始
                    //判断第二个值的类型,如果为text,则直接添加第二个值的信息
                    if (secondParameterType[j].equals("text")){
                        //如果为最后一个
                        if (j==secondParameterType.length-1){
                            parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":{\"type\":\""+secondParameterType[j]+"\",\"options\":[]}";
                        }else{
                            parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":{\"type\":\""+secondParameterType[j]+"\",\"options\":[]},";
                        }

                    } else if (secondParameterType[j].equals("null")){
                        //如果为最后一个
                        if (j==secondParameterType.length-1){
                            parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":null";
                        }else{
                            parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":null,";
                        }
                    }else{
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":{\"type\":\""+secondParameterType[j]+"\",\"options\":[";
                        String secondParameterValueString=secondParameterValue[j];
                        String[] secondParameterValueArr=secondParameterValueString.split(",");
                        String secondAlgorithmParameterString=secondAlgorithmParameterValue[j];
                        String [] secondAlgorithmParameterArr=secondAlgorithmParameterString.split(",");
                        //遍历第二个值
                        for (int k=0;k<secondParameterValueArr.length;k++){
                            if (k==secondParameterValueArr.length-1 && j==firstParameterValue.length-1){
                                parameterSettingInfo=parameterSettingInfo+"\""+secondParameterValueArr[k]+"\"]}";
                            }else if(k==secondParameterValueArr.length-1){
                                parameterSettingInfo=parameterSettingInfo+"\""+secondParameterValueArr[k]+"\"]},";
                            }
                            else{
                                parameterSettingInfo=parameterSettingInfo+"\""+secondParameterValueArr[k]+"\",";
                            }
                            /*
                            插入第二个值：
                            1.获取parameter_value_map的key和value
                            2.key为第一个web参数值与第二个web参数值的字符串拼接格式为：第一个web参数值+"_"+第二个web参数值
                            3.判断parameter_value_map是否已经存贮该key对应的value
                            4.如果存在，则不添加
                            5.如果存在，则调用算法参数映射的Mapper,将参数添加入算法映射表
                             */
                            String webKey=firstParameterValue[j]+"_"+secondParameterValueArr[k];
                            String algorithmValue=secondAlgorithmParameterArr[k];
                            WebAlgorithmMapperEntity webAlgorithmMapperEntity=new WebAlgorithmMapperEntity();
                            webAlgorithmMapperEntity.setAlgorithmId(algorithmId);
                            webAlgorithmMapperEntity.setWebKey(webKey);
                            webAlgorithmMapperEntity.setAlgorithmValue(algorithmValue);
                            webAlgorithmMapperEntityList.add(webAlgorithmMapperEntity);

                        }
                    }

                }
                //遍历完成 添加尾部
                parameterSettingInfo=parameterSettingInfo+"}}";

            }else if (parameterInfo.getParameterTypes()[i].equals("text")){
                parameterSettingInfo=parameterSettingInfo+"\"text\",\"options\":[],\"optionExtra\":null}";
            }else{
                String [] firstAlgorithmParameterValue=parameterInfo.getFirstAlgorithmParameterValues()[i];
                String[] firstParameterValue=parameterInfo.getFirstParameterVales()[i];
                parameterSettingInfo=parameterSettingInfo+"\""+parameterInfo.getParameterTypes()[i]+"\",\"options\":[";
//                遍历第一个值，取出对应的值
                for(int l=0;l<firstParameterValue.length;l++){
                    //如果为最后一个值
                    if (l==firstParameterValue.length-1){
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[l]+"\"],";
                    }
                    //其他情况
                    else{
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[l]+"\",";
                    }
                    String webKey=firstParameterValue[l];
                    String algorithmValue=firstAlgorithmParameterValue[l];
                    WebAlgorithmMapperEntity webAlgorithmMapperEntity=new WebAlgorithmMapperEntity();
                    webAlgorithmMapperEntity.setAlgorithmId(algorithmId);
                    webAlgorithmMapperEntity.setWebKey(webKey);
                    webAlgorithmMapperEntity.setAlgorithmValue(algorithmValue);
                    webAlgorithmMapperEntityList.add(webAlgorithmMapperEntity);

                }
                //添加尾部信息
                parameterSettingInfo=parameterSettingInfo+"\"optionExtra\":null}";
            }

            parameter.setParameterSettingInfo(parameterSettingInfo);


//            String parameterSettingInfoType=parameterInfo.getParameterSettingInfoTypes()[i];
//            //获取取值数组的字符串
//            String parameterSettingInfoValue=parameterInfo.getParameterSettingInfoValues()[i];
//            String values[]=parameterSettingInfoValue.split(",");
//
//            String parameterSettingInfo="{\"type\":\"";// '{"type":"'
//            parameterSettingInfo=parameterSettingInfo+parameterSettingInfoType+"\",\"options\":[\"";
//            //遍历values数组，取值设置parameterSettingInfo
//            for (int j=0;j<values.length;j++){
//                if (j==values.length-1){
//                    parameterSettingInfo=parameterSettingInfo+values[j]+"\"]}";
//                }else{
//                    parameterSettingInfo=parameterSettingInfo+values[j]+"\",\"";
//                }
//            }
            parameter.setParameterSettingInfo(parameterSettingInfo);
            algorithmMapper.createParameter(parameter);


            //给参数方案表添加参数
            List<Integer> list = schemeDemoAdminMapper.findTheChangedSchemeAffectedByParameter(parameter.getAlgorithmId());
            AlgorithmParameterDemoAdmin a = new AlgorithmParameterDemoAdmin();
            for(int j=0;j<list.size();j++){
                a.setSchemeId(list.get(j));
                schemeDemoAdminMapper.insertSchemeParameterValueAfterDelete(a);
            }


            int parameterId=algorithmParamMapper.getMaxParameterId();
            for (WebAlgorithmMapperEntity webAlgorithmMapperEntity:webAlgorithmMapperEntityList){
                webAlgorithmMapperEntity.setParameterId(parameterId);
                webAlgorithmMapper.insertParameterAlgorithmValue(webAlgorithmMapperEntity);
            }



        }
    }

    @Override
    public List<Parameter> getParameters() {
        List<Parameter> list = algorithmParamMapper.getParameters();//存放每个参数
        for (Parameter p : list){
            String tmpStr = p.getParameterSettingInfo();//获取第i个参数的settingInfo
            JSONObject obj = (JSONObject) JSONObject.parse(tmpStr);
            //若settingInfo无值，即为text类型，直接跳过
            if(obj.get("options").toString().equals("[]")){
                continue;
            }
            //去除options对应的值的[]以及所有"方便存取
            String str[] = obj.get("options").toString().replace("[","").replace("]","").replaceAll("\"","").split(",");
            List<String> pav = new LinkedList<>();//存放第i个参数的options对应的算法层的值
            for(int i = 0; i < str.length; i++){
                tmpStr = webAlgorithmMapper.getParameterValue(p.getAlgorithmId(),p.getParameterId(),str[i]);
                pav.add("\""+tmpStr+"\"");//将数据规范为["a","b",...]类型
            }
            obj.put("parameterAlgorithmValue",pav);
            p.setParameterAlgorithmValue(obj.get("parameterAlgorithmValue").toString());
        }
        return list;
    }

    @Override
    public void updateParameter(Parameter parameter) {
        algorithmParamMapper.updateParameter(parameter);
    }

    @Override
    public void deleteParameter(int parameterId) {
        algorithmParamMapper.deleteParameter(parameterId);
    }

    @Override
    public void deleteProcedureSetting(int id) {
        procedureSettingsMapper.deleteProcedureSetting(id);
    }

    @Override
    public void setAvailableDataset4Algorithm(AvailableDataset4Algorithm availableDataset4Algorithm) {
        algorithmMapper.setAvailableDataset4Algorithm(availableDataset4Algorithm);
    }

    /**
     *
     * @param excel
     * @throws Exception
     */
    @Override
    @Transactional
    public void addAlgorithmInfoByExcelFile(MultipartFile excel) throws Exception {
        //获取excel文件对象,MultipartFile转化为普通的io文件对象File
        File algorithmInfoExcel=fileUtil.multipartFileToFile(excel);
        //根据上传的excel对象获取sheet0中的算法信息列表
        List<Algorithm> algorithms=readExcelUtil.readAlgorithmInfoByExcelFile(algorithmInfoExcel);
        //遍历算法信息列表，添加算法信息
        for (Algorithm algorithm:algorithms){
            //添加算法的算法，调用到了demo管理系统中的AlgorithmInfoDemoAdminMapper接口
            algorithmInfoDemoAdminMapper.insertAlgorithmInfoDemoAdmin(algorithm);
        }
        List<ProcedureSettings> procedureSettings=readExcelUtil.readProcedureSettingInfoByExcelFile(algorithmInfoExcel);
        //遍历步骤列表，添加步骤信息
        for(ProcedureSettings procedureSetting:procedureSettings){
            procedureSettingsMapper.addProcedureSetting(procedureSetting);
        }
        //遍历算法参数列表，添加参数信息
        Map<String,Object> algorithmInfoMapper = readExcelUtil.readParameterInfoByExcelFile(algorithmInfoExcel);

        List<Parameter> parameters= (List<Parameter>) algorithmInfoMapper.get("parameters");
        List<ParameterExcelRowObject> parameterExcelRowObjectList= (List<ParameterExcelRowObject>) algorithmInfoMapper.get("parameterExcelRowObjectList");
        for (Parameter parameter:parameters){
            algorithmMapper.createParameter(parameter);
        }
        //添加映射值内容
        readExcelUtil.addParameterMapper(parameterExcelRowObjectList);

    }
}
