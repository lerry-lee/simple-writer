<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/22
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>

<html>
<head>
    <title>analyse</title>
</head>
<body>
<div class="div-analyse">
    <span>Txt:<textarea id="txt">When I kept adjusting how I'd normally ask questions in day to day life, it felt exhausting because I had to put more energy into not only know what questions to ask but also how and when to ask those questions.</textarea></span>

    <span>Grammar:
        <select id="grammar">
            <option>analytical</option>
            <option>reflective</option>
        </select>
    </span>

    <button class="btn" id="send" onmouseover="this.style.backgroundColor='#8fbc8f'" onmouseout="this.style.backgroundColor='#00A2CA'">提交</button>
    <br/>
    <span style="color:red;margin-top: 5px" id="rst"></span>
</div>


<%--jquery提交ajax请求方式--%>
<script src="plugins/jquery.min.js"></script>
<script type="text/javascript" src="pages/analyse.getFeedback.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>