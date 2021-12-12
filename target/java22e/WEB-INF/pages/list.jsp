<%--
  Created by IntelliJ IDEA.
  User: 27618
  Date: 2021/12/9
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>queryUserById</h2>
<span>${user.phone}</span><br/>
<span>${user.username}</span><br/>
<span>${user.password}</span><br/>

<h2>queryUserByPhone</h2>
<span>${user.phone}</span><br/>
<span>${user.username}</span><br/>
<span>${user.password}</span><br/>

<h2>queryUsersByLimit</h2>
<c:forEach items="${users}" var="user">
    ${user.phone}&nbsp;
    ${user.username}&nbsp;
    ${user.password}<br/>
</c:forEach>

<h2>insertUser</h2>
<span>${insertUser}</span><br/>

<h2>updateUser</h2>
<span>${updateUser}</span><br/>

<h2>deleteUser</h2>
<span>${deleteUser}</span><br/>
</body>
</html>
