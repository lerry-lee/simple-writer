
$(document).ready(function () {
        $.get(
            "getAllHttpInfo",
            {},
            function (list) {
                var json=JSON.parse(list)
                console.log(json);
                for(var i in json){
                    $("#tb").append(
                        "<tr onmouseover=\"this.style.backgroundColor='#ffff66'\" onmouseout=\"this.style.backgroundColor='d4e3e5'\"><td>"+json[i].id+
                        "</td><td>"+json[i].date+
                        "</td><td>"+json[i].url+
                        "</td><td>"+json[i].method+
                        "</td><td>"+json[i].ip+
                        "</td><td>"+json[i].param+
                        "</td><td>"+json[i].status+
                        "</td><td>"+json[i].timeConsuming+
                        "</td></tr>"
                    );
                }
            }
        );
});