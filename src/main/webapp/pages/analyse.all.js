$(document).ready(function () {
    $.get(
        'queryReport',
        function (rst) {
            $('#txt').html(rst);
        }
    );
});

layui.use(['layedit', 'util', 'layer','form'], function () {
    var util = layui.util;
    var layer = layui.layer;
    var layedit = layui.layedit;
    var form=layui.form;
    //构建一个默认的编辑器
    var index = layedit.build('txt');
    //固定块
    util.fixbar({
        bar1: '&#xe611;'
        // , bar2: '&#xe600;'
        , css: {right: 30, bottom: 50}
        , bgcolor: '#393D49;width:36px;height:36px;font-size:32px;line-height:36px'
        , click: function (type) {
            if (type === 'bar1') {
                layer.open({
                    type: 2,
                    offset: '200px',
                    title: '编辑帖子分享到社区',
                    area: ['600px', '550px'],
                    content: 'toShare.jsp'
                });
            }
        }
    });
    //每隔5S监听文本域内容变化保存到数据库
    setInterval(function () {
        var content_last = layedit.getContent(index);

        setTimeout(function () {
            var content = layedit.getContent(index);

            if (content_last == content) ;
            else {
                $.post(
                    'saveReport',
                    {'content': content},
                    function (rst) {
                        if (rst == '1') ;
                        layer.msg('content saved', {icon: 1});
                    }
                );
            }

        }, 4999);
    }, 5000);
    //评分存档
    $('#score').click(function () {
        $('#temporary-storage').html(layedit.getContent(index));
        layer.open({
            type: 2,
            offset: '200px',
            shade: 0.5,
            title: '给写作过程评分并保存此次写作版本',
            area: ['400px', '350px'],
            content: 'toScore.jsp'
        });
    });

    //分析报告
    $("#send").click(function () {
            var txt = layedit.getText(index);
            var feature = $('#genre option:selected').val();
            var grammar = feature == 8 ? 'reflective' : 'analytical';
            if ($.trim(txt) == '') {
                layer.msg('写作内容为空！');
                return;
            }
            if (feature == 0) {
                layer.msg('请选择类型！');
                return;
            }
            var loading = layer.load(0, {shade: false, offset: '50vh'});
            $('#feedback').empty();
            $('#analyticalReport8').css('display', 'none');
            $('#analyticalReport6').css('display', 'none');
            $('#analyticalReport7').css('display', 'none');
            $('#analyticalReport5').css('display', 'none');
            $('#tips').css('display', 'none');
            $('#examples').css('display', 'none');
            $('#resources').css('display', 'none');
            $('#r-tips').css('display', 'none');
            $('#r-examples').css('display', 'none');
            $('#r-resources').css('display', 'none');

            var data = JSON.stringify({
                'txt': txt,
                'action': 'fetch',
                'extra': {
                    'feedbackOpt': 'r_01',
                    'grammar': grammar,
                    'feature': feature
                },
                'type': 'manual'
            });

            $.post(
                'sendHttpPostJson',
                {
                    'param_json': data,
                    'feature': feature
                },
                function (result) {
                    layer.close(loading);

                    if (feature == 7) {
                        $('#analyticalReport7').css('display', 'block');
                        $('#tips').css('display', 'block');
                        $('#r-tips').css('display', 'block');
                        // 格式化json
                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        for (key in objectJson) {
                            feedback = objectJson[1] + objectJson[2] + objectJson[3];
                        }
                        $("#feedback").html(feedback);
                    } else if (feature == 6) {
                        $('#analyticalReport6').css('display', 'block');
                        $('#examples').css('display', 'block');
                        $('#r-examples').css('display', 'block');

                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        for (key in objectJson) {
                            feedback = objectJson[1] + objectJson[2];
                        }
                        $("#feedback").html(feedback);
                    } else if (feature == 5) {
                        $('#analyticalReport5').css('display', 'block');
                        $('#resources').css('display', 'block');
                        $('#r-resources').css('display', 'block');

                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        for (key in objectJson) {
                            feedback = objectJson[1] + objectJson[2];
                        }
                        $("#feedback").html(feedback);
                    } else {
                        $('#analyticalReport8').css('display', 'block');
                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        for (key in objectJson) {
                            feedback = objectJson[1] + objectJson[2];
                        }
                        $("#feedback").html("<div class='alert alert-secondary'>" + feedback + "</div>");
                    }

                }
            );

        }
    );
});

