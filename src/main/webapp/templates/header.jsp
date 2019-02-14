<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/22
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="plugins/layui/css/layui.min.css" media="all">
<link href="css/style1.css" type="text/css" rel="stylesheet"/>
<html>
<head>
</head>
<body>

<ul class="layui-nav">
    <li class="layui-nav-item"><a href="home.jsp"><i class="home-header"></i>主页</a></li>
    <li class="layui-nav-item">
        <a href="analyse.jsp">智能写作反馈</a>
        <dl class="layui-nav-child">
            <dd><a href="#to-edit">写作</a></dd>
            <dd><a href="#to-feedback">反馈</a></dd>
            <dd><a href="#to-tips">提示</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="echarts.jsp"><i class="chart-header"></i>图表</a></li>
    <li class="layui-nav-item">
        <a href="">待开发</a>
        <dl class="layui-nav-child">
            <dd><a href="">模块1</a></dd>
            <dd><a href="">模版2</a></dd>
            <dd><a href="">模块3</a></dd>
            <dd><a href="">模块4</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item"><a href="test.jsp">测试</a></li>
</ul>
<script src="plugins/layui/layui.min.js" charset="utf-8"></script>
<script>
    layui.use('element',function () {
        var element=layui.element;
    })
</script>
</body>
</html>
