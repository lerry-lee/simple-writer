layui.use(['carousel', 'form'], function () {
    var carousel = layui.carousel
        , form = layui.form;

    //常规轮播
    carousel.render({
        elem: '#test1'
        , arrow: 'always'
    });
    //改变下时间间隔、动画类型、高度
    carousel.render({
        elem: '#test1'
        , interval: 5000
        , anim: 'default'
        , height: '80%'
        , width: '100%'
    });

});