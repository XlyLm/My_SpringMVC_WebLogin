let baseUrl = "http://localhost:8080/java22e";

let checkInput = $("#checkInput")[0];  //验证码输入
let userInput = $("#userInput")[0];    //手机号输入
let pwInput = $("#pwInput")[0];        //密码输入
let form = $("form")[0];           //form表单
let check = $(".test_er")[0];      //验证码
let user_err = $(".user_err")[0];   //手机输入错误
let pw_err = $(".pw_err")[0];      //密码输入错误
let test_err = $(".test_err")[0];  //验证码输入错误
//更新验证码
function updateTest() {
    $.ajax({
        type:"GET",
        url:baseUrl+"/toLogin/updateCheck",
        success:function(data){
            check.innerText = data;
        }
    });
}
// 获取输入信息
function handleInputChange() {
    event.target.value=event.target.value.trim();
}
//清除报错
function clear_err() {
    const name = event.target.name;
    if(name === "phone"){
        user_err.innerText = "";
    }
    if(name === "password"){
        pw_err.innerText = "";
    }
    if(name === "check"){
        test_err.innerText = "";
    }
}
// 手机号输入格式有错
function isPhone() {
    const value = userInput.value;
    const regex = /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/;
    // 如果手机号格式不正确
    if(!regex.test(value)){
        user_err.innerText = "手机号格式不正确!";
    }
}
//检查输入合法性
function checkInputs () {
    user_err.innerText = "";
    pw_err.innerText = "";
    //检验输入是否为空
    if(checkInput.value === undefined||checkInput.value === ""){
        test_err.innerText = "请输入验证码";
        return false;
    }
    if(userInput.value === undefined||userInput.value === ""){
        user_err.innerText = "手机号不能为空!";
    }
    if(pwInput.value === undefined||pwInput.value === ""){
        pw_err.innerText = "密码不能为空!";
    }
    if((userInput.value === undefined||userInput.value === "")||(pwInput.value === undefined||pwInput.value === "")){
        // 更新验证码
        updateTest();
        return false;
    }
    return true;
}
//表单提交
form.onsubmit=function(){
    event.preventDefault();
    let bl = checkInputs();
    if(bl) {
        event.target.submit();
    }
}
//免密登录
function freeLogin(){
    $.ajax({
        type:"post",
        url:baseUrl+"/toLogin/freeLogin",
        success:function (data) {
            if(data==="0"){
                alert("登录超时!请重新登录。");
                window.location.href = baseUrl+"/toLogin";
            }else{
                window.location.href = baseUrl+"/freeLogin";
            }
        },
        error:function(res){
            console.log(res);
            alert("请求超时!");
        }
    });
}
//获取数据
function getData(){
    return {
        phone:userInput.value,
        password:pwInput.value,
        check:checkInput.value
    };
}
//请求回调函数
function success(res){
    let req = JSON.parse(res)
    if(req.status===0){
        test_err.innerText = req.data;
    }else if(req.status===1){
        alert(req.data);
    }else{
        window.location.href = baseUrl+"/freeLogin";
    }
}
// 快速注册
function fastRegister(){
    let bl = checkInputs();
    if(bl){
        if(window.confirm("是否注册该用户?")){
            $.ajax({
                type:"post",
                url:baseUrl+"/toLogin/register",
                data:getData(),
                success:function(res){success(res)}
            })
        }
    }
}
//修改密码
function updatePassword(){
    let bl = checkInputs();
    if(bl){
        if(window.confirm("是否修改为改密码?")){
            $.ajax({
                type:"post",
                url:baseUrl+"/toLogin/updatePw",
                data:getData(),
                success:function(res){success(res)}
            })
        }
    }
}