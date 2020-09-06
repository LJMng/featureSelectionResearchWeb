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
    el:"#administratorData",
    data:{
        administrators:[],
        values:"",
        administratorId:'',
        checkAdministratorId:'',
        checkAdministratorName:'',
        checked:{checkedAdministratorId:"",checkedAdministratorName:""},
        administratorInfo:{
            administratorId:'',
            administratorName:'',
            administratorPassword:'',
            confirmAdministrator:''
        },
        administratorName:''

    },
    computed:{
        filterAdministrator(){
            //取出数据
            const{administrators,administratorId}=this
            //过滤获得的属性
            let fAdministrator;
            //对datasetMap进行过滤
            fAdministrator=administrators.filter(p => p.administratorId.indexOf(administratorId)!==-1)
            return fAdministrator;
        }
    },
    methods:{
        deleteAdministrator:function (administratorId) {
            axios.get('/deleteAdministrator?administratorId='+administratorId)
            window.location.reload();
        },
        fCheckedAdministratorId:function () {
            if (this.checkAdministratorId.length>20){
                this.checked.checkedAdministratorId="id值太长！"
            }else{
                this.checked.checkedAdministratorId="正确！"
            }
        },
        fCheckedAdministratorName:function () {
            if (this.checkAdministratorName.length>30){
                this.checked.checkedAdministratorName="用户名太长！"
            }else {
                this.checked.checkedAdministratorName="正确！"
            }

        },
        updateAdministrator:function (administratorId) {
            this.administratorInfo.administratorId=administratorId;
            axios.post('/updateAdministrator',this.administratorInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        addAdministrator:function () {
            axios.post('/addAdministrator',this.administratorInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })

        }

    },
    created:function () {
        //初始化数值
        var that=this;
        axios.get('/getAdministrators').then(function (response) {
            that.administrators=response.data;
            console.log(response.data);
            let administrator = $.cookie("admin")
            if (administrator != null && administrator != ''){
                $('#loginButton').text(administrator);
                $('#signOutButton').removeClass('d-none');
            } else {
                $('#loginButton').text(this.administratorName);
                $('#signOutButton').addClass('d-none');
            }
        },function (err) {

        })
        axios.get('/elements?htmlName=htmlElementList&isCh=ch').then(function (response){
            that.values=response.data;
        } ,function (err) {
        })

    }
})