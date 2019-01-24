<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/22
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/style1.css" type="text/css" rel="stylesheet"/>
<%@include file="templates/header.jsp" %>
<html>
<head>
    <title>分析</title>
</head>
<body>
<div class="form">
    <span style="">txt:<textarea class="input" id="txt">When I kept adjusting how I'd normally ask questions in day to day life, it felt exhausting because I had to put more energy into not only know what questions to ask but also how and when to ask those questions.</textarea></span>
    <span>action:<input class="input" id="action" value="fetch"></span>
    <span>extra:</span>
    <div id="extra" class="div1">
        <span style="padding-left: 20px;width: 480px">feedbackOpt:<input class="input" id="feedbackOpt" value="r_01" readonly></span>
        <span style="padding-left: 20px;width: 480px">grammar:<select id="grammar">
            <option>analytical</option>
            <option>reflective</option>
            </select></span>
        <span style="padding-left: 20px;width: 480px">feature:<input class="input" id="feature" value="7"/></span>
    </div>
    <span>type:<input class="input" id="type" value="manual" readonly></span>
    <button class="btn" id="send" onmouseover="this.className='style2'" onmouseout="this.className='btn'">提交</button>
    <br/>
</div>

<span style="display: inline-block;margin: 10px" id="rst"></span>
<%--jquery提交ajax请求方式--%>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.post.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>