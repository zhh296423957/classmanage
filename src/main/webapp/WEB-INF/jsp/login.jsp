<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Small Red DK Zhang">
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <link rel="stylesheet" href="../../css/style.css">

    <link href='//fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
</head>
<body>
        <h1>班级管理登录平台</h1>
        <div class="container w3">
            <h2>登录</h2>
            <form action="/loginJudge" method="post" id="form1" name="form1" onsubmit="return checkUser()">
                <div class="username">
                    <span class="username">用户名:</span>
                    <input id="username" type="text" name="username" class="name" placeholder="" required="">
                    <div class="clear"></div>
                </div>
                <div class="password-agileits">
                    <span class="username">Password:</span>
                    <input id="password" type="password" name="password" class="password" placeholder="" required="">
                    <div class="clear"></div>
                </div>
                <div class="msg">
                    <label style="width:auto;font-family: 'Times New Roman','Georgia,Serif';font-size: large;color:red"  >
                        ${msg}
                    </label>
                </div>
                <div class="rem-for-agile">
                    <input type="checkbox" name="remember" class="remember">Remember me<br>     <!--忘记密码有待完成-->
                    <a href="#">Forgot Password</a><br>
                </div>
                <div class="login-w3">
                    <input type="submit" class="login" value="Login">
                </div>
                <div class="clear"></div>
            </form>
        </div>
    <script type="text/javascript" src="../../js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="../../js/html/login.js"></script>
     <script type="application/x-javascript">
          addEventListener("load", function() {
            setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){
                window.scrollTo(0,1);
      } </script>
</html>