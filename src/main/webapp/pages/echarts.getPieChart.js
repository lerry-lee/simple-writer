$(document).ready(function () {

    $.get(
        "requestTimesPieChart",
        {},
        function (map) {
            var objectJson = JSON.parse(map);
            var arrayJson = [];

            for (var key in objectJson) {
                var arr = {
                    value: objectJson[key],
                    name: key
                };
                arrayJson.push(arr);
            }

            var pieChart = echarts.init(document.getElementById("echarts"));
            var option = {
                backgroundColor: '#FFF',

                title: {
                    text: 'UrlRequest PieChart',
                    left: 'center',
                    top: 20,
                    textStyle: {
                        color: '#CCC'
                    }
                },

                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },

                visualMap: {
                    show: false,
                    min: 80,
                    max: 600,
                    inRange: {
                        colorLightness: [0, 1]
                    }
                },
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        data: arrayJson.sort(function (a, b) {
                            return a.value - b.value;
                        }),
                        roseType: 'radius',
                        label: {
                            normal: {
                                textStyle: {
                                    color: 'rgba(112, 128, 144, 0.3)'
                                }
                            }
                        },
                        labelLine: {
                            normal: {
                                lineStyle: {
                                    color: 'rgba(255, 255, 255, 0.3)'
                                },
                                smooth: 0.2,
                                length: 10,
                                length2: 20
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: '#87cefa',
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },

                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function (idx) {
                            return Math.random() * 200;
                        }
                    }
                ]
            };

            pieChart.setOption(option);

        }
    );

});
