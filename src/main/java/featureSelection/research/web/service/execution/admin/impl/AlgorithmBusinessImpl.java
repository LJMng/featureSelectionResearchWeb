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
            //获取默认的input值
            String InputDefaultValue=parameterInfo.getParameterInputDefaultValues()[i];
            //获取默认的option值
            String OptionDefaultValue=parameterInfo.getParameterOptionDefaultValues()[i];
            parameter.setParameterDefaultValue(InputDefaultValue+","+OptionDefaultValue);
            parameter.setParameterType(parameterInfo.getParameterTypes()[i]);
            String parameterSettingInfoType=parameterInfo.getParameterSettingInfoTypes()[i];
            //获取取值数组的字符串
            String parameterSettingInfoValue=parameterInfo.getParameterSettingInfoValues()[i];
            String values[]=parameterSettingInfoValue.split(",");

            String parameterSettingInfo="{\"type\":\"";// '{"type":"'
            parameterSettingInfo=parameterSettingInfo+parameterSettingInfoType+"\",\"options\":[\"";
            //遍历values数组，取值设置parameterSettingInfo
            for (int j=0;j<values.length;j++){
                if (j==values.length-1){
                    parameterSettingInfo=parameterSettingInfo+values[j]+"\"]}";
                }else{
                    parameterSettingInfo=parameterSettingInfo+values[j]+"\",\"";
                }
            }
            parameter.setParameterSettingInfo(parameterSettingInfo);
            algorithmMapper.createParameter(parameter);



        }
    }
}
