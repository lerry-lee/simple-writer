<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/21
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>

<link rel="stylesheet" href="plugins/layui/homepage/global2.css" media="all">
<html>
<head>
    <title>Home</title>
</head>

<body style="background-color: #F2F2F2;font-family: panel-">

<div class="site-banner">
    <div class="site-banner-bg"
         style="background-image: url('css/img/home-bg1.jpg'); background-size: cover;">
    </div>
    <div class="site-banner-main">
        <div class="site-zfj site-zfj-anim">
            <i class="layui-icon" style="color: #fff; color: rgba(255,255,255,.7);"></i>
        </div>
        <div class="layui-anim site-desc site-desc-anim">
            <p class="web-font-desc">Reflective writing platform</p>
            <cite>For all users,created by Lerryli</cite>
        </div>
        <div class="site-download">
            <a href="analyse.jsp" class="layui-inline site-down"
               target="_blank">
                Start Writing
            </a>
        </div>
        <div class="site-version">
            <span>current version：<cite class="site-showv">1.3.5</cite></span>
            <span><a href="" rel="nofollow" target="_blank">update log</a></span>
            <span id="visits">visits：</span>
        </div>

    </div>
</div>
<div style="padding-bottom: 20px">
    <ul class="site-idea">
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>what to do</legend>
                <p>Welcome to AcaWriter! This website provides automated feedback on academic writing. A lot of
                    research into writing shows that many students find it tough to express their ideas in formal
                    academic language, and wish they had better, quicker feedback</p>
            </fieldset>
        </li>
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>how to work</legend>
                <p>AcaWriter works by looking for specific hallmarks of good academic writing that signal that
                    there's a significant connection being made, or an important development or contrast in ideas. This helps to demonstrate your critical thinking, skill in
                    argument, or development as a reflective professional</p>
            </fieldset>
        </li>
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>star and sea</legend>
                <p>If there is still a sporadic fire at the moment, after the strategizing, the east wind is a flame,
                    and it will definitely be a burning. When the autumn wind is bleak, it is scattered all over the
                    sky. You see that the connection between the sea and the sky is my obsession</p>
            </fieldset>
        </li>
    </ul>

</div>

</body>
</html>

<%@include file="templates/footer.jsp" %>