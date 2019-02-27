layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var layer = layui.layer;

    $.get(
        'getUsername',
        {},
        function (user) {
            if (user == '' || user == 'null') {
                layer.msg('登陆状态已过期，请重新登录', {
                    shade:0.8
                    ,offset:'100px'
                    ,time: 0 //不自动关闭
                    ,btn: '重新登录'
                    ,yes: function(){
                        window.location.href='login.jsp'
                    }
                });
            } else
                $('#user').html(user);
        }
    );

    $('#logout').click(function () {
        $.get(
            'logout',
            {},
            function () {
            }
        );
    });

    $('#developing').click(function () {
        layer.msg('功能仍在开发中', {offset: '100px'});
    });

});


