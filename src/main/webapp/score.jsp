<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/2/24
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="plugins/layui/css/layui.min.css" media="all">
    <script type="text/javascript" src="plugins/jquery.min.js"></script>
    <script type="text/javascript" src="plugins/layui/layui.min.js"></script>
    <script type="text/javascript" src="pages/score.submit.js"></script>
</head>
<body>
<div style="padding: 20px 20px">
    <div>标题<input id="title" style="width: 300px;display: inline-block;margin-left: 5px" class="layui-input" type="text"
                  placeholder="在此处添加标题有助于写作内容回馈" maxlength="16"></div>
    <ul>
        <li>自我反思
            <div id="test0"></div>
        </li>
        <li>比较反思
            <div id="test1"></div>
        </li>
        <li>总结反思
            <div id="test2"></div>
        </li>
        <li>智能反馈
            <div id="test3"></div>
        </li>
    </ul>
    <div style="text-align: center">
        <button id="score-submit" class="layui-btn">提交</button>
    </div>
</div>

</body>
</html>
