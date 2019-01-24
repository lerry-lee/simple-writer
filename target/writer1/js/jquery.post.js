var data = JSON.stringify({
    'txt': $("#txt").val(),
    'action': $("#action").val(),
    'extra': {
        'feedbackOpt': $("#feedbackOpt").val(),
        'grammar': $("#grammar").find("option:selected").text(),
        'feature': $("#feature").val()
    },
    'type': $("#type").val()
});
$(function () {
    $("#send").click(function () {
        var url = "sendHttpPostJson";
        // alert(data);
        $.post(
            url,
            {"param_json": data},
            function (result) {
                var objectJson=JSON.parse(result);
                var formatJson=JSON.stringify(objectJson,null,4);
                alert("HTTP请求返回结果：\n"+formatJson);
                $("#rst").html(formatJson);
            }
        );
    });

});