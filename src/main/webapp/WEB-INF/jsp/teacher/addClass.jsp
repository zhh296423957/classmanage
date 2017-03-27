<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/24
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增班级</title>
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
        <form method="post" class="form-x" action="/tbClass/addClass" enctype="multipart/form-data" name="class">
            <div class="form-group">
                <div class="label">
                    <label>班级名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50"  name="claName"  data-validate="required:班级名称" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>指导老师：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50"  name="claTeacher" data-validate="required:请输入指导老师名称" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>班级简介：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50"  name="introducation" data-validate="required:请输入课程周次" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>学生名单：</label>
                </div>
                <div class="field">
                    <input type="file" class="input w50"  name="file" data-validate="required:请上传学生名单" />
                    <p><a href="/student/download?fileName=学生信息模板.xlsx">点击可下载学生信息模板</a></p>
                    <p style="color: red">${msg}</p>
                </div>
            </div>
            <div class="clear"></div>
            <div  class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <input class="button bg-main icon-check-square-o" type="submit" value="提交" />
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
