<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/6
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>个人信息</title>
    <link rel="stylesheet" href="../../../css/bootstrap.css"  />
    <link rel="stylesheet" href="../../../css/pintuer.css">
    <link rel="stylesheet" href="../../../css/admin.css">

</head>
<body>
<div style="width: 80%;margin: 0 auto;">
    <form class="bs-example bs-example-form" role="form">
        <div class="input-group">
            <span class="input-group-addon">工号:</span>
            <input type="text" name="teacher.employeeNumber" value="${teacher.employeeNumber}" class="form-control" disabled>
            <span class="input-group-addon">姓名:</span>
            <input type="text" name="teacher.teaName" value="${teacher.teaName}" class="form-control" disabled>
            <span class="input-group-addon">性别</span>
                <c:if test="${teacher.sex ==0}">
                    <input type="text" name="teacher.sex" value="男" class="form-control" disabled>
                </c:if>
                <c:if test="${teacher.sex ==1}">
                    <input type="text" name="teacher.sex" value="女" class="form-control" disabled>
                </c:if>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">入职:</span>
            <input  type="text" value="${teacher.hireDate}" name="teacher.hireDate" class="form-control" id="birth" readonly>
            <span class="input-group-addon">电话:</span>
            <input type="text" value="${teacher.phone}" name="teacher.phone" class="form-control" id="phone_tea" readonly >
            <span class="input-group-addon">邮箱:</span>
            <input type="text" value="${teacher.email}" name="teacher.email" class="form-control" id="email_tea" readonly>
        </div><br>
        <div class="input-group">
            <span class="input-group-addon">学校:</span>
            <input type="text" value="${school.schName}" name="schName" class="form-control" disabled>
            <span class="input-group-addon">学院:</span>
            <input type="text" value="${academy.acaName}" name="acaName" class="form-control" disabled>
            <span class="input-group-addon">年级:</span>
            <input type="text" value="${grade.graName}" name="graName" class="form-control" disabled>
        </div><br>
     </form>
</div>

    <script src="../../../js/jquery-1.11.1.min.js" ></script>
    <script src="../../../js/pintuer.js"></script>
    <script src="../../../js/html/infoUi.js"></script>
</body>
</html>
