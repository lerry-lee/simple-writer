<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/4
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="plugins/layui/css/layui.min.css" rel="stylesheet" type="text/css">
    <script src="plugins/jquery.min.js"></script>
    <script src="plugins/layui/layui.min.js"></script>
    <script src="pages/toShare.send.js"></script>
</head>
<body>
<form class="layui-form" style="margin-top: 10px">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">编辑文章</label>
        <div class="layui-input-block">
            <textarea id="content" placeholder="请输入内容" class="layui-textarea" style="width:400px;height: 300px "></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">编辑标题</label>
        <div class="layui-input-block">
            <input type="text" id="share-title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input" style="width: 400px">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择类型</label>
        <div class="layui-input-block">
            <select id="category" lay-filter="aihao">
                <option value=""></option>
                <option value="Civil Law Essay">Civil Law Essay</option>
                <option value="Research Abstract/Intro" selected="">Research Abstract/Intro</option>
                <option value="Analytical Accounting">Analytical Accounting</option>
                <option value="Pharmacy">Pharmacy</option>
                <option value="Others">其他</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <input type="button" class="layui-btn" id="to-share" value="提交"/>
        </div>
    </div>
</form>
</body>
</html>
