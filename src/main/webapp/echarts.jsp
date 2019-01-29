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

<div class="div-echarts" id="echarts" style="width: 900px;height:600px;"></div>

<div class="div-echarts">
    <div>
        请求时间：<input style="width: 266px" type="text" class="demo-input" placeholder="选择起止时间" id="date-time">
        请求方法：<input name="method" type="radio" checked="checked" value="GET">GET
        <input name="method" type="radio" value="POST">POST&nbsp;
        请求关键词：<input id="url-input" placeholder="输入url中的关键词">
        <button id="url-search"></button>
    </div>
    <table id="tb" class="bordered">
        <tr>
            <th>id</th>
            <th>date</th>
            <th>url</th>
            <th>param</th>
            <th>method</th>
            <th>ip</th>
            <th>status</th>
            <th>timeConsuming</th>
        </tr>
    </table>
</div>

<script src="plugins/laydate/laydate.min.js"></script>
<script src="pages/echarts.laydate.js"></script>

<script src="plugins/echarts.common.min.js"></script>
<script src="plugins/jquery.min.js"></script>
<script type="text/javascript" src="pages/echarts.getpiechart.js"></script>
<%--<script type="text/javascript" src="pages/echarts.gettable.js"></script>--%>
<script type="text/javascript" src="pages/echarts.fuzzyquery.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>