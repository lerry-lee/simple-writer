<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/2/23
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新日志-AcaWriter</title>
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
    <legend>更新日志</legend>
</fieldset>
<ul class="layui-timeline">
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-1-28</h3>
            <p>
                AcaWriter1.0已经就位，在此版本基础上我们还做了如下更新：
                <ul><li>图表页面样式优化</li>
                <li>数据表增加根据HTTP请求时间查询的条件</li></ul>
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-1-29</h3>
            <p>图表页面调整</p>
            <ul>
                <li>查询条件中响应状态改为请求方法</li>
                <li>请求时间输入框优化</li>
            </ul>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-13</h3>
            <p>
                导航栏样式优化
                <br>写作反馈页面样式优化
                <br>图表页面数据表格增加分页功能
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-14</h3>
            <p>
                首页添加轮播样式
                <br>写作反馈页面样式优化，添加固定块定位反馈面板、提示面板、返回顶部
                <br>修复了图表页面数据表格分页功能无法正常分页的BUG
                <br>关闭了监听所有HTTP请求并写入数据库功能
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-15</h3>
            <p>
                字体图标样式优化
                <br>增加底部栏文字浮动样式
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-16</h3>
            <p>
                项目部署到服务器，可通过域名http://acawriter.iask.in访问
                <br>前端UI优化
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-18</h3>
            <p>
                增加登陆功能
                <br>写作反馈页面增加写作内容实时保存功能
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-19</h3>
            <p>
                增加注册功能
                <br>增加首页显示网站访问量统计
                <br>首页UI优化
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-20</h3>
            <p>
                首页UI优化
                <br>修复了注册页面背景图片无法自适应的BUG
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-26</h3>
            <p>首页调整</p>
            <ul>
                <li>字体语言调整为汉字中文</li>
                <li>请求时间输入框优化</li>
            </ul>
            <p>反思性写作页面</p>
            <ul>
                <li>增加评分功能</li>
            </ul>
            <p>统计报表页面</p>
            <ul>
                <li>数据表显示评分表的标题和评分时间</li>
                <li>饼图-折线图显示每次评分情况</li>
            </ul>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-27</h3>
            <p>
                网站字体优化
                <br>访问量统计每个用户当天访问只记一次
                <br>修复已知BUG
                <br>重登提示窗优化
            </p>
        </div>
    </li>
    <li class="layui-timeline-item">
        <div class="layui-timeline-content layui-text">
            <h3 class="layui-timeline-title">2019-2-28</h3>
            <p>
                AcaWriter2.0准备就绪：
                <br>页面风格较1.0有较大变化
                <br>修复某些BUG
                <br>提示信息更加优化
            </p>
        </div>
    </li>
</ul>
</body>
</html>
