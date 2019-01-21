<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/21
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="WEB-INF/resources/css/style1.css" type="text/css" rel="stylesheet"/>
<html>
<head>
    <title>主页</title>
</head>

<body>
<%--<textarea id="param_json" name="param_json" class="input"></textarea>--%>
<%--<span id="rst"></span>--%>
<%--jquery提交ajax请求方式--%>
<%--<script src="WEB-INF/resources/js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#param_json").onkeyup(function () {
            var url="sendHttpPostJson";
            var value=$(this).val();
            $.post(
                url,
                {"name":value},
                function (result) {
                    $("#rst").html(result);
                }
            );
        });

    });
</script>--%>
<%--form表单方式--%>
<div align="center" class="form">
    <form action="sendHttpPostJson" method="post" class="form" style="padding-left: 10%;padding-right: 10%">
        <textarea class="input" name="param_json" type="text" style="width: 90%;height: 50%;font-size: 22px;" readonly>
            {
                "txt":"When I kept adjusting how I'd normally ask questions in day to day life, it felt exhausting because I had to put more energy into not only know what questions to ask but also how and when to ask those questions.",
                "action":"fetch",
                "extra":{"feedbackOpt":"r_01","grammar":"analytical","feature":7},
                "type":"manual"
            }
        </textarea>
        <button class="btn" type="submit">提交</button>
    </form>
    <span>${rst}</span>

</div>
</body>
</html>
