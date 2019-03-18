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
<div style="padding-left: 160px">
    <%--<ul class="layui-nav" lay-filter="" style="background-image:url('css/img/community.jpg');text-align: center;height: 40px;padding: 5px 0">--%>
        <%--<li class="layui-nav-item layui-this"><a id="allPosts">所有帖子</a></li>--%>
        <%--<li class="layui-nav-item"><a id="myPosts">我的发布</a></li>--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a>消息中心</a>--%>
            <%--<dl class="layui-nav-child"> <!-- 二级菜单 -->--%>
                <%--<dd><a href="">系统消息<span class="layui-badge-dot" style="visibility: hidden"></span></a></dd>--%>
                <%--<dd><a href="messages.jsp">评论我的<span class="layui-badge-dot" style="visibility: visible"></span></a></dd>--%>
            <%--</dl>--%>
        <%--</li>--%>
    <%--</ul>--%>
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