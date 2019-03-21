layui.use(['element', 'form'], function () {
    // var element=layui.element;
    var form = layui.form;
    var falg = false;
    $('#email').focus(function () {
        $('#email-msg').empty();
    });
    $('#email').blur(function () {
        falg=true;
        var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
        var email = $(this).val();
        if (!reg.test(email)) {
            $('#email-msg').html("邮箱格式有误");
            falg = false;
        }
    });
    $('#contact').click(function () {
        var name = $('#name').val();
        var email = $('#email').val();
        var comments = $('#comments').val();
        if (name == '' || email == '' || comments == '') {
            layer.msg('Name或Email或Comments不能为空！', {offset: '200px'});
            return;
        }
        console.log(falg);
        if (!falg) {
            layer.msg('请确认邮箱正误', {offset: '200px'});
            return;
        }
        $.post(
            'saveContact'
            , {
                'name': name,
                'email': email,
                'comments': comments
            }
            , function (rst) {
                if (rst == 1)
                    layer.msg('发送成功！感谢您的宝贵建议！', {offset: '200px'});
            }
        );
    });
});