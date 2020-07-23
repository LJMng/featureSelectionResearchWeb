package featureSelection.research.web.entity.communicationJson.rabbitmqcominfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import featureSelection.research.web.common.util.DemoCsvUtil;
import featureSelection.research.web.common.util.EmailUtil;
import featureSelection.research.web.common.util.RabbitmqUtil;
import featureSelection.research.web.common.util.SpringUtil;
import featureSelection.research.web.entity.communicationJson.AlgorithmCallTaskInfo;
import featureSelection.research.web.entity.communicationJson.localrabbitmqinfo.LocalExecutionRabbitmqInfo;
import featureSelection.research.web.entity.demo.visitor.Algorithm;
import featureSelection.research.web.entity.demo.visitor.Dataset;
import featureSelection.research.web.entity.execution.admin.ToEmail;
import featureSelection.research.web.entity.execution.visitor.TaskInfo;
import featureSelection.research.web.mybatisMapper.demo.visitor.AccountMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.AlgorithmMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.DatasetMapper;
import featureSelection.research.web.mybatisMapper.demo.visitor.ParameterSchemeMapper;
import featureSelection.research.web.mybatisMapper.execution.visitor.TaskInfoMapper;
import featureSelection.research.web.mybatisMapper.execution.visitor.TaskResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

import java.io.IOException;

/**
 * @ClassName : ExecutionRabbitmqComInfo
 * @Description :Execution系统rabbitmq通讯信息
 * @Author : WDD
 * @Date: 2020-05-20 11:28
 */
public class ExecutionRabbitmqComInfo {
    private final static Logger log= LoggerFactory.getLogger(ExecutionRabbitmqComInfo.class);

    private String accoutEmail; //用户邮箱
    private String executionRabbimqComTaskId; //当前连接任务信息id
    private RabbitTemplate rabbitmqTemplate;//rabbitmqTemplate 模板,通过该对象发送信息至服务端
    //任务状态，分别为READY：任务就绪 CONNECTED：与服务端连接成功 FINISH：任务完成
    private String statues = "READY";
    private Object resultInfo; //任务结果信息
    private Dataset dataset;//任务使用数据集
    private String connectRoutingkey;//与服务端进行连接时发送队列所绑定的routingKey
    private String sendRoutingkey;//与服务端进行数据传输时数据传输队列所绑定的routingKey
    private String exchange;//服务端exchange
    private TaskInfo taskInfo; //任务信息
    //通过工具类取得bean
    private TaskInfoMapper taskInfoMapper = (TaskInfoMapper) SpringUtil.getBean(TaskInfoMapper.class);
    private DatasetMapper datasetMapper = (DatasetMapper) SpringUtil.getBean(DatasetMapper.class);
    private AlgorithmMapper algorithmMapper = (AlgorithmMapper) SpringUtil.getBean(AlgorithmMapper.class);
    private AccountMapper accountMapper=(AccountMapper)SpringUtil.getBean(AccountMapper.class);
    private TaskResultMapper taskResultMapper = (TaskResultMapper) SpringUtil.getBean(TaskResultMapper.class);
    private EmailUtil emailUtil = (EmailUtil) SpringUtil.getBean(EmailUtil.class);
    //excution系统使用的rabbitmq信息
    private LocalExecutionRabbitmqInfo localExecutionRabbitmqInfo =
            (LocalExecutionRabbitmqInfo) SpringUtil.getBean(LocalExecutionRabbitmqInfo.class);

    /**
     * 根据taskId初始化通讯信息类信息
     * 设置executionRabbimqComTaskId、routingkey、algorithmId、exchange、dataset、、rabbitmqTemplate
     * @param taskId：任务id
     */
    public ExecutionRabbitmqComInfo(int taskId){
        //获取任务信息
        TaskInfo taskInfo = taskInfoMapper.getTaskInfoByTaskId(taskId);

        JSONObject taskParamaterInfo=JSONObject.parseObject(taskInfo.getAlgorithmParameters());
        log.info(taskParamaterInfo.toString());
        int algorithmid = taskInfo.getAlgorithmId();
        Algorithm algorithm = algorithmMapper.getAlgorithmInfoById(algorithmid);
        String connectRoutingkey = algorithm.getAlgorithmCallExecutionConnectRoutingkey();
        String sendRoutingkey=algorithm.getAlgorithmCallExecutionSendRoutingkey();
        String host = algorithm.getAlgorithmCallHost();
        String exchange = algorithm.getAlgorithmCallExchange();
        int port = Integer.parseInt(algorithm.getAlgorithmCallPort());
        String username = algorithm.getAlgorithmCallUsername();
        String password = algorithm.getAlgorithmCallPassword();

        CachingConnectionFactory connectionFactory = RabbitmqUtil.getConnectionFactory(host, port, username, password, exchange);

        this.accoutEmail=taskInfo.getTaskEmail();
        this.executionRabbimqComTaskId = taskParamaterInfo.getString("id");
        this.exchange=exchange;
        this.taskInfo=taskInfoMapper.getTaskInfoByTaskId(taskId);
        this.dataset=datasetMapper.getDatasetInfo(taskInfo.getDatasetId());
        this.connectRoutingkey=connectRoutingkey;
        this.sendRoutingkey=sendRoutingkey;
        this.rabbitmqTemplate = RabbitmqUtil.getRabbitTemplate(connectionFactory);
    }

