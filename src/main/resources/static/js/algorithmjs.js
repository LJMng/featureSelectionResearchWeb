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
    el:"#algorithmData",
    data:{
        paramsNumber:0,
        values:"",
        parasType:'',
        valueNumber:[],
        algorithms:'',
        algorithmId:1,
        algorithmName:[],
    },
    created:function () {
        //初始化数值
        var that=this;
        axios.get('/elements?htmlName=algorithm&isCh=ch').then(function (response){
            that.values=response.data;
            console.log(response.data);
        } ,function (err) {

        })

        axios.get('/getAlgorithms').then(function (response) {
            that.algorithms=response.data;
        },function (err) {

        })


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

