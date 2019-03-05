layui.use(['layer'],function () {
    var layer=layui.layer;

    $.post(
        'queryComments',
        {
            'sid':1
        },
        function (rst) {
           var json=JSON.parse(rst);
           for(var i in json){
               $('#commments-list').append("<article><p style='color: grey'>" +
                   json[i].cdate+
                   "</p><p>" +
                   json[i].comment+
                   "</p></article><hr class=\"layui-bg-gray\">");
           }
        }
    );

    $('#save-comment').click(function () {
        var comment=$('#comment').val();
        $.post(
            'saveComments',
            {
                'sid':1,
                'comment':comment
            },
            function (rst) {
                if(rst=='1')
                    layer.msg('成功');
            }
        );
    });
});