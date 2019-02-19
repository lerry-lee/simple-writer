var username = '';
$.get(
    'updateVisits',
    {},
    function (rst) {
        username = rst;
    }
);

layui.use(['element', 'layer'], function () {
    var element = layui.element;
    var layer = layui.layer;

    // $.get(
    //     'getUsername',
    //     {},
    //     function (rst) {
    if (username == 'null') {
        layer.msg('用户信息已过期，请重新登录');
        setTimeout(function () {
            window.location.href = 'login.jsp';
        }, 1000);

    } else
        $('#user').append(username);
    //     }
    // );
    $.get(
        'getVisits',
        {},
        function (rst) {
            $('#visits').append(rst);
        }
    );

});

function show() {
    layer.msg('功能仍在开发中哦', function () {
    });
}

