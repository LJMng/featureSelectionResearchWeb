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

// $('#updateAlgorithmPowerName').dropdown();
// $('#updateAlgorithmPowerName').selectpicker();

var vm =new Vue({
    el:"#accountData",
    data:{
        applyAccounts:{"5":"25"},
        accounts: [],
        values:"",
        accountEmail:'',
        checkAccountId:1,
        checkAccountName:"",
        checkEmail:"",
        checkPassword:'',
        checked:{checkedAccountName:'',checkedEmail:'',checkedAccountId:'',checkedPassword:''},
        // 用于暂时存放修改、新增、删除用户信息
        accountInfo:{
            accountEmail:'',
            accountName:'',
            accountPassword:'',
        },
        administratorName:'',
        applyReasons:[],
        applyReason:'',
        applyAccountInfo:{
            applyId:'',
            administratorId:'',
            administratorReason:''
        },
        //待审核的用户个数
        waitingAuditAccountNumber:0,
        deleteResultText:'',
        deleteAccountInfo:{
            accountId:1
        },
        setAccountPowerInfo:{
            accountId:1,
            algorithmId:1,
            algorithmName:'',
            administratorName:'',
            haveUploadDocPower:'',
            haveDownloadDocPower:''
         },
        updateAccountPowerAlgorithms:'',
        setAccountPowerResult:'',
        resultTextCss:''
    },
    computed:{
        filterAccount(){
            //取出数据
            const{accounts,accountEmail}=this
            //过滤获得的属性
            let fAccount;
            //对datasetMap进行过滤
            fAccount=accounts.filter(p => p.accountEmail.indexOf(accountEmail)!==-1)
            return fAccount;
        }
    }
    ,
    methods:{
        reloadCurrentPage:function(){
            window.location.reload();
        },
        administratorSignOut:function(){
            axios.get('/administratorSignOut/{administratorName}').then(() =>{
                window.location.reload();
            })
        },
        deleteAccount:function (accountId) {
            this.deleteAccountInfo.accountId=accountId
            axios.post('/deleteAccount',this.deleteAccountInfo).then((response) =>{
                if(response.data === '删除用户信息成功！'){
                    this.deleteResultText=response.data;
                    $('#deleteResult'+accountId).show();
                }
            }).catch((err) =>{
                console.log(err)
            })

        },
        setAccountPowerInfoAccountId:function(accountId){
            $('#setAccountPowerResult').hide();
            this.setAccountPowerInfo.accountId = accountId;
        },
        setAccountPower:function(){
            this.setAccountPowerInfo.administratorName = $.cookie("administratorName");
            axios.post('/setAccountPower',this.setAccountPowerInfo).then((response) => {
                this.setAccountPowerResult=response.data;
                if (this.setAccountPowerResult === "修改用户权限成功！"){
                    this.resultTextCss = 'text-success'
                }else {
                    this.resultTextCss = 'text-danger'
                }
                $('#setAccountPowerResult').show();
            }).catch((err)=>{
                console.log(err)

            })
        },
        checkoutEmail:function (checkEmail) {

        },
        fCheckAccountId: function () {
            if(this.checkAccountId > 10000000000){
                this.checked.checkedAccountId="用户Id太长，请输入小于10位数的id"
            }else {
                this.checked.checkedAccountId="正确！"
            }
        },
        setUpdateAccountInfo:function(account){
            this.accountInfo=account;
        },
        fCheckAccountName:function () {
            if (this.checkAccountName.length>30){
                this.checked.checkedAccountName="用户名太长！"
            }else {
                this.checked.checkedAccountName="正确！"
            }
        },
        addAccount:function () {
            axios.post('/administratorAddAccount',this.accountInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        updateAccount:function (accountId) {
            this.accountInfo.accountId=accountId;
            axios.post('/updateAccount',this.accountInfo)
                .then(() => {
                    window.location.reload();
                })
                .catch(err => {
                    console.log(err);
                })
        },
        //同意申请VIP用户
        passAccountAdult:function (applyId) {
            let administratorName;
            administratorName=$.cookie("administratorName")
            this.applyAccountInfo.administratorId=administratorName;
            this.applyAccountInfo.applyId=applyId;
            this.applyAccountInfo.administratorReason=this.applyReasons[applyId];
            axios.post('/passAccountAdult',this.applyAccountInfo).then(() =>{
                this.clearApplyAccountInfo();
                window.location.reload();
            }).catch(err => {
                console.log(err)
            })
        },
        //拒绝申请VIP用户
        unPassAccountAdult:function (applyId) {
            let administratorName;
            administratorName=$.cookie("administratorName")
            this.applyAccountInfo.administratorId=administratorName;
            this.applyAccountInfo.applyId=applyId;
            this.applyAccountInfo.administratorReason=this.applyReasons[applyId];
            axios.post('/unPassAccountAdult',this.applyAccountInfo).then(() => {
                this.clearApplyAccountInfo();
                window.location.reload();
            }).catch(err =>{
                console.log(err)
            })
        },
        //清空申请单的数据
        clearApplyAccountInfo:function () {
            this.applyAccountInfo.administratorId='';
            this.applyAccountInfo.applyId=-1;
            this.applyAccountInfo.applyReason=''
        },
        clearSetAccountInfo:function(){
            this.setAccountPowerInfo.accountId=1;
            this.setAccountPowerInfo.algorithmId=1;
            this.setAccountPowerInfo.algorithmName='';
            this.setAccountPowerInfo.administratorName='';
            this.setAccountPowerInfo.haveUploadDocPower='';
            this.setAccountPowerInfo.haveDownloadDocPower=''
        },
        //获取用户的算法对应的权限对象
        getAccountPower:function (algorithmName) {
            this.setAccountPowerInfo.algorithmName=algorithmName;
            axios.post('/getAccountPower',this.setAccountPowerInfo).then((response) => {
                this.setAccountPowerInfo = response.data;
            }).catch((err) =>{
                console.log(err)
            })
        }
    },
    created:function () {
        //初始化数值
        var that=this;
        that.administratorName=$.cookie("administratorName");

        axios.get('/getAlgorithms').then((response) => {
            console.log(response.data)
            that.updateAccountPowerAlgorithms = response.data;
        }).catch((err)=>{
            console.log(err)
        })

        axios.get('/getAccounts').then(function (response) {
            that.accounts=response.data;
            console.log(response.data);
        },function (err) {

        })
        axios.get('/elements?htmlName=htmlElementList&isCh=ch').then(function (response){
            that.values=response.data;
            console.log(response.data);
        } ,function (err) {

        })

        axios.get('/getApplyAccounts').then(function (response){
            that.applyAccounts=response.data;
            that.waitingAuditAccountNumber=that.applyAccounts.length;
            console.log(response.data);
        } ,function (err) {

        })

    }
})

