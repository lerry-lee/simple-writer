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
    <script src="pages/commments.save.js"></script>
</head>

<body>
<div id="commments-list"></div>
<textarea id="comment" placeholder="输入您的评论" class="layui-input" style="width: 500px;height: 200px"></textarea>
<button id="save-comment" class="layui-btn">提交评论</button>
</body>
</html>
