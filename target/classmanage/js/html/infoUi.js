$('#phone').click(function () {
    if(confirm("是否修改手机号码?")){
        $('#phone').removeAttr("readonly");
    }
});

$('#phone_tea').click(function () {
    if(confirm("是否修改手机号码?")){
        $('#phone_tea').removeAttr("readonly");
    }
});

$('#email_tea').click(function () {
    if(confirm("是否修改邮箱?")){
        $('#email_tea').removeAttr("readonly");
    }
});

$("#department").click(function () {
    if(confirm("是否修改宿舍号码?")){
        $("#department").removeAttr("readonly");
    }
});