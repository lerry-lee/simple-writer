<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/6
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>
<html>
<head>
    <title>消息中心-社区</title>
    <link rel="stylesheet" href="css/community/style.css"/>
    <script src="plugins/readmore.js"></script>
    <script src="pages/messages.all.js"></script>
</head>
<body>
<div style="padding-left: 160px;">
    <div style="padding: 10px 10px"><i class="layui-icon" id="makeMessagesRead" style="cursor:pointer;font-size: 20px">&#xe756;</i></div>
    <div class="layui-collapse" id="messages">
        <%--<div class="layui-colla-item">
            <h2 class="layui-colla-title">系统消息</h2>
            <div class="layui-colla-content">欢迎来到Acawriter</div>
        </div>--%>
    </div>
</div>
</body>
</html>
<%@include file="templates/footer.jsp" %>