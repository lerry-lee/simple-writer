$(function () {
    //加载上次保存写作内容
    $.get(
        'queryReport',
        function (rst) {
            if (rst != 'null')
                $('#txt').html(rst);
        }
    );
});
layui.use(['layedit', 'util', 'layer', 'form'], function () {
    var util = layui.util;
    var layer = layui.layer;
    var layedit = layui.layedit;
    var form = layui.form;
    //构建一个默认的编辑器
    var index = layedit.build('txt');
    //固定块
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
                    content: 'editPosts.jsp'
                });
            }
        }
    });

    //每隔5S监听文本域内容变化保存到数据库
    setInterval(function () {
        var content_last = layedit.getContent(index);

        setTimeout(function () {
            var content = layedit.getContent(index);

            if (content_last == content) ;
            else {
                $.post(
                    'saveReport',
                    {'content': content},
                    function (rst) {
                        if (rst == '1') ;
                        layer.msg('content saved', {icon: 1});
                    }
                );
            }

        }, 4999);
    }, 5000);

    //监听select选择,预填充文本
    form.on('select(genre)', function (data) {
        var content = layedit.getText(index);

        if (content == '') {
            if (data.value == 6) {
                var test = ("Technology is an enabler in providing greater access to justice through its ability to connect people with legal needs to legal assistance, information, and advice. With the increasing popularity of internet-enabled hand held devices and laptop computers, there is a tendency to assume that even the socio-economically vulnerable in our society have access to technology and the skills to use online services with confidence. This is not necessarily the case. \n" +
                    "\n" +
                    "Examples of the application of technology to provide legal information and assistance include case studies, guides and virtual legal advice clinics. The 2012 Review does not address the role of courts in serving the legal needs of the community. The court system is not regarded as a part of the wider legal assistance services. This omission questions the role of the court in facilitating access to its services, including dispute resolution and trials. It also identified uses of technology to expand the delivery of services, many of which are transferable to an online court. These services include e-access for remote communities, availability outside of business hours, interactive processes and virtual appearances. This essay will discuss uses of technology to expand the delivery of services, many of which are transferable to an online court.")
                layedit.setContent(index, test, false);
            } else if (data.value == 5) {
                var test = ("It is now widely accepted that timely, actionable feedback is essential for effective learning. In response to this, data science is now impacting the education sector, with a growing number of commercial products and research prototypes providing “learning dashboards”, aiming to provide real time progress indicators. From a human-centred computing perspective, the end-user’s interpretation of these visualisations is a critical challenge to design for, with empirical evidence already showing that ‘usable’ visualisations are not necessarily effective from a learning perspective. Since an educator’s interpretation of visualised data is essentially the construction of a narrative about student progress, we draw on the growing body of work on Data Storytelling (DS) as the inspiration for a set of enhancements that could be applied to data visualisations to improve their communicative power. We present a pilot study that explores the effectiveness of these DS elements based on educators’ responses to paper prototypes.");
                layedit.setContent(index, test, false);
            } else if (data.value == 7) {
                var test = ("What does ‘performance’ mean for Lululemon?\n" +
                    "EXECUTIVE SUMMARY\n" +
                    "Lululemon Athletica (‘Lululemon’) is an athletic apparel brand that produces high-end products and has expanded globally since its establishment in 1998. Commercial performance is important for the company however Lululemon’s success relies on providing a “consistent, high quality product and guest experience” (Lululemon Athletica 2017 p.5). Therefore, performance for Lululemon can be defined by two factors: \n" +
                    "\n" +
                    "1. producing high quality merchandise \n" +
                    "\n" +
                    "2. continuous innovation \n" +
                    "I INTRODUCTION \n" +
                    "Lululemon is a premium fitness brand that designs and retails ‘healthy lifestyle inspired’ athletic apparel for women, men and children (Lululemon Athletica 2017). Lululemon is a commercial success as attested to in its current operation of 406 stories in over 12 countries. This global expansion has resulted in the continuous increase of net revenue in recent years, with FY17 seeing a 15% rise to $2.3bn from FY16 (Lululemon Athletica 2017). However, academic theory holds that while financial measures are important, organisational performance can be defined through a range of methods as organisations will have different objectives (Rasula, Vuksic & Stemberger 2012). Therefore, to effectively measure ‘performance’ for the Canadian Head Office of Lululemon it is essential to consider how the transformational self-improvement ethos of the company is achieved by analysing non-traditional metrics. The report will first examine Lululemon’s overall objectives and how the company achieves these through business strategies and activities. Drawing from the company’s objective, the report will then define performance for Lululemon using non-traditional metrics. Ultimately, the report will comment on why the aforementioned definition of performance is appropriate for Lululemon.\n" +
                    "\n" +
                    "II ORGANISATIONAL ANALYSIS \n" +
                    "Lululemon’s organisational objective is to “produce products which create transformational experiences for people to live happy, healthy, fun lives” (Lululemon Athletica 2017 p.2). This aim is achieved by a threefold competitive strategy of differentiation through quality, innovation and supply chain sustainability. These strategies are achieved through the company’s corporate strategy of a single business with a vertical retail and distribution structure. Additionally, the decentralised leadership model allows store managers to connect with the brand and increase autonomy over individual stores to best implement the company’s objective (Lululemon Athletica 2017; Lululemon Athletica 2018a). Here, retail staff (‘educators’) are under control of store managers, who themselves report to the Retail Executive Vice President. Figure 1 details the organisational structure [Figure removed for AcaWriter].\n" +
                    "Lululemon’s first strategy is the creation of high-quality products. To achieve this strategy it is essential that the fabric, performance and craftsmanship of each product meets a certain standard. Lululemon can meet its quality expectations by increasing internal controls to ensure each product is of a high standard. Further, Lululemon conducts routine quality control inspections to assess if the manufactured product adheres to its quality standards (WWD Staff 2014). The second strategy is Lululemon’s continuous product innovation through a ‘design-led’ vision. Lululemon’s design is a point of differentiation as all fashion-forward products contain ‘innovative functional features’ (Lululemon Athletica 2017). Lululemon’s design team continually conducts market research and seeks inspiration from customers to ensure the products address the needs of users (Lululemon Athletica 2017). This ensures product lines are improved and appealing to customers who value the ‘technical rigor and premium quality’ of the products (Lululemon Athletica 2017).\n" +
                    "Lululemon’s final strategy focuses on improving its supply chain sustainability to retain its position as a market leader with a favourable reputation as this allows the company to create ‘transformational experiences’. Lululemon requires that manufacturers adhere to a code of ethics to ensure practices are environmentally and socially sustainable (Lululemon Athletica 2017). These requirements maintain product quality as unethically produced garments could be of lower quality, damage its reputation and ultimately contradict the company’s objective.");
                layedit.setContent(index, test, false);
            } else if (data.value == 8) {
                var test = ("Prior to starting my clinical placement, I honestly had no idea what sort of challenges I would have to face in a Community Pharmacy setting. It has essentially provided me with a perspective of the expectations of a pharmacist as a health care professional. I personally saw it as a journey which exposed my strengths and weaknesses. I saw my preceptor as someone who guided me to help address my weaknesses. However, I began to realise that this was only to a certain extent. The most important thing I learnt from these experiences is that I can only develop my skills if I actively contribute to the pharmacy by demonstrating initiative. This initiative was a product of my inner passion and motivation to practise as a pharmacist in future. Various encounters along my journey proved to me that every day presents with a new challenge. I initially could not comprehend just how diverse the members of the community were, particularly in regards to their health issues and understanding of their condition.");
                layedit.setContent(index, test, false);
            }
        }
    });

    //评分存档
    $('#score').click(function () {
        $('#temporary-storage').html(layedit.getContent(index));
        layer.open({
            type: 2,
            offset: '200px',
            shade: 0.5,
            title: '给写作过程评分并保存此次写作版本',
            area: ['400px', '350px'],
            content: 'editScore.jsp'
        });
    });

    //分析报告获得反馈
    $("#send").click(function () {
            var txt = layedit.getText(index);
            var feature = $('#genre option:selected').val();
            var grammar = feature == 8 ? 'reflective' : 'analytical';
            if ($.trim(txt) == '') {
                layer.msg('写作内容为空！');
                return;
            }
            if (feature == 0) {
                layer.msg('请选择类型！');
                return;
            }
            //加载层图标
            var loading = layer.load(0, {shade: false, offset: '50vh'});
            //清空上次的反馈结果
            $('#feedback').empty();
            $('#analyticalReport8').css('display', 'none');
            $('#analyticalReport6').css('display', 'none');
            $('#analyticalReport7').css('display', 'none');
            $('#analyticalReport5').css('display', 'none');
            $('#tips').css('display', 'none');
            $('#examples').css('display', 'none');
            $('#resources').css('display', 'none');
            $('#r-tips').css('display', 'none');
            $('#r-examples').css('display', 'none');
            $('#r-resources').css('display', 'none');

            //格式化参数data
            var data = JSON.stringify({
                'txt': txt,
                'action': 'fetch',
                'extra': {
                    'feedbackOpt': 'r_01',
                    'grammar': grammar,
                    'feature': feature
                },
                'type': 'manual'
            });

            //向后端发起getFeedback请求
            $.post(
                'getFeedback',
                {
                    'param_json': data,
                    'feature': feature
                },
                function (result) {
                    //得到结果，关闭加载层图标
                    layer.close(loading);
                    //类型为Civil Law Essay的返回结果处理
                    if (feature == 6) {
                        $('#analyticalReport6').css('display', 'block');
                        $('#examples').css('display', 'block');
                        $('#r-examples').css('display', 'block');

                        var objectJson = JSON.parse(result);
                        var feedback = "", alert1 = "", alert2 = "";
                        alert1 = "<div class='alert alert-success'>" + objectJson[1] + "</div>";
                        for (var i in objectJson[2]) {
                            alert2 += "<div class='alert alert-info'>" + objectJson[2][i] + "</div>";
                        }
                        feedback = alert1 + alert2;
                        $("#feedback").html(feedback);
                        var analyticalR = "";
                        for (var i in objectJson[3]) {
                            if (objectJson[3][i][2] == 'S') {
                                var s = "<span class='badge badge-pill badge-analytic-green'>" + objectJson[3][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[3][i][0] + "</li>";
                            } else {
                                var s = "<span class='badge badge-pill badge-analytic'>" + objectJson[3][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[3][i][0] + "</li>"
                            }
                        }
                        $('#analyticalR6').html(analyticalR);
                    }
                    //类型为Research Abstract/Intro的返回结果处理
                    else if (feature == 5) {
                        $('#analyticalReport5').css('display', 'block');
                        $('#resources').css('display', 'block');
                        $('#r-resources').css('display', 'block');

                        var objectJson = JSON.parse(result);
                        var feedback = "", alert1 = "", alert1_ = "", alert2 = "";

                        alert1 = "<div class='alert alert-success'>" + objectJson[1][0] + "</div>";
                        alert1_ = "<div class='alert alert-danger'>" + objectJson[1][1] + "</div>";

                        for (var i in objectJson[2]) {
                            alert2 += "<div class='alert alert-info'>" + objectJson[2][i] + "</div>";
                        }
                        feedback = alert1 + alert1_ + alert2;
                        $("#feedback").html(feedback);
                        var analyticalR = "";
                        for (var i in objectJson[3]) {
                            if (objectJson[3][i][2] == 'S') {
                                var s = "<span class='badge badge-pill badge-analytic-green'>" + objectJson[3][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[3][i][0] + "</li>";
                            } else {
                                var s = "<span class='badge badge-pill badge-analytic'>" + objectJson[3][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[3][i][0] + "</li>"
                            }
                        }
                        $('#analyticalR5').html(analyticalR);
                    }
                    //类型为Analytical Accounting的返回结果处理
                    else if (feature == 7) {
                        $('#analyticalReport7').css('display', 'block');
                        $('#tips').css('display', 'block');
                        $('#r-tips').css('display', 'block');
                        // 格式化json
                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        var feedback = "", alert1 = "", alert2 = "", alert3 = "";
                        alert1 = "<div class='alert alert-success'>" + objectJson[1] + "</div>";
                        alert2 = "<div class='alert alert-info'>" + objectJson[2] + "</div>";
                        for (var i in objectJson[3]) {
                            alert2 += "<div class='alert alert-info'>" + objectJson[3][i] + "</div>";
                        }
                        feedback = alert1 + alert2;
                        $("#feedback").html(feedback);
                        var analyticalR = "";
                        for (var i in objectJson[4]) {
                            if (objectJson[4][i][2] == 'S') {
                                var s = "<span class='badge badge-pill badge-analytic-green'>" + objectJson[4][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[4][i][0] + "</li>";
                            } else {
                                var s = "<span class='badge badge-pill badge-analytic'>" + objectJson[4][i][2] + "</span>";
                                analyticalR += "<li>" + s + objectJson[4][i][0] + "</li>"
                            }
                        }
                        $('#analyticalR7').html(analyticalR);
                    }
                    //类型为Pharmacy的返回结果处理
                    else {
                        $('#analyticalReport8').css('display', 'block');
                        var objectJson = JSON.parse(result);
                        var feedback = "";
                        var feedback = "", alert1 = "", alert2 = "";
                        alert1 = "<div class='alert alert-secondary'>" + objectJson[1] + "</div>";
                        for (var i in objectJson[2]) {
                            alert2 += "<div class='alert alert-secondary'>" + objectJson[2][i] + "</div>";
                        }
                        feedback = alert1 + alert2;
                        $("#feedback").html(feedback);

                        var analyticalR = "";
                        for (var i in objectJson[3]) {
                            var s0 = "<li>";
                            var s_ = "";
                            if (objectJson[3][i][2].indexOf('1') != -1) {
                                var s = "<span class='context'></span>&nbsp;";
                                s0 += s;
                            }
                            if (objectJson[3][i][2].indexOf('2') != -1) {
                                var s = "<span class='challenge'></span>&nbsp;";
                                s0 += s;
                            }
                            if (objectJson[3][i][2].indexOf('4') != -1) {
                                var s = "<span class='change'></span>&nbsp;";
                                s0 += s;
                            }
                            if (objectJson[3][i][2].indexOf('3') != -1) {
                                s_ = s0 + "<span class='link2me'>" + objectJson[3][i][0] + "</span></li>";
                            } else {
                                s_ = s0 + objectJson[3][i][0] + "</li>";
                            }
                            analyticalR += s_;
                        }
                        $('#analyticalR8').html(analyticalR);
                    }

                }
            );

        }
    );
    //右侧导航的tips弹出层
    $('#tips-analyticalReport').click(function () {
        layer.tips('Report分析结果在这里哦', '#to-analyticalReport', {
            tips: 3
        });
    });
    $('#tips-feedback').click(function () {
        layer.tips('Feedback结果在这里哦', '#to-feedback', {
            tips: 3
        });
    });
    $('#tips-examples').click(function () {
        layer.tips('Examples结果在这里哦', '#to-examples', {
            tips: 3
        });
    });
    $('#tips-resources').click(function () {
        layer.tips('Resources结果在这里哦', '#to-resources', {
            tips: 3
        });
    });
    $('#tips-tips').click(function () {
        layer.tips('Tips结果在这里哦', '#to-tips', {
            tips: 3
        });
    });

});

