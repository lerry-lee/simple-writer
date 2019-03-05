layui.use(['layer', 'flow'], function () {
    var layer = layui.layer;
    var flow = layui.flow;



    flow.load({
        elem: '#main-listing' //流加载容器
        , scrollElem: '#main-listing' //滚动条所在元素，一般不用填，此处只是演示需要。
        , done: function (page, next) { //执行下一页的回调

            //模拟数据插入
            var json = [];
            var lis = [];
            $.get(
                'queryShare',
                {'page':page},
                function (rst) {
                    map = JSON.parse(rst);
                    var json=map.json;
                    var pages=map.pages;
                    for (var i in json) {
                        lis.push("<article class=\"format-standard type-post hentry clearfix\">\n" +
                            "                        <header class=\"clearfix\">\n" +
                            "                            <h3 class=\"post-title\">\n" +
                            json[i].title +
                            "                            </h3>\n" +
                            "\n" +
                            "                            <div class=\"post-meta clearfix\">\n" +
                            "                                <span class=\"date\">" +
                            json[i].sdate +
                            "</span>\n" +
                            "                                <span class=\"category\">" +
                            json[i].category +
                            "</span>\n" +
                            "                                <span class=\"comments\"><a name=\"to-comments\" sid=\"007\">" +
                            json[i].totalComments +
                            " Comments</a></span>\n" +
                            "                                <span class=\"like-count\">66</span>\n" +
                            "<span id=\"sid\" style=\"display: none\">" +
                            json[i].id +
                            "+</span>" +
                            "                            </div>\n" +
                            "\n" +
                            "                        </header>\n" +
                            "\n" +
                            "                        <p>" +
                            json[i].content +
                            "                    </article><hr class=\"layui-bg-gray\">");
                    }
                    //执行下一页渲染，第二参数为：满足“加载更多”的条件，即后面仍有分页
                    //pages为Ajax返回的总页数，只有当前页小于总页数的情况下，才会继续出现加载更多
                    next(lis.join(''), page < pages); //假设总页数为 10
                }
            );
            $('p').readmore(
                {
                    maxHeight: 44
                }
            );
            $("a[name='to-comments']").click(function () {
                var sid = $(this).attr("sid");

                layer.open({
                    type: 2,
                    offset: '100px',
                    shade: 0.5,
                    title: '这篇文章的评论都在下面了哦',
                    area: ['600px', '600px'],
                    content: 'comments.jsp'
                });
            });
        }
    });


});
