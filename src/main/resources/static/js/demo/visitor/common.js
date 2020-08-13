var demoVisitorBaseURL= "http://localhost:8000/demo/visitor/";
var baseURL = "http://localhost:8000/";

function toLoginPage(){
  window.location.href='/accountLogin';
}
function toexecution() {
  if ($.cookie("account") != null) {
    window.location.href = baseURL + "execution";
  }
  else {
    $.cookie("loginTo", 'execution');
    $("#loginbutton").click()
  }
};
//回到首页
function backIndex() {
  window.location.href = baseURL;
};
//to aboutus页面
function toaboutus() {
  window.location.href = "/pages/demo/visitor/aboutus.html";
};