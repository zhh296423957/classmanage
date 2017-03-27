<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/10
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>课表管理</title>
    <link rel="stylesheet" href="../../../css/bootstrap.css">
    <link rel="stylesheet" href="../../../css/schedule.css">
</head>
<body>
<div id="div1">
    <span id="span1">按条件搜索</span>
    <select id="aca1" name="academy" class="select1">
        <option value="0">请选择学院</option>
        <c:forEach var="academy" items="${academyList}">
            <option value="${academy.id}">${academy.acaName}</option>
        </c:forEach>
    </select>
    <select id="gra1" name="grade" class="select1">
        <option value="0">请选择年级</option>
    </select>
    <select id="cla1" name="tbClass" class="select1">
        <option value="0">请选择班级</option>
    </select>
    <button class="btn btn-default" id="searchBtn">查询</button>
    <c:if test="${student.isCommitee !=0}">
        <button class="btn btn-primary" id="but1">添加课程</button>
    </c:if>
</div>

<div id="div3">
    <c:if test="${flag ==0}">
        <span style="color: red;">${lists}</span>
    </c:if>
    <c:if test="${flag != 0}">
    <table class="table table-striped" id="tab1">
        <tr>
            <th>序号</th>
            <th>课程名称</th>
            <th>授课老师</th>
            <th>周次</th>
            <th>日次</th>
            <th>上课地点</th>
            <td>操作</td>
        </tr>
        <c:forEach var="list" items="${lists}" varStatus="status">
            <tr >
                <td>${status.index+1}</td>
                <td>${list.courseName}</td>
                <td>${list.teacherName}</td>
                <td>${list.courseWeek}</td>
                <td>${list.courseTime}</td>
                <td>${list.place}</td>
                <td>
                    <c:if test="${student.isCommitee !=0}">
                        <a href="/course/modUi?id=${list.id}" title="只有班委才有权限修改课表"><span class="btn btn-link">修改</span></a>
                    </c:if>
                    <c:if test="${student.isCommitee ==0}">
                        <a href="javascript:return false;"  title="只有班委才有权限修改课表"><span class="btn btn-link" style="opacity: 0.6">修改</span></a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
<p id="p1"></p>
</div>
    <script src="../../../js/jquery-1.11.1.min.js"></script>
    <script src="../../../js/html/schedule.js"></script>
</body>
</html>
