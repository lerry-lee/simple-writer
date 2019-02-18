$(document).ready(function () {
    $.get(
        'queryReport',
        {},
        function (rst) {
            $('#txt').html(rst);
        }
    );
});