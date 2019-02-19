<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/21
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>
<link rel="stylesheet" href="plugins/layui/homepage/global.css" media="all">
<html>
<head>
    <title>Home</title>
    <script src="pages/home.carousel.js"></script>
</head>

<body style="background-color: #F2F2F2">

<div class="it-home">
    <div class="site-banner">
        <div class="site-banner-bg"
             style="background-image: url('css/img/home-bg.jpg'); background-size: cover;">
        </div>
        <div class="site-banner-main">
            <div class="layui-anim site-desc" style="font-family: panel-;margin-top: 10%">
                <p class="web-font-desc">Reflective writing platform</p>
                <cite>When the autumn wind is bleak, it is scattered all over the sky,You see the four seasons of reincarnation, it is my obsession.
                    --Created by Lerryli</cite>
            </div>
            <div class="site-download">
                <a href="analyse.jsp" class="layui-inline" style="font-family: panel-">Start Writing
                </a>
            </div>
            <div class="site-version" style="font-family: panel-">
                <span>current version:<cite class="site-showv">1.3.5</cite></span>
                <span>Views:<em class="site-showdowns">…</em></span>
            </div>
        </div>
    </div>

    <div>
        <ul class="site-idea">
            <li>
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>Gift rose</legend>
                    <p>Welcome to AcaWriter! This website provides automated feedback on academic writing. A lot of
                        research into writing shows that many students find it tough to express their ideas in formal
                        academic language, and wish they had better, quicker feedback.</p>
                </fieldset>
            </li>
            <li>
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>Working principle</legend>
                    <p>AcaWriter works by looking for specific hallmarks of good academic writingthat signal that there's a significant connection being made, or an important
                        development or contrast in ideas. This helps to demonstrate your critical thinking, skill in
                        argument, or development as a reflective professional.</p>
                </fieldset>
            </li>
        </ul>

    </div>
</div>


</body>
</html>

<%@include file="templates/footer.jsp" %>