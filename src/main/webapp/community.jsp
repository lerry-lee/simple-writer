<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/4
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>
<html>
<head>
    <title>社区-Acawriter</title>
    <!-- Style Sheet-->
    <link rel="stylesheet" href="css/community/style.css"/>
    <link rel="stylesheet" href="plugins/layui/css/layui.min.css">
    <script src="plugins/layui/layui.min.js"></script>
    <script src="plugins/readmore.js"></script>
    <script src="pages/community.all.js"></script>

</head>
<body>
<div style="padding-left: 160px">
    <div style="height: 100px;background-color: #d1ecf1;">
        <ul class="layui-nav" style="text-align: right;height: 80px;padding: 50px 50px">
            <li class="layui-nav-item">
                <a href="community.jsp">所有帖子</a>
            </li>
            <li class="layui-nav-item" style="margin-left: 30px">
                <a href="myposts.jsp">我的帖子</a>
            </li>
            <li class="layui-nav-item" style="margin-left: 30px">
                <a href="messages.jsp">消息中心<span class="layui-badge-dot"></span></a>
            </li>
        </ul>
    </div>
    <div class="container">
        <div class="row">
            <!-- start of page content -->
            <div class="main-listing" id="main-listing">

                <article class="format-standard type-post hentry clearfix">
                    <header class="clearfix">
                        <h3 class="post-title">
                            Integrating WordPress with Your Website
                        </h3>
                        <hr class="layui-bg-gray">
                        <div class="post-meta clearfix">
                            <span class="date">25 Feb, 2013</span>
                            <span class="category">Server &amp; Database</span>
                            <span class="comments"><a name="to-comments" sid="2">3 Comments</a></span>
                            <span class="by-author">system</span>
                        </div>
                        <hr class="layui-bg-gray">
                    </header>

                    <p>Many of us work in an endless stream of tasks, browser tasks, social media, emails, meetings,
                        rushing from one thing to another, never pausing and never ending.&nbsp;Then the day is
                        over,
                        and we are exhausted, and we often have very little to show for it. And we start the next .
                        . .<br>滚滚长江东逝水
                        <br>浪花淘尽英雄
                    </p>

                </article>

            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@include file="templates/footer.jsp" %>