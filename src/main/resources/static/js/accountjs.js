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
            accountId:'',
            accountName:'',
            accountPassword:''
        }

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
        deleteAccount:function (accountId) {
            axios.get('/deleteAccount?accountId='+accountId)
            window.location.reload();
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
            axios.post('/addAccount',this.accountInfo)
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
        }


    },
    created:function () {
        //初始化数值
        var that=this;

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
            console.log(response.data);
        } ,function (err) {

        })

    }
})