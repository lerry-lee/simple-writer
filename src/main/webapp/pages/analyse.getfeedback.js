layui.use(['layedit', 'util', 'layer'], function () {
    var util = layui.util;
    var layedit = layui.layedit;
    //构建一个默认的编辑器
    var index = layedit.build('txt');
    //固定块
    util.fixbar({
        bar1: false
        , css: {right: 50, bottom: 100}
        , bgcolor: '#393D49'
    });

    $("#send").click(function () {
            var txt = layedit.getText(index);
            var grammar = $("input[name='grammar']:checked").val();

            if ($.trim(txt) == '') {
                alert('写作内容为空！');
                return;
            } else {
                var data = JSON.stringify({
                    'txt': txt,
                    'action': 'fetch',
                    'extra': {
                        'feedbackOpt': 'r_01',
                        'grammar': grammar,
                        'feature': 7
                    },
                    'type': 'manual'
                });
                var url = "sendHttpPostJson";
                $.post(
                    url,
                    {"param_json": data},
                    function (result) {
                        // 格式化json
                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        var tips = "";
                        for (key in objectJson) {
                            feedback = objectJson[1] + objectJson[2] + objectJson[3];
                            tips = objectJson[4];
                        }
                        $("#feedback").html(feedback);
                        $("#tips").html(tips);
                    }
                );
            }
        }
    );
});
