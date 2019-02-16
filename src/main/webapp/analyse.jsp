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
    <title>Reflective Writing</title>
</head>
<body style="background-color: #F2F2F2">
<div style="padding: 20px; background-color: #F2F2F2">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" id="to-edit"><i class="edit-analyse icon-offset"></i>Writing Panel</div>
                <div class="layui-card-body">
                    <span><textarea id="txt" name="txt" class="layui-textarea" style="display: none"></textarea></span>
                    <span style="font-family: 'MV Boli';font-size: 16px">Grammar:
                    <input name="grammar" type="radio" value="analytical" checked="checked">analytical
                    <input name="grammar" type="radio" value="reflective">reflective
                    </span>
                    <div style="text-align: right">
                        <button class="layui-btn" id="send">Analyse</button>
                    </div>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header" id="to-feedback"><i class="feedback-analyse icon-offset"></i>Feedback
                    Panel
                </div>
                <div class="layui-card-body">
                    <span id="feedback"></span>
                </div>
            </div>
            <div class="layui-card">
                <div class="layui-card-header" id="to-tips"><i class="tips-analyse icon-offset"></i>Tips Panel</div>
                <div class="layui-card-body">
                    <span class="span-tips" id="tips"></span>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="plugins/jquery.min.js"></script>
<script src="pages/analyse.getfeedback.js"></script>

</body>
</html>

<%@include file="templates/footer.jsp" %>