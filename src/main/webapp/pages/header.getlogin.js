layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var layer = layui.layer;

    $.get(
        'getUsername',
        {},
        function (user) {
            if (user == '' || user == null) {
                layer.msg('用户信息已过期，请重新登录');
                // setTimeout(function () {
                //     window.location.href = 'login.jsp';
                // }, 1000);

            } else
                $('#user').html(user);
        }
    );


    $('#developing').click(function () {
        layer.msg('功能仍在开发中')
    });

});


