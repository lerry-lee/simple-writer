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
    <title>Register</title>
    <link href="css/register/css/default.min.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="css/register/css/styles.min.css" rel="stylesheet" type="text/css" />
    <link href="css/register/css/demo.min.css" rel="stylesheet" type="text/css" />
    <link href="css/register/css/loaders.min.css" rel="stylesheet" type="text/css" />

    <link href="plugins/layui/css/layui.min.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="plugins/jquery.min.js"></script>
    <script type="text/javascript" src="css/register/js/jquery-ui.min-.js"></script>
    <script type="text/javascript" src='css/register/js/stopExecutionOnTimeout.min.js?t=1'></script>
    <script type="text/javascript" src="plugins/layui/layui.min.js"></script>
    <script type="text/javascript" src="css/register/js/Particleground.min.js"></script>
    <script type="text/javascript" src="css/register/js/Treatment.min.js"></script>
    <script type="text/javascript" src="css/register/js/jquery.mockjax-min.js"></script>
    <script src="pages/register.all.js"></script>
</head>
<body style="background-image: url('css/img/home-bg.jpg');background-size: cover">
<div class='register'>

    <div class='register_fields'>
        <div class='register_fields__user'>
            <div class='icon'>
                <img alt="" src='css/register/img/user_icon_copy-.png'>
            </div>
            <input id='username' placeholder='用户名' maxlength="16" type='text' autocomplete="off"/>
            <div class='validation'>
                <img alt="" src='css/register/img/tick-.png'>
            </div>
        </div>
        <div class='register_fields__password'>
            <div class='icon'>
                <img alt="" src='css/register/img/lock_icon_copy-.png'>
            </div>
            <input id='password' placeholder='密码' maxlength="16" type='password' autocomplete="off">
            <div class='validation'>
                <img alt="" src='css/register/img/tick-.png'>
            </div>
        </div>
        <%--<div class='register_fields__password'>--%>
            <%--<div class='icon'>--%>
                <%--<img alt="" src='css/register/img/key-.png'>--%>
            <%--</div>--%>
            <%--<input name="code" placeholder='验证码' maxlength="4" type='text' name="ValidateNum" autocomplete="off">--%>
        <%--</div>--%>
        <div class='register_fields__submit'>
            <input type='button' id='register' value='注册'>
        </div>
    </div>
</div>

</body>
</html>
