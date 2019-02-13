$(document).ready(function () {

    $.get(
        "getUrlCount",
        {},
        function (map) {
            var objectJson = JSON.parse(map);
            var arrayJson = [];
            var dataArray = [];
            for (var key in objectJson) {
                var arr = {
                    value: objectJson[key],
                    name: key
                };
                arrayJson.push(arr);
                dataArray.push(key);
            }

            var pieChart = echarts.init(document.getElementById("echarts"));

            var option = {
                title: {
                    text: 'HTTP REQUEST TIMES PIE CHART',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b}: {c} ({d}%)"
                },
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0,0,0,0.5)'
                            }
                        },
                        data: arrayJson
                    }
                ]
            };


            pieChart.setOption(option);

        }
    );

});
