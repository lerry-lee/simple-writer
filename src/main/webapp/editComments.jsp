<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/5
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="plugins/layui/css/layui.min.css">
    <script src="plugins/jquery.min.js"></script>
    <script src="plugins/layui/layui.min.js"></script>
    <script src="js/community.comments.js"></script>
</head>

<body>
<div id="params"></div>
<div id="commments-list" style="margin: 5px 20px"></div>
<form class="layui-form" style="padding: 10px 20px">
    <div class="layui-form-item" style="width: 50%">
        <textarea id="comment" placeholder="输入您的评论" class="layui-input" style="width: 500px;height: 200px"></textarea>
    </div>
    <div class="layui-form-item">
        匿名评论
        <input type="checkbox" lay-filter="niming" lay-skin="switch">
    </div>
    <div class="layui-form-item">
        <input type="button" id="save-comment" class="layui-btn" value="提交">
    </div>
</form>
</body>
</html>
