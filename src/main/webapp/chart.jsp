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
    <title>Chart and Table</title>
    <script src="plugins/jquery.min.js"></script>
    <script src="pages/chart.laytable.js"></script>
    <script src="plugins/echarts.common.min.js"></script>
    <script type="text/javascript" src="pages/chart.getpiechart.js"></script>

</head>
<body style="background-color: #F2F2F2">

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">PieChart Panel</div>
                <div class="layui-card-body">
                    <div id="echarts" style="width: 100%;height:80%;"></div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header">DataTabel Panel</div>
                <div class="layui-card-body">
                    <form class="layui-form layui-form-pane" action="">
                        <div class="layui-form-item">

                            <label class="layui-form-label">请求时间</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" placeholder="选择请求时间范围" id="date-time">
                            </div>

                        </div>
                        <div class="layui-form-item">

                            <label class="layui-form-label">请求关键词</label>
                            <div class="layui-input-block">
                                <input class="layui-input" id="url-input" placeholder="输入URL中的关键词">
                            </div>

                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">请求方法</label>
                            <div class="layui-inline">
                                <input name="method" type="radio" checked="checked" value="GET">GET
                                <input name="method" type="radio" value="POST">POST
                            </div>
                        </div>
                    </form>
                    <button id="url-search" class="layui-btn">Search</button>
                    <table id="demo" lay-filter="test" class="layui-table" lay-data="{id:'demo'}"></table>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<%@include file="templates/footer.jsp" %>