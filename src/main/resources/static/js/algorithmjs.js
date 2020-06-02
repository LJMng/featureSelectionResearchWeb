$(function () {
    // 网页一打开，就执行这个js初始方法，可以自行百度一下相关介绍与用法
    // 1. 调用js方法获取页面涉及的URL, 赋值到js变量中.
    //	queryXXXURI();
    $("[name='my-checkbox']").bootstrapSwitch({
        onText: "English",
        offText: "中文",
        onColor: "primary",
        offColor: "primary",
        size: "small",
        labelWidth: "15px"
    });

});

var vm =new Vue({
    el:"#algorithmData",
    data:{
        paramsNumber:0,
        values:"",
        parasType:'',
        valueNumber:[],
        algorithms:'',
        algorithmId:1,
        algorithmName:[],
        algorithmNames:'',
        msgs: [],
        info:{
            algorithmId:'',
            algorithmName:'',
            algorithmPaperReference:'',
            algorithmPaperLink:'',
            algorithmDescription: '',
            algorithmCallInterface:'',
            algorithmParameterDemoAdmin:[],
            algorithmCallHost:'',
            algorithmCallExchange:'',
            algorithmCallDemoRoutingkey:'',
            algorithmCallExecutionSendRoutingkey:'',
            algorithmCallExecutionConnectRoutingkey:'',
            algorithmCallPort:'',
            algorithmCallUsername:'',
            algorithmCallPassword:''
        },
        number: 0,
        // parameterName: [],
        parameterType: [],
        searchString: '',

        parameterInfo:{
            // 算法id
            algorithmId:1,
            // 参数名称
            parameterNames:[],
            // 参数描述
            parameterDescriptions:[],
            // 参数默认值
            parameterDefaultValues:[],
            //根据下面四个标识有1的属性进行parameterSettingInfo的封装
            // 第一个参数值类型      1
            parameterTypes:[],
            //第一个参数值,二维数组  里层是个字符串数组   1
            firstParameterVales:[],
            //第二个参数类型,二维    里层是个字符串数组   1
            secondParameterTypes:[],
            //第二个参数值,二维      里层是个字符串数组 一个数组包含对应的所有值    1
            secondParameterValues:[],
        },
        procedureSetting:{
            algorithmId:1,
            name:'',
            state:'',
            options:'',
            defaultOption:'',
            description:''
        },
        //暂时存放第一个参数值的数组
        firstParameterValue:[],
        //暂时存放第二个参数值的数组
        secondParameterValue:[],
        //循环遍历设置第一个参数值的个数
        paramValuesNumber:[],
        //暂时存放第二个参数类型的数组
        secondParameterType:[],

        procedureSettings: '',
        procedureSettingReturned: '',
        parameters:[],
        parameterInfo:{
            parameterId:1,
            parameterName:'',
            parameterType:'',
            parameterDefaultValue:'',
            parameterDescription:''
        },
        procedureSettingInfo:{
            id:1,
            name:'',
            state:'',
            options:'',
            defaultOption:'',
            description:''
        }
    },
    created:function () {
        //初始化数值
        var that=this;
        axios.get('/elements?htmlName=algorithm&isCh=ch').then(function (response){
            that.values=response.data;
            console.log(response.data);
        } ,function (err) {

        })

        axios.get('/getAlgorithms').then(function (response) {
            that.algorithms=response.data;
        },function (err) {

        })

        axios.get('/findAllProcedureSetting')
            .then(function (response){
                that.procedureSettings = response.data;
            })
            .catch(function (err){
                console.log(err);
            })


        axios.get('/getParameters')
            .then(function (response){
                that.parameters = response.data;
            })
            .catch(function (err){
                console.log(err);
            })
        this.getData()

    },
    methods:{
        //获得所有算法信息
        getData() {
            axios.get('/AlgorithmInfoDemoAdmin/findAll')
                .then(resp => {
                    this.msgs = resp.data;
                })
                .catch(err => {
                    console.log(err);
                });
        }, //获得指定ID算法信息
        getDataById(id) {
            const _id = id;
            axios.get('/AlgorithmInfoDemoAdmin/find/'+id)
                .then(resp => {
                    this.info.algorithmId = _id;
                    this.info.algorithmName = resp.data.algorithmName;
                    this.info.algorithmPaperLink = resp.data.algorithmPaperLink;
                    this.info.algorithmPaperReference = resp.data.algorithmPaperReference;
                    this.info.algorithmDescription = resp.data.algorithmDescription;
                    this.info.algorithmCallInterface = resp.data.algorithmCallInterface;
                })
                .catch(err => {
                    console.log(err);
                });
        },
        //添加算法参数信息
        createParameter(){
            axios.post('/createParameters',this.parameterInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //新增算法信息
        insertData() {
            //表单验证
            if(!this.info.algorithmName){
                alert('请输入算法名称')
                return ;
            }
            if(!this.info.algorithmPaperReference){
                alert('请输入算法简介')
                return ;
            }
            if(!this.info.algorithmCallInterface){
                alert('请输入算法接口')
                return ;
            }

            //获取数据并检验
            for(var i=0;i<this.number;i++){
                this.info.algorithmParameterDemoAdmin[i].parameterName=this.parameterName[i];
                this.info.algorithmParameterDemoAdmin[i].parameterType=this.parameterType[i];
                if(!this.info.algorithmParameterDemoAdmin[i].parameterName){
                    alert('请输入参数'+(i+1)+'的名称')
                    return ;
                }
                if(!this.info.algorithmParameterDemoAdmin[i].parameterType){
                    alert('请选择参数'+(i+1)+'的类型')
                    return ;
                }
            }
            axios.post('/AlgorithmInfoDemoAdmin/insert',this.info)
                .then(() => {
                    console.log(this.info)
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //更新算法信息
        updateData() {
            //表单验证
            if(!this.info.algorithmName){
                alert('算法名称不能为空')
                return ;
            }
            if(!this.info.algorithmPaperReference){
                alert('算法简介不能为空')
                return ;
            }
            if(!this.info.algorithmCallInterface){
                alert('算法接口不能为空')
                return ;
            }
            axios.post('/AlgorithmInfoDemoAdmin/update',this.info)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //删除算法信息
        deleteData(id) {
            axios.post('/AlgorithmInfoDemoAdmin/delete/'+id)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //清空数据
        clearData() {
            this.info.algorithmId = '';
            this.info.algorithmName = '';
            this.info.algorithmDescription = '';
            this.info.algorithmPaperLink = '';
            this.info.algorithmPaperReference = '';
            this.info.algorithmCallInterface = '';
        },
        //新增算法步骤
        createProcedureSetting(){
            axios.post('/addProcedureSetting',this.procedureSetting)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        updateProcedureSetting(id){
            this.procedureSettingInfo.id=id;
            axios.post('/updateProcedureSetting',this.procedureSettingInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err)
                })
        },
        confirmFirstParameterValue:function (n,m) {
            if(m >= this.paramValuesNumber[n-1]){
            // this.parameterInfo.firstParameterVales[n-1]=this.firstParameterValue;
            // this.firstParameterValue=[];
            this.parameterInfo.secondParameterTypes[n-1]=this.secondParameterType;
            this.secondParameterType=[];
            this.parameterInfo.secondParameterValues[n-1]=this.secondParameterValue;
            this.secondParameterValue=[];
            console.log(this.parameterInfo.secondParameterTypes[n-1])
                console.log("改方法调用了")
            }
        },
        confirmFirstValue:function (n,m) {
            if(m >= this.paramValuesNumber[n-1]){
                this.parameterInfo.firstParameterVales[n-1]=this.firstParameterValue;
                this.firstParameterValue=[];
                console.log("改方法调用了")
            }
        },
        putAlgorithmId:function (algorithmId) {
            this.algorithmId=algorithmId
        },
        updateParameter:function (parameterId) {
            this.parameterInfo.parameterId=parameterId;
            axios.post('/updateParameter',this.parameterInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })

        }
    },
    computed: {
        //搜索功能
        filterInfo: function() {
            var info_array = this.msgs,
                searchString = this.searchString;

            if(!searchString){
                return info_array;
            }

            searchString = searchString.trim().toLowerCase();

            info_array = info_array.filter(function (item) {
                if(item.algorithmName.toLowerCase().indexOf(searchString) !== -1){
                    return item;
                }
            });

            return info_array;
        },
        //根据算法id过滤得到算法对应的参数
        filterParametersByAlgorithmId() {
            //取出数据
            const{parameters,algorithmId}=this
            //过滤获得的属性
            let fParameters=new Array();
            let j=0;
            // //对datasetMap进行过滤
            // fParameters=parameters.filter(p => p.algorithmId===algorithmId)
            for(let i=0;i<parameters.length;i++){
                var parameter=parameters[i];
                if (parameter.algorithmId===algorithmId){
                    fParameters[j]=parameter;
                    j++
                }
            }

                return fParameters;
        },
        filterProcedureSettingsByAlgorithmId(){
            //取出数据
            const{procedureSettings,algorithmId}=this
            //过滤获得的属性
            let fProcedureSettings=new Array();
            let j=0;
            // //对datasetMap进行过滤
            // fParameters=parameters.filter(p => p.algorithmId===algorithmId)
            for(let i=0;i<procedureSettings.length;i++){
                var procedureSetting=procedureSettings[i];
                if (procedureSetting.algorithmId===algorithmId){
                    fProcedureSettings[j]=procedureSetting;
                    j++
                }
            }

            return fProcedureSettings;
        }

    },
    watch:{
        //监听number
        number:{
            handler(newVal,oldVal){
                //新的长度
                var newLength = this.number;
                //新增长度
                var addLength = 0;
                //如果新的长度大于原来的长度
                if(newLength>this.info.algorithmParameterDemoAdmin.length){
                    //增加长度=新的长度-原来长度
                    addLength = newLength - this.info.algorithmParameterDemoAdmin.length;
                    //增加个数
                    for(var i=0;i<addLength;i++){
                        //增加的数组,且不能在外面声明,否则地址会一样,即修改一个其他全部修改
                        var newArr = [{parameterName:'',parameterType:''}];
                        this.info.algorithmParameterDemoAdmin = this.info.algorithmParameterDemoAdmin.concat(newArr)
                    }
                } else {
                    this.info.algorithmParameterDemoAdmin.splice(this.number);//清除多余数组
                }
            }
        }
    }

})

//发送表单ajax请求
$("#addParameterSettingInfo").on('click',function(){
    alert("请求发送")
    $.ajax({
        url:"/addAlgorithm",
        type:"POST",
        data:JSON.stringify($("#createAlgorithm").serializeObject()),
        contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
        success:function(){
            alert("成功");
        }
    });
});

/**
 * 自动将form表单封装成json对象
 *
 */
$.fn.serializeObject = function() {
    /**
     * 定义一个外围数组，数组类型是{}json对象
     * 遍历输入规则：从paraMeterName开始遍历至values let i++
     * @type {{}}
     */
    var k=[];
    var o = {};
    var a = this.serializeArray();
    let i=-1;
    $.each(a,function () {
        //判断是否为最后一个的values
        if(this.name==='value'){
            if (o[this.name]) {
                if (!o[this.name].push) {
                    //         不存在名，就赋值一个名
                    o[this.name] = [ o[this.name] ];
                }
                // 给对应的名赋值，都是采用追加的方式
                o[this.name].push(this.value || '');
            }
            else {
                o[this.name] = this.value || '';
            }

        }else{
            if (this.name==='algorithmId'){
                if (i===-1){
                    i++;
                }else {
                    k[i] = o;
                    i++;
                    o = {};
                }
            }
            o[this.name] = this.value || '';
        }

    })
    // $.each(a, function() {
    //     if (o[this.name]) {
    //         if (!o[this.name].push) {
    // //         不存在名，就赋值一个名
    //             o[this.name] = [ o[this.name] ];
    //         }
    //         // 给对应的名赋值，都是采用追加的方式
    //         o[this.name].push(this.value || '');
    //     }
    //     else {
    //         o[this.name] = this.value || '';
    //     }
    // });
    return k;
};
