layui.use(['layer','element'], function () {
    var layer = layui.layer;
    var element=layui.element;
    $.get(
        'getUsername',
        function (user) {
            if (user == '' || user == 'null') {
                layer.msg('登陆状态已过期，请重新登录', {
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

    $('#user-icon').click(function () {
        $('#logout').css('visibility', 'visible');
    });
});


