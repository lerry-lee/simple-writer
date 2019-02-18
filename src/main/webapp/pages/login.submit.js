//加载弹出层组件
layui.use('layer', function () {
    var layer = layui.layer;

    //登录函数
    $("#login").click(function () {

        var username = $(" input[ name='username' ] ").val();
        var password = $(" input[ name='password' ] ").val();
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
                if (objectJson.status == '1')
                    window.location.href = objectJson.url;
                else
                    layer.msg(objectJson.msg);
            }
        );
    });
});