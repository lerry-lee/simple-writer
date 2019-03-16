layui.use(['layer', 'flow', 'util'], function () {
    var layer = layui.layer;
    var flow = layui.flow;
    var util = layui.util;
    util.fixbar({
        bar1: '&#xe605;'
        // , bar2: '&#xe600;'
        , css: {right: 30, bottom: 50}
        , bgcolor: '#393D49;width:36px;height:36px;font-size:32px;line-height:36px'
        , click: function (type) {
            if (type === 'bar1') {
                $("a[name='to-comments']").click(function () {
                    var sid = $(this).attr("sid");
                    var title=$(this).attr("title");
                    var author=$(this).attr("author");
                    layer.open({
                        type: 2,
                        offset: '200px',
                        shade: 0.5,
                        title: '这篇帖子的评论都在下面了哦',
                        area: ['600px', '600px'],
                        content: 'toComment.jsp?sid=' + sid+'&title='+title+'&author='+author,
                    /*    success: function (layero, index) {
                            //注意这里的#sid是iframe页面中的一个标签id
                            var jquerySendHelloButton = $("#params", layero.find("iframe")[0].contentWindow.document);
                            jquerySendHelloButton.attr("sid", sid);
                            jquerySendHelloButton.attr("title", title);
                            jquerySendHelloButton.attr("author", author);
                        }*/
                    });
                });
            }
        }
    });
    flow_my.load({
        elem: '#main-listing' //流加载容器
        , isAuto: false
        , scrollElem: '#main-listing' //滚动条所在元素，一般不用填，此处只是演示需要。
        , done: function (page, next) { //执行下一页的回调
            //模拟数据插入
            var lis = [];
            $.get(
                'queryMyPosts',
                {'page': page},
                function (rst) {
                    map = JSON.parse(rst);
                    var json = map.json;
                    var pages = map.pages;
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
                            "                                <span class=\"comments\"><a name=\"to-comments\" title=\"" + json[i].title + "\" author=\"" + json[i].author +
                            "\" sid=\"" +
                            json[i].id +
                            "\">" +
                            json[i].totalComments +
                            " Comments</a></span>\n" +
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
                    next(lis.join(''), page < pages);
                }
            );
        }
    });
    setInterval(function () {
        $('p').readmore(
            {
                maxHeight: 44
            }
        );
    }, 100);
});
