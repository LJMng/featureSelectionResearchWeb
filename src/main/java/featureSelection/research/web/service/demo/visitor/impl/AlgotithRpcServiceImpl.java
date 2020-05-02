package featureSelection.research.web.service.demo.visitor.impl;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.ParameterScheme;
import featureSelection.research.web.entity.demo.visitor.ParameterSchemeValue;
import featureSelection.research.web.entity.communicationJson.AlgorithmCallTaskInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmSetting;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ParameterSchemeMapper;
import featureSelection.research.web.service.demo.visitor.AlgotithRpcService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : AlgotithRpcServiceimp
 * @Description : 算法远程调用服务
 * @Author : WDD
 * @Date: 2020-04-12 20:09
 */
@Service
public class AlgotithRpcServiceImpl implements AlgotithRpcService {
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    AlgorithmMapper algorithmMapper;
    @Autowired
    ParameterSchemeMapper parameterSchemeMapper;

    /**
     *根据算法id，方案id封装算法参数设置信息，通过rabbitmq的rpc模式发送至算法服务端，并接收返回的算法处理结果
     * @param  algorithmid:算法id
     * @param  schemeid：方案id
     * @return 算法处理结果
     */
    @Override
    public Object send(int algorithmid, int schemeid) {
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmid);
        String Routingkey = algorithm.getAlgorithmCallInterface();
        JSONObject data = getTransferData(algorithm.getAlgorithmName(), schemeid);
        Object response = rabbitTemplate.convertSendAndReceive("tut.rpc", "rpc", data);
        System.out.println(response.toString());
        return response;
    }


    /**
     * 对算法设置进行封装的类
     * @param algorithmName 算法名称
     * @param schemeid  参数方案id
     * @return 发送给算法服务器的Json对象
     */
    @Override
    public JSONObject getTransferData(String algorithmName, int schemeid) {
        //获取方案信息
        ParameterScheme parameterScheme = parameterSchemeMapper.getSchemeWithParameterValueAndDatasetById(1);
        //定义算法调用任务信息实体类
        AlgorithmCallTaskInfo algorithmCallServiceInfo = new AlgorithmCallTaskInfo();
        //定义算法主体信息实体类
        AlgorithmInfo algorithmInfo = new AlgorithmInfo();
        //定义算法设置类
        AlgorithmSetting algorithmSetting = new AlgorithmSetting();
        //算法基础设置
        Map<String, Map<String, Object>> basicSettings = new HashMap<>();
        //获取参数设置
        List<ParameterSchemeValue> parameterSchemeValues = parameterScheme.getParameterSchemeValues();
        //放入参数值
        for (ParameterSchemeValue parameterSchemeValue : parameterSchemeValues) {
            //算法基础设置取值
            Map<String, Object> basicSettingValue = new HashMap<>();
            basicSettingValue.put("input", null);
            basicSettingValue.put("option", null);
            //判断参数类型
            if (parameterSchemeValue.getParameter().getParameterType().equals("option")) {
                basicSettingValue.replace("option", parameterSchemeValue.getParameterValue());
                basicSettingValue.replace("input", null);
                basicSettings.put(parameterSchemeValue.getParameter().getParameterName(),
                        basicSettingValue);
            } else {
                basicSettingValue.replace("option", null);
                basicSettingValue.replace("input", parameterSchemeValue.getParameterValue());
                basicSettings.put(parameterSchemeValue.getParameter().getParameterName(),
                        basicSettingValue);
            }
        }
        //算法基础设置放入算法设置实体
        algorithmSetting.setBasic(basicSettings);
        //算法设置放入算法主体信息实体
        algorithmInfo.setSetting(algorithmSetting);
        //算法主体信息实体放进算法调用任务信息实体类
        algorithmCallServiceInfo.setAlgorithmInfo(algorithmInfo);
        //设置数据集名称
        algorithmCallServiceInfo.setDatasetName(parameterScheme.getDataset().getDatasetName());
        //设置数据集维度
        algorithmCallServiceInfo.setColumn(parameterScheme.getDataset().getDatasetDimension());
        // 当前时间戳
        Long startTs = System.currentTimeMillis();
        //设置算法调用任务信息id
        String taskId=algorithmName+startTs;
        algorithmCallServiceInfo.setId(taskId);
        //将 algorithmCallServiceInfo对象转换为json字符串
        String jsonString = JSONObject.toJSONString(algorithmCallServiceInfo);
        System.out.println(jsonString);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;

    }
}
