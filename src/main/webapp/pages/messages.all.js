$(function () {
    $.get(
        'queryMessages',
        function (rst) {
            var json = JSON.parse(rst);
            for (var i in json) {
                $('#messages').append("<div class='layui-colla-item'>" +
                    "<h2 class='layui-colla-title' mid='" + json[i].id + "'>" + json[i].message + "<span class='layui-badge-dot'></span></h2>" +
                    "<div class='layui-colla-content'>" + json[i].comment + "</div></div>");
            }
        }
    );
    $('#messages').delegate("h2", 'click', function () {

        // layui.use('element', function () {
        //     var element = layui.element;
        // });

        $(this).next().css('display', 'block');

        // 去掉小红点,标记为已读
        var mid = $(this).attr('mid');
        var flag = false;

        $.get({
            async: false
            , url: 'readMessages'
            , data: {'mid': mid}
            , success: function (rst) {
                if (rst == 1) {
                    flag = true;
                }
            }
        });
        if (flag)
            $(this).children("span").css('display', 'none');
    });
    $('#makeMessagesRead').click(function () {
        layer.confirm('确定所有消息标记为已读吗？', {
            offset: '200px',
            btn: ['确定', '我再想想'] //按钮
        }, function (index) {
            $.get(
                'readAllMessages',
                function (rst) {
                    if (rst == 1)
                        $('span').css('visibility', 'hidden');
                }
            );
            layer.close(index);
        });
    });
});

