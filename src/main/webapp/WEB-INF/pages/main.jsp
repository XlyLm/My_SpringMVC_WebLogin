<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>画眉主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/css/main.css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>欢迎 <span>${user.getUsername()}</span> 来到画眉空间</h2>
    <h2>您的手机号是: <span>${user.getPhone()}</span></h2>
    <a href="#" id="update" onclick="updateUserName()">点击修改用户名</a>
    <a href="#" id="logout" onclick="logoutUser()">点击注销用户</a>
</div>

<script src="${pageContext.request.contextPath}/public/js/main.js"></script>
</body>
</html>
