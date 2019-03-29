$(function () {
    //查询所有未读消息
    $.ajax({
        type: 'get'
        , url: 'messages'
        , data: []
        , success: function (rst) {
            var json = JSON.parse(rst);
            for (var i in json) {
                $('#messages').append("<div class='layui-colla-item'>" +
                    "<h2 class='msg-colla-title' mid='" + json[i].id + "'><i class='zhankai'></i>" + json[i].message + "<span class='layui-badge-dot'></span></h2>" +
                    "<div class='msg-colla-content' mid='" + json[i].id + "'>" + json[i].comment + "</div></div>");
            }
        }
    });
    //为动态添加的h2元素添加点击事件，消除小红点标记为已读
    $('#messages').delegate("h2", 'click', function () {

        var mid = $(this).attr('mid');
        $("div.msg-colla-content[mid=" + mid + "]").toggle();

        // 去掉小红点,标记为已读
        var mid = $(this).attr('mid');
        var flag = false;
        var data = {'id': mid};
        $.ajax({
            async: false
            , type: 'put'
            , url: 'messages'
            , contentType: 'application/json;charset=utf-8'
            , data: JSON.stringify(data)
            , success: function (rst) {
                if (rst == 1) {
                    flag = true;
                }
            }
        });
        if (flag)
            $(this).children("span").css('display', 'none');
    });
    //标记所有消息为已读
    $('#makeMessagesRead').click(function () {
        layer.confirm('确定所有消息标记为已读吗？', {
            offset: '200px',
            btn: ['确定', '我再想想'] //按钮
        }, function (index) {
            $.ajax({
                type: 'put'
                , url: 'messages/all'
                , data: {}
                , success: function (rst) {
                    if (rst == 1)
                        $('span').css('visibility', 'hidden');
                }
            });
            layer.close(index);
        });
    });

});

