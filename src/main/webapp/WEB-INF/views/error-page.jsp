<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 11/07/2022
  Time: 2:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Opps</title>
    <style>
        html {
            background-color: #43A047;
            font-weight: bold;
        }

        h1 {
            font-size: 30px;
            color: darkorange;
            text-align: center;
        }

        p {
            font-size: 20px;
            color: brown;
            text-align: center;
        }

        p a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Error 404</h1>
<p>Not thing to see here => <a href="${pageContext.request.contextPath}/Home">Back To Homepage</a></p>
</body>
</html>
