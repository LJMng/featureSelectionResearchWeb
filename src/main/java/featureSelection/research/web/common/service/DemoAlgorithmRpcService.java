package featureSelection.research.web.common.service;

import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.DemoCsvUtil;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.entity.demo.visitor.ParameterScheme;
import featureSelection.research.web.entity.demo.visitor.ParameterSchemeValue;
import featureSelection.research.web.entity.communicationJson.AlgorithmCallTaskInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmSetting;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ParameterSchemeMapper;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName : AlgotithRpcServiceimp
 * @Description : 供demo系统使用的rpc服务（同步）
 * @Author : WDD
 * @Date: 2020-04-12 20:09
 */
@Service
public class DemoAlgorithmRpcService {

    @Autowired
    DatasetMapper datasetMapper;
    @Autowired
    AlgorithmMapper algorithmMapper;
    @Autowired
    ParameterSchemeMapper parameterSchemeMapper;

    /**
     * 根据算法id，方案id封装算法参数设置信息，通过rabbitmq的rpc模式发送至算法服务端，并接收返回的算法处理结果
     *
     * @param algorithmid:算法id
     * @param schemeid：方案id
     * @return 算法处理结果
     */
    public Object send(int algorithmid, int schemeid) {
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmid);
        String routingkey = algorithm.getAlgorithmCallRoutingkey();
        String host = algorithm.getAlgorithmCallHost();
        String exchange = algorithm.getAlgorithmCallExchange();
        int port = Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username = algorithm.getAlgorithmCallUsername();
        String password = algorithm.getAlgorithmCallPassword();
        //1.创建rabbitmq连接
        CachingConnectionFactory connectionFactory = RabbitmqUtil.getConnectionFactory(host, port, username, password, exchange);
        //2.封装算法参数信息
            //算法参数实体信息
        AlgorithmCallTaskInfo connectenity = schemeInfoToRequestEnity(schemeid);
            // 当前时间戳
        Long startTs = System.currentTimeMillis();
            //设置算法调用任务信息id
        String taskId = algorithm.getAlgorithmName()+ startTs;
        connectenity.setId(taskId);
            //将算法参数实体信息对象转换为json字符串
        String jsonString = JSONObject.toJSONString(connectenity);
            //将json字符串转换为json对象
        JSONObject connectJsondata = JSONObject.parseObject(jsonString);
        //3.发送信息请求与rabbitmq建立通讯
        System.out.println("进行连接请求,请求数据："+connectJsondata.toJSONString());
        RabbitTemplate rabbitTemplate = RabbitmqUtil.getRabbitTemplate(connectionFactory);
        rabbitTemplate.setReplyTimeout(-1);
        //4.接受第一次返回结果（连接结果）
        Object firstresponse = rabbitTemplate.convertSendAndReceive(exchange, routingkey, connectJsondata);
        JSONObject connectresult = (JSONObject) firstresponse;
        int Partresult = (Integer) connectresult.get("part");
        //5.判断请求结果
        if (connectenity.getPart()== Partresult) {
            System.out.println("请求结果："+firstresponse.toString()+"\n"+"成功建立连接");
            //5.1 建立通讯后开始发送数据
            try {
                ParameterScheme parameterScheme = parameterSchemeMapper.getDataSetAndSchemeBySchemeId(schemeid);
                Dataset dataset = datasetMapper.getDatasetInfo(parameterScheme.getDataset().getDatasetId());
                int[][] data = new DemoCsvUtil(dataset.getdatasetFile()).csvToIntArray();
                //请求数据实体
                AlgorithmCallTaskInfo RequestJsonDataCommonInfo = new AlgorithmCallTaskInfo();
                //时间戳与任务建立时保持一致
                RequestJsonDataCommonInfo.setId(taskId);
                RequestJsonDataCommonInfo.setDatasetName(dataset.getDatasetName());
                Object reductResult=new Object();
                System.out.println("开始发送数据");
                //5.2 根据数据量确定消息数
                for (int i=0;i<data.length-2;i++){
                    JSONObject RequestJsonData = RequestJsonData(i,data[i],RequestJsonDataCommonInfo);

                    rabbitTemplate.convertSendAndReceive(exchange, routingkey, RequestJsonData);
                    System.out.println("发送第"+i+"条数据："+RequestJsonData.toJSONString());
                }
                JSONObject RequestJsonData = RequestJsonData(data.length,data[data.length-1],RequestJsonDataCommonInfo);
                reductResult=rabbitTemplate.convertSendAndReceive(exchange, routingkey, RequestJsonData);
                System.out.println("接受处理结果"+reductResult.toString());
                return reductResult;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "fail";

    }


    /**
     * 根据方案信息封装发送至rabbitmq建立通讯的请求信息实体
     *
     * @param schemeid     参数方案id
     * @return 发送至rabbitmq建立通讯的请求信息实体
     */
    public AlgorithmCallTaskInfo schemeInfoToRequestEnity(int schemeid) {
        //获取方案信息
        ParameterScheme parameterScheme = parameterSchemeMapper.getDataSetAndSchemeBySchemeId(schemeid);
        Dataset dataset = datasetMapper.getDatasetInfo(parameterScheme.getDataset().getDatasetId());
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
        algorithmCallServiceInfo.setDatasetName(dataset.getDatasetName());
        //设置数据集维度
        algorithmCallServiceInfo.setColumn(dataset.getDatasetDimension());
        //设置数据集part
        algorithmCallServiceInfo.setPart(0);
        return algorithmCallServiceInfo;
    }


    /**
     * @param row 数据为数据集第几行
     * @param data 数据
     * @param requestCommonData(数据实体)
     * @return
     * @throws IOException
     */
    public JSONObject RequestJsonData(int row,int[]data,AlgorithmCallTaskInfo requestCommonData) throws IOException {
        requestCommonData.setLine(row);
        requestCommonData.setPartTotalLine(data.length);
        requestCommonData.setData(data);
        String jsonString = JSONObject.toJSONString(requestCommonData);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;
    }
}
