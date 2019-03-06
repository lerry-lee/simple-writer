

layui.use(['table','laydate'], function () {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#date-time'
        , type: 'datetime'
        , range: true
    });
    var table = layui.table;
    table.render({
        elem: '#demo',
        height: 312,
        url: 'getAllReflectiveTitle',
        page: true,
        cols: [[
            {field: 'id', title: 'ID', width: 100, sort: true, fixed: 'left'},
            {field: 'title', title: '标题'},
            {field: 'sdate', title: '保存时间'},
        ]]
    });

    $('#title-search').click(function () {
        var title = $("#title-input").val();
        var date_time = $("#date-time").val();
        var startDate = date_time.substring(0, 19);
        var endDate = date_time.substring(22, 41);

        table.reload('demo', {
            url: 'fuzzyQuery',
            where: {
                "title": title,
                "startDate": startDate,
                "endDate": endDate,
            }
        });
    });
});


$(function () {

    $.get(
        'getScore',
        {},
        function (rst) {
            var data = JSON.parse(rst);
            var sdate_row1=data[0][1];
            if(sdate_row1==undefined){
                layer.msg('还没有数据哦，快去评分吧');
                return;
            }
            setTimeout(function () {

                var option = {
                    legend: {},
                    tooltip: {
                        trigger: 'axis',
                        showContent: false
                    },
                    dataset: {
                        source: data
                    },
                    xAxis: {type: 'category'},
                    yAxis: {gridIndex: 0},
                    grid: {top: '55%'},
                    series: [
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {type: 'line', smooth: true, seriesLayoutBy: 'row'},
                        {
                            type: 'pie',
                            roseType: 'angle',
                            itemStyle: {
                                // 阴影的大小
                                shadowBlur: 60,
                                // 阴影水平方向上的偏移
                                shadowOffsetX: 0,
                                // 阴影垂直方向上的偏移
                                shadowOffsetY: 0,
                                // 阴影颜色
                                shadowColor: 'rgba(0, 0, 0, 0.3)'
                            },
                            id: 'pie',
                            radius: '40%',
                            center: ['50%', '25%'],
                            label: {
                                formatter: '{b}: {@'+data[0][1]+'} ({d}%)'
                            },
                            encode: {
                                itemName: "sdate",
                                value:data[0][1],
                                tooltip:data[0][1]
                            }
                        }
                    ]
                };
                var myChart = echarts.init(document.getElementById("echarts"));
                myChart.on('updateAxisPointer', function (event) {
                    var xAxisInfo = event.axesInfo[0];
                    if (xAxisInfo) {
                        var dimension = xAxisInfo.value + 1;
                        myChart.setOption({
                            series: {
                                id: 'pie',
                                label: {
                                    formatter: '{b}: {@[' + dimension + ']} ({d}%)'
                                },
                                encode: {
                                    value: dimension,
                                    tooltip: dimension
                                }
                            }
                        });
                    }
                });

                myChart.setOption(option);

            });


        }
    );


});

