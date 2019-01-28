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
    <div style="font-size: 18px"><b>HTTP请求信息统计表</b></div>
    <div>
        起始时间：<input id="start-date" type="date">
        结束时间：<input id="end-date" type="date">
        响应状态：<input name="status" type="radio" value="success">成功
                <input name="status" type="radio" value="failed">失败&nbsp;
        请求关键词：<input id="url-input">
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

<script src="plugins/echarts.common.min.js"></script>
<script src="plugins/jquery.min.js"></script>
<script type="text/javascript" src="pages/echarts.getPieChart.js"></script>
<%--<script type="text/javascript" src="pages/echarts.getTable.js"></script>--%>
<script type="text/javascript" src="pages/echarts.fuzzyQuery.js"></script>
</body>
</html>

<%@include file="templates/footer.jsp" %>