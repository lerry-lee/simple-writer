layui.use(['layer', 'element'], function () {
    var layer = layui.layer;
    var element = layui.element;
    //获得当前用户名，在左侧导航栏显示
    $.get(
        'getUsername',
        function (user) {
            if (user == '' || user == 'null') {
                layer.msg('登陆过期，请重新登录', {
                    shade: 0.8
                    , offset: '200px'
                    , time: 0 //不自动关闭
                    , btn: '重新登录'
                    , yes: function () {
                        window.location.href = 'login.jsp'
                    }
                });
            } else
                $('#user').append(user);
        }
    );
    //登出请求
    $('#logout').click(function () {
        layer.msg('确定要退出登录吗？', {
            time: 0 //不自动关闭
            , shade: 0.8
            , offset: '200px'
            , btn: ['确定', '返回']
            , yes: function () {
                $.get(
                    'logout',
                    function () {
                        window.location.href = 'login.jsp';
                    }
                );
            }
        });

    });

});


