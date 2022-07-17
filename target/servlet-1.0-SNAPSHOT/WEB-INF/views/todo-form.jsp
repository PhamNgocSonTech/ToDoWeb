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

</head>

<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #76b852">
        <div>
            <a href="${pageContext.request.contextPath}/Home" class="navbar-brand"> Todo App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="${pageContext.request.contextPath}/ListToDo"
                   class="nav-link">Todos</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
            <li><a href="${pageContext.request.contextPath}/Logout"
                   class="nav-link">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${todo != null}">
            <form action="${pageContext.request.contextPath}/Update" method="post">
                </c:if>
                <c:if test="${todo == null}">
                <form action="${pageContext.request.contextPath}/Insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${todo != null}">
                                <p style="text-align: center; background-color: darkseagreen"
                                   class="faUpdate">${failUpdate}</p>
                                Edit Todo
                            </c:if>
                            <c:if test="${todo == null}">
                                Add New Todo
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${todo != null}">
                        <input type="hidden" name="id" value="<c:out value='${todo.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Todo Title</label> <input type="text"
                                                         value="<c:out value='${todo.title}' />" class="form-control"
                                                         name="title" required="required" minlength="5">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Todo Description</label> <input type="text"
                                                               value="<c:out value='${todo.detail}' />"
                                                               class="form-control"
                                                               name="detail" minlength="5">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Todo Status</label> <select class="form-control"
                                                           name="isDone">
                        <option value="false">Pending</option>
                        <option value="true">Complete</option>
                    </select>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Todo Target Date</label> <input type="date"
                                                               value="<c:out value='${todo.targetDate}' />"
                                                               class="form-control"
                                                               name="targetDate" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>

<%--<jsp:include page="../common/footer.jsp"></jsp:include>--%>
</body>
</html>
