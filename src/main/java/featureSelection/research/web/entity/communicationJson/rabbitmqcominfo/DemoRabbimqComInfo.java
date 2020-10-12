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
import featureSelection.research.web.entity.communicationJson.SendDataSetInfo;
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
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : DemoRabbimqComInfo
 * @Description :Demo系统rabbitmq通讯信息类，当需要调用算法服务端时，新建该类
 * @Author : WDD
 * @Date: 2020-05-19 15:58
 */
public class DemoRabbimqComInfo {
    private final static Logger log = LoggerFactory.getLogger(DemoRabbimqComInfo.class);
    private String demoRabbimqComTaskId;  //当前连接任务信息id
    private RabbitTemplate rabbitmqTemplate; //rabbitmqTemplate 模板,通过该对象发送信息至服务端
    //任务状态，分别为READY：任务就绪 CONNECTED：与服务端连接成功 FINISH：任务完成
    private String statues = "READY";
    private Object resultInfo; //任务结果信息
    private int algorithmId; //当前使用算法id
    private Dataset dataset; //任务使用数据集
    private String routingkey; //服务端routingKey
    private String exchange; //服务端exchange
    private ParameterScheme parameterScheme; //该任务使用的参数方案
    private ParameterSchemeMapper parameterSchemeMapper = SpringUtil.getBean(ParameterSchemeMapper.class);
    private DatasetMapper datasetMapper = SpringUtil.getBean(DatasetMapper.class);
    private AlgorithmMapper algorithmMapper = SpringUtil.getBean(AlgorithmMapper.class);
    private SchemeProcedureMapper schemeProcedureMapper = SpringUtil.getBean(SchemeProcedureMapper.class);
    private LocalDemoRabbitmqInfo localDemoRabbitmqInfo = SpringUtil.getBean(LocalDemoRabbitmqInfo.class);
    private AlgorithmMapperValueUtil algorithmMapperValueUtil = SpringUtil.getBean(AlgorithmMapperValueUtil.class);

    public DemoRabbimqComInfo() {
    }


    /**
     * 根据schemeId和algorithmId初始化通讯信息类信息
     * 设置demoRabbimqComTaskId、routingkey、algorithmId、exchange、dataset、parameterScheme、rabbitmqTemplate
     *
     * @param schemeId：参数方案id
     * @param algorithmId：算法id
     */
    public DemoRabbimqComInfo(int schemeId, int algorithmId, int datasetId) {
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmId);

        //根据算法id查询该算法对应的服务端rabbitmq的配置，并根据配置信息实例化connectionFactory类
        String routingkey = algorithm.getAlgorithmCallDemoRoutingkey();
        String host = algorithm.getAlgorithmCallHost();
        String exchange = algorithm.getAlgorithmCallExchange();
        int port = Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username = algorithm.getAlgorithmCallUsername();
        String password = algorithm.getAlgorithmCallPassword();
        CachingConnectionFactory connectionFactory = RabbitmqUtil.getConnectionFactory(host, port, username, password, exchange);

        ParameterScheme parameterScheme = parameterSchemeMapper.getSchemeWithParameterValueById(schemeId);

