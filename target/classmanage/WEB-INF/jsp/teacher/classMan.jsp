<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/23
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理页面</title>
    <link rel="stylesheet" href="../../../css/bootstrap.css">
    <link rel="stylesheet" href="../../../css/schedule.css">
</head>
<body>
<div  id="div1">
    <form id="for1" action="/teacher/search" name="form1" method="post">
        <input type="text" name="keyword"  placeholder="按条件查找" value="${keyword}" style="width:auto; border: 1px #cccccc solid">
        <button class="btn btn-primary" id="but2" >查找</button>
    </form>
    <button class="btn btn-info" id="but1">新增班级</button>
</div>
<div id="div3">
    <c:if test="${flag ==0}">
        <span style="color: red;">${lists}</span>
    </c:if>
    <c:if test="${flag != 0}">
        <table class="table table-striped" id="tab1">
            <tr>
                <th>序号</th>
                <th>班级名称</th>
                <th>指导老师</th>
                <th>班级简介</th>
                <td>操作</td>
            </tr>
            <c:forEach var="list" items="${lists}" varStatus="status">
                <tr >
                    <td>${status.index+1}</td>
                    <td>${list.claName}</td>
                    <td>${list.claTeacher}</td>
                    <td>${list.introducation}</td>
                    <td>
                            <a href="/teacher/listStudent?id=${list.id}&pageNow=1" title="查看班级名单"><span class="btn btn-link">查看学生列表</span></a>
                            <a href="/teacher/download?id=${list.id}" title="下载班级名单"><span class="btn btn-link">下载学生列表</span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<jsp:include page="../page.jsp" flush="true"></jsp:include>
<script type="application/javascript" src="../../../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
    $("#but1").click(function () {
       window.location.href="/tbClass/addClassUi"
    });
</script>
</body>
</html>
