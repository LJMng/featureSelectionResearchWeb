package featureSelection.research.web.entity.communicationJson.rabbitmqcominfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.service.DemoRabbitmqComServiceSingleton;
import featureSelection.research.web.common.util.AlgorithmMapperValueUtil;
import featureSelection.research.web.common.util.DemoCsvUtil;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.common.util.SpringUtil;
import featureSelection.research.web.entity.communicationJson.AlgorithmCallTaskInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmInfo;
import featureSelection.research.web.entity.communicationJson.AlgorithmSetting;
import featureSelection.research.web.entity.communicationJson.localrabbitmqinfo.LocalDemoRabbitmqInfo;
import featureSelection.research.web.entity.demo.visitor.*;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ParameterSchemeMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.SchemeProcedureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : DemoRabbimqComInfo
 * @Description : Demo系统rabbitmq通讯信息
 * @Author : WDD
 * @Date: 2020-05-19 15:58
 */
public class DemoRabbimqComInfo {
    private final static Logger log = LoggerFactory.getLogger(DemoRabbimqComInfo.class);
    private String demoRabbimqComTaskId;
    private RabbitTemplate rabbitmqTemplate;
    private String statues = "READY";
    private Object resultInfo;
    private int algorithmId;
    private Dataset dataset;
    private String routingkey;
    private String exchange;
    private ParameterScheme parameterScheme;
    private ParameterSchemeMapper parameterSchemeMapper = SpringUtil.getBean(ParameterSchemeMapper.class);
    private DatasetMapper datasetMapper = SpringUtil.getBean(DatasetMapper.class);
    private AlgorithmMapper algorithmMapper = SpringUtil.getBean(AlgorithmMapper.class);
    private SchemeProcedureMapper schemeProcedureMapper = SpringUtil.getBean(SchemeProcedureMapper.class);
    private LocalDemoRabbitmqInfo localDemoRabbitmqInfo = SpringUtil.getBean(LocalDemoRabbitmqInfo.class);
    private AlgorithmMapperValueUtil algorithmMapperValueUtil = SpringUtil.getBean(AlgorithmMapperValueUtil.class);

    public DemoRabbimqComInfo() {
    }


    public DemoRabbimqComInfo(int schemeId, int algorithmId) {
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmId);
        String routingkey = algorithm.getAlgorithmCallDemoRoutingkey();
        this.routingkey = routingkey;
        String host = algorithm.getAlgorithmCallHost();
        String exchange = algorithm.getAlgorithmCallExchange();
        int port = Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username = algorithm.getAlgorithmCallUsername();
        String password = algorithm.getAlgorithmCallPassword();
        CachingConnectionFactory connectionFactory = RabbitmqUtil.getConnectionFactory(host, port, username, password, exchange);
        ParameterScheme parameterScheme = parameterSchemeMapper.getDataSetAndSchemeBySchemeId(schemeId);

