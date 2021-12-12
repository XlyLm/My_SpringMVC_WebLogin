<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" charset="UTF-8"/>
    <title>画眉登录界面</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/iconfont/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/Login.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
</head>
<body>
<div class="login_container">
    <form action="/java22e/login" method="post">
        <h1>用户登录</h1>
        <%--用户名输入框--%>
        <div class="user">
            <i class="iconfont icon-ren"></i>
            <input id="userInput" name="phone" type="text" placeholder="请输入手机号" onchange="handleInputChange()"
                   onblur="isPhone()" onfocus="clear_err()" autocomplete="off" value="${phone}"/>
        </div>
        <div class="err_box user_err">${err_user}</div>
        <%--密码输入框--%>
        <div class="password">
            <i class="iconfont icon-24gl-lock2"></i>
            <input id="pwInput" name="password" type="password" placeholder="请输入密码" onchange="handleInputChange()"
                   onfocus="clear_err()"  value="${pw}"/>
        </div>
        <div class="err_box pw_err">${err_pw}</div>
        <%--验证码--%>
        <div class="test_container">
            <input id="checkInput" name="check" type="text" class="test" placeholder="验证码" onchange="handleInputChange()"
                   onfocus="clear_err()" autoComplete="off"  value=""/>
            <div class="test_ers">
                <div class="test_er">${check}</div>
                <div class="update" onclick="updateTest()">点击刷新</div>
            </div>
        </div>
        <div class="err_box test_err">${msg}</div>
        <%--提交按钮--%>
        <input type="submit" value="登录" class="submit"/>
        <%--其他部分--%>
        <div class="others">
            <a href="#" onclick="freeLogin()">免密登录</a><span>|</span>
            <a href="#" onclick="fastRegister()">快速注册</a><span>|</span>
            <a href="#" onclick="updatePassword()">忘记密码</a>
        </div>
    </form>
</div>
<script src="${pageContext.request.contextPath}/public/js/Login.js"></script>
</body>
</html>
