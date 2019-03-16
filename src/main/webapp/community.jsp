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
    <div style="height: 200px;background-color: #d1ecf1;">
        <ul class="layui-nav" style="text-align: right;height: 50px;padding: 10px 50px">
            <li class="layui-nav-item">
                <a id="allPosts">所有帖子</a>
            </li>
            <li class="layui-nav-item" style="margin-left: 30px">
                <a id="myPosts">我的帖子</a>
            </li>
            <li class="layui-nav-item" style="margin-left: 30px">
                <a href="messages.jsp">消息中心<span class="layui-badge-dot"></span></a>
            </li>
        </ul>
        <div >
            <input class="layui-input" id="key_words" placeholder="输入标题或者内容中的关键词进行查找">
            <button class="layui-btn-primary" id="search_posts" category="All" author="All">搜索</button>
        </div>

        <span class="layui-breadcrumb" lay-separator="|">
            <a name="choose_category" category="All">All</a>
            <a name="choose_category" category="Civil Law Essay">Civil Law Essay</a>
            <a name="choose_category" category="Research Abstract/Intro">Research Abstract/Intro</a>
             <a name="choose_category" category="Analytical Accounting">Analytical Accounting</a>
             <a name="choose_category" category="Pharmacy">Pharmacy</a>
             <a name="choose_category" category="Others">Others</a>
        </span>
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
                            <span class="comments"><a name="to-comments" sid="2" author="lerry">3 Comments</a></span>
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
                <div id="posts_list"></div>
            </div>
        </div>
    </div>

    <div id="posts_demo">
    </div>
</div>
</body>
</html>

<%@include file="templates/footer.jsp" %>