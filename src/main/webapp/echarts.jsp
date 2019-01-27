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
    <table id="tb">
        <tr>
            <th>id</th><th>date</th><th>url</th><th>method</th><th>ip</th><th>param</th><th>status</th><th>timeConsuming</th>
        </tr>
    </table>
</div>

<script src="plugins/echarts.common.min.js"></script>
<script src="plugins/jquery.min.js"></script>
<script type="text/javascript" src="pages/echarts.getPieChart.js"></script>
<script type="text/javascript" src="pages/echarts.getTable.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>