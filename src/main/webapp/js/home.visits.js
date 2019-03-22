//获得访问量
$(function () {
    $.get(
        'getVisits',
        function (rst) {
            $('#visits').append(rst);
        }
    );
});