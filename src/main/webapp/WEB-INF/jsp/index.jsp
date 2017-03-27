<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/6
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%><%--
  Created by IntelliJ IDEA.
  User: Zhangxq
  Date: 2016/7/16
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <title>后台管理中心</title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
    <div class="head-2">
        <h1 style="font-size: 30px;">班级管理平台</h1>
    </div>
    <div class="head-l">${cla.claName}&nbsp;${student.studentName}
        <c:if test="${student.isCommitee==0}">
            同学
        </c:if>
        <c:if test="${student.isCommitee ==1}">
            班委
        </c:if>
        <a class="button button-little bg-red" href="/logout"><span class="icon-power-off"></span> 退出登录</a> </div>
    <div class="logo margin-big-left fadein-top">
        <img src="../../../img/avator/${student.avator}" class="radius-circle rotate-hover" height="50" alt="" />
    </div>
</div>
<div class="leftnav">
    <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
        <h2><span class="icon-user"></span>基本设置</h2>
        <ul style="display:block" id = "ul1">
            <li><a href="/common/infoUi" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
            <li><a href="/common/passUi" target="right"><span class="icon-caret-right"></span>密码管理</a></li>
        </ul>
        <h2><span class="icon-pencil-square-o"></span>功能设置</h2>
        <ul id="ul2">
            <li><a href="/student/schedule" target="right"><span class="icon-caret-right"></span>课表查询</a></li>
            <li><a href="/sec/gra?id=${user.userNumber}" target="right"><span class="icon-caret-right"></span>班费管理</a></li>
            <li><a href="/sec/gra?id=${user.userNumber}" target="right"><span class="icon-caret-right"></span>公告通知</a></li>
            <li><a href="/sec/gra?id=${user.userNumber}" target="right"><span class="icon-caret-right"></span>班级论坛</a></li>
        </ul>
   <%-- <c:if test="${user.userIdentity==2}">
        <h2><span class="icon-user"></span>基本设置</h2>
        <ul style="display:block">
            <li><a href="/common/infoUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
            <li><a href="/common/passUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
            <li><a href="/common/bookUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>留言管理</a></li>
        </ul>
        <h2><span class="icon-pencil-square-o"></span>功能设置</h2>
        <ul>
            <li><a href="/tea/list?id=${user.id}" target="right"><span class="icon-caret-right"></span>查看课程</a></li>
            <li><a href="/tea/add?id=${user.id}" target="right"><span class="icon-caret-right"></span>学生名单</a></li>
            <li><a href="/tea/addGra" target="right"><span class="icon-caret-right"></span>网上录入成绩</a></li>
        </ul>
    </c:if>
    <c:if test="${user.userIdentity==3}">
        <h2><span class="icon-user"></span>基本设置</h2>
        <ul style="display:block">
            <li><a href="/common/infoUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
            <li><a href="/common/passUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
            <li><a href="/common/bookUi?id=${user.id}" target="right"><span class="icon-caret-right"></span>留言管理</a></li>
        </ul>
        <h2><span class="icon-pencil-square-o"></span>功能设置</h2>
        <ul>
            <li><a href="/sec/list" target="right"><span class="icon-caret-right"></span>管理学生信息</a></li>
            <li><a href="/sec/type" target="right"><span class="icon-caret-right"></span>打印成绩</a></li>
            <li><a href="/sec/subject" target="right"><span class="icon-caret-right"></span>分配课程</a></li>
        </ul>
    </c:if>--%>
</div>
<ul class="bread">
    <li><a href="/message" target="right" class="icon-home"> 首页</a></li>
    <li><a href="javascript:;" id="a_leader_txt">网站信息</a></li>
    <li><b>当前语言：</b><span style="color:red;">中文</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </li>
    <li id="clock" style="font-family: 仿宋"></li>
</ul>
<div class="admin">
    <iframe scrolling="auto" rameborder="0" src="/message" name="right" width="100%" height="100%"></iframe>
</div>

<script src="../../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        });
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
    function realSysTime(clock){
        var now=new Date(); //创建Date对象
        var year=now.getFullYear(); //获取年份
        var month=now.getMonth(); //获取月份
        var date=now.getDate(); //获取日期
        var day=now.getDay(); //获取星期
        var hour=now.getHours(); //获取小时
        var minu=now.getMinutes(); //获取分钟
        var sec=now.getSeconds(); //获取秒钟
        month=month+1;
        var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
        var week=arr_week[day]; //获取中文的星期
        var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
        clock.innerHTML=time; //显示系统时间
    }
    window.onload=function(){
        window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间
    }

</script>
</body>
</html>
