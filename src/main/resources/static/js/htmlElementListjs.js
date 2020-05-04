// 管理输出元素信息的vue
var pages;
var state=true;
var vm=new Vue({
    el: '#pageElementControl',
    data: {
        pageElements: [],
        Values: "",
        moduleKey:'',
        checkModuleKey:'',
        checkHtmlName:'',
        checkEnValue:'',
        checkChValue:'',
        checked:{checkedModuleKey:'',checkedHtmlName:'',checkedEnValue:'',checkedChValue:''}
    },
    computed:{
        filterPageElement(){
            //取出数据
            const{pageElements,moduleKey}=this
            //过滤获得的属性
            let fPageElement;
            //对datasetMap进行过滤
            fPageElement=pageElements.filter(p => p.moduleKey.indexOf(moduleKey)!==-1)
            return fPageElement;
        }
    },
    methods: {
        deletePageElement:function (htmlName,moduleKey) {
            axios.get('/deletePageElement?moduleKey='+moduleKey)
        },
        fCheckModuleKey:function () {
            if (this.checkModuleKey.length>30){
                this.checked.checkedModuleKey="模块值太长！"
            }else {
                this.checked.checkedModuleKey="正确！"
            }
        },
        fCheckHtmlName:function () {
            if (this.checkHtmlName.length>30){
                this.checked.checkedHtmlName="html页面名太长！"
            }else {
                this.checked.checkedHtmlName="正确！"
            }
        },
        fCheckEnValue:function () {
            if(/.*[\u4e00-\u9fa5]+.*$/.test(this.checkEnValue)) {
                this.checked.checkedEnValue="不能含有中文！"
            }else{
                this.checked.checkedEnValue="正确！"
            }

    },
        fCheckChValue:function () {
            var re = /[^\u4e00-\u9fa5]/;
            if(re.test(this.checkChValue)){
                this.checked.checkedChValue="不能含有英文！"
            }else{
                this.checked.checkedChValue="正确！"
            }
        }
    },
    created: function () {
        // Vue初始方法，可以自行百度一下相关介绍与用法
        // 1. 调用js方法获取页面涉及的URL, 赋值到js变量中.
        // 	queryXXXURI();
        var that =this;
        axios.get('/htmlElements').then(function (response) {
            console.log(response.data);
            that.pageElements=response.data;
        },function (err) {

        })
        axios.get('/elements?htmlName=htmlElementList&isCh=ch').then(function (response){
            that.Values=response.data;
        } ,function (err) {

        })
    }


})

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

});











