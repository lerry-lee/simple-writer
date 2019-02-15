<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/21
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>

<html>
<head>
    <title>首页</title>
</head>

<body style="background-color: #F2F2F2">

<div class="home-Carousel">
    <div class="layui-carousel" id="test1" lay-filter="test1">
        <div carousel-item="">
            <div style="background-image: url(css/img/1.jpg);background-size: cover">
                <p class="home-p">Welcome to
                    AcaWriter! This website provides automated feedback on academic writing. A lot of
                    research
                    into writing shows that many students find it tough to express their ideas in formal
                    academic language, and wish they had better, quicker feedback.</p>
            </div>
            <div style="background-image: url(css/img/2.jpg);background-size: cover"><p class="home-p">
                AcaWriter
                works by looking for specific hallmarks of good academic writingthat signal (to your
                audience, the reader) that there's a significant connection being made, or an important
                development or contrast in ideas. This helps to demonstrate your critical thinking, skill in
                argument, or development as a reflective professional.</p>
            </div>
            <div style="background-image: url(css/img/3.jpg);background-size: cover"><p class="home-p">
                AcaWriter is
                not grading your writing. Instead, it gives you feedback to improve your draft. Nobody will
                see your documents other than you, and the UTS research team who is continually analysing
                AcaWriter. So please revise your draft and get feedback as many times as you want!</p>
            </div>
            <div style="background-image: url(css/img/4.jpg);background-size: cover">
            </div>
            <div style="background-image: url(css/img/5.jpg);background-size: cover">
            </div>
            <div style="background-image: url(css/img/6.jpg);background-size: cover">
            </div>
        </div>
    </div>
</div>

<script src="pages/home.carousel.js"></script>
</body>
</html>

<%@include file="templates/footer.jsp" %>