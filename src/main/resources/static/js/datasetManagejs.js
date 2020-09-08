// 上面created与下面$(function(){})的调用顺序自行百度和查看Vue.js文档说明，或者自行尝试
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

})

// var vue_head_navbar_nav = new Vue({
//     el: '#navbar',	// 通过id(="div_id")与上面的div绑定
//     data: {
//     },
//     created: function () {
//         // Vue初始方法，可以自行百度一下相关介绍与用法
//         // 1. 调用js方法获取页面涉及的URL, 赋值到js变量中.
//         //	queryXXXURI();
//         // const pageElements = $.ajax("/htmlElements");
//         axios.get('/htmlElements').then(function(data) {
//             // console.log(data);
//         })
//     }
//
// });

//定义Vue,给页面属性赋值
var vm =new Vue({
    el:'#datasetData',
    data:{
        searchName:"",
        datasetMap:[{"datasetId":123456,"datasetName":"myDataset","datasetDescription":"杩欐槸涓€涓畝鍗曠殑鏁版嵁闆�","datasetCount":100,"datasetSource":"http://localhost:/8080","datasetDimension":15,"datasetFile":"","common":false},{"datasetId":123457,"datasetName":"dataset-9","datasetDescription":"short description","datasetCount":1569,"datasetSource":"www.apache.com","datasetDimension":0,"datasetFile":"/dataset/temp/goodfile.xlsx","common":true},{"datasetId":123458,"datasetName":"dataset-7","datasetDescription":"test","datasetCount":123,"datasetSource":"www.apache.com","datasetDimension":0,"datasetFile":"/dataset/temp/testunpass","common":true},{"datasetId":123459,"datasetName":"dataset-10","datasetDescription":"long description","datasetCount":1234,"datasetSource":"www.apache.com","datasetDimension":0,"datasetFile":"/dataset/temp/newfile.xlsx","common":true},{"datasetId":123460,"datasetName":"dataset-8","datasetDescription":"test","datasetCount":145,"datasetSource":"www.apache.com","datasetDimension":0,"datasetFile":"/dataset/temp/mynewfile.xlsx","common":true}],
        values:"",
        datasetForms:"",
        advice:"put your advice",
        administratorName:'',
        persons:[
            {name:'Tom',age:18},
            {name:'jack',age: 17},
            {name:'Bob',age:19},
            {name:'Rose',age:17}
            ],
        //0代表All,1代表记录数大于100，2代表维度大于100，3代表为公共数据集
        orderType:0,
        checkDatasetName:"",
        checkDatasetDescription:"",
        checkDatasetCount:1,
        checkDatasetSource:"",
        checkDatasetDimension:"",
        checkDatasetRecords:'',
        checkDatasetTag:'',
        checkDatasetType:'',
        checkDatasetPreprocessing:'',

        checked:{checkedDatasetName:"",checkedDatasetDescription:"",checkedDatasetCount:"",checkedDatasetDimension:""},
        datasetInfo:{
            datasetId:1,
            datasetName:'',
            datasetDescription:'',
            datasetSource:'',
            datasetDimension:'',
            datasetIsCommon:true,
            datasetCount:''
        },
        //回显登陆用户名
        administratorLoginName:''

    },
    computed:{
        filterDatasetMap(){
            //取出相关的数据
            const{datasetMap,searchName,orderType}=this
            //过滤获得的属性
            let fdataset;
            //对datasetMap进行过滤
            fdataset=datasetMap.filter(p => p.datasetName.indexOf(searchName)!==-1)
            //再一次筛选
            if(orderType!==0){
                if (orderType===1){
                    fdataset=fdataset.filter(p => p.datasetCount>100)
                }
                if (orderType===2){
                    fdataset=fdataset.filter(p => p.datasetDimension>100)

                }
                if (orderType===3){
                    fdataset=fdataset.filter(p => p.isCommon)

                }
            }
            return fdataset;
        }

    }
    ,
    methods:{
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
                $(event.srcElement).next().removeClass("border-danger");
                $(event.srcElement).next().next().css('display','none');
                $(event.srcElement).next().html(showName);

            }else {
                $(event.srcElement).next().addClass("border-danger");
                $(event.srcElement).next().next().css('display','block');
                $(event.srcElement).next().html(showName);

            }
        },
        setOrderType:function(orderType){
            this.orderType=orderType;
        },
        deleteDataset:function (datasetId) {
            this.datasetInfo.datasetId=datasetId;
            axios.post('/deleteDataset',this.datasetInfo)
            window.location.reload();
        },
        passDatasetForm:function (inputId) {
            axios.get('/passDatasetForm?inputId='+inputId)

            window.location.reload();
        },
        setDatasetInfo:function(dataset){
            this.datasetInfo=dataset;
        },
        unPassDatasetForm:function (inputId,advice,administratorName) {
            axios.get('/unPassDatasetForm?inputId='+inputId+'&advice='+advice+'&administratorName='+administratorName)
            window.location.reload();
        },
        fCheckDatasetName:function () {
            if (this.checkDatasetName.length>20){
                this.checked.checkedDatasetName="数据集名称过长！"
            }else{
                this.checked.checkedDatasetName="正确！"
            }

        },
        fCheckDatasetDescription:function () {
            this.checked.checkedDatasetDescription="正确！"

        },
        fCheckDatasetCount:function () {
            if (Number.isInteger(this.checkDatasetCount)){
                if (this.checkDatasetCount>100000000000000000000){
                    this.checked.checkedDatasetCount="数据集记录数过大!"
                }else {
                    this.checked.checkedDatasetCount="正确!"
                }
            }else {
                this.checked.checkedDatasetCount="请输入整型数据!"
            }

        },
        fCheckDatasetDimension:function () {

        },
        setIsCommon:function(isCommon){
            this.datasetInfo.isCommon=isCommon
        },
        updateDataset:function (datasetId) {
            this.datasetInfo.datasetId=datasetId;
            axios.post('/updateDataset',this.datasetInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        }

    }
    ,
    created:function () {
        //初始化数值
        var that=this;
        that.administratorLoginName=$.cookie("administratorName")
        axios.get('/getDatasetMap').then(function (response) {
            that.datasetMap=response.data;
            console.log(response.data);
        },function (err) {

        })
        axios.get('/elements?htmlName=htmlElementList&isCh=ch').then(function (response){
            that.values=response.data;
            console.log(response.data);
            console.log(that.persons)
        } ,function (err) {

        })

        axios.get('/getDatasetForms').then(function (response){
            that.datasetForms=response.data;
            console.log(response.data);
        } ,function (err) {

        })
    }

})