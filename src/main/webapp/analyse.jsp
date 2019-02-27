<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/22
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="templates/header.jsp" %>


<html>
<head>
    <title>反思性写作-Acawriter</title>
    <script src="plugins/jquery.min.js"></script>
    <script src="plugins/icon-alibaba/iconfont.min.js"></script>
    <script src="pages/analyse.all.js"></script>
</head>

<body style="background-color: #F2F2F2">
<div style="padding: 20px; background-color: #F2F2F2">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" id="to-edit">
                    <svg class="icon-alibaba" aria-hidden="true">
                        <use xlink:href="#icon-shuru"></use>
                    </svg>
                    Writing Panel
                </div>
                <div class="layui-card-body">
                    <div><textarea id="txt" style="display: none"></textarea></div>
                    <div style="margin-top:10px;font-size: 16px">Grammar:
                    <input name="grammar" type="radio" value="analytical" checked="checked">analytical
                    <input name="grammar" type="radio" value="reflective">reflective
                    </div>
                    <div style="text-align: right">
                        <button class="layui-btn" id="score">To Score</button>
                        <button class="layui-btn" id="send">Analyse</button>
                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header" id="to-feedback">
                    <svg class="icon-alibaba" aria-hidden="true">
                        <use xlink:href="#icon-dingdan"></use>
                    </svg>
                    Feedback Panel
                </div>
                <div class="layui-card-body">
                    <span id="feedback"></span>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header" id="to-tips">
                    <svg class="icon-alibaba" aria-hidden="true">
                        <use xlink:href="#icon-linggan"></use>
                    </svg>
                    Tips Panel
                </div>
                <div class="layui-card-body">
                    <span class="span-tips" id="tips"></span>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="opacity: 0" id="temporary-storage"></div>

</body>
</html>

<%@include file="templates/footer.jsp" %>