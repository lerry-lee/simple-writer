layui.use(['layer','form'], function () {
    var form=layui.form;
    var layer = layui.layer;
    var sid=$.getUrlParam('sid');
    var title=$.getUrlParam('title');
    var author=$.getUrlParam('author');

    $.post(
        'queryComments',
        {
            'sid': sid
        },
        function (rst) {
            if(rst=='[]')
                return;
            var json = JSON.parse(rst);
            for (var i in json) {
                $('#commments-list').append("<article><p style='color: grey'>" +
                    json[i].cdate +"\xa0\xa0       "+json[i].commentator+
                    "</p><p>" +
                    json[i].comment +
                    "</p></article><hr class=\"layui-bg-gray\">");
            }
        }
    );
    var niming=0;
    form.on('switch(niming)', function(data){
        niming=(data.elem.checked==true?1:0); //开关是否开启，true或者false
    });

    $('#save-comment').click(function () {
        var comment = $('#comment').val();

        if($.trim(comment)==''){
            layer.msg('评论内容不能为空');
            return;
        }
        $.post(
            'saveComments',
            {
                'sid': sid,
                'comment': comment,
                'niming':niming
            },
            function (rst) {
                if (rst == '1')
                    layer.msg('成功');
            }
        );
        $.post(
            'saveMessages',
            {
                'sid':sid,
                'title':title,
                'author':author,
                'comment':comment
            }
        )
    });
});
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);