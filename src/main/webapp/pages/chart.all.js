layui.use(['table', 'laydate'], function () {
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
        url: 'getTitle',
        page: true,
        cols: [[
            {field: 'id', title: 'ID',align:'center', width: 100, unresize: true, sort: true, fixed: 'left'},
            {field: 'title', title: '标题',align:'center'},
            {field: 'sdate', title: '时间',align:'center'},
            {field: 'right',title:'操作',align:'center',toolbar: '#barDemo'}
        ]]
    });

    table.on('tool(test)', function (obj) {
        var layEvent=obj.event;
        var data=obj.data;
        var tr=obj.tr;
        if (layEvent == 'del') {
            layer.confirm('确定删除该行吗？', {offset:'200px'},function (index) {
                obj.del();
                layer.close(index);
                $.get(
                    'deleteFromReflective',
                    {
                        'id':data.id
                    },
                    function (rst) {
                        if(rst=='1')
                            layer.msg('删除成功',{offset:'200px'});
                        else layer.msg('失败',{offset:'200px'});
                    }
                );
            });
        } else if (layEvent === 'detail') {
            layer.alert(data.content, {title: data.title, offset: '200px'})
        }
    });

    $('#title-search').click(function () {
        var title = $("#title-input").val();
        var date_time = $("#date-time").val();
        var start_date = date_time.substring(0, 19);
        var end_date = date_time.substring(22, 41);
        table.reload('demo', {
            url: 'fuzzyQueryReflective',
            where: {
                "title": title,
                "start_date": start_date,
                "end_date": end_date,
            }
        });
    });


    $.get(
        'getScore',
        function (rst) {
            var data = JSON.parse(rst);

            var id_row1 = data[0][1];
            if (id_row1 == undefined) {
                layer.msg('还没有数据哦，快去写作和评分吧', {offset: '200px'});
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
                                formatter: '{b}: {@' + id_row1 + '} ({d}%)'
                            },
                            encode: {
                                itemName: 'id',
                                value: id_row1,
                                tooltip: id_row1
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