    /**
     * 发送rabbitmq连接请求信息的方法
     */
     public void sendRabbitmqConnectRequestInfo(){
     String localRabbitmqInfoString= JSON.toJSONString(this.localExecutionRabbitmqInfo);
     JSONObject localRabbitmqInfo=JSONObject.parseObject(localRabbitmqInfoString);
     JSONObject taskParamaterInfo=JSONObject.parseObject(taskInfo.getAlgorithmParameters());
     taskParamaterInfo.put("rabbitmqInfo",localRabbitmqInfo);
     //发送信息请求与rabbitmq建立通讯
     log.info("进行连接请求,请求数据：" + taskParamaterInfo.toJSONString());
     this.rabbitmqTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
     this.rabbitmqTemplate.convertAndSend(exchange, connectRoutingkey,taskParamaterInfo);
     }




    /**
     * 根据每一行数据信息封装数据发送实体Json数据
     * @param row
     * @param data
     * @param requestCommonData
     * @return
     * @throws IOException
     */
    public JSONObject RequestJsonData(int row, int[] data, AlgorithmCallTaskInfo requestCommonData) throws IOException {
        requestCommonData.setLine(row);
        requestCommonData.setPartTotalLine(data.length);
        requestCommonData.setData(data);
        String jsonString = JSONObject.toJSONString(requestCommonData);
        //将json字符串转换为json对象
        JSONObject returnData = JSONObject.parseObject(jsonString);
        return returnData;
    }

    //发送数据集信息
    public void sendDataset() throws IOException {
        int[][] data = new DemoCsvUtil(dataset.getdatasetFile()).csvToIntArray();
        //请求数据实体
        AlgorithmCallTaskInfo RequestJsonDataCommonInfo = new AlgorithmCallTaskInfo();
        //时间戳与任务建立时保持一致
        RequestJsonDataCommonInfo.setId(this.executionRabbimqComTaskId);
        RequestJsonDataCommonInfo.setDatasetName(dataset.getDatasetName());
        log.info("开始发送数据");
        //根据数据量确定消息数
        for (int i = 0; i < data.length - 1; i++) {
            JSONObject RequestJsonData = RequestJsonData(i, data[i], RequestJsonDataCommonInfo);
            this.rabbitmqTemplate.convertAndSend(exchange, sendRoutingkey, RequestJsonData);
            log.info("发送第" + i + "条数据：" + RequestJsonData.toJSONString());
        }
    }

    /**
     * 将结果写入数据库中并发送邮件提醒
     */
    public void sendEmailAndWriteResult(){
        JSONObject reductResultJson = (JSONObject)resultInfo;
        JSONArray reductarray = (JSONArray) reductResultJson.get("reducts");
        String reduct=reductarray.toJSONString();
        taskResultMapper.insertTaskResults(taskInfo.getTaskId(),1, reduct);
        taskInfoMapper.updateTaskInfoStatus("已完成",taskInfo.getTaskId());
        //邮件设置
        ToEmail email = new ToEmail();
        email.setToAccount(taskInfo.getTaskEmail());
        email.setSubject("Your task " + taskInfo.getTaskId() + "result");
        email.setContent("columns" + reduct);
        emailUtil.commonEmail(email);
    }
    public void setResultInfo(Object resultInfo) {
        this.resultInfo = resultInfo;
    }

    public Object getResultInfo() {
        return resultInfo;
    }

    public String getExecutionRabbimqComTaskId() {
        return executionRabbimqComTaskId;
    }

    public String getStatues() {
        return statues;
    }

    public void setStatues(String statues) {
        this.statues = statues;
    }

    public String getTaskAccoutEmail(){
        return accoutEmail;
    }
    public String getDataSetName(){return dataset.getDatasetName();}

    public TaskInfo getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(TaskInfo taskInfo) {
        this.taskInfo = taskInfo;
    }
}
