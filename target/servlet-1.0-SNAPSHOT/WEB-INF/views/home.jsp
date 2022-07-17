<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 10/07/2022
  Time: 9:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To Home Page</title>
    <style>
        * {
            list-style: none;
            text-decoration: none;

        }

        html {
            background-color: #76b852;
            font-weight: bold;
        }

        /*a {*/
        /*    margin-left: 20px;*/
        /*}*/
        .header {
            height: 120px;
        }

        .header-navbar {
            display: flex;
            justify-content: space-between;
        }

        .header-navbar-item {
            display: inline-block;
        }
    </style>
</head>

<body>
<%--    <jsp:include page="menu.jsp"> </jsp:include>--%>
<p style=" background-color: #b3b3b3; color: deeppink">${sucMess}</p>
<header class="header">
    <nav class="header-navbar">
        <ul class="header-navbar-list">
            <li class="header-navbar-item"><p>Good Morning, Thank you to visit my page. Login to enjoy</p></li>
        </ul>
        <ul class="header-navbar-list">
            <%--                <li class="header-navbar-item"><p>Hello: ${sessionScope.accSession.username} </p></li>--%>

            <c:if test="${sessionScope.accSession.username != null}">
                <li class="header-navbar-item"><p><a href="${pageContext.request.contextPath}/ListToDo">To Do List</a></p></li>
                <li class="header-navbar-item"><a href="${pageContext.request.contextPath}/UserDetail">My Infor</a></li>
                <li class="header-navbar-item"><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>

            </c:if>
            <c:if test="${sessionScope.accSession.username == null}">
                <li class="header-navbar-item"><a href="${pageContext.request.contextPath}/Login">Login</a></li>
                <li class="header-navbar-item"><a href="${pageContext.request.contextPath}/Register">Register</a></li>
            </c:if>

            <%--                <li class="header-navbar-item"><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>--%>
        </ul>
    </nav>
</header>
<%--    <c:if test="${sessionScope.accSession} == null">--%>
<%--        <a href="${pageContext.request.contextPath}/Login">Login</a> <br>--%>
<%--        <a href="${pageContext.request.contextPath}/Register">Register</a>--%>
<%--    </c:if>--%>
<%--    <c:if test="${sessionScope.accSession} != null">--%>
<%--        <h2>Hello: ${sessionScope.accSession.username}</h2>--%>
<%--        <a href="${pageContext.request.contextPath}/UserDetail">My infor</a>--%>
<%--        <a href="${pageContext.request.contextPath}/Logout">Logout</a>--%>
<%--    </c:if>--%>


<%--        <a href="${pageContext.request.contextPath}/Login">Login</a> <br>--%>
<%--        <a href="${pageContext.request.contextPath}/Register">Register</a>--%>

<%--        <h2>Hello: ${sessionScope.accSession.username}</h2>--%>
<%--        <a href="${pageContext.request.contextPath}/Logout">Logout</a>--%>


<%--    <jsp:include page="footer.jsp"> </jsp:include>--%>
</body>
</html>
