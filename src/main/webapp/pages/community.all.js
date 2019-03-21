layui.use(['layer', 'flow', 'util', 'element', 'laypage'], function () {
    var layer = layui.layer;
    var flow = layui.flow;
    var util = layui.util;
    var element = layui.element;
    var laypage = layui.laypage;

    util.fixbar({
        bar1: '&#xe611;'
        , css: {right: 30, bottom: 50}
        , bgcolor: '#393D49;width:36px;height:36px;font-size:32px;line-height:36px'
        , click: function (type) {
            if (type === 'bar1') {
                layer.open({
                    type: 2,
                    offset: '200px',
                    title: '编辑帖子分享到社区',
                    area: ['600px', '550px'],
                    content: 'toShare.jsp'
                });
            }
        }
    });

    $.get(
        'countMessages'
        ,function (rst) {
            $('#totalMessages').html(rst);
        }
    )

    $('#allPosts').click(function () {
        $('#search_posts').attr('author', 'All');
        $('#search_posts').attr('category', 'All');
        var data = [];
        $.get({
                async: false,
                url: 'queryAllPosts',
                data: {},
                success: function (rst) {
                    var json = JSON.parse(rst);

                    for (var i in json) {
                        data.push("<article class='format-standard type-post hentry clearfix'>" +
                            "<header class='clearfix'><h3 class='post-title'>" +
                            json[i].title + "</h3>" +
                            "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                            "<span class='date'>" +
                            json[i].sdate + "</span><span class='category'>" +
                            json[i].category + "</span>" +
                            "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                            "' sid='" + json[i].id + "'>" + json[i].totalComments +
                            " Comments</a></span>" + "<span class='by-author'>" +
                            json[i].author + "</span></div>" +
                            "<hr class='layui-bg-gray'></header>" +
                            "<p>" + json[i].content + "</article>");
                    }

                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });
    $('#myPosts').click(function () {
        $('#search_posts').attr('author', 'My');
        $('#search_posts').attr('category', 'All');
        var data = [];
        $.get({
                async: false,
                url: 'queryMyPosts',
                data: {},
                success: function (rst) {
                    var json = JSON.parse(rst);

                    for (var i in json) {
                        data.push("<article class='format-standard type-post hentry clearfix'>" +
                            "<header class='clearfix'><h3 class='post-title'>" +
                            json[i].title + "</h3>" +
                            "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                            "<span class='date'>" +
                            json[i].sdate + "</span><span class='category'>" +
                            json[i].category + "</span>" +
                            "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                            "' sid='" + json[i].id + "'>" + json[i].totalComments +
                            " Comments</a></span>" + "<span class='by-author'>" +
                            json[i].author + "</span></div>" +
                            "<hr class='layui-bg-gray'></header>" +
                            "<p>" + json[i].content + "</article>");
                    }

                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });

    $('#search_posts').click(function () {
        var author = $(this).attr('author');
        var key_words = $('#key_words').val();
        var category = $(this).attr('category');
        var data = [];
        $.get({
                async: false,
                url: 'fuzzyQueryPosts',
                data: {
                    'key_words': key_words,
                    'category': category,
                    'author': author
                },
                success: function (rst) {
                    var json = JSON.parse(rst);

                    for (var i in json) {
                        data.push("<article class='format-standard type-post hentry clearfix'>" +
                            "<header class='clearfix'><h3 class='post-title'>" +
                            json[i].title + "</h3>" +
                            "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                            "<span class='date'>" +
                            json[i].sdate + "</span><span class='category'>" +
                            json[i].category + "</span>" +
                            "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                            "' sid='" + json[i].id + "'>" + json[i].totalComments +
                            " Comments</a></span>" + "<span class='by-author'>" +
                            json[i].author + "</span></div>" +
                            "<hr class='layui-bg-gray'></header>" +
                            "<p>" + json[i].content + "</article>");
                    }

                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    return arr.join('');
                }();
            }
        });

    });
    $("a[name='choose_category']").click(function () {
        $("a[name='choose_category']").css('color', '#777');
        $(this).css('color', '#5FB878');
        var author = $('#search_posts').attr('author');
        var category = $(this).attr('category');
        $('#search_posts').attr('category', category);
        var data = [];
        $.get({
                async: false,
                url: 'queryPostsByCategory',
                data: {
                    'category': category,
                    'author': author
                },
                success: function (rst) {
                    var json = JSON.parse(rst);

                    for (var i in json) {
                        data.push("<article class='format-standard type-post hentry clearfix'>" +
                            "<header class='clearfix'><h3 class='post-title'>" +
                            json[i].title + "</h3>" +
                            "<hr class='layui-bg-gray'><div class='post-meta clearfix'>" +
                            "<span class='date'>" +
                            json[i].sdate + "</span><span class='category'>" +
                            json[i].category + "</span>" +
                            "<span class='comments'><a name='to-comments' title='" + json[i].title + "' author='" + json[i].author +
                            "' sid='" + json[i].id + "'>" + json[i].totalComments +
                            " Comments</a></span>" + "<span class='by-author'>" +
                            json[i].author + "</span></div>" +
                            "<hr class='layui-bg-gray'></header>" +
                            "<p>" + json[i].content + "</article>");
                    }

                }
            }
        );
        //分页模块
        laypage.render({
            elem: 'posts_demo'
            , count: data.length
            , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip']
            , jump: function (obj) {
                //模拟渲染
                document.getElementById('posts_list').innerHTML = function () {
                    var arr = []
                        , thisData = data.concat().splice(obj.curr * obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function (index, item) {
                        arr.push(item);
                    });
                    // console.log( thisData+''+arr);
                    return arr.join('');
                }();
            }
        });
    });
    $('#main-listing').delegate("p[name='readmore']",'load',function () {
        $('p').readmore(
            {
                maxHeight: 44
            }
        );
    });
    $('#main-listing').delegate("a[name='to-comments']", "click", function () {
        var sid = $(this).attr("sid");
        var title = $(this).attr("title");
        var etitle = encodeURI(encodeURI(title));
        var author = $(this).attr("author");
        layer.open({
            type: 2,
            offset: '200px',
            shade: 0.5,
            title: '这篇文章的评论都在下面了哦',
            area: ['600px', '600px'],
            content: 'toComment.jsp?sid=' + sid + '&title=' + etitle + '&author=' + author
        });
    });
    $('#systemMessages').click(function () {
        layer.open({
            type: 1
            ,title: false //不显示标题栏
            ,closeBtn: false
            ,area: '300px;'
            ,shade: 0.8
            ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
            ,resize: false
            ,btn: ['火速围观', '残忍拒绝']
            ,btnAlign: 'c'
            ,moveType: 1 //拖拽模式，0或者1
            ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">该项目在Github同步维护<br>如需访问请前往</div>'
            ,success: function(layero){
                var btn = layero.find('.layui-layer-btn');
                btn.find('.layui-layer-btn0').attr({
                    href: 'https://github.com/lca1070841799/writer1'
                    ,target: '_blank'
                });
            }
        });
    });
    setTimeout(function () {
        $('p').readmore(
            {
                maxHeight: 44
            }
        );
    },500)

});
