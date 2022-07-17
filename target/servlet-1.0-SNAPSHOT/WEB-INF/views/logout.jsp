<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 11/07/2022
  Time: 11:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
        <h1>Goodbye, You Logout</h1>
        <p>You can comeback</p>
        <a href="${pageContext.request.contextPath}/Home">Home</a>
        <a href="${pageContext.request.contextPath}/Login">Login</a>
</body>
</html>
