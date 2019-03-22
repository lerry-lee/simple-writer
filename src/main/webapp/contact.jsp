<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/21
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>
<html>
<head>
    <title>联系我们-AcaWriter</title>
    <script src="js/contact.all.js"></script>
</head>
<body style="background-color: #F2F2F2">
<div style="padding-left: 150px">
    <div style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header">Contact</div>
                    <div class="layui-card-body">
                        <div style="text-align: center;margin: 10px 0;font-size: 18px">How well did AcaWriter do? We
                            want to hear from you!
                        </div>
                        <div class="layui-form" style="padding: 20px 80px 20px 20px">
                            <div class="layui-form-item">
                                <label class="layui-form-label">Name</label>
                                <div class="layui-input-block">
                                    <input type="text" id="name" required lay-verify="required" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">Email</label>
                                <div class="layui-input-block">
                                    <input type="text" id="email" lay-verify="email" class="layui-input">
                                </div>
                            </div>
                            <div class="error" id="email-msg" style="color: red;padding-left: 120px"></div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">Comments</label>
                                <div class="layui-input-block">
                                    <textarea id="comments" class="layui-textarea"></textarea>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button id="contact" class="layui-btn layui-btn-primary" lay-filter="formDemo">
                                        Send
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<%@include file="templates/footer.jsp" %>