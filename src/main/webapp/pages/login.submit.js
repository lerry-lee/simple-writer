$(document).keypress(function (e) {
    if (e.which == 13)
        $('#login').click();
});

//加载弹出层组件
layui.use('layer', function () {
    var layer = layui.layer;
    var username = '', password = '';
    //登录请求
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
                if (rst == 0) {
                    layer.msg('用户名或密码错误');
                    return;
                } else {
                    $.get(
                        'addVisits',
                        function () {
                            window.location.href = 'home.jsp';
                        }
                    );
                }
            }
        );

    });
});
