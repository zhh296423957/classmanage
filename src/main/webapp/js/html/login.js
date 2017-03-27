function checkUser() {
    if ($("input[name='username']").val() == "") {
        alert("用户名不能为空");
        return false;
    }
    else if ($("input[name='password']").val() == "") {
        alert("密码不能为空");
        return false;
    }
    else {
        return true;
    }
}