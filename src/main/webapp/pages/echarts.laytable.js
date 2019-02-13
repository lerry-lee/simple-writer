layui.use('laydate', function () {
    var laydate = layui.laydate;
    laydate.render({
        elem: '#date-time'
        , type: 'datetime'
        , range: true
    });
});

layui.use('table', function () {
    var table = layui.table;
    table.render({
        elem: '#demo',
        height: 312,
        url: 'getAllHttpInfo',
        page: true,
        cols: [[
            {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'},
            {field: 'date', title: '请求时间', width: 80},
            {field: 'url', title: '请求地址', width: 80},
            {field: 'method', title: '请求参数', width: 80},
            {field: 'ip', title: '请求方法', width: 80},
            {field: 'param', title: 'IP', width: 80},
            {field: 'status', title: '返回状态', width: 80, sort: true},
            {field: 'timeConsuming', title: '响应时间', width: 80, sort: true},
        ]]
    });
    var url = $("#url-input").val();
    var date_time = $("#date-time").val();
    var startDate = date_time.substring(0, 19);
    var endDate = date_time.substring(22, 41);
    var method = $("input[name='method']:checked").val();

    $('#url-search').click(function () {
        table.reload('demo', {
            url: 'fuzzyQuery',
            where: {
                "url": url,
                "startDate": startDate,
                "endDate": endDate,
                "method": method
            }
        });
    });
});

