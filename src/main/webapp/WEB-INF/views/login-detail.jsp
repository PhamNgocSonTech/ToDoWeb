<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 11/07/2022
  Time: 12:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Login</title>
    <style>
        html {
            background-color: #43A047;
            font-weight: bold;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
    <h2>Welcome: ${sessionScope.accSession.username}</h2>
    <h3>Your User Information</h3>
    <p>Username: ${sessionScope.accSession.username}</p>
    <p>Email: ${sessionScope.accSession.email}</p>
    <p><a href="${pageContext.request.contextPath}/Home">Home</a> </p>
<%--    <p><a href="${pageContext.request.contextPath}/ListToDo">To Do List</a> </p>--%>
    <c:if test="${sessionScope.accSession.username != null}">
        <p><a href="${pageContext.request.contextPath}/ListToDo">To Do List</a> </p>
    </c:if>
    <c:if test="${sessionScope.accSession.username == null}">
        <p><a href="${pageContext.request.contextPath}/Login">To Do List</a> </p>
    </c:if>
</body>
</html>
