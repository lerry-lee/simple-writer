$(document).ready(function () {
    $.get(
        "getAllHttpInfo",
        {},
        function (list) {
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