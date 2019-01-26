var data = JSON.stringify({
    'txt': $("#txt").val(),
    'action': 'fetch',
    'extra': {
        'feedbackOpt': 'r_01',
        'grammar': $("#grammar").find("option:selected").text(),
        'feature': 7
    },
    'type': 'manual'
});
$(function () {
    $("#send").click(function () {
        var url = "sendHttpPostJson";
        $.post(
            url,
            {"param_json": data},
            function () {
                //格式化json
                // var objectJson=JSON.parse(result);
                // var formatJson=JSON.stringify(objectJson,null,4);
                $("#rst").html("成功，查看结果请点击导航栏Feedback和Tips");
            }
        );
    });

});