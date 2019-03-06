layui.use('element', function () {
    var element = layui.element;
    $.get(
        'queryMessages',
        function (rst) {
            var json = JSON.parse(rst);
            for (var i in json) {
                $('#messages').append("<div class=\"layui-colla-item\">"+
                "<h2 class=\"layui-colla-title\">"+json[i].message+"</h2>"+
                    "<div class=\"layui-colla-content layui-show\">"+json[i].comment+"</div></div>");
            }
        }
    );
});