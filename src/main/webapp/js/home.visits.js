//获得访问量
$(function () {
    $.ajax({
        type: 'get'
        , url: 'visits'
        , data: {}
        , success: function (rst) {
            $('#visits').append(rst);
        }
    });
});