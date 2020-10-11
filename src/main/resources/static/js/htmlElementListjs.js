// 管理输出元素信息的vue
var pages;
var state=true;
var ListCurrPage=9;
var ListPageSize=10;
var pageElementslength;
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
        checked:{checkedModuleKey:'',checkedHtmlName:'',checkedEnValue:'',checkedChValue:''},
        htmlElement:{
            htmlName:'',
            moduleKey:'',
            chValue:'',
            enValue:'',
            type:''
        },
        //封装修改页面元素信息
        updateHtmlElementInfo:{
            htmlName:'',
            moduleKey:'',
            chValue:'',
            enValue:'',
            type:''
        },
        vueListCurrPage:1,
        vueListPageSize:10,
        administratorName:''
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
        },
        pagingPageElement:function (){
            //取出数据
            const{pageElements,moduleKey}=this
            //过滤获得的属性
            let fPageElement;
            //对datasetMap进行过滤
            fPageElement=pageElements.filter(p => p.moduleKey.indexOf(moduleKey)!==-1 | p.htmlName.indexOf(moduleKey) !== -1)
            //获取列表大小
            const totalSize=fPageElement.length;
            var pageElementList= new Array();
            var j=0;
            // console.log(ListCurrPage);
            // console.log(ListPageSize);
            // console.log(totalSize)
            for (var i=0;i<totalSize;i++){
                if(i>(this.vueListCurrPage-1)*this.vueListPageSize  &&  i<=this.vueListCurrPage*this.vueListPageSize){
                    pageElementList[j]=fPageElement[i];
                    j++;
                }
            }
            return pageElementList;
        }
    },
    methods: {
        deletePageElement:function (htmlName,moduleKey) {
            this.htmlElement.htmlName=htmlName;
            this.htmlElement.moduleKey=moduleKey;
            axios.post('/deletePageElement',this.htmlElement)
            window.location.reload();
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
        },
        setUpdateHtmlElementInfo:function (pageElement) {
            this.updateHtmlElementInfo=pageElement;
        }
        ,
        updateHtmlElement(htmlName,moduleKey){
            this.updateHtmlElementInfo.htmlName=htmlName;
            this.updateHtmlElementInfo.moduleKey=moduleKey;
            axios.post('/updateElement',this.updateHtmlElementInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        createHtmlElement(){
            axios.post('/htmlElements',this.htmlElement)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })

        },
        //更新分页列表信息
        updateElementList:function () {
            this.vueListCurrPage=ListCurrPage;
            this.vueListPageSize=ListPageSize;

        }
    },
    created: function () {
        // Vue初始方法，可以自行百度一下相关介绍与用法
        // 1. 调用js方法获取页面涉及的URL, 赋值到js变量中.
        // 	queryXXXURI();
        var that =this;
        that.administratorName=$.cookie("administratorName")
        axios.get('/htmlElements').then(function (response) {
            console.log(response.data);
            that.pageElements=response.data;
            pageElementslength=that.pageElements.length;
            console.log(pageElementslength)
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
    //设为默认值
    $('#default').click(function () {
        $.ajax({
            type: 'POST',
            url: '/HtmlElementDemoAdmin/setDefault',
            success: function () {
                setTimeout('alert("设置成功!")',300);
                setTimeout('window.location.reload()',500);
            }
        })
    });
});
// 列表分页样式设置
$("#pagination_14").whjPaging({
    css: 'css-4',
    totalSize: 127,
    totalPage: 13,
    pageSize: 10,
    showPageNum: 10,
    pageSizeOpt: [
        {value: 5, text: '5条/页', },
        {value: 10, text: '10条/页',selected: true},
        {value: 15, text: '15条/页'},
        {value: 20, text: '20条/页'}
    ],

    callBack: function (currPage, pageSize) {
        ListCurrPage=currPage;
        ListPageSize=pageSize;
        console.log('currPage:' + ListCurrPage + '     pageSize:' + ListPageSize);
    }
});








