$(function () {
    var url = $("#url-input").val();
    var date_time=$("#date-time").val();
    var startDate = date_time.substring(0,19);
    var endDate = date_time.substring(22,41);
    var method = $("input[name='method']:checked").val();

    $("#url-search").click(function () {
        $.get(
            "fuzzyQuery",
            {
                "url": url,
                "startDate": startDate,
                "endDate": endDate,
                "method": method
            },
            function (list) {
                $("#tb tr:not(:first)").empty();
                var json = JSON.parse(list);
                for (var i in json) {
                    $("#tb").append(
                        "<tr><td>" + json[i].id +
                        "</td><td>" + json[i].date +
                        "</td><td>" + json[i].url +
                        "</td><td>" + json[i].method +
                        "</td><td>" + json[i].ip +
                        "</td><td>" + json[i].param +
                        "</td><td>" + json[i].status +
                        "</td><td>" + json[i].timeConsuming +
                        "</td></tr>"
                    );
                }
            }
        );
    });
});