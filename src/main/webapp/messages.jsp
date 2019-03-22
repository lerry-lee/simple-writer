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
    <title>评论我的-社区</title>
    <link rel="stylesheet" href="css/community/style.css"/>
    <script src="js/messages.all.js"></script>
</head>
<body style="background-color: #F2F2F2">
<div style="padding-left: 160px;">

    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header"><i class="layui-icon" id="makeMessagesRead"
                                                      style="cursor:pointer;font-size: 20px">&#xe756;</i>所有消息
                    </div>
                    <div class="layui-card-body">
                        <div class="layui-collapse" id="messages">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<%@include file="templates/footer.jsp" %>