layui.use(['layer', 'form'], function () {
    var form = layui.form;
    var layer = layui.layer;
    var sid = $.getUrlParam('sid');
    var title = $.getUrlParam('title');
    var author = $.getUrlParam('author');

    //查询所有评论
    $.ajax({
        type: 'get'
        , url: 'comments'
        , data:
            {
                'sid': sid
            }
        , success: function (rst) {
            if (rst == '[]')
                return;
            var json = JSON.parse(rst);
            for (var i in json) {
                $('#commments-list').append("<article><p style='color: grey'>" +
                    json[i].cdate + "\xa0\xa0       " + json[i].commentator +
                    "</p><p>" +
                    json[i].comment +
                    "</p></article><hr class=\"layui-bg-gray\">");
            }
        }
    })
    ;
    //匿名选择
    var niming = 0;
    form.on('switch(niming)', function (data) {
        niming = (data.elem.checked == true ? 1 : 0); //开关是否开启，true或者false
    });
    //提交评论
    $('#save-comment').click(function () {
        var comment = $('#comment').val();

        if ($.trim(comment) == '') {
            layer.msg('评论内容不能为空');
            return;
        }
        var data = {
            'sid': sid,
            'comment': comment,
            'niming': niming
        };
        $.ajax({
            type: 'post'
            , url: 'comments'
            , contentType: 'application/json;charset=utf-8'
            , data: JSON.stringify(data)
            , success: function (rst) {
                if (rst == '1')
                    layer.msg('成功');
            }
        });
        //向作者发送一条消息
        var data_ = {
            'sid': sid,
            'title': title,
            'author': author,
            'comment': comment
        };
        $.ajax({
            type: 'post'
            , url: 'messages'
            , contentType: 'application/json;charset=utf-8'
            , data: JSON.stringify(data_)
            , success: function () {
            }
        });
    });
});
//封装一个方法用于获取url中参数
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
})(jQuery);