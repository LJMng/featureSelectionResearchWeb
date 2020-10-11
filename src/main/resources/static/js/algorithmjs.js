// $(document).ready(function(){
//     $('[data-toggle="popover"]').popover();
// });

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

$(document).ready(function() {
    $('.multi-step').MultiStep({
        title:'步骤框',
        data:[{
            content:'Hi!!',
            label:'参数一',
            skip:false
        },{
            content:'这是一个多步骤模式',
            label:'参数二',
            skip:true
        },{
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        }, {
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        }, {
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        }, {
            content:'这是一个多步骤模式',
            label:'参数二',
            skip:true
        },{
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        }, {
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        }, {
            content:`你可以选择跳过`,
            label:'参数三',
            skip:true
        },{
            content:`<small>您也可以包含HTML内容！</small><br><br>
			<div class="form-group">
				<label for="exampleInputEmail1">电邮地址</label>
				<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
				<small id="emailHelp" class="form-text text-muted">我们绝不会把你的邮件告诉别人。

</small>
			  </div>
			`,
            label:'参数四',
            skip:true
        }],
        final:'参数信息',
        modalSize:'lg'
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
            algorithmNameMapper:'',
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
            algorithmCallPassword:'',
            algorithmUsage:'',
        },
        number: 0,
        // parameterName: [],
        parameterType: [],
        searchString: '',
        // //用于封装修改参数信息的对象
        // updateParameterInfo:{
        //
        // },
        parameterInfo:{
            // 算法id
            algorithmId:1,
            // 参数名称
            parameterNames:[],
            //参数名称映射到算法端的值
            parameterNamesMapper:[],
            // 参数描述
            parameterDescriptions:[],
            // 参数默认值
            parameterDefaultValues:[],
            //根据下面四个标识有1的属性进行parameterSettingInfo的封装
            // 第一个参数值类型      1
            parameterTypes:[],
            //第一个参数值,二维数组  里层是个字符串数组   1
            firstParameterVales:[],
            //第一个参数值（算法层）,二维数组     1
            firstAlgorithmParameterValues:[],
            //第二个参数类型,二维    里层是个字符串数组   1
            secondParameterTypes:[],
            //第二个参数值,二维      里层是个字符串数组 一个数组包含对应的所有值    1
            secondParameterValues:[],
            //第二个参数值（算法层）,二维数组     1
            secondAlgorithmParameterValues:[]

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
        //暂时存放第一个算法层参数值的数组
        firstAlgorithmParameterValue:[],
        //暂时存放第二个算法层参数值的数组
        secondAlgorithmParameterValue:[],
        /*
        定义与前端绑定的五个二维数组(默认规则一次最多可以添加十个参数)
        1.secondParameterTypes
        2.secondParameterValues
        3.firstParameterValues
        4.firstAlgorithmParameterValues
        5.secondAlgorithmParameterValues
         */
        secondParameterTypes:[[],[],[],[],[],[],[],[],[],[]],
        secondParameterValues:[[],[],[],[],[],[],[],[],[],[]],
        firstParameterValues:[[],[],[],[],[],[],[],[],[],[]],
        firstAlgorithmParameterValues:[[],[],[],[],[],[],[],[],[],[]],
        secondAlgorithmParameterValues:[[],[],[],[],[],[],[],[],[],[]],


        procedureSettings: '',
        procedureSettingReturned: '',
        parameters:[],
        updateParameterInfo:{
            parameterId:1,
            parameterName:'',
            parameterType:'',
            parameterDefaultValue:'',
            parameterDescription:'',
            parameterNameMapper:''
        },
        deleteParameterInfo:{
            parameterId:1,
            parameterName:'',
            parameterType:'',
            parameterDefaultValue:'',
            parameterDescription:''
        },
        procedureSettingInfo:{
            name:'',
            nameMapper:'',
            state:'',
            options:'',
            optionsMapper:'',
            defaultOption:'',
            description:''
        },
        deleteProcedureSettingInfo:{
            id:1,
        },
        //封装公共数据集信息，用于算法可用数据集的设置
        executionDatasetInfo:'',
        availableDataset4Algorithm:{
            algorithmId:'',
            availableDatasets:''
        },
        //公共数据集名称
        executionDatasetInfoName:'',
        // 算法方案数据
        schemes: [],
        procedures: [],
        p: [],
        ap: [],
        temp: [],
        scheme: {
            schemeId: '',
            schemeName: '',
            schemeDescription: '',
            schemeRemark: '',
            algorithmId: '',
            algorithmName: '',
            algorithmParameterDemoAdmin: [],
        },
        procedure: {
            schemeProcedureId: '',
            schemeId: '',
            procedureName: '',
            procedureSettingData: '',
            procedureSettingsId: '',
        },
        tempSetting: '',
        Ealgorithms: [],
        datasets: [],
        params: '',
        EsearchString: '',
        ProcedureSettingsList: {},
        parameterList: {},
        EalgorithmNames: '',
        administratorName:''
    },
    created:function () {
        //算法方案初始化方法
        this.getData();
        this.getIdAndName();
        //初始化数值
        var that=this;
        that.administratorName=$.cookie("administratorName")
        axios.get('/elements?htmlName=algorithm&isCh=ch').then(function (response){
            that.values=response.data;
            // console.log(response.data);
        } ,function (err) {

        });
        //获取公共数据集信息，executionDatasetInfo
        axios.get('/getDatasetInfo').then(function (response) {
            that.executionDatasetInfo=response.data;
        },function (err) {

        });

        axios.get('/getAlgorithms').then(function (response) {
            that.algorithms=response.data;
        },function (err) {

        });

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
        this.getEData()

    },
    methods:{
        //算法方案管理Method
        //获得所有方案信息
        getData() {
            window.onload = function () {
                var arrStr = document.cookie;
                if (arrStr.indexOf("isClose") > -1) {
                    $('.toast').remove();
                }
            }
            axios.get('/SchemeDemoAdmin/findAll')
                .then(resp => {
                    this.schemes = resp.data;
                    axios.get('/schemeProcedureDemoAdmin/findAll')
                        .then(resp => {
                            this.procedures = resp.data;
                            this.temp = this.procedures;
                            for (let i = 0; i < this.temp.length; i++) {
                                this.$set(this.temp[i], 'data', JSON.parse(this.temp[i].procedureSettingData).data);
                                this.$set(this.temp[i], 'selected', JSON.parse(this.temp[i].procedureSettingData).selected);
                            }
                        })
                        .catch(err => {
                            console.log(err);
                        });
                    axios.get('/execution/getProcedureSettingsList').then((response) => {
                        this.ProcedureSettingsList = response.data;
                    });
                    axios.get('/execution/getParameterList').then((response) => {
                        let params = response.data;
                        for (let key in params) {
                            for (let i = 0; i < params[key].length; i++) {
                                params[key][i].parameterSettingInfo = JSON.parse(params[key][i].parameterSettingInfo);
                            }
                        }
                        this.parameterList = params;
                    });
                    axios.get('/AlgorithmInfoDemoAdmin/findAll')
                        .then(resp => {
                            this.EalgorithmNames = resp.data;
                        })
                        .catch(err => {
                            console.log(err);
                        });
                })
                .catch(err => {
                    console.log(err);
                });
        },
        //重载当前页面
        reloadPage:function(){
            window.location.reload();
        },
        showAlgorithmInfoName:function(even){
            let originFileName = event.target.files[0].name;
            let suffix = originFileName.substr(originFileName.lastIndexOf("."));
            let showName = null;
            if ((originFileName.length-suffix.length)>=6){
                showName = originFileName.substr(0,6)+"*"+suffix;
            }else {
                showName = originFileName;
            }
            if (this.file_suffix.indexOf(suffix)>-1){
                $(event.srcElement).next().removeClass("border-danger");
                $(event.srcElement).next().next().css('display','none');
                $(event.srcElement).next().html(showName);

            }else {
                $(event.srcElement).next().addClass("border-danger");
                $(event.srcElement).next().next().css('display','block');
                $(event.srcElement).next().html(showName);

            }
        },
        //上次算法信息excel文件，并且校验文件格式
        submitAlgorithmExcelFile:function(){
            //校验文件格式，定义ifFileTypeCorrect变量,默认正确
            let ifFileTypeCorrect = true;
            let checks = $("div[name='excelFileCheck']");
            for (let j = 0; j < checks.length; j++) {
                if ($(checks[j]).css('display')!='none'){
                    ifFileTypeCorrect = false;
                    break;
                }
            };
            if(this.$refs.algorithmInfoExcelFile.files[0]==null){
                ifFileTypeCorrect = false;
            };
            if (ifFileTypeCorrect){
                let inputFile = new FormData();
                inputFile.append("algorithmInfoExcel",this.$refs.algorithmInfoExcelFile.files[0]);
                //通过axios发送请求至后台，将algorithmInfoExcel文件传送至算法平台
                axios.post('/addAlgorithmInfoByExcelFile',inputFile,{
                    'Content-Type':'multipart/form-data'
                }).then((response) => {
                    if(response.data == "success"){
                        $('#addAlgorithmInfoByExcelFileResult').html('' +
                            '<div class="alert alert-success alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                            '  <strong>Submit Success!</strong>You can click \'Check My Uploads\' to Check your uploads\'status anytime.\n' +
                            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                            '    <span aria-hidden="true">&times;</span>\n' +
                            '  </button>\n' +
                            '</div>');
                    }else {
                        $('#addAlgorithmInfoByExcelFileResult').html('' +
                            '<div class="alert alert-danger alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                            '  <strong>Error!</strong>Please Check Your Form!\n' +
                            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                            '    <span aria-hidden="true">&times;</span>\n' +
                            '  </button>\n' +
                            '</div>');
                    }
                    window.location.reload();
                })
                }
            },
        //设置可用算法数据集的id
        setDataset4AlgorithmOfAlgorithmId:function(AlgorithmId){
            this.availableDataset4Algorithm.algorithmId=AlgorithmId;
        },
        //设置可用数据集的数据集
        setDataset4AlgorithmOfAvailableDataset:function(){
            let availableDatasets = [];
            $('input[name="availableDataset"]:checked').each(function () {//遍历每一个名字为availableDataset的复选框
                availableDatasets.push($(this).val());//将选中的值添加到数组中
            });
            this.availableDataset4Algorithm.availableDatasets = JSON.stringify(availableDatasets);
            console.log(availableDatasets);
            //将AvailableDataset4Algorithm对象通过axios发送至后台进行存储
            axios.post("/setAvailableDataset4Algorithm",this.availableDataset4Algorithm)
                .then(() =>{
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err)
                })
        },
        //获得指定ID方案信息(编辑)
        getEDataById(id) {
            this.clearEData();
            const _id = id;
            console.log(id)
            axios.get('/SchemeDemoAdmin/find/' + id)
                .then(resp => {
                    this.scheme.schemeId = _id;
                    this.scheme.schemeName = resp.data.schemeName;
                    this.scheme.schemeDescription = resp.data.schemeDescription;
                    this.scheme.schemeRemark = resp.data.schemeRemark;
                    this.scheme.algorithmId = resp.data.algorithmId;
                    this.scheme.algorithmName = resp.data.algorithmName;
                    this.scheme.algorithmParameterDemoAdmin = resp.data.algorithmParameterDemoAdmin;
                    axios.get('/schemeProcedureDemoAdmin/find/' + _id)
                        .then(resp => {
                            if (resp.data.length !== 0) {
                                $.extend(true, this.p, resp.data);//深拷贝
                                this.procedures = resp.data;
                                this.tempSetting = resp.data;
                                let temp1 = resp.data;
                                for (let i = 0; i < this.procedures.length; i++) {
                                    temp1[i] = this.tempSetting[i].procedureSettingData;
                                    this.tempSetting[i] = JSON.parse(temp1[i]);
                                }
                                let temp = this.ProcedureSettingsList[this.scheme.algorithmId];
                                for (let i = 0; i < temp.length; i++) {
                                    this.tempSetting[i].data = temp[i].defaultOption;
                                    this.p[i].procedureSettingsId = temp[i].id;
                                    if (temp[i].state === 'optional') {
                                        this.tempSetting[i].selected = 'false';
                                    } else {
                                        this.tempSetting[i].selected = 'true';
                                    }
                                }
                            }
                        })
                        .catch(err => {
                            console.log(err);
                        });
                })
                .catch(err => {
                    console.log(err);
                });
        },
        //通过算法ID获取算法参数
        getParameterByAlgorithmId(id) {
            //表单验证
            if (!this.scheme.algorithmId) {
                alert('请选择算法');
                return;
            }
            if (!this.scheme.schemeName) {
                alert('请输入方案名称');
                return;
            }
            if (!this.scheme.schemeDescription) {
                alert('请输入简介');
                return;
            }
            axios.get('/AlgorithmInfoDemoAdmin/findParameter/' + id)
                .then(resp => {
                    this.scheme.algorithmParameterDemoAdmin = resp.data.algorithmParameterDemoAdmin;
                    this.insertEData();
                })
                .catch(err => {
                    console.log(err)
                })
        },
        //新增方案信息
        insertEData() {
            if (this.scheme.algorithmParameterDemoAdmin === undefined) {
                alert("请确认该算法是否设定参数，可以到execution管理系统添加噢！");
                return;
            }
            axios.post('/SchemeDemoAdmin/insert', this.scheme)
                .then(() => {
                    axios.post('/schemeProcedureDemoAdmin/insert');
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //更新方案信息
        updateEData() {
            //表单验证
            if (!this.scheme.schemeName) {
                alert('请输入方案名称');
                return;
            }
            if (!this.scheme.schemeDescription) {
                alert('请输入简介');
                return;
            }
            this.saveAlgorithmSettings();
            axios.post('/SchemeDemoAdmin/update', this.scheme)
                .then(() => {
                    if (this.tempSetting.length) {
                        for (let i = 0; i < this.tempSetting.length; i++) {
                            this.p[i].procedureSettingData = '{"data":"' + this.tempSetting[i].data + '","selected":"' + this.tempSetting[i].selected + '"}';
                        }
                        axios.post('/schemeProcedureDemoAdmin/update', this.p)
                            .then(() => {

                            })
                            .catch(err => {
                                console.log(err);
                            });
                    }
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //删除方案信息
        deleteEData(id) {
            axios.post('/SchemeDemoAdmin/delete/' + id)
                .then(() => {
                    axios.post('/schemeProcedureDemoAdmin/delete/' + id);
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //清空数据
        clearEData() {
            this.scheme.schemeId = '';
            this.scheme.schemeName = '';
            this.scheme.schemeDescription = '';
            this.scheme.schemeRemark = '';
            this.scheme.algorithmId = '';
            this.scheme.algorithmName = '';
            this.scheme.algorithmParameterDemoAdmin = [];
            this.procedure.schemeId = '';
            this.procedure.procedureName = '';
            this.procedure.schemeProcedureId = '';
            this.procedure.procedureSettingData = '';
            this.procedures = '';
        },
        //获得所有算法和方案提供方案选择
        getIdAndName() {
            axios.get('/AlgorithmInfoDemoAdmin/findAllIdAndName')
                .then(resp => {
                    this.Ealgorithms = resp.data
                })
                .catch(err => {
                    console.log(err);
                });
            axios.get('/SchemeDemoAdmin/findAllIdAndName')
                .then(resp => {
                    this.datasets = resp.data
                })
                .catch(err => {
                    console.log(err);
                });
        },
        check(i) {
            if (event.target.checked) {
                this.tempSetting[i].selected = 'true';
            } else {
                this.tempSetting[i].selected = 'false';
            }
        },
        changeProduct(event, index) {
            this.tempSetting[index].data = event.target.value; //获取option对应的value值
        },
        changeDisabled: function (event, name) {
            if ($(event.srcElement).prop("checked")) {
                $("select[name=" + name + "]").removeAttr("disabled");
            } else {
                $("select[name=" + name + "]").attr("disabled", "disabled");
            }
        },
        appendInfo: function (event, algorithmName, parameterName) {
            if (event.target.value == 'Choose...') {
                hub.$emit('optionName', algorithmName + parameterName);
            } else {
                hub.$emit('optionName', event.target.value);
            }
        },
        saveAlgorithmSettings() {
            let parameters = this.parameterList[this.scheme.algorithmId];
            if (parameters != null) {
                for (let i = 0; i < parameters.length; i++) {
                    let nameTemp = this.scheme.algorithmName + parameters[i].parameterName;
                    let value = null;
                    switch (parameters[i].parameterSettingInfo.type) {
                        case 'text':
                            let temp = $("input[name=" + nameTemp + "]").val();
                            if (temp == '') {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = 'null';
                            } else {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = $("input[name=" + nameTemp + "]").val();
                            }
                            this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = 'null';
                            break;
                        case 'selection':
                            let paramInput = $("select[name=" + nameTemp + "]").val();
                            value = paramInput;
                            if (parameters[i].parameterSettingInfo.optionExtra[paramInput] != null) {
                                let value2 = null;
                                switch (parameters[i].parameterSettingInfo.optionExtra[paramInput].type) {
                                    case 'text':
                                        this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = $("input[name=" + nameTemp + paramInput + "]").val();
                                        this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = value;
                                        break;
                                    case 'selection':
                                        value2 = $("select[name=" + nameTemp + paramInput + "]").val();
                                        this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = value2;
                                        this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = value;
                                        break;
                                }
                            } else {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = 'null';
                                if (value == 'Choose...') {
                                    this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = 'null';
                                } else {
                                    this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = value;
                                }
                            }
                            break;
                        case 'radio':
                            value = $("input[name=" + nameTemp + "]:checked").val();
                            this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = 'null';
                            if (value === undefined) {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = 'null';
                            } else {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = value;
                            }
                            break;
                        case 'checkbox':
                            let listTemp = [];
                            $("input[name=" + nameTemp + "]:checked").each(function () {
                                value = $(this).val();
                                listTemp.push(value);
                            });
                            this.scheme.algorithmParameterDemoAdmin[i].parameterInputValue = 'null';
                            if (listTemp.length == 0) {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = 'null';
                            } else {
                                this.scheme.algorithmParameterDemoAdmin[i].parameterOptionValue = JSON.stringify(listTemp);
                            }
                    }
                }
            }
        },
        find(algo) {
            $('#search-input').val(algo);
            //触发一下该input的input事件
            $('#search-input')[0].dispatchEvent(new Event('input'));
        },
        show() {
            $('[data-toggle="popover"]').popover();
        },
        hide() {
            $('.toast').remove()
            document.cookie = 'isClose';
        },
        removeSymbol(x) {
            if (x != null)
                return x.replace(/\"/g, "");
            return x;
        },
        conversion(x) {
            return x == 'data' ? '该步骤还没设置呢！' : x;
        },
        //
        setDataPopover:function(){
            $(document).ready(function(){
                $('[data-toggle="popover"]').popover();
            });
        },
        currentTag: function (event) {
            sessionStorage.setItem('currentTag',event.target.id);
        },
        //获得所有算法信息
        getEData() {
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
            axios.get('/AlgorithmInfoDemoAdmin/getAlgorithmInfo/'+id)
                .then(resp => {
                    this.info.algorithmId = _id;
                    this.info.algorithmName = resp.data.algorithmName;
                    this.info.algorithmPaperLink = resp.data.algorithmPaperLink;
                    this.info.algorithmPaperReference = resp.data.algorithmPaperReference;
                    this.info.algorithmDescription = resp.data.algorithmDescription;
                    this.info.algorithmCallInterface = resp.data.algorithmCallInterface;
                    this.info.algorithmNameMapper = resp.data.algorithmNameMapper;
                    this.info.algorithmCallHost = resp.data.algorithmCallHost;
                    this.info.algorithmUsage = resp.data.algorithmUsage;
                    this.info.algorithmCallExchange = resp.data.algorithmCallExchange;
                    this.info.algorithmCallExecutionConnectRoutingkey = resp.data.algorithmCallExecutionConnectRoutingkey;
                    this.info.algorithmCallExecutionSendRoutingkey = resp.data.algorithmCallExecutionSendRoutingkey;
                    this.info.algorithmCallDemoRoutingkey = resp.data.algorithmCallDemoRoutingkey;
                    this.info.algorithmCallPort = resp.data.algorithmCallPort;
                    this.info.algorithmCallUsername = resp.data.algorithmCallUsername;
                    this.info.algorithmCallPassword = resp.data.algorithmCallPassword;
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
        //确认第二个参数类型
        confirmSecondParameterType:function(n,m){
            if(m >= this.paramValuesNumber[n-1]){
                // this.parameterInfo.firstParameterVales[n-1]=this.firstParameterValue;
                // this.firstParameterValue=[];
                this.secondParameterType=this.secondParameterTypes[n-1];
                this.parameterInfo.secondParameterTypes[n-1]=this.secondParameterType;
                this.secondParameterType=[];
                console.log(this.parameterInfo.secondParameterTypes[n-1])
                console.log("改方法调用了")
            }
            if (this.secondParameterTypes[n-1][m-1] !== 'selection'){
                this.secondParameterValues[n-1][m-1]="default";
                this.secondAlgorithmParameterValues[n-1][m-1]="default";
            }
            if(this.secondParameterTypes[n-1][m-1] !== 'selection' && m >= this.paramValuesNumber[n-1] ){
                this.secondParameterValue=this.secondParameterValues[n-1]
                this.parameterInfo.secondParameterValues[n-1]=this.secondParameterValue;
                this.secondParameterValue=[];
                this.secondAlgorithmParameterValue=this.secondAlgorithmParameterValues[n-1];
                this.parameterInfo.secondAlgorithmParameterValues[n-1]=this.secondAlgorithmParameterValue;
                this.secondAlgorithmParameterValue=[];
                console.log("调用了该方法")
            }

        },
        //确认第二个参数web层的值跟类型
        confirmSecondParameterValue:function (n,m) {
            if(m >= this.paramValuesNumber[n-1]){
                // this.parameterInfo.firstParameterVales[n-1]=this.firstParameterValue;
                // this.firstParameterValue=[];
                this.secondParameterValue=this.secondParameterValues[n-1]
                this.parameterInfo.secondParameterValues[n-1]=this.secondParameterValue;
                this.secondParameterValue=[];
                console.log(this.parameterInfo.secondParameterTypes[n-1])
                console.log("改方法调用了")
            }
        },
        confirmFirstValue:function (n,m) {
            if(m >= this.paramValuesNumber[n-1]){
                this.firstParameterValue=this.firstParameterValues[n-1];
                this.parameterInfo.firstParameterVales[n-1]=this.firstParameterValue;
                this.firstParameterValue=[];
                console.log("改方法调用了")
            }
        },
        confirmFirstAlgorithmValue:function (n,m) {
            if(m >= this.paramValuesNumber[n-1]){
                this.firstAlgorithmParameterValue=this.firstAlgorithmParameterValues[n-1];
                this.parameterInfo.firstAlgorithmParameterValues[n-1]=this.firstAlgorithmParameterValue;
                this.firstAlgorithmParameterValue=[];
                console.log("改方法调用了")
            }
        }
        ,
        confirmSecondAlgorithmParameterValue:function(n,m){
            if(m >= this.paramValuesNumber[n-1]){
                this.secondAlgorithmParameterValue=this.secondAlgorithmParameterValues[n-1];
                this.parameterInfo.secondAlgorithmParameterValues[n-1]=this.secondAlgorithmParameterValue;
                this.secondAlgorithmParameterValue=[];
                console.log("改方法调用了")
            }
        },
        putAlgorithmId:function (algorithmId) {
            this.algorithmId=algorithmId
        },
        updateParameter:function (parameterId) {
            this.updateParameterInfo.parameterId=parameterId;
            axios.post('/updateParameter',this.updateParameterInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })

        },
        deleteParameter:function (parameterId) {
            this.deleteParameterInfo.parameterId=parameterId
            axios.post('/deleteParameter',this.deleteParameterInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        deleteProcedureSetting:function (procedureSettingId) {
            this.deleteProcedureSettingInfo.id=procedureSettingId
            axios.post('/deleteProcedureSetting',this.deleteProcedureSettingInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        setUpdateParameterInfo: function (parameter) {
            this.updateParameterInfo=parameter;
        },
        setUpdateProcedureInfo:function (procedureSetting) {
            this.procedureSettingInfo=procedureSetting;
        }

    },
    computed: {
        //算法方案搜索功能
        EfilterInfo: function () {
            var dataset_array = this.schemes,
                searchString = this.EsearchString;

            if (!searchString) {
                return dataset_array;
            }

            searchString = searchString.trim().toLowerCase();

            dataset_array = dataset_array.filter(function (item) {
                if (item.algorithmName.toLowerCase().indexOf(searchString) !== -1) {
                    return item;
                }
            });

            return dataset_array;
        },
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

Vue.component('append', {
    props: ['scheme', 'param'],
    data: function () {
        return {
            optionName: ''
        }
    },
    template: `
                <div class="input-group form-row" v-if="optionName!=''&&param.parameterSettingInfo.optionExtra[optionName]!=null?param.parameterSettingInfo.optionExtra[optionName].type=='selection':false">
                    <label :for="scheme.algorithmName+param.parameterName+'Basic'+optionName" class="col-3 align-content-center">{{optionName}}</label>
                    <select class="custom-select col-9" :name="scheme.algorithmName+param.parameterName+optionName" :id="scheme.algorithmName+param.parameterName+'Basic'+optionName">
                        <option selected value="Choose...">Choose...</option>
                        <option v-for="option in param.parameterSettingInfo.optionExtra[optionName].options" :value="option">{{option}}</option>
                    </select>
                </div>
                <div class="input-groupv form-row"v-else-if="optionName!=''&&param.parameterSettingInfo.optionExtra[optionName]!=null?param.parameterSettingInfo.optionExtra[optionName].type=='text':false">
                    <label :for="scheme.algorithmName+param.parameterName+'Basic'+optionName" class="col-3 align-content-center">{{optionName}}</label>
                    <input type="text" class="form-control col-9" :id="scheme.algorithmName+param.parameterName+'Basic'+optionName" :name="scheme.algorithmName+param.parameterName+optionName">
                </div>
                <div v-else></div>
        `,
    mounted: function () {
        hub.$on('optionName', (val) => {
            if (val == (this.scheme.algorithmName + this.param.parameterName)) {
                this.optionName = '';
            } else {
                if (this.param.parameterSettingInfo.optionExtra != null) {
                    for (key in this.param.parameterSettingInfo.optionExtra) {
                        if (key == val && this.param.parameterSettingInfo.optionExtra[key] != null) {
                            this.optionName = val;
                        }
                        if (key == val && this.param.parameterSettingInfo.optionExtra[key] == null) {
                            this.optionName = '';
                        }
                    }
                }
            }
        })
    }
});
