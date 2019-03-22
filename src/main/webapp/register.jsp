<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/2/19
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册-Acawriter</title>
    <link href="css/register/css/default.min.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="css/register/css/styles.min.css" rel="stylesheet" type="text/css" />
    <link href="css/register/css/demo.min.css" rel="stylesheet" type="text/css" />
    <link href="css/register/css/loaders.min.css" rel="stylesheet" type="text/css" />
    <link href="plugins/layui/css/layui.min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="plugins/jquery.min.js"></script>
    <script type="text/javascript" src="plugins/layui/layui.min.js"></script>
    <script src="js/register.all.js"></script>
</head>
<body style="background-image: url('css/img/home-bg.jpg');background-size: cover">
<div class='register'>

    <div class='register_fields'>
        <div class='register_fields__user'>
            <div class='icon'>
                <img alt="" src='css/register/img/user_icon_copy-.png'>
            </div>
            <input id='username' placeholder='输入您的用户名' maxlength="16" type='text' autocomplete="off"/>
            <div class='validation' id="uValidation">
                <img alt="" src='css/register/img/tick-.png'>
            </div>
            <div class="error" id="error-umsg"></div>
        </div>
        <div class='register_fields__password'>
            <div class='icon'>
                <img alt="" src='css/register/img/lock_icon_copy-.png'>
            </div>
            <input id='password' placeholder='输入您的密码' maxlength="16" type='password' autocomplete="off">
            <div class='validation' id="pValidation">
                <img alt="" src='css/register/img/tick-.png'>
            </div>
            <div class="error" id="error-pmsg"></div>
        </div>
        <div class='register_fields__password'>
            <div class='icon'>
                <img alt="" src='css/register/img/lock_icon_copy-.png'>
            </div>
            <input id='password_verify' placeholder='再次确认密码' maxlength="16" type='password' autocomplete="off">
            <div class='validation' id="pvValidation">
                <img alt="" src='css/register/img/tick-.png'>
            </div>
            <div class="error" id="error-pvmsg"></div>
        </div>

        <div class='register_fields__submit'>
            <input type='button' id='register' value='立即注册'>
        </div>

        <div class='register_fields__submit'>
            <a href="login.jsp"><input type='button' id='to-login' value='去登陆'></a>
        </div>
    </div>
</div>

</body>
</html>
