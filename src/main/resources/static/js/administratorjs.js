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
        administratorName:'',
        searchByAdministratorName:'',
        deleteAdministratorInfo:{
            administratorName:'',
            administratorId:'',
            administratorPassword:''
        },
        deleteResultText:'删除成功！',
        //修改管理员信息模态框结果回显
        updateResult:'',
        //修改管理员模态框class样式绑定
        updateModalClass:''

    },
    computed:{
        filterAdministrator(){
            //取出数据
            const{administrators,searchByAdministratorName}=this
            //过滤获得的属性
            let fAdministrator;
            //对datasetMap进行过滤
            fAdministrator=administrators.filter(p => p.administratorName.indexOf(searchByAdministratorName)!==-1)
            return fAdministrator;
        }
    },
    methods:{
        signOut:function(){
            axios.post("/administratorSignOut");
            window.location.reload();
        },
        deleteAdministrator:function (administratorName) {
            $.post("/deleteAdministrator", { "administratorName": administratorName }, function
                (response) {
                console.log(response);
                if (response == 'success') {
                    $('#deleteResult'+administratorName).show();
                }else {
                    $('#deleteResult'+administratorName).text(response);
                    $('#deleteResult'+administratorName).show();
                }
            });
            // window.location.reload();
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
                .then((response) => {
                    console.log(response.data)
                    if (response.data === '修改用户信息成功！') {
                        this.updateModalClass='text-success';
                        this.updateResult=response.data;
                        $('#updateResult'+administratorId).show();
                    }else {
                        this.updateModalClass='text-warning';
                        this.updateResult=response.data;
                        $('#updateResult'+administratorId).show();
                    }
                })
                .catch(err => {
                    console.log(err);
                })
        },
        hideDeleteResultInfo:function(administratorName){
                $('#deleteResult'+administratorName).hide();
        },
        hideUpdateResultInfo:function(administratorName){
            $('#updateResult'+administratorName).hide()
        },
        reloadCurrentPage:function(){
            window.location.reload();
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
        that.administratorName=$.cookie("administratorName");
        axios.get('/getAdministrators').then(function (response) {
            that.administrators=response.data;
            console.log(response.data);
            let administrator = $.cookie("administrator")
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

 function hideDeleteResultInfo(){
    console.log("弹出来了")
    $('#deleteResult').hide();
}


