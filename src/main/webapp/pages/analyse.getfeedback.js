layui.use(['layedit', 'util', 'layer'], function () {
    var util = layui.util;
    var layer=layui.layer;
    var layedit = layui.layedit;
    //构建一个默认的编辑器
    var index = layedit.build('txt');
    //固定块
    util.fixbar({
        bar1:'&#xe62e;'
        , bar2: '&#xe62e;'
        , css: {right: 50, bottom: 100}
        , bgcolor: '#393D49;width:36px;height:36px;font-size:32px;line-height:36px'
        , click: function (type) {
            if (type === 'bar1') {
                window.location.hash='#to-feedback';
                layer.tips('反馈内容在这里哦','#to-feedback',{tips:1});
            } else if (type === 'bar2') {
                window.location.hash='#to-tips';
                layer.tips('提示内容在这里哦','#to-tips',{tips:1});
            }
        }
    });

    //监听键盘按下，保存写作内容
    // $("#txt").keyup(function () {
       var timer=setInterval(function () {
           var content=layedit.getContent(index);
           $.post(
               'saveReport',
               {'content':content},
               function (rst) {
                   if(rst=='1')
                       layer.msg('content saved');
               }
           );
       },5000);
    // });

    //监听analyse按钮点击，分析文本
    $("#send").click(function () {
            var txt = layedit.getText(index);
            var grammar = $("input[name='grammar']:checked").val();

            if ($.trim(txt) == '') {
                layer.msg('写作内容为空！');
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
