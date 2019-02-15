
layui.use(['layedit','util', 'layer'], function () {
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
});

