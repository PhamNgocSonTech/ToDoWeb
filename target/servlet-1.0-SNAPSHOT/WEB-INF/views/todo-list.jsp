<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 13/07/2022
  Time: 10:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo App</title>

    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <style>
        nav ul .header-navbar-item a {
            font-weight: bold;
            color: saddlebrown;
            padding: 8px;
        }


    </style>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #76b852">
        <div>
            <a href="${pageContext.request.contextPath}/ListToDo" class="navbar-brand">Todo App</a>

        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/Home"
                   class="nav-link">Home</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li class="header-navbar-item">Hello &#128075:
                <a href="${pageContext.request.contextPath}/UserDetail">${sessionScope.accSession.username}</a>||
            </li>
            <li> <a href="${pageContext.request.contextPath}/Logout" class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>

<div class="row">
<%--    <div class="alert alert-success" *ngIf='message'>${succUpdate}</div>--%>

    <div class="container">
        <p style="text-align: center; background-color: darkseagreen" class="suUpdate">${succUpdate}</p>
        <h3 class="text-center">Danh sách công việc của bạn nè &#128071 </h3>
        <hr>
        <div class="container text-left">

            <a style="margin-left: 450px" href="${pageContext.request.contextPath}/NewToDo" class="btn btn-success">Thêm gì đi nào &#9997</a>

        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Title &#128204</th>
                <th>Todo Detail &#11088</th>
                <th>Target Date &#9200</th>
                <th>Todo Status &#9989</th>
                <th>Actions &#10071</th>
            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="todo" items="${listTodo}">
                <tr>
                    <td><c:out value="${todo.title}"/></td>
                    <td><c:out value="${todo.detail}"/></td>
                    <td><c:out value="${todo.targetDate}"/></td>
                    <td><c:out value="${todo.statusDo}"/></td>
<%--                    <c:if test="${todo.statusDo == true}}">--%>
<%--                        <td><c:out value="Complete"/></td>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${todo.statusDo == false}">--%>
<%--                        <td><c:out value="Pending"/></td>--%>
<%--                    </c:if> --%>


                    <td><a href="${pageContext.request.contextPath}/EditForm?id=<c:out value='${todo.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="${pageContext.request.contextPath}/Delete?id=<c:out value='${todo.id}' />">Delete</a></td>

                    <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                              <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>

<%--<jsp:include page="../common/footer.jsp"></jsp:include>--%>
</body>
</html>
