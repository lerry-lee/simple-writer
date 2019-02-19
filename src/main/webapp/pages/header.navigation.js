layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var layer = layui.layer;

    $.get(
        'getUsername',
        {},
        function (rst) {
            // console.log(rst);
            if (rst == null) {
                layer.open('用户信息已过期，请重新登录');
                window.location.href = 'login.jsp';
            } else
                $('#user').append(rst);
        }
    )

    // $('#setting').click(function () {
    //     layer.open({
    //         type: 2,
    //         area: ['350px', '250px'],
    //         fixed: false, //不固定
    //         maxmin: true,
    //         content: 'userSetting.jsp'
    //     });
    // });
});

function show() {
    layer.msg('功能仍在开发中哦', function () {
    });
}

