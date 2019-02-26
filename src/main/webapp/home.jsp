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
    <title>首页-Acawriter</title>
</head>

<body style="background-color: #F2F2F2">

<div class="site-banner">
    <div class="site-banner-bg"
         style="background-image: url('css/img/home-bg1.jpg'); background-size: cover;">
    </div>
    <div class="site-banner-main">
        <div class="site-zfj site-zfj-anim">
            <i class="zfj-home" style="color: #fff; color: rgba(255,255,255,.7);"></i>
        </div>
        <div class="layui-anim site-desc site-desc-anim">
            <p class="web-font-desc">反思性写作平台</p>
            <cite>待秋风萧瑟，散作满天星辰，看那四季轮回，是我不灭的执念。</cite>
        </div>
        <div class="site-download">
            <a href="analyse.jsp" class="layui-inline site-down">
                开始写作之旅
            </a>
        </div>
        <div class="site-version">
            <span>当前：<cite>1.4.3</cite></span>
            <span><a id="updatelog" href="updatelog.jsp" rel="nofollow" target="_blank">更新日志</a></span>
            <span id="visits">访问量：</span>
        </div>
    </div>
</div>
<div>
    <ul class="site-idea">
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>开门见山</legend>
                <p>欢迎来到AcaWriter！该平台提供有关学术写作的自动反馈。大量的写作研究表明，许多学生发现很难用正式的学术语言表达自己的想法，并希望他们有更好，更快的反馈，AcaWriter可以帮助他们。</p>
            </fieldset>
        </li>
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>曲尽其妙</legend>
                <p>AcaWriter通过寻找具有良好学术写作的特定标志来发挥作用，这些标志表明存在重要的联系，或者是思想的重要发展或对比。这有助于展示您作为反思专业人士的批判性思维，论证技巧或发展。</p>
            </fieldset>
        </li>
        <li>
            <fieldset class="layui-elem-field layui-field-title">
                <legend>水到渠成</legend>
                <p>反思性写作首先自我反思，写作后自己先分析文章并做修改。然后比较性反思，可将文章或者段落分享给他人评阅。再来总结性反思，总结他人的建议和自己的观点。最后交给平台自动产生反馈。</p>
            </fieldset>
        </li>
    </ul>

</div>

</body>
</html>

<%@include file="templates/footer.jsp" %>