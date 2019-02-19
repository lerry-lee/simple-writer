$('body').particleground({
    dotColor: '#E8DFE8',
    lineColor: '#133b88'
});

layui.use('layer', function () {
    var layer = layui.layer;

    $('#username').blur(function () {
        var username = $('#username').val();

        $.get(
            'checkUsernameExist',
            {'username': username},
            function (rst) {
                if (rst == '1')
                    layer.msg('用户名已存在！');
            }
        );
    });

    $('#register').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        if($.trim(username)==''||$.trim(password)==''){
            layer.msg('用户名或密码不能为空',function () {
            });
            return;
        }
        $.post(
            'register',
            {
                'username': username,
                'password': password
            },
            function (rst) {
                if (rst == '1') {
                    layer.msg('注册成功！即将跳转登录页面');
                    setTimeout(function () {
                        window.location.href = 'login.jsp';
                    }, 2000);
                }else {
                    layer.msg('注册失败！');
                }
            }
        );
    });
});
