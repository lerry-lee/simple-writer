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


<body>

<ul class="layui-nav layui-nav-tree layui-nav-side" style="padding: 20vh 0px;text-align: center;/*background-color: #202932;*/">
    <li class="layui-nav-item" style="height: 85px;margin-bottom: 40px">
        <a id="user" style="line-height: 50px;cursor:pointer"><i class="layui-icon" id="user-icon" style="color: whitesmoke;font-size: 50px;">&#xe612;</i>
        </a>
        <dl class="layui-nav-child" style="text-align: center">
            <dd><a id="logout" style="cursor: pointer">登出</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item">
        <a href="home.jsp">首页</a>
    </li>
    <li class="layui-nav-item"><a href="analyse.jsp">写作</a></li>
    <li class="layui-nav-item"><a href="chart.jsp">报表</a></li>
    <li class="layui-nav-item"><a href="community.jsp">社区</a>
    </li>
    <li class="layui-nav-item"><a href="motto.jsp" style="margin-top: 40px">Motto</a></li>
</ul>
</body>
</html>
