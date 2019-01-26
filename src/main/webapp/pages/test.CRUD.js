$(document).ready(function () {
    var tables = $('#table_id').DataTable({
        "oLanguage": { //表格的语言设置
            "sProcessing": "正在获取数据，请稍后...",
            "sLengthMenu": "显示 _MENU_ 条",
            "sZeroRecords": "没有您要搜索的内容",
            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "记录数为0",
            "sInfoFiltered": "(全部记录数 _MAX_ 条)",
            "sInfoPostFix": "",
            "sSearch": "搜索",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "最后一页"
            }
        },
        "bProcessing": true, //DataTables载入数据时，是否显示‘进度’提示
        // "serverSide": true,
        "autoWidth": false,
        //"sScrollY" : 350, //DataTables的高
        "sPaginationType": "full_numbers", //详细分页组，可以支持直接跳转到某页
        "iDisplayStart": 0,//刷新插件后显示的第几页（如果一页为10条数据，填10就显示第二页）
        "ajax": {
            "url": "url地址"//输入url地址
        },
        columns: [//定义接受到的数据，“key”
            {data: 'id'},
            {data: 'name'},
            {data: 'industry'},
            {data: 'source'},
            {data: 'location'},
            {data: 'serviceStatus'},
            {data: null}
        ],
        'bStateSave': true,//配置好这个,刷新页面会让页面停留在之前的页码
        "columnDefs": [{
            "targets": 6,//编辑
            "data": null,//下面这行，添加了编辑按钮和，删除按钮
            "defaultContent": "<button id='editrow' class='btn btn-primary' type='button' style='margin-right:10px;'>编辑</button><button id='delrow' class='btn btn-primary' type='button'>删除</button>"
        }],
        "createdRow": function (row, data, index) {
            //每加载完一行的回调函数
            $('td', row).eq(5).css('font-weight', "bold").css("color", "red");//获取到具体行具体格的元素

        }
    });
    //以下为自定义的删除按钮事件，可以忽略，也可以参考写法
    $('#table_id tbody').on('click', 'button#delrow', function () {
        var data = tables.row($(this).parents('tr')).data();
        //tables.ajax.reload();重新获取数据
        //tables.draw(false);重新刷新页面
        if (confirm("是否确认删除这条信息")) {
            $.ajax({
                url: 'http://10.10.1.183:8080/crm/enterprise/' + data.id,
                type: 'delete',
                timeout: "3000",
                cache: "false",
                success: function (str) {
                    if (str.data) {
                        tables.row().remove();//删除这行的数据
                        window.location.reload();//重新刷新页面，还有一种方式：tables.draw(false);(这是不刷新，重新初始化插件，但是做删除时候，老有问题)
                    }
                },
                error: function (err) {
                    alert("获取数据失败");
                }
            });
        }

    });
    $('#table_id tbody i').css({"fontStyle": "normal"});
    $('#table_id tbody').on('click', 'button#editrow', function () {
        //获取数据
        var data = tables.row($(this).parents('tr')).data();
        //清空内容
        $('.pop_clear_text input').val('');
        //弹出层展示
        $('.pop').show();
        //填充内容
        $('.pop_id').val(data.id);
        $('.pop_name').val(data.name);
        $('.pop_industry').val(data.industry);
        $('.pop_source').val(data.source);
        $('.pop_location').val(data.location);
        $('.pop_serviceStatus').val(data.serviceStatus);
    });
    //弹出层的功能
    $('.pop_cancel,.pop_close').on("click", function () {
        $('.pop').hide();
    });
    $('.pop_confirm').on('click', function () {
        var n = parseInt($('.pop_id').val());
        console.log(typeof (n));
        $.ajax({
            url: 'http://10.10.1.183:8080/crm/enterprise',
            type: 'PUT',
            contentType: "application/json",
            timeout: "3000",
            cache: false,
            data: JSON.stringify({
                "id": n,
                "name": $('.pop_name').val(),
                "industry": $('.pop_industry').val(),
                "location": $('.pop_location').val(),
                "source": $('.pop_source').val(),
                "serviceStatus": $('.pop_serviceStatus').val()
            }),
            dataType: "json",
            success: function (str) {
                //弹窗关闭
                $('.pop').hide();
                window.location.reload();
            },
            error: function (err) {
                alert("数据刷新失败,请重新刷新");
            }
        });
    });
    //添加事件
    $('.table_list_add').on("click", function () {
        //先清空
        $('.table_list_name').val('');
        $('.table_list_industry').val('');
        $('.table_list_source').val('');
        $('.table_list_location').val('');
        $('.table_list_serviceStatus').val('');
        //展示
        $('.table_list').show();
    });
    //增加弹窗的功能
    $('.table_list_close,.table_list_cancel').on("click", function () {
        $('.table_list').hide();
    });
    $('.table_list_confirm').on("click", function () {
        $.ajax({
            url: 'http://10.10.1.183:8080/crm/enterprise',
            type: 'POST',
            contentType: "application/json",
            timeout: "3000",
            cache: false,
            data: JSON.stringify({
                "name": $('.table_list_name').val(),
                "industry": $('.table_list_industry').val(),
                "location": $('.table_list_location').val(),
                "source": $('.table_list_source').val(),
                "serviceStatus": $('.table_list_serviceStatus').val()
            }),
            dataType: "json",
            success: function (str) {
                //弹窗关闭
                $('.table_list').hide();
                window.location.reload();
                $('#table_id_last').click();
            },
            error: function (err) {
                alert("数据刷新失败,请重新刷新");
            }
        });
    });
    //控制这个表格大小
    $('#table_id_wrapper').css({"width": "1400px", "margin": "20px auto"});
});