        this.routingkey = routingkey;
        this.algorithmId = algorithmId;
        this.exchange = exchange;
        //设置demoRabbimqComTaskId=算法名+当前时间戳
        this.demoRabbimqComTaskId = algorithm.getAlgorithmNameMapper() + System.currentTimeMillis();
        this.dataset = datasetMapper.getDatasetInfo(datasetId);
        this.parameterScheme = parameterScheme;
        //通过工具类由connectionFactory实例化rabbitmqTemplate
        this.rabbitmqTemplate = RabbitmqUtil.getRabbitTemplate(connectionFactory);
    }

    /**
     * 向算法服务端建立连接
     */
    public String sendRabbitmqConnectRequestInfo() {
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
        return connectJsondata.toJSONString();

    }

    /**
     * 封装发送至rabbitmq建立通讯的请求信息实体
     *
     * @return AlgorithmCallTaskInfo：发送至rabbitmq建立通讯的请求信息实体
     */
    private AlgorithmCallTaskInfo schemeInfoToRequestEnity() {

        Dataset dataset = this.dataset;
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
                String inputValueString = parameterSchemeValue.getParameterInputValue();
                if (inputValueString.contains(".")) {
                    basicSettingValue.put("input", Float.parseFloat(parameterSchemeValue.getParameterInputValue()));
                } else {
                    basicSettingValue.put("input", Integer.parseInt(parameterSchemeValue.getParameterInputValue()));
                }
            }
            //selection类型的参数，此时除了input还带有option的参数
            else if (parameterSchemeValue.getParameter().getParameterType().equals("selection")) {
                String parameterInputWebKey = parameterSchemeValue.getParameterInputValue();
                String parameterOptionWebKey = parameterSchemeValue.getParameterOptionValue();
                String parameterOptionValue = algorithmMapperValueUtil.getParameterValue(algorithmId, paramterid,
                        parameterOptionWebKey, null);
                //先插入select的方法
                basicSettingValue.put("option", parameterOptionValue);
                if (parameterInputWebKey != null) {
                    //正则表达式，检验input是否为数字，一般为数字
                    Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
                    Matcher isNum = pattern.matcher(parameterInputWebKey);
                    //匹配成功,input为数字
                    if (isNum.matches()) {
                        basicSettingValue.put("input", Integer.parseInt(parameterInputWebKey));
                    }
                }
            }
            //radio类型的参数：即单选框
            else if (parameterSchemeValue.getParameter().getParameterType().equals("radio")) {
                String parameterWebKey = parameterSchemeValue.getParameterOptionValue();
                String parameterMapperName = algorithmMapperValueUtil.getParameterValue(algorithmId,
                        paramterid, parameterWebKey, null);
                basicSettingValue.put("option", parameterMapperName);
            }
            //checkbox类型的参数：即多选框
            else if (parameterSchemeValue.getParameter().getParameterType().equals("checkbox")) {
                String[] parameterWebKeys = parameterSchemeValue.getParameterOptionValue().split(",");
                List<String> parameterMapperNames = new ArrayList<>();

                for (int i = 0; i < parameterWebKeys.length; i++) {
                    parameterMapperNames.add(algorithmMapperValueUtil.getParameterValue(algorithmId,
                            paramterid, parameterWebKeys[i], null));
                }
                basicSettingValue.put("option", parameterMapperNames);
            }
            basicSettings.put(parameterSchemeValue.getParameter().getParameterNameMapper(), basicSettingValue);
        }
        //步骤信息
        Map<String, Map<String, Object>> procedureSetting = new HashMap<>();
        List<SchemeProcedure> schemeProcedures =
                schemeProcedureMapper.getSchemeProceduresBySchemeId(parameterScheme.getSchemeId());
        for (SchemeProcedure schemeprocedure : schemeProcedures) {
            Map proceduredatamap = (Map) JSON.parse(schemeprocedure.getProcedureSettingData());
            String procedureNameMapper = schemeprocedure.getProcedureSettings().getNameMapper();
            int procedureSettingId = schemeprocedure.getProcedureSettings().getId();
            String procedureDataWebkey = (String) proceduredatamap.get("data");
            String procedureDataValue = algorithmMapperValueUtil.getProcedureValue(algorithmId, procedureSettingId,
                    procedureDataWebkey);
            proceduredatamap.replace("data", procedureDataValue);
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
        algorithmCallServiceInfo.setColumn(Integer.parseInt(dataset.getDatasetDimension()));
        //设置数据集part
        algorithmCallServiceInfo.setPart(0);
        algorithmCallServiceInfo.setPartDataSize(0);
        int featureNums=Integer.parseInt(dataset.getDatasetDimension());
        int[]attributes=new int[featureNums-1];
        for (int i=0;i<featureNums-1;i++){
            attributes[i]=i+1;
        }
        algorithmCallServiceInfo.setAttributes(attributes);
        return algorithmCallServiceInfo;
    }

    /**
     * 向算法服务端发送数据集信息
     *
     * @throws IOException
     */
    public void sendDataset() throws IOException {
        String fileinfo=dataset.getdatasetFile().replace("\\","/");
        StringBuilder stringBuilder=new StringBuilder(fileinfo);
        stringBuilder.insert(0,"static/");
        int[][] data = new DemoCsvUtil(stringBuilder.toString()).csvToIntArray();
        //请求数据实体
        SendDataSetInfo RequestJsonDataCommonInfo = new SendDataSetInfo();
        //时间戳与任务建立时保持一致
        RequestJsonDataCommonInfo.setId(this.demoRabbimqComTaskId);
        RequestJsonDataCommonInfo.setPartTotalLine(dataset.getDatasetRecords());
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


    /**
     * 封装数据集信息
     *
     * @param row                     数据为数据集第几行
     * @param data                    数据
     * @param requestCommonData(数据实体)
     * @return
     * @throws IOException
     */
    private JSONObject RequestJsonData(int row, int[] data, SendDataSetInfo requestCommonData) throws IOException {
        requestCommonData.setLine(row);
        requestCommonData.setData(data);
        String jsonString = JSONObject.toJSONString(requestCommonData);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;
    }

    public Dataset getDataset() {
        return dataset;
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

    public String getDatasetName() {
        return dataset.getDatasetName();
    }
}
