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
    <title>报表-Acawriter</title>
    <script src="plugins/echarts/echarts.common.min.js"></script>
    <script src="pages/chart.all.js"></script>
</head>
<body style="background-color: #F2F2F2">
<div  style="padding-left: 160px">
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">DataTabel Panel</div>
                <div class="layui-card-body">
                    <form class="layui-form layui-form-pane">
                        <div class="layui-form-item">

                            <label class="layui-form-label">保存时间</label>
                            <div class="layui-input-block">
                                <input type="text" class="layui-input" placeholder="选择保存时间的范围区间" id="date-time">
                            </div>

                        </div>
                        <div class="layui-form-item">

                            <label class="layui-form-label">保存标题</label>
                            <div class="layui-input-block">
                                <input class="layui-input" id="title-input" placeholder="输入标题中的关键词">
                            </div>

                        </div>
                    </form>
                    <button id="title-search" class="layui-btn">Search</button>
                    <table id="demo" lay-filter="test" class="layui-table" lay-data="{id:'demo'}"></table>
                    <script type="text/html" id="barDemo">
                        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header">PieChart Panel</div>
                <div class="layui-card-body">
                    <div id="echarts" style="width: 100%;height:80%;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>

<%@include file="templates/footer.jsp" %>