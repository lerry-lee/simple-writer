<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/22
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="plugins/layui/css/layui.min.css" media="all">
    <link href="css/style1.css" type="text/css" rel="stylesheet"/>
    <script src="plugins/layui/layui.min.js" charset="utf-8"></script>
    <script src="plugins/jquery.min.js"></script>
    <script src="pages/header.all.js"></script>
</head>

<style>
    nav {
        top: 0vh;
        bottom: 0vh;
        text-align: center;
        background: #202932;
        position: fixed;
        z-index: 100;
        height: 100vh;
        left: 0;
        width: 160px;
        font-weight: 300;
        font-size: 20px;
        color: whitesmoke;
    }

    nav ul {
        margin-top: 60px;
        text-align: center;
        list-style-type: none;
        height: 40vh;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -ms-flex-direction: column;
        flex-direction: column;
        justify-content: space-around;
    }

    nav ul li a {
        color: whitesmoke;
        text-decoration: none !important;
        font-size: 20px;
        letter-spacing: 0.5px;
        position: relative;
        z-index: 0;
    }

    nav a:hover {
        color: white;
    }

</style>

<body>

<nav style="font-family: Arial;padding-top: 100px">

    <div class="layui-anim"><i class="layui-icon" id="user-icon"
                               style="color: whitesmoke;font-size: 50px;cursor:pointer">&#xe612;</i></div>
    <div id="user" style="color: whitesmoke;font-size: 14px;height: 16px"></div>
    <a id="logout" style="visibility: hidden;color:grey;cursor:pointer">登出</a>

    <ul>
        <li><a href="home.jsp"><i class="home-header icon-offset"></i>首页</a>
        </li>
        <li>
            <a href="analyse.jsp"><i class="analyse-header icon-offset"></i>写作</a>
        </li>
        <li><a href="chart.jsp"><i class="chart-header icon-offset"></i>图表</a>
        </li>
        <li>
            <a href="community.jsp" id="developing" style="cursor:pointer">
                <i class="develop-header icon-offset"></i>社区</a>
        </li>
        <li><a href="motto.jsp">Motto</a>
        </li>
    </ul>
</nav>
</body>
</html>
