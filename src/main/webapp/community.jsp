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
    <script src="plugins/readmore.js"></script>
    <script src="js/community.all.js"></script>
</head>
<body>
<div style="padding-left: 160px">

    <div style="background-image:url('css/img/home-bg2.jpg');height: 180px;text-align: center">
        <ul class="layui-nav" lay-filter="" style="background-color:transparent;text-align: right;height: 80px;">
            <li class="layui-nav-item layui-this"><a id="allPosts">所有帖子</a></li>
            <li class="layui-nav-item"><a id="myPosts">我的发布</a></li>
            <li class="layui-nav-item">
                <a>消息中心</a>
                <dl class="layui-nav-child"> <!-- 二级菜单 -->
                    <dd><a id="systemMessages">系统消息<span class="layui-badge">1</span></a></dd>
                    <dd><a href="messages.jsp">评论我的<span class="layui-badge" id="totalMessages"></span></a></dd>
                </dl>
            </li>
        </ul>
        <div style="text-align: center">
            <div style="width: 70%;display: inline-block;margin:0 0 20px 0">
                <input class="layui-input" id="key_words" placeholder="输入关键词进行查找"
                       style="background-color: transparent;color:whitesmoke">
            </div>
            <button class="layui-btn layui-btn-normal" id="search_posts" category="All" author="All">搜索</button>
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
                <div id="posts_list"></div>
            </div>
        </div>
    </div>

    <div id="posts_demo" style="text-align: center">
    </div>
</div>

</body>
</html>

<%@include file="templates/footer.jsp" %>