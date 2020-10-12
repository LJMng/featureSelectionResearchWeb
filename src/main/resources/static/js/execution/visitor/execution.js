Vue.component('append',{
    props: ['algorithm','param'],
    data: function() {
        return {
            optionName: ''
        }
    },
    template: `
                <div class="input-group form-row" v-if="optionName!=''&&param.parameterSettingInfo.optionExtra[optionName]!=null?param.parameterSettingInfo.optionExtra[optionName].type=='selection':false">
                    <label :for="algorithm.algorithmName+param.parameterName+'Basic'+optionName" class="col-3 align-content-center">{{optionName}}</label>
                    <select class="custom-select col-9" :name="algorithm.algorithmName+param.parameterName+optionName" :id="algorithm.algorithmName+param.parameterName+'Basic'+optionName">
                        <option selected value="Choose...">Choose...</option>
                        <option v-for="option in param.parameterSettingInfo.optionExtra[optionName].options" :value="option">{{option}}</option>
                    </select>
                </div>
                <div class="input-groupv form-row"v-else-if="optionName!=''&&param.parameterSettingInfo.optionExtra[optionName]!=null?param.parameterSettingInfo.optionExtra[optionName].type=='text':false">
                    <label :for="algorithm.algorithmName+param.parameterName+'Basic'+optionName" class="col-3 align-content-center">{{optionName}}</label>
                    <input type="text" class="form-control col-9" :id="algorithm.algorithmName+param.parameterName+'Basic'+optionName" :name="algorithm.algorithmName+param.parameterName+optionName">
                </div>
                <div v-else></div>
        `,
    mounted: function () {
        hub.$on('optionName', (val) => {
            if (val==(this.algorithm.algorithmName+this.param.parameterName)){
                this.optionName = '';
            }else {
                if (this.param.parameterSettingInfo.optionExtra!=null) {
                    for (key in this.param.parameterSettingInfo.optionExtra){
                        if (key == val && this.param.parameterSettingInfo.optionExtra[key]!=null){
                            this.optionName = val;
                        }
                        if (key == val && this.param.parameterSettingInfo.optionExtra[key]==null){
                            this.optionName = '';
                        }
                    }
                }
            }
        })
    }
});
var hub = new Vue();
var app = new Vue({
    el: '#app',
    data: {
        //------------------public-----------------
        algorithmList: {},
        parameterList: {},
        datasetList: {},
        ProcedureSettingsList: {},
        file_suffix: ['.csv','.xlsx','.xls'],
        dataset_info_p1: '',
        dataset_info_p2: '',
        dataset_info_p3: '',
        dataset_info_p4: '',
        dataset_info_p5: '',
        dataset_info_p6: '',
        dataset_info_p7: '',
        modal_btn_close: '',
        modal_btn_save: '',
        modal_btn_confirm: '',
        modal_btn_cancel: '',
        modal_btn_submit: '',
        dataset_pages: 0,
        dataset_page_num: 0,
        dataset_current_page: 1,
        dataset_list_page: [],
        language: '',
        //------------------HeaderNav-----------------
        navHead_li1: '',
        navHead_li2: '',
        navHead_li3: '',
        navHead_btn1: '',
        navHead_btn2: '',
        //------------------BodyNav-----------------
        navBody_a1: '',
        navBody_a2: '',
        navBody_a3: '',
        navBody_a4: '',
        navBody_a5: '',
        //------------------HomeContext-----------------
        home_text: '',
        home_title: '',
        home_ul1: '',
        home_ul1_li1: '',
        home_ul1_li2: '',
        home_ul1_li3: '',
        home_ul1_li4: '',
        home_ul2: '',
        home_ul2_li1: '',
        home_ul2_li2: '',
        home_ul2_li3: '',
        home_ul2_li4: '',
        //------------------AlgorithmsContext-----------------
        algorithms_filter: '',
        algorithms_search: '',
        algorithms_filter1: '',
        algorithms_filter2: '',
        algorithms_filter3: '',
        algorithms_info_how: '',
        algorithms_info_intro: '',
        algorithms_info_papers: '',
        algorithms_info_parameter: '',
        algorithms_info_title: '',
        search: '',
        algorithms_info_how_context: '',
        algorithms_info_how_img: '',
        algorithms_info_parameter_li1: '',
        algorithms_info_parameter_li2: '',
        algorithms_info_parameter_footer: '',
        //------------------PublicDatasetContext-----------------
        dataset_temp: {},
        dataset_form_name: '',
        dataset_form_source: '',
        dataset_form_description: '',
        dataset_form_preprocessing: '',
        dataset_form_record: '',
        dataset_form_dimension: '',
        dataset_form_tag: '',
        dataset_form_type: '',
        dataset_forms: {},
        public_dataset_upload_title1: '',
        public_dataset_upload_label1: '',
        public_dataset_upload_label2: '',
        public_dataset_upload_label3: '',
        public_dataset_check_title1: '',
        public_dataset_check_th1: '',
        public_dataset_intro_btn1: '',
        public_dataset_intro_btn2: '',
        public_dataset_intro_p1: '',
        public_dataset_intro_title: '',
        public_dataset_list_btn1: '',
        //------------------NewTaskContext-----------------
        task_dataset: 0,
        task_dataset_info: {},
        algorithm_info_temp: {},
        password: '',
        params: null,
        task_email: '',
        task_name: '',
        task_description: '',
        task_algorithm_id: -1,
        email_check: true,
        new_task_navbar_a1: '',
        new_task_navbar_a2: '',
        new_task_navbar_a3: '',
        new_task_step_btn1: '',
        new_task_step3_feedback2: '',
        new_task_step3_feedback1: '',
        new_task_step3_card_label4: '',
        new_task_step3_card_label3: '',
        new_task_step3_card_label2: '',
        new_task_step3_card_label1: '',
        new_task_step3: '',
        new_task_step2_feedback1: '',
        new_task_step2_card_p1: '',
        new_task_step2_card_btn2: '',
        new_task_step2_card_btn1: '',
        new_task_step2: '',
        new_task_step1_select_default: '',
        new_task_step1_label2: '',
        new_task_step1_label1: '',
        new_task_step1_feedback2: '',
        new_task_step1_feedback1: '',
        new_task_step1: '',
        new_task_navbar_a3: '',
        new_task_navbar_a2: '',
        new_task_navbar_a1: '',
        algorithm_setting1: '',
        algorithm_setting2: '',
        algorithm_setting_btn1: '',
        algorithm_setting_save: '',
        new_task_step1_btn1: '',
        new_task_step1_h1: '',
        new_task_step1_h2: '',
        new_task_step1_p1: '',
        new_task_step1_a1: '',
        //------------------QueryTaskContext-----------------
        task_list: [],
        temp_task_info: {},
        update_task_comment: '',
        update_task_name: '',
        update_task_email: '',
        query_task_table_th1: '',
        query_task_table_th2: '',
        query_task_table_th3: '',
        query_task_table_th4: '',
        query_task_table_th5: '',
        query_task_delete_warning: '',
        query_task_delete_context: '',
        query_task_chart_title: '',
        //------------------LoginModal-----------------
        logintitle: '',
        accounttitle: '',
        passwordtitle: '',
        notaccount: '',


    },
    created: function () {
        /*
        * 根据存储语言选择信息的cookie获取页面元素内容
        * */
        axios.get('/htmlElements').then((response) => {
            for (let i = 0; i < response.data.length; i++) {
                for (item in this._data){
                    if (response.data[i].moduleKey==item){
                        if($.cookie("language")=='ch'){
                            this.$set(this._data,item,response.data[i].chValue);
                            this.language='ch';
                        }else {
                            this.$set(this._data,item,response.data[i].enValue);
                            this.language='en';
                        }
                    }
                }
            }
            let account = $.cookie("account")
            if (account != null && account != ''){
                $('#loginButton').text(account);
                $('#signOutButton').removeClass('d-none');
            } else {
                $('#loginButton').text(this.navHead_btn1);
                $('#signOutButton').addClass('d-none');
            }
        });
        axios.get('/execution/getAlgorithmsList').then((response) => {
            this.algorithmList=response.data;
        });
        axios.get('/execution/getParameterList').then((response) => {
            let params = response.data;
            for (let key in params){
                for (let i = 0; i < params[key].length; i++) {
                    try {
                        params[key][i].parameterSettingInfo = JSON.parse(params[key][i].parameterSettingInfo);
                    } catch (e) {
                    }
                }
            }
            this.parameterList=params;
        });
        axios.get('/execution/getDatasetList').then((response) => {
            this.datasetList=response.data;
            this.dataset_page_num = 3;
            let keys = Object.keys(this.datasetList);
            let totals = keys.length;
            this.dataset_pages = Math.floor(totals/this.dataset_page_num)+1;
            this.dataset_list_page = keys.slice(0, this.dataset_page_num);
        });
        axios.get('/execution/getProcedureSettingsList').then((response) => {
            this.ProcedureSettingsList = response.data;
        })
        let param = new URLSearchParams();
        param.append("accountId",$.cookie('accountId'));
        axios.post('/execution/getTaskListByAccountId',param).then((response) => {
            this.task_list=response.data;
        });
    },
    methods: {
        goPublicDataset: function () {
            $('#nav-dataset-tab').addClass('show');
            $('#nav-dataset-tab').addClass('active');
            $('#nav-dataset-tab').attr('aria-selected', 'true');
            $('#nav-dataset').addClass('show');
            $('#nav-dataset').addClass('active');
            $('#nav-new-tab').removeClass('show');
            $('#nav-new-tab').removeClass('active');
            $('#nav-new-tab').attr('aria-selected', 'false');
            $('#nav-new').removeClass('show');
            $('#nav-new').removeClass('active');

        },
        changeDatasetListPage: function(currentPage, action) {
            if (action==1) {
                this.dataset_list_page = Object.keys(this.datasetList).slice(currentPage*3, currentPage*3+3);
            } else if (action==0){
                this.dataset_list_page = Object.keys(this.datasetList).slice(currentPage*3-3, currentPage*3);
            } else {
                this.dataset_list_page = Object.keys(this.datasetList).slice(currentPage*3-6, currentPage*3-3);
            }
        },
        nextDatasetPage: function (event) {
            if (this.dataset_current_page < this.dataset_pages) {
                this.changeDatasetListPage(this.dataset_current_page, 1);
                this.dataset_current_page = this.dataset_current_page + 1;
            }
        },
        previousPage: function (event) {
            if (this.dataset_current_page > 1) {
                this.changeDatasetListPage(this.dataset_current_page, -1);
                this.dataset_current_page = this.dataset_current_page - 1;
            }
        },
        goDatasetPage: function (index) {
            this.changeDatasetListPage(index, 0);
            this.dataset_current_page = index;
        },
        currentTag: function (event) {
            if ($.cookie('account') == null) {
                // TODO
                alert('Please login in first');
                sessionStorage.setItem('currentTag','nav-home-tab');
                window.location.href = '/accountLogin';
            } else {
                sessionStorage.setItem('currentTag',event.target.id);
            }
        },
        searchAlgorithm: function (event) {
            $('#v-pills-tab').children().each((index,element) => {
                if (!($(element).text().trim().toLowerCase().indexOf(this.search.toLowerCase())>=0)){
                    $(element).addClass("d-none");
                }else {
                    $(element).removeClass("d-none");
                }
            });
        },
        tipLoader: function (event) {
            $('[data-toggle="tooltip"]').tooltip();
        },
        getDatasetInfo: function (key) {
            this.dataset_temp=this.datasetList[key];
        },
        submitDatasetForm: function () {
            let ifCorrect = true;
            let checks = $("div[name='datasetFormCheck']");
            for (let j = 0; j < checks.length; j++) {
                if ($(checks[j]).css('display')!='none'){
                    ifCorrect = false;
                    break;
                }
            };
            if(this.dataset_form_name=='' || this.$refs.inputDataset.files[0]==null){
                ifCorrect = false;
            };
            if(this.dataset_form_description=='' || this.dataset_form_dimension=='' ||
                this.dataset_form_preprocessing=='' || this.dataset_form_record=='' ||
                this.dataset_form_source=='' || this.dataset_form_tag=='' ||
                this.dataset_form_type=='') {
                ifCorrect = false;
            }
            if (ifCorrect){
                let datasetForm = new FormData();
                datasetForm.append("accountId",$.cookie('accountId'));
                datasetForm.append("inputName",this.dataset_form_name);
                datasetForm.append("inputHref",this.dataset_form_source);
                datasetForm.append("inputDescription",this.dataset_form_description);
                datasetForm.append("inputPreprocess",this.dataset_form_preprocessing);
                datasetForm.append("inputRecord",this.dataset_form_record);
                datasetForm.append("inputDimension",this.dataset_form_dimension);
                datasetForm.append("inputTag",this.dataset_form_tag);
                datasetForm.append("inputType",this.dataset_form_type);
                datasetForm.append("file",this.$refs.inputDataset.files[0]);
                axios.post('/execution/uploadDatasetForm',datasetForm,{
                    'Content-Type':'multipart/form-data'
                }).then((response) => {
                    if (response.data=="success"){
                        $('#formResult').html('' +
                            '<div class="alert alert-success alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                            '  <strong>Submit Success!</strong>You can click \'Check My Uploads\' to Check your uploads\'status anytime.\n' +
                            '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                            '    <span aria-hidden="true">&times;</span>\n' +
                            '  </button>\n' +
                            '</div>');
                    }
                    $('#datasetFormAlert').bind('closed.bs.alert', function () {
                        $('#datasetForm')[0].reset();
                    });
                });
            }else {
                if ($.cookie("language")=='ch'){
                    $('#formResult').html('' +
                        '<div class="alert alert-danger alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                        '  <strong>表单有误！</strong>请检查你的表单\n' +
                        '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                        '    <span aria-hidden="true">&times;</span>\n' +
                        '  </button>\n' +
                        '</div>');

                } else {
                    $('#formResult').html('' +
                        '<div class="alert alert-danger alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                        '  <strong>Error!</strong>Please Check Your Form!\n' +
                        '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                        '    <span aria-hidden="true">&times;</span>\n' +
                        '  </button>\n' +
                        '</div>');
                }

            }
        },
        showFileName: function (event) {
            let originFileName = event.target.files[0].name;
            let suffix = originFileName.substr(originFileName.lastIndexOf("."));
            let showName = null;
            if ((originFileName.length-suffix.length)>=6){
                showName = originFileName.substr(0,6)+"*"+suffix;
            }else {
                showName = originFileName;
            }
            if (this.file_suffix.indexOf(suffix)>-1){
                $(event.srcElement).next().next().css('display','none');
                $(event.srcElement).next().html(showName);

            }else {
                $(event.srcElement).next().next().css('display','block');
                $(event.srcElement).next().html(showName);

            }
        },
        getDatasetForms: function () {
            let param = new URLSearchParams();
            param.append("accountId",$.cookie('accountId'));
            axios.post('/execution/getDatasetForms',param).then((response) => {
                this.dataset_forms = response.data;
            });
        },
        datasetOption: function () {
            if (this.task_dataset!=0){
                this.dataset_temp=this.datasetList[this.task_dataset];
                $('#taskDatasetInfo').removeClass("d-none");
                $('#taskDatasetInfo').addClass("d-block");
                $('#datasetFile').attr("disabled","disabled");
                $('#taskDatasetFeedback').addClass('invisible');
            }else{
                this.dataset_temp={};
                $('#datasetFile').removeAttr("disabled","disabled");
                $('#taskDatasetInfo').removeClass("d-block");
                $('#taskDatasetInfo').addClass("d-none");
                $("#datasetFileLabel2").html($('#datasetFile')[0].files[0].name);
                $('#datasetSelect').attr("disabled","disabled");
            }
            $('#taskDatasetFeedback').addClass('invisible');
        },
        getAlgorithmInfo: function (key) {
            this.algorithm_info_temp=this.algorithmList[key];
            $('[data-toggle="popover"]').popover();
        },
        submitTaskForm: function() {
            let ifCorrect = true;
            let checks = $("div[name='taskFormCheck']");
            for (let j = 0; j < checks.length; j++) {
                if ($(checks[j]).css('display')!='none'){
                    ifCorrect = false;
                    break;
                }
            }
            if (this.task_name==''){
                $('#taskName').addClass('border-danger');
                ifCorrect = false;
            }
            if (this.email_check == true) {
                if (this.task_email==''){
                    $('#email').addClass('border-danger');
                    ifCorrect = false;
                }
            }
            if (this.task_dataset==0 && this.$refs.taskDataset.files[0]==null){
                $('#taskDatasetFeedback').removeClass('invisible');
                ifCorrect = false;
            }
            if (this.params==null) {
                $('#algorithmSelectFeedback').removeClass('invisible');
                ifCorrect = false;
            }
            if (ifCorrect) {
                let taskForm = new FormData();
                taskForm.append("accountId",$.cookie('accountId'));
                taskForm.append("taskName",this.task_name);
                taskForm.append("taskComment",this.task_description);
                taskForm.append("algorithmId",this.task_algorithm_id);
                taskForm.append("taskEmail",this.task_email);
                taskForm.append("algorithmParameters",JSON.stringify(this.params));
                taskForm.append("datasetId",this.task_dataset);
                taskForm.append("file",this.$refs.taskDataset.files[0]);
                axios.post('/execution/uploadTaskForm',taskForm,{
                    'Content-Type':'multipart/form-data'
                }).then((response) => {
                    let param2 = new URLSearchParams();
                    param2.append("accountId",$.cookie('accountId'));
                    axios.post('/execution/getTaskListByAccountId',param2).then((response) => {
                        this.task_list=response.data;
                    });
                    $('#taskFormResult').html('<div class="alert alert-success alert-dismissible fade show" role="alert" id="taskFormAlert">' +
                        'Submit Success!Your task id is <strong>'+response.data+'</strong>'+'<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
                    $('#taskFormAlert').bind('closed.bs.alert', function () {
                        $('#datasetForm')[0].reset();
                    });
                });
            } else {
                if ($.cookie("language")=='ch') {
                    $('#taskFormResult').html('' +
                        '<div class="alert alert-danger alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                        '  <strong>错误！</strong>请检查你的表单！\n' +
                        '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                        '    <span aria-hidden="true">&times;</span>\n' +
                        '  </button>\n' +
                        '</div>');
                } else {
                    $('#taskFormResult').html('' +
                        '<div class="alert alert-danger alert-dismissible fade show" role="alert" id="datasetFormAlert">\n' +
                        '  <strong>Error!</strong>Please Check Your Form!\n' +
                        '  <button type="button" class="close" data-dismiss="alert" aria-label="Close">\n' +
                        '    <span aria-hidden="true">&times;</span>\n' +
                        '  </button>\n' +
                        '</div>');
                }

            }
        },
        datasetNameCheck: function (event) {
            axios.get('/execution/queryDatasetName',{
                params: {
                    datasetName: $.trim(event.target.value)
                }
            }).then(response => {
                if (response.data=="exist"){
                    $(event.srcElement).next().css('display','block');
                }else {
                    $(event.srcElement).next().css('display','none');
                }
            });
        },
        emailCheck: function (event) {
            let myreg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
            if (myreg.test(event.target.value)) {
                $(event.srcElement).removeClass('border-danger');
                $(event.srcElement).next().css('display','none');
            }else {
                $(event.srcElement).addClass('border-danger');
                $(event.srcElement).next().css('display','block');
            }
        },
        taskNameCheck: function (event) {
            if (this.task_name!=''){
                $(event.srcElement).removeClass('border-danger');
            }
            axios.get('/execution/queryTaskName',{
                params: {
                    taskName: $.trim(event.target.value),
                    accountId: $.cookie('accountId')
                }
            }).then(response => {
                if (response.data=="exist"){
                    $(event.srcElement).next().css('display','block');
                    $(event.srcElement).addClass('border-danger');
                }else {
                    $(event.srcElement).next().css('display','none');
                    $(event.srcElement).removeClass('border-danger');
                }
            });
        },
        queryTaskInfo: function (task) {
            this.temp_task_info = task;
            this.update_task_name = task.taskName;
            this.update_task_email = task.taskEmail;
            this.update_task_comment = task.taskComment;
            let checks = $("div[name='updateTaskCheck']");
            for (let i = 0; i < checks.length; i++) {
                $(checks[i]).css('display','none');
                $(checks[i]).prev().removeClass('border-danger');
            }
        },
        updateTask: function (task) {
            if (task.taskStatus!="排队中") {
                alert("The task is not in queue and it can't be updated");
            }else {
                let form = new FormData();
                form.append('taskId',this.temp_task_info.taskId);
                form.append('taskName',this.update_task_name);
                form.append('taskEmail',this.update_task_email);
                form.append('taskComment',this.update_task_comment);
                axios.post('/execution/updateTask',form).then((response) => {
                    if (response.data=="success"){
                        let param2 = new FormData();
                        param2.append("accountId",$.cookie('accountId'));
                        axios.post('/execution/getTaskListByAccountId',param2).then((response2) => {
                            this.task_list=response2.data;
                        });
                        if ($.cookie("language")=='ch'){
                            $('#updateResult').html("成功！");
                        } else {
                            $('#updateResult').html("Success！");
                        }
                        $('#updateResult').addClass("text-success");
                    }
                });
            }
        },
        deleteTask: function (event,task) {
            let param = new FormData();
            param.append("taskId",task.taskId);
            axios.post('/execution/deleteTask',param).then((response) => {
                let param2 = new FormData();
                param2.append("accountId",$.cookie('accountId'));
                axios.post('/getTaskListByAccountId',param2).then((response2) => {
                    this.task_list=response2.data;
                });
            });
            $('#deleteFeedback').next().css('display','none');
            $('#deleteFeedback').next().next().css('display','none');
            if ($.cookie("language")=="ch"){
                $('#deleteFeedback').html("<div class='text-success'>成功！</div>");
            }else{
                $('#deleteFeedback').html("<div class='text-success'>Success!</div>");
            }
            /*setTimeout(function () {
                window.location.reload();
            },1000);*/

        },
        getTaskEcharts: function (task) {
            this.temp_task_info = task;
            $("#taskEchartsBody").empty();
            axios.get('/execution/getTaskResult',{
                params: {
                    taskId: task.taskId
                }
            }).then((response) => {
                let TaskFormat = response.data;
                let datasetDimension = TaskFormat.datasetDimension;
                let resultList = TaskFormat.resultList;
                for (let i = 0;i<resultList.length;i++){
                    $("#taskEchartsBody").append('<div style="height: 300px;width: 400px;margin: 0 auto" id="task' + task.taskId + 'Result' + i + '"></div>');
                    let myChart = echarts.init(document.getElementById('task' + task.taskId + 'Result' + i));
                    let objKey = ["Reduct", "NotReduct"];
                    let values = [{value: resultList[i].length, name: "Reduct"}, {value: datasetDimension- resultList[i].length, name: "NotReduct"}];
                    let option = {
                        title: {
                            text: 'Result' + (i + 1),
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{b}: {c}({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 10,
                            data: objKey
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['50%', '70%'],
                                avoidLabelOverlap: false,
                                label: {

                                        show: true,
                                        position: 'inside',
                                        formatter: '{b}: {c}({d}%)',//模板变量有 {a}、{b}、{c}、{d}，分别表示系列名，数据名，数据值，百分比。{d}数据会根据value值计算百分比

                                        textStyle : {
                                            align : 'center',
                                            baseline : 'middle',
                                            fontFamily : '微软雅黑',
                                            fontSize : 15,
                                            fontWeight : 'bolder'
                                        }

                                },
                                emphasis: {
                                    label: {
                                        show: true,
                                        fontSize: '30',
                                        fontWeight: 'bold'
                                    }
                                },
                                labelLine: {
                                    show: false
                                },
                                data: values
                            }
                        ]
                    };
                    myChart.setOption(option);
                }
            });
        },
        downLoadResultFile: function (task){
            if (task.taskStatus!='排队中') {
                axios.get('/execution/getTaskResult',{
                    params: {
                        taskId: task.taskId
                    }
                }).then((response) => {
                    let TaskFormat = response.data;
                    let datasetDimension = TaskFormat.datasetDimension;
                    let resultList = TaskFormat.resultList;
                    let resultString = "";
                    for (let i = 0; i < resultList.length; i++) {
                        resultString = resultString + "Result" + (i+1) + ": [" +resultList[i].toString() + ']\n';
                    }
                    var aTag = document.createElement('a');
                    var blob = new Blob([resultString],{endings: "native"});
                    aTag.download = "result.txt";
                    aTag.href = URL.createObjectURL(blob);
                    aTag.click();
                    URL.revokeObjectURL(blob);
                });
            } else {
                if (this.language=='en') {
                    alert(task.taskName+" is not completed");
                } else {
                    alert(task.taskName+"结果下载失败，任务未完成");
                }
            }

        },
        myAlert: function (msg) {
            if ($.cookie("language")=='ch'){
                alert(msg+'当前状态不可修改');
            }else {
                alert(msg+' is not in queue and it can not be updated');
            }
        },
        saveAlgorithmSettings: async function (event, algorithm) {
            let paramSet = {basic: {}, procedure: {}};
            let parameters = this.parameterList[algorithm.algorithmId];
            let procedureSettings = this.ProcedureSettingsList[algorithm.algorithmId];
            if (parameters != null) {
                for (let i = 0; i < parameters.length; i++) {
                    let nameTemp = algorithm.algorithmName + parameters[i].parameterName;
                    let value = null;
                    switch (parameters[i].parameterSettingInfo.type) {
                        case 'text':
                            paramSet.basic[parameters[i].parameterNameMapper] = {input: $("input[name=" + nameTemp + "]").val(), option: null};
                            break;
                        case 'selection':
                            let paramInput = $("select[name=" + nameTemp + "]").val();
                            await axios.get('/execution/getParamValue' + '/' + algorithm.algorithmId + '/' + parameters[i].parameterId + '/' + paramInput).then(function (response) {
                                value = response.data;
                            });
                            if (parameters[i].parameterSettingInfo.optionExtra !=null&&parameters[i].parameterSettingInfo.optionExtra[paramInput] != null) {
                                let value2 = null;
                                switch (parameters[i].parameterSettingInfo.optionExtra[paramInput].type) {
                                    case 'text':
                                        paramSet.basic[parameters[i].parameterNameMapper] = {
                                            option: value,
                                            input: $("input[name=" + nameTemp + paramInput + "]").val()
                                        };
                                        break;
                                    case 'selection':
                                        await axios.get('/execution/getParamValue' + '/' + algorithm.algorithmId + '/' + parameters[i].parameterId + '/' + paramInput + '/' + $("select[name=" + nameTemp + paramInput + "]").val()).then((response) => {
                                            value2 = response.data;
                                        });
                                        paramSet.basic[parameters[i].parameterNameMapper] = {
                                            option: value,
                                            input: value2
                                        };
                                        break;
                                }
                            } else {
                                paramSet.basic[parameters[i].parameterNameMapper] = {input: null, option: value};
                            }
                            break;
                        case 'radio':
                            await axios.get('/execution/getParamValue' + '/' + algorithm.algorithmId + '/' + parameters[i].parameterId + '/' + $("input[name=" + nameTemp + "]:checked").val()).then((response) => {
                                value = response.data;
                            });
                            paramSet.basic[parameters[i].parameterNameMapper] = {input: null, option: value};
                            break;
                        case 'checkbox':
                            let listTemp = [];
                            $("input[name=" + nameTemp + "]:checked").each(async function () {
                                await axios.get('/execution/getParamValue' + '/' + algorithm.algorithmId + '/' + parameters[i].parameterId + '/' + $(this).val()).then((response) => {
                                    value = response.data;
                                });
                                listTemp.push(value);
                            });
                            paramSet.basic[parameters[i].parameterNameMapper] = {input: null, option: listTemp};
                    }
                }
            }
            if (procedureSettings != null) {
                for (let i = 0; i < procedureSettings.length; i++) {
                    let value = null;
                    let nameTemp = algorithm.algorithmName + procedureSettings[i].name;
                    if ($("select[name=" + nameTemp + "]").prop("disabled")) {
                        paramSet.procedure[procedureSettings[i].nameMapper] = {data: null, selected: false};
                    } else {
                        await axios.get('/execution/getProcedureValue' + '/' + algorithm.algorithmId + '/' + procedureSettings[i].id + '/' + $("select[name=" + nameTemp + "]").val()).then((response) => {
                            value = response.data;
                        });
                        paramSet.procedure[procedureSettings[i].nameMapper] = {
                            data: value,
                            selected: true
                        };
                    }
                }
            }
            this.params = paramSet;
            this.task_algorithm_id = algorithm.algorithmId;
            if ($.cookie("language") == 'ch') {
                $(event.srcElement).prev().prev().html("成功保存！");
            } else {
                $(event.srcElement).prev().prev().html("Success!");
            }
            setTimeout(function () {
                $(event.srcElement).prev().prev().html("");
            }, 2000);
        },
        changeDisabled: function (event,name) {
            if ($(event.srcElement).prop("checked")) {
                $("select[name="+name+"]").removeAttr("disabled");
            }else {
                $("select[name="+name+"]").attr("disabled","disabled");
            }
        },
        appendInfo: function (event,algorithmName,parameterName) {
            if (event.target.value=='Choose...'){
                hub.$emit('optionName', algorithmName+parameterName);
            }else {
                hub.$emit('optionName', event.target.value);
            }

        },
        setParamDefault: function (algorithm,param) {
            switch (param.parameterSettingInfo.type) {
                case 'text':
                    $("input[name="+algorithm.algorithmName+param.parameterName+"]").val(param.parameterDefaultValue);
                    break;
                case 'selection':
                    $("select[name="+algorithm.algorithmName+param.parameterName+"]").val(param.parameterDefaultValue);
                    hub.$emit('optionName',param.parameterDefaultValue);
                    break;
            }
        },
        setProcedureDefault: function (algorithm,procedure) {
            $("select[name="+algorithm.algorithmName+procedure.name+"]").val(procedure.defaultOption);
        },
        login: function () {
            if ($.cookie("account") == null) {
                $.cookie("loginTo",'execution');
                window.location.href = '/accountLogin';
            }
        },
        cancelSelectedAlgorithm: function () {
            this.task_algorithm_id=-1;
            this.params=null;
        }
    },
    watch: {
        email_check: function (val) {
            if (val==false){
                this.task_email='';
                $('#email').attr("disabled","disabled");
                $('#email').removeClass('border-danger');
                $('#email').next().css('display','none');
            }else{
                $('#email').addClass('border-danger');
                $('#email').removeAttr("disabled","disabled");
            }
        },
        params: function (val) {
            if (val!=null){
                $('#algorithmSelectFeedback').addClass('invisible');
            }
        },
        task_algorithm_id: function (val, oldVal) {
            let lang = $.cookie("language");
            if (val!=-1){
                if (lang=='en'){
                    $("a[data-target='#Algorithm"+val+"Modal']").removeClass('btn-primary').addClass('btn-success').text("Selected Info");
                }else {
                    $("a[data-target='#Algorithm"+val+"Modal']").removeClass('btn-primary').addClass('btn-success').text("已选择算法详情");
                }
                $("a[data-target='#Algorithm"+val+"Modal']").next().removeClass("d-none");
                for (const id in this.algorithmList) {
                    if (id != val) {
                        $("a[data-target='#Algorithm"+id+"Modal']").addClass("disabled");
                    }
                }
            } else {
                if (lang=='en'){
                    $("a[data-target='#Algorithm"+oldVal+"Modal']").removeClass('btn-success').addClass('btn-primary').text("Select");
                }else {
                    $("a[data-target='#Algorithm"+oldVal+"Modal']").removeClass('btn-success').addClass('btn-primary').text("选择算法");
                }
                $("a[data-target='#Algorithm"+oldVal+"Modal']").next().addClass("d-none");
                for (const id in this.algorithmList) {
                    if (id != val) {
                        $("a[data-target='#Algorithm"+id+"Modal']").removeClass("disabled");
                    }
                }
            }
        }
    }
});


$(function () {
    switch (sessionStorage.getItem('currentTag')) {
        case "nav-home-tab":
            $('#nav-home-tab').addClass('show');
            $('#nav-home-tab').addClass('active');
            $('#nav-home-tab').attr('aria-selected', 'true');
            $('#nav-home').addClass('show');
            $('#nav-home').addClass('active');

            break;
        case "nav-algorithms-tab":
            $('#nav-algorithms-tab').addClass('show');
            $('#nav-algorithms-tab').addClass('active');
            $('#nav-algorithms-tab').attr('aria-selected', 'true');
            $('#nav-algorithms').addClass('show');
            $('#nav-algorithms').addClass('active');
            break;
        case "nav-new-tab":
            $('#nav-new-tab').addClass('show');
            $('#nav-new-tab').addClass('active');
            $('#nav-new-tab').attr('aria-selected', 'true');
            $('#nav-new').addClass('show');
            $('#nav-new').addClass('active');
            break;
        case "nav-query-tab":
            $('#nav-query-tab').addClass('show');
            $('#nav-query-tab').addClass('active');
            $('#nav-query-tab').attr('aria-selected', 'true');
            $('#nav-query').addClass('show');
            $('#nav-query').addClass('active');
            break;
        case "nav-dataset-tab":
            $('#nav-dataset-tab').addClass('show');
            $('#nav-dataset-tab').addClass('active');
            $('#nav-dataset-tab').attr('aria-selected', 'true');
            $('#nav-dataset').addClass('show');
            $('#nav-dataset').addClass('active');
            break;
        default:
            $('#nav-home-tab').addClass('show');
            $('#nav-home-tab').addClass('active');
            $('#nav-home-tab').attr('aria-selected', 'true');
            $('#nav-home').addClass('show');
            $('#nav-home').addClass('active');
    }
    $('#deleteTaskConfirm').on('hidden.bs.modal', function (e) {
        $('#deleteFeedback').next().css('display','block');
        $('#deleteFeedback').next().next().css('display','block');
        $('#deleteFeedback').html("");
    });
    deleteTaskConfirm
    $('#updateTaskInfo').on('hidden.bs.modal', function (e) {
        $('#updateResult').html('');
    });
    /**
     * 语言选择
     */
    var sta;
    var lang=$.cookie("language");
    if (lang==null){
        $.cookie("language","en");
        lang="en";
    }
    if (lang=='en'){
        sta=true;
    }else {
        sta=false;
    }
    /**
     * 开关按钮
     */
    $("#language").bootstrapSwitch({
        state: sta,
        onText: "English",
        offText: "中文",
        onColor: "primary",
        offColor: "primary",
        size: "small",
        labelWidth: "15px",
        onSwitchChange: function (event,state) {
            if (state==false){
                $.cookie("language","ch")
                window.location.href='/execution';
            }else {
                $.cookie("language","en")
                window.location.href='/execution';
            }
        }
    });
});