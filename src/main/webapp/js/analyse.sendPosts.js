layui.use(['layer', 'form'], function () {
    var layer = layui.layer;
    var form = layui.form;
    //点击右下角发帖
    $('#to-share').click(function () {
        var content = $('#content').val();
        var share_title = $('#share-title').val();
        var category = $('#category option:selected').val();
        if (content == '' || share_title == '') {
            layer.msg('内容或标题不能为空');
            return;
        }
        var data = {
            'content': content,
            'title': share_title,
            'category': category
        };
        $.ajax({
            type: 'post'
            , url: 'posts'
            , contentType: 'application/json;charset=utf-8'
            , data: JSON.stringify(data)
            , success: function (rst) {
                if (rst == '1') {
                    layer.msg('分享成功');
                }
            }
        });
    });

});
