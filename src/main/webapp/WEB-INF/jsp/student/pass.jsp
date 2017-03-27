<%--
  Created by IntelliJ IDEA.
  User: 张宏浩
  Date: 2017/3/7
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../../../css/pintuer.css">
    <link rel="stylesheet" href="../../../css/admin.css">
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-key"></span> 修改个人密码</strong></div>
    <div class="body-content">
        <form method="post" class="form-x"  id="form1">
            <input type="hidden" value="${student.pwd}" id="pwd" name="pwd">
            <div class="form-group">
                <div class="label">
                    <label for="number">个人学号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" id="number" value="${student.number}" name="student.number">
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="pass1">原始密码：</label>
                </div>
                <div class="field">
                    <input type="password" class="input w50" id="pass1" name="mpass" size="50"  placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="newpass">新密码：</label>
                </div>
                <div class="field">
                    <input id="newpass" type="password" class="input w50" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" disabled/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label for="renewpass">确认新密码：</label>
                </div>
                <div class="field">
                    <input id="renewpass" type="password" class="input w50" name="renewpass" size="50"  placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" disabled/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label style="color: #ff0000">${message}</label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit" onclick="updatePwd()"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="../../../js/jquery-1.11.1.min.js"></script>
<script src="../../../js/pintuer.js"></script>
<script src="../../../js/jQuery.md5.js"></script>
<script type="text/javascript">
    $("#pass1").blur(function () {
        var password = $("#pass1").val();
        if($.md5(password) ==$("#pwd").val()){
            $("#newpass").removeAttr("disabled");
            $("#renewpass").removeAttr("disabled");
            $("#pass1").css("border","#ddd solid 1px");
        }else {
            $(this).css("border","1px solid red");
            alert("密码错误，请重新输入！");
        }
    });

    function updatePwd() {
        var pass1 = $('#pass1').val();
        console.log(1234567+pass1);
        var newpass = $('#newpass').val();
        console.log(1234567+newpass);
        var renewpass = $('#renewpass').val();
        console.log(1234567+renewpass);

        $.ajax({
            type:"POST",
            url:"/common/pass",
            async:false,
            data:$('#form1').serialize(),
            success:function (data) {
                if(data ==true){
                    alert("修改密码成功!");
                    $('#pass1').attr("value",pass1);
                    $('#newpass').attr("value",newpass);
                    $('#renewpass').attr("value",renewpass);
                }else {
                    alert("两次输入密码不一致，请重新输入！");
                    $('#pass1').val(pass1);
                    $("#newpass").css("border","red solid 1px");
                    $("#renewpass").css("border","red solid 1px");

                }
            },
            error:function(data){
                console.log(data);
                alert("error:"+data.responseText);
            }
        });
    }

</script>
</body>
</html>
