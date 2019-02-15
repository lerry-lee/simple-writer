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
    <title>图表</title>
</head>
<body style="background-color: #F2F2F2">

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">HTTP请求次数统计图</div>
                <div class="layui-card-body">
                    <div id="echarts" style="width: 100%;height:80%;"></div>
                </div>
            </div>
        </div>
        <div class="layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">HTTP请求信息数据表</div>
                <div style="padding:10px">
                    请求时间：<input type="text" class="layui-input" placeholder="选择起止时间" id="date-time">
                    请求方法：<input name="method" type="radio" checked="checked" value="GET">GET
                    <input name="method" type="radio" value="POST">POST&nbsp;
                    请求关键词：<input id="url-input" placeholder="输入url中的关键词">
                    <button id="url-search" class="layui-btn layui-btn-normal" style="-webkit-transform: scale(0.7)">搜索</button>
                </div>
                <div class="layui-card-body" style="overflow: auto">
                    <table id="demo" lay-filter="test" class="layui-table" lay-data="{id:'demo'}"></table>
                </div>
            </div>
        </div>

    </div>
</div>

<script src="plugins/jquery.min.js"></script>

<script src="pages/echarts.laytable.js"></script>

<script src="plugins/echarts.common.min.js"></script>

<script type="text/javascript" src="pages/echarts.getpiechart.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>