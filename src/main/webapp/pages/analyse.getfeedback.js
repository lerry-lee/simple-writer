
var data = JSON.stringify({
    'txt': $("#txt").val(),
    'action': 'fetch',
    'extra': {
        'feedbackOpt': 'r_01',
        'grammar': $("input[name='grammar']:checked").val(),
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
    });

});