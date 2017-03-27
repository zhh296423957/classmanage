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
        <form method="post" class="form-x" action="/course/modSch" enctype="multipart/form-data" name="class">
            <input type="hidden" name="id" value="${course.id}" id="id" />
            <input type="hidden" name="gmtCreate" value="${course.gmtCreate}" id="gmtCreate" />
            <div class="form-group">
                <div class="label">
                    <label>课程名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${course.courseName}" name="courseName"  data-validate="required:课程名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>老师名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${course.teacherName}" name="teacherName" data-validate="required:请输入老师名称" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>课程周次：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${course.courseWeek}" name="courseWeek" data-validate="required:请输入课程周次" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>课程时间：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${course.courseTime}" name="courseTime" data-validate="required:请输入课程时间" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>地点：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${course.place}" name="place" data-validate="required:请输入课程地点" />
                </div>
            </div>
            <div class="clear"></div>
            <div  class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input class="button bg-main icon-check-square-o" type="submit" value="提交"/>
                </div>
            </div>
        </form>
    </div>
</div>


<script src="../../../js/jquery-1.11.1.min.js"></script>
</body>
</html>
