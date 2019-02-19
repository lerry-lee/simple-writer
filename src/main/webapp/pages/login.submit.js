//加载弹出层组件
layui.use('layer', function () {
    var layer = layui.layer;
    var username='',password='';
    //登录函数
    $("#login").click(function () {

        username = $(" input[ name='username' ] ").val();
        password = $(" input[ name='password' ] ").val();
        if (username == "" || password == "") {
            layer.msg("用户名或密码不能为空！");
            return;
        }
        $.post(
            "login",
            {
                "username": username,
                "password": password
            },
            function (rst) {
                var objectJson = JSON.parse(rst);
                if (objectJson.status == '0') {
                    layer.msg(objectJson.msg);
                    return;
                }else window.location.href = 'home.jsp';
            }
        );

    });
});
