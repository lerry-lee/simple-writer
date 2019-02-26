layui.use(['rate','layer'], function () {
    var layer=layui.layer;
    var rate = layui.rate;
    var self,comparison,summary,automatic;
    rate.render({
        elem: '#test0'
        , value: 0
        , half: true
        , theme: '#FF8000' //自定义主题色
        , text: true
        ,choose: function(value){
            self=value;
        }
    });
    rate.render({
        elem: '#test1'
        , value: 0
        , half: true
        , theme: '#009688'
        , text: true
        ,choose: function(value){
            comparison=value;
        }
    });

    rate.render({
        elem: '#test2'
        , value: 0
        , half: true
        , theme: '#1E9FFF'
        , text: true
        ,choose: function(value){
            summary=value;
        }
    })
    rate.render({
        elem: '#test3'
        , value: 0
        , half: true
        , theme: '#2F4056'
        , text: true
        ,choose: function(value){
            automatic=value;
        }
    });


    $('#score-submit').click(function () {
        var content=parent.$('#temporary-storage').html();

        var title=$('#title').val();
        if($.trim(title)==''){
            layer.msg('请填写标题后再提交哦')
        }
        else if(self==undefined||comparison==undefined||summary==undefined||automatic==undefined){
            layer.msg('请全部评分后再提交哦');
        }else {
            $.post(
                'saveReflectiveScore',
                {
                    'title':title,
                    'content':content,
                    'self':self,
                    'comparison':comparison,
                    'summary':summary,
                    'automatic':automatic
                },
                function (rst) {
                    if(rst=='1')
                        layer.msg('保存成功');
                    else
                        layer.msg('保存失败');
                }
            )
        }
    });

});

