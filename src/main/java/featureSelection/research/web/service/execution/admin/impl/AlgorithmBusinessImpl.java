package featureSelection.research.web.service.execution.admin.impl;

import featureSelection.research.web.entity.execution.admin.Algorithm;
import featureSelection.research.web.entity.execution.admin.Parameter;
import featureSelection.research.web.entity.execution.admin.ParameterInfo;
import featureSelection.research.web.entity.execution.admin.ProcedureSettings;
import featureSelection.research.web.mybatisMapper.execution.admin.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.AlgorithmParamMapper;
import featureSelection.research.web.mybatisMapper.execution.admin.ProcedureSettingsMapper;
import featureSelection.research.web.service.execution.admin.AlgorithmBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        for(int i=0;i<parameterNames.length;i++){
            Parameter parameter=new Parameter();
            parameter.setAlgorithmId(parameterInfo.getAlgorithmId());
            parameter.setParameterName(parameterInfo.getParameterNames()[i]);
            parameter.setParameterDescription(parameterInfo.getParameterDescriptions()[i]);
            parameter.setParameterDefaultValue(parameterInfo.getParameterDefaultValues()[i]);
            parameter.setParameterType(parameterInfo.getParameterTypes()[i]);
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

            String parameterSettingInfo="{\"type\":";
            if (parameterInfo.getParameterTypes()[i].equals("selection")){
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

                    }else{
                        parameterSettingInfo=parameterSettingInfo+"\""+firstParameterValue[j]+"\":{\"type\":\""+secondParameterType[j]+"\",\"options\":[";
                        String secondParameterValueString=secondParameterValue[j];
                        String[] secondParameterValueArr=secondParameterValueString.split(",");
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

                        }
                    }

                }
                //遍历完成 添加尾部
                parameterSettingInfo=parameterSettingInfo+"}}";

            }else if (parameterInfo.getParameterTypes()[i].equals("text")){
                parameterSettingInfo=parameterSettingInfo+"\"text\",\"options\":[],\"optionExtra\":null}";
            }else{
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



        }
    }

    @Override
    public List<Parameter> getParameters() {
        return algorithmParamMapper.getParameters();
    }

    @Override
    public void updateParameter(Parameter parameter) {
        algorithmParamMapper.updateParameter(parameter);
    }
}
