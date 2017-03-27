<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/23
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <link rel="stylesheet" href="../../../css/bootstrap.css">
    <link rel="stylesheet" href="../../../css/schedule.css">
</head>
<body>
<div  id="div1">
    <form id="for1" action="/student/search" name="form1" method="post">
        <input type="hidden" name="classId" value="${classId}">
        <input type="text" name="keyword"  placeholder="按条件查找" value="${keyword}" style="width:auto; border: 1px #cccccc solid">
        <button class="btn btn-primary" id="but2" >查找</button>
    </form>
    <button class="btn btn-info" id="but1">新增学生</button>
</div>
<div id="div3">
    <c:if test="${flag ==0}">
        <span style="color: red;">${lists}</span>
    </c:if>
    <c:if test="${flag != 0}">
        <table class="table table-striped" id="tab1">
            <tr>
                <th>序号</th>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>宿舍号</th>
                <th>邮箱</th>
                <th>联系电话</th>
                <td>操作</td>
            </tr>
            <c:forEach var="list" items="${lists}" varStatus="status">
                <tr >
                    <td>${status.index+1}</td>
                    <td>${list.number}</td>
                    <td>${list.studentName}</td>
                    <c:if test="${list.sex ==0}">
                        <td>男</td>
                    </c:if>
                    <c:if test="${list.sex ==1}">
                        <td>女</td>
                    </c:if>
                    <td>${list.department}</td>
                    <td>${list.email}</td>
                    <td>${list.phone}</td>
                    <td>
                        <a href="/student/modStuUi?id=${list.id}&pageNow=${page.pageNow}" title="查看学生信息"><span class="btn btn-link">修改</span></a>
                        <a href="/student/delete?id=${list.id}&pageNow=${page.pageNow}" title="删除学生信息" onclick="confirm('是否确定删除？')"><span class="btn btn-link">删除</span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<div align="center">
    <font size="2">${page.totalCount}条记录 &nbsp; 共 ${page.totalPageCount} 页</font> <font size="2">第
    ${page.pageNow} 页</font> <a href="/student/page?pageNow=1&classId=${classId}">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="/student/page?pageNow=${page.pageNow - 1}&classId=${classId}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="/student/page?pageNow=1&classId=${classId}">上一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="/student/page?pageNow=${page.pageNow}&classId=${classId}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="/student/page?pageNow=${page.pageNow + 1}&classId=${classId}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="/student/page?pageNow=${page.totalPageCount}&classId=${classId}">下一页</a>
        </c:when>
    </c:choose>
    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="/student/page?pageNow=${page.pageNow}&classId=${classId}">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="/student/page?pageNow=${page.totalPageCount}&classId=${classId}">尾页</a>
        </c:otherwise>
    </c:choose>
</div>
<!-- 分页功能 End -->
</body>
</html>