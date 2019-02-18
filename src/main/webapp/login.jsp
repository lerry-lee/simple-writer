<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/2/18
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/login/css/normalize.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/login/css/demo.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/style1.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/login/css/component.min.css"/>
    <link rel="stylesheet" type="text/css" href="plugins/layui/css/layui.min.css"/>
    <script type="text/javascript" src="plugins/jquery.min.js"></script>
    <script type="text/javascript" src="plugins/layui/layui.min.js"></script>
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3 style="font-family: panel-">WelCome to AcaWriter</h3>

                <div class="input_outer">
                    <span class="u_user"></span>
                    <input name="username" class="text" style="color: #FFFFFF !important" type="text"
                           placeholder="Username">
                </div>
                <div class="input_outer">
                    <span class="us_uer"></span>
                    <input name="password" class="text"
                           style="color: #FFFFFF !important; position:absolute; z-index:100;"
                           type="password" placeholder="Password">
                </div>
                <div style="text-align: center">
                    <button id="login" class="layui-btn layui-btn-normal layui-btn-radius"
                            style="color: #FFFFFF;font-family: panel-;font-size: 26px">login
                    </button>
                </div>

            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="css/login/js/TweenLite.js"></script>
<script src="css/login/js/EasePack.js"></script>
<script src="css/login/js/rAF.min.js"></script>
<script src="css/login/js/demo-1.min.js"></script>
<script src="pages/login.submit.js"></script>
</body>

</html>