        this.algorithmId = algorithmId;
        this.exchange = exchange;
        this.rabbitmqTemplate = RabbitmqUtil.getRabbitTemplate(connectionFactory);
        this.demoRabbimqComTaskId = algorithm.getAlgorithmNameMapper() + System.currentTimeMillis();
        this.dataset = datasetMapper.getDatasetInfo(parameterScheme.getDataset().getDatasetId());
        this.parameterScheme = parameterSchemeMapper.getSchemeWithParameterValueAndDatasetById(schemeId);
    }

    public void sendRabbitmqConnectRequestInfo() {
        AlgorithmCallTaskInfo connectenity = schemeInfoToRequestEnity();
        connectenity.setLocalRabbitmqInfo(this.localDemoRabbitmqInfo);
        connectenity.setId(this.demoRabbimqComTaskId);
        //将算法参数实体信息对象转换为json字符串
        String jsonString = JSONObject.toJSONString(connectenity);
        //将json字符串转换为json对象
        JSONObject connectJsondata = JSONObject.parseObject(jsonString);
        //发送信息请求与rabbitmq建立通讯
        this.rabbitmqTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        this.rabbitmqTemplate.convertAndSend(exchange, routingkey, connectJsondata);
        log.info("connecting：" + connectJsondata.toJSONString());
    }

    /**
     * 根据方案信息封装发送至rabbitmq建立通讯的请求信息实体
     *
     * @return 发送至rabbitmq建立通讯的请求信息实体
     */
    private AlgorithmCallTaskInfo schemeInfoToRequestEnity() {

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
            int paramterid = parameterSchemeValue.getParameter().getParameterId();
            //算法基础设置参数取值
            Map<String, Object> basicSettingValue = new HashMap<>();
            //判断参数类型
            //text类型的情况，此时输入值为数值型类型
            if (parameterSchemeValue.getParameter().getParameterType().equals("text")) {
                basicSettingValue.put("input",Integer.parseInt(parameterSchemeValue.getParameterInputValue()));
            }
            //selection类型的参数，此时除了input还带有option的参数
            else if (parameterSchemeValue.getParameter().getParameterType().equals("selection")) {
                String parameterInputWebKey = parameterSchemeValue.getParameterInputValue();
                String parameterOptionWebKey = parameterSchemeValue.getParameterOptionValue();
                String parameterInputValue = algorithmMapperValueUtil.getParameterValue(algorithmId,paramterid,
                        parameterInputWebKey,null);
                basicSettingValue.put("input", parameterInputValue);
                //正则表达式，检验option是否为数字，如果是数字就不需要寻找对应的value，如果为文字则需要寻找对应的value
                Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
                Matcher isNum = pattern.matcher(parameterOptionWebKey);
                //匹配成功,option为数字
                if (isNum.matches()) {
                    basicSettingValue.put("option", Integer.parseInt(parameterOptionWebKey));
                }else{
                    //寻找option对应的取值
                    String parameterOptionValue=algorithmMapperValueUtil.getParameterValue(algorithmId,paramterid,
                            parameterInputWebKey,parameterOptionWebKey);
                    basicSettingValue.put("option",parameterOptionValue);
                }
            }
            //radio类型的参数：即单选框
            else if (parameterSchemeValue.getParameter().getParameterType().equals("radio")) {
                String parameterWebKey = parameterSchemeValue.getParameterInputValue();
                String parameterMapperName = algorithmMapperValueUtil.getParameterValue(algorithmId,
                        paramterid, parameterWebKey, null);
                basicSettingValue.put("input",parameterMapperName);
            }
            //checkbox类型的参数：即多选框
            else if (parameterSchemeValue.getParameter().getParameterType().equals("checkbox")) {
                String[] parameterWebKeys = parameterSchemeValue.getParameterInputValue().split(",");
                StringBuilder parameterMapperName =new StringBuilder();
                for (int i = 0; i <=parameterWebKeys.length - 2; i++) {
                    parameterMapperName.append(algorithmMapperValueUtil.getParameterValue(algorithmId,
                            paramterid, parameterWebKeys[i], null) + ",");
                }
                //插入最后一个值，末尾不带","
                parameterMapperName.append(algorithmMapperValueUtil.getParameterValue(algorithmId,
                        paramterid,
                        parameterWebKeys[parameterWebKeys.length - 1],
                        null));
                basicSettingValue.put("input",parameterMapperName);
            }
            basicSettings.put(parameterSchemeValue.getParameter().getParameterNameMapper(),basicSettingValue);
        }
        //步骤信息
        Map<String, Map<String, Object>> procedureSetting = new HashMap<>();
        List<SchemeProcedure> schemeProcedures =
                schemeProcedureMapper.getSchemeProceduresBySchemeId(parameterScheme.getSchemeId());
        for (SchemeProcedure schemeprocedure : schemeProcedures) {
            Map proceduredatamap = (Map) JSON.parse(schemeprocedure.getProcedureSettingData());
            String procedureNameMapper=schemeprocedure.getProcedureSettings().getNameMapper();
            int procedureSettingId=schemeprocedure.getProcedureSettings().getId();
            String procedureDataWebkey= (String) proceduredatamap.get("data");
            String procedureDataValue=algorithmMapperValueUtil.getProcedureValue(algorithmId,procedureSettingId,
                    procedureDataWebkey);
            proceduredatamap.replace("data",procedureDataValue);
            procedureSetting.put(procedureNameMapper, proceduredatamap);
        }

        //算法步骤设置放入算法设置实体
        algorithmSetting.setProcedure(procedureSetting);
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
     * @param row                     数据为数据集第几行
     * @param data                    数据
     * @param requestCommonData(数据实体)
     * @return
     * @throws IOException
     */
    private JSONObject RequestJsonData(int row, int[] data, AlgorithmCallTaskInfo requestCommonData) throws IOException {
        requestCommonData.setLine(row);
        requestCommonData.setPartTotalLine(data.length);
        requestCommonData.setData(data);
        String jsonString = JSONObject.toJSONString(requestCommonData);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;
    }

    public void sendDataset() throws IOException {
        int[][] data = new DemoCsvUtil(dataset.getdatasetFile()).csvToIntArray();
        //请求数据实体
        AlgorithmCallTaskInfo RequestJsonDataCommonInfo = new AlgorithmCallTaskInfo();
        //时间戳与任务建立时保持一致
        RequestJsonDataCommonInfo.setId(this.demoRabbimqComTaskId);
        RequestJsonDataCommonInfo.setDatasetName(dataset.getDatasetName());
        Object reductResult = new Object();
        log.info("begin send dataset");
        //根据数据量确定消息数
        for (int i = 0; i < data.length - 1; i++) {
            JSONObject RequestJsonData = RequestJsonData(i, data[i], RequestJsonDataCommonInfo);
            this.rabbitmqTemplate.convertAndSend(exchange, routingkey, RequestJsonData);
            log.info("article" + i + "data：" + RequestJsonData.toJSONString());
        }
    }

    public void setResultInfo(Object resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Object getResultInfo() {
        return resultInfo;
    }

    public String getDemoRabbimqComTaskId() {
        return demoRabbimqComTaskId;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

}
