<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/21
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp" %>

<html>
<head>
    <title>主页</title>
</head>

<body>
<div class="layui-row layui-col-space15">
    <div class="layui-col-md6">
        <div class="layui-card">
            <div class="layui-card-body">
                <div class="layui-carousel" id="test1" lay-filter="test1" style="text-align:center;font-size: 20px;font-family: Arial">
                    <div carousel-item="">
                        <div style="background-color: whitesmoke"><p style="bottom: 40%;position: absolute;">The UTS 2027 strategy will continue
                            to emphasise the importance of authentic learning for
                            students.
                            Internships, work placements, community service, overseas exchanges and role play team
                            simulations are all
                            contexts in which students experience something of the complexity of real world professional
                            practice.</p>
                        </div>
                        <div style="background-color: #5FB878"><p style="bottom: 40%;position: absolute;">The question is what and how do
                            students learn from these experiences? One of the most
                            established methods
                            is to ask students to reflect on this in writing. Done well, this can be extremely powerful,
                            but done
                            poorly, it is often experienced as a superficial, meaningless ‘diary’ that is written by
                            students out of
                            obligation.</p>
                        </div>
                        <div style="background-color: #93D1FF"><p style="bottom: 40%;position: absolute;">Now clearly, there’s nothing as
                            valuable as detailed instruction on reflective writing, and
                            then receiving
                            feedback from a good mentor. But this is (i) a scarce skillset and (ii) it’s very
                            labour-intensive. The
                            practical consequence is that many students do not understand what good reflective writing
                            is, and do not
                            receive good feedback on their work. For these reasons, there’s growing interest in the
                            potential of
                            automated techniques to relieve some of the load.</p>
                        </div>
                        <div style="background-color: #4476A7"><p style="bottom: 40%;position: absolute;">The Connected Intelligence Centre
                            (CIC) at UTS has developed a website providing automated
                            feedback on
                            student writing, called AcaWriter. This helps develop students’ reflective writing by
                            providing immediate,
                            actionable feedback on their writing. This has been used in UTS in several contexts, and
                            this workshop will
                            share some of those examples.</p>
                        </div>
                        <div style="background-color: #FFB800"><p style="bottom: 40%;position: absolute;">In particular, using the software
                            standalone without integrating it in its educational
                            context isn’t enough
                            for students to make the best use of it. For learning analytic tools like AcaWriter to have
                            a meaningful
                            impact on learners, the tools should be embedded in the pedagogical context. In our
                            workshop, we will
                            demonstrate the use of AcaWriter for writing feedback and how we design learning activities
                            around it for
                            different pedagogic contexts.</p>
                        </div>
                        <div style="background-color: pink"><p style="bottom: 40%;position: absolute;">We will show examples of learning
                            activities integrating AcaWriter in a pedagogical context
                            implemented in
                            UTS: an undergraduate pharmacy unit for relecting on work placements. These models can help
                            you design
                            similar learning activities for students using AcaWriter in your own pedagogical contexts.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
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
            , interval: 3000
            , anim: 'default'
            , height: '80%'
            , width: '100%'
        });

    });
</script>
</body>
</html>

<%@include file="templates/footer.jsp" %>