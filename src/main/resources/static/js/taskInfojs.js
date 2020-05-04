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
    el:"#taskInfoData",
    data:{
        taskInfos:[],
        values:"",
        taskEmail:'',
        checkAccountId: 1,
        checked:{checkedAccountId:""}

     },
    methods:{
        fCheckAccountId:function () {
            if (this.checkAccountId>1000000000000000000000){
                this.checked.checkedAccountId="用户名太长！"
            }else {
                this.checked.checkedAccountId="正确！"
            }

        }
    },
    computed:{
        filterTaskInfo(){
            //取出数据
            const{taskInfos,taskEmail}=this
            //过滤获得的属性
            let fTaskInfo;
            //对datasetMap进行过滤
            fTaskInfo=taskInfos.filter(p => p.taskEmail.indexOf(taskEmail)!==-1)
            return fTaskInfo;
        }
    }
    ,
    created:function () {
        //初始化数值
        var that=this;

        axios.get('/getTaskInfos').then(function (response) {
            that.taskInfos=response.data;
            console.log(response.data);
        },function (err) {

        })
        axios.get('/elements?htmlName=htmlElementList&isCh=ch').then(function (response){
            that.values=response.data;
            console.log(response.data);
        } ,function (err) {

        })


    }
})