$(function () {
    var url = $("#url-input").val();
    var startDate = $("#start-date").val();
    var endDate = $("#end-date").val();
    var status = $("input[name='status']:checked").val();
    $("#url-search").click(function () {
        $.get(
            "fuzzyQuery",
            {
                "url": url,
                "startDate": startDate,
                "endDate": endDate,
                "status": status
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