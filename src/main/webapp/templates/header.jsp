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
    <li class="header-acawriter"><a href="home.jsp">AcaWriter</a></li>
    <li class="layui-nav-item">
        <a href="analyse.jsp"><i class="analyse-header icon-offset"></i>Analytical Report</a>
        <dl class="layui-nav-child">
            <dd><a href="#to-edit">Writing</a></dd>
            <dd><a href="#to-feedback">Feedback</a></dd>
            <dd><a href="#to-tips">Tips</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item" style="margin-left: 10px"><a href="chart.jsp"><i class="chart-header icon-offset"></i>Chart Table</a></li>
    <li class="layui-nav-item">
        <a href=""><i class="develop-header icon-offset"></i>Developing</a>
        <dl class="layui-nav-child">
            <dd><a href="">module1</a></dd>
            <dd><a href="">module2</a></dd>
            <dd><a href="">module3</a></dd>
            <dd><a href="">module4</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item" style="margin-left: 10px"><a href="about.jsp"><i class="about-header icon-offset"></i>Like a Snail</a></li>
</ul>
<script src="plugins/layui/layui.min.js" charset="utf-8"></script>
<script>
    layui.use('element',function () {
        var element=layui.element;
    })
</script>
</body>
</html>
