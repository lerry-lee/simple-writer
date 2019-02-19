<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/2/19
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="plugins/layui/css/layui.min.css" media="all">
    <link href="css/style1.css" type="text/css" rel="stylesheet"/>
    <script src="plugins/layui/layui.min.js" charset="utf-8"></script>
    <script src="plugins/jquery.min.js"></script>
</head>
<body>
<form class="layui-form" style="margin-top: 10px">
    <div class="layui-form-item">
        <label class="layui-form-label">原始密码</label>
        <div class="layui-input-block">
            <input type="password" id="password_old" lay-verify="title" autocomplete="off" placeholder="请输入初始密码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">新密码</label>
        <div class="layui-input-block">
            <input type="password" id="password_new" lay-verify="title" autocomplete="off" placeholder="请输入新密码" class="layui-input">
        </div>
    </div>
    <span id='msg' style="color: red;text-align: center"></span>
    <div class="layui-form-item">
    <div class="layui-input-block">
        <button id="change" class="layui-btn">提交</button>
    </div>
    </div>
</form>
<script>
    layui.use('layer',function () {
        var password_new='',password_old='';
        $('#password_old').blur(function () {
            password_old=$('#password_old').val();
        });
        $('#password_new').keyup(function () {
            password_new=$('#password_new').val();
            $('#msg').empty();
            if(password_new==password_old){
                $('#msg').html('新旧密码不能相同');
                return;
            }
        });
        $('#change').click(function () {
            if(password_old==''||password_new==''){
                layer.msg('密码不能为空',function () {
                });
                return;
            }
            $.post(
                'changePassword',
                {
                    'password_old':password_old,
                    'password_new':password_new
                },
                function (rst) {
                    if(rst=='1')
                        layer.msg('修改成功',{icon:1});
                    else
                        layer.msg('修改失败',function () {
                        });
                }
            );
        });
    });
</script>
</body>
</html>
