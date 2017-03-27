<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/17
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>修改课表</title>
    <link rel="stylesheet" href="../../../css/pintuer.css">
    <link rel="stylesheet" href="../../../css/admin.css">

</head>
<body>
<div class="panel admin-panel">
    <%--<div class="panel-head" id="add">
        <strong><span class="icon-pencil-square-o"></span>录入成绩</strong>
        <a href="/download?fileName=录入成绩模板.xlsx" class="button bg-main icon-check-square-o" style="margin-left: 800px;" >下载模板</a>
    </div>--%>
    <div class="body-content">
        <form method="post" class="form-x" action="/student/modStu"  name="class">
            <input type="hidden" value="${pageNow}" name="pageNow" id="pageNow">
            <input type="hidden" value="${student.classId}" id="classId" name="classId">
            <div class="form-group">
                <div class="label">
                    <label>学号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.number}" name="number"  data-validate="required:请输入学号" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.studentName}" name="studentName" data-validate="required:请输入学生姓名" />
                </div>
            </div>
            <%--<div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <c:if test="${student.sex ==0}">
                        <input type="text" class="input w50" value="男" name="sex" data-validate="required:请输入性别" />
                    </c:if>
                    <c:if test="${student.sex}==1">
                        <input type="text" class="input w50" value="女" name="sex" data-validate="required:请输入性别" />
                    </c:if>
                </div>
            </div>--%>
            <div class="form-group">
                <div class="label">
                    <label>宿舍号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.department}" name="department" data-validate="required:请输入寝室号" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>邮箱：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.email}" name="email" data-validate="required:请输入邮箱" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>联系电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.phone}" name="phone" data-validate="required:请输入电话" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>家庭住址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${student.address}" name="address" data-validate="required:请输入住址" />
                </div>
            </div>
            <div class="clear"></div>
            <div  class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input class="button bg-main icon-check-square-o" type="submit" value="提交"/>
                    <input id="but1" class="button bg-main icon-check-square-o" type="button" value="返回列表">
                </div>
            </div>
        </form>

    </div>
</div>


<script src="../../../js/jquery-1.11.1.min.js"></script>
<script>
    $("#but1").click(function () {
        var classId = $("#classId").val();
        var pageMow =$("#pageNow").val();
        window.location.href = "/teacher/listStudent?id="+classId+"&pageNow="+pageMow;
    });
</script>
</body>
</html>
