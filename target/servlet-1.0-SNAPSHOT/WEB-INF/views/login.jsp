<%--
  Created by IntelliJ IDEA.
  User: Ngoc Son
  Date: 10/07/2022
  Time: 11:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300&family=Poppins:wght@200&family=Roboto:wght@100;300&display=swap');

        * {
            padding: 0;
            margin: 0;
            text-decoration: none;
            box-sizing: border-box


        }

        html {
            font-size: 14px;
            font-family: 'Roboto', sans-serif;
            display: block;
        }

        /* body {
            margin: 8px;
            background: linear-gradient(90deg, rgba(141,194,111,1) 0%, rgba(118,184,82,1) 50%);
            /* -webkit-font-smoothing: antialiased; */


        body {
            background: #76b852; /* fallback for old browsers */
            background: rgb(141, 194, 111);
            background: linear-gradient(90deg, rgba(141, 194, 111, 1) 0%, rgba(118, 184, 82, 1) 50%);
            font-family: "Roboto", sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        .form {
            max-width: 360px;
            position: relative;
            padding: 45px;
            margin: 100px auto;
            z-index: 1;
            text-align: center;
            background-color: #fff;
        }

        .form input {
            width: 100%;
            margin: 0 0 15px;
            padding: 15px;
            background-color: #f2f2f2;
            border: 0;
            box-sizing: border-box;
            outline: 0;
        }

        .form button {
            width: 100%;
            margin: 0 0 15px;
            padding: 15px;
            color: #ffff;
            border: 0;
            box-sizing: border-box;
            outline: 0;
            background-color: #4CAF50;
            cursor: pointer;
            text-transform: uppercase;

        }

        .form button:hover, .form button:active, .form button:focus {
            background: #43A047;
        }

        .form .message {
            margin: 15px 0 0;
            color: #b3b3b3;
            font-size: 12px;
        }

        .form .message a {
            color: #4CAF50;
            text-decoration: none;
        }

        .form .register-form {
            display: none;
        }

        .container {
            position: relative;
            z-index: 1;
            max-width: 300px;
            margin: 0 auto;
        }

        /* .container:before, .container:after {
          content: "";
          display: block;
          clear: both;
        }
        .container .info {
          margin: 50px auto;
          text-align: center;
        }
        .container .info h1 {
          margin: 0 0 15px;
          padding: 0;
          font-size: 36px;
          font-weight: 300;
          color: #1a1a1a;
        }
        .container .info span {
          color: #4d4d4d;
          font-size: 12px;
        }
        .container .info span a {
          color: #000000;
          text-decoration: none;
        }
        .container .info span .fa {
          color: #EF3B3A;
        } */
    </style>
</head>
<body>
<div class="login-page">
    <div class="form">
        <form action="${pageContext.request.contextPath}/Login" class="login-form" method="post">
            <p class="para-err-login" style="color: tomato">${err}</p>
            <input type="text" name="username" value="${usernameCk}" placeholder="username"  required/>
            <input type="password" name="password" value="${passCk}" placeholder="password"  required/>
            <button type="submit">login</button>
            <p class="message">Not registered? <a href="${pageContext.request.contextPath}/Register">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>
