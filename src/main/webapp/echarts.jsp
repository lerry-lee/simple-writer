<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/25
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>

<html>
<head>
    <title>echarts</title>
</head>
<body>
<button class="btn" id="getChart">生成报表</button>
<div class="chartDiv" id="echarts" style="width: 900px;height:600px;"></div>
<div class="chartDiv" id="test"></div>

<script src="js/echarts.common.min.js"></script>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/echarts.request.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>