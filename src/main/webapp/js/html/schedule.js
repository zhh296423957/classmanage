/**
 * Created by 张宏浩 on 2017/3/13.
 */
$(document).ready(function () {
   $("#aca1").change(function () {
        var acaId = $("#aca1").val();
        var text1 = '请选择年级';
        var text2 = '请选择班级';
        $.ajax({
            url:"/course/getGrade?acaId="+acaId,
            type:"POST",
            dataType:"json",
            async:false,
            success:function (data) {
                $("#gra1").empty();
                $("#cla1").empty();
                $("#gra1").append("<option value='0'>"+text1+"</option>");
                $("#cla1").append("<option value='0'>"+text2+"</option>");
                $.each(data.list,function (i,item) {
                        $("#gra1").append(
                          "<option value="+item.id+">"+item.graName+"</option>"
                        );
                });
            },
            error:function () {
                alert("Connection error!")
            }
        })
   });
    $("#gra1").change(function () {
        var graId = $("#gra1").val();
        var text = '请选择班级';
        $.ajax({
            url:"/course/getCla?graId="+graId,
            type:"POST",
            dataType:"json",
            async:false,
            success:function (data) {
                $("#cla1").empty();
                $("#cla1").append("<option value='0'>"+text+"</option>");
                $.each(data.list,function (i,item) {
                    $("#cla1").append(
                        "<option value="+item.id+">"+item.claName+"</option>"
                    );
                });
            },
            error:function () {
                alert("Connection error!")
            }
        });
    });
});

$("#searchBtn").click(function ( ) {
   var aca = $("#aca1").val();
   var gra = $("#gra1").val();
   var cla = $("#cla1").val();
   $.ajax({
       url:"/course/getList?acaId="+aca+"&graId="+gra+"&claId="+cla,
       type:"POST",
       async:false,
       dateType:"JSON",
       success:function (data) {
           $("#tab1 tr").eq(0).nextAll().remove();
           var lists = data.list;
           if(lists.length == 0){
                $("#p1 ").append("该班级暂无课表，请稍后查询！").css("color","red").css("font-size","16px");
           }else {
               $("#p1").empty();
               $.each(lists,function (i,item) {
                    $("#tab1").append("<tr>"+"<td>"+(++i)+"</td>"+"<td>"+item.courseName+"</td>"+"<td>"+item.teacherName+"</td>"+"<td>"+item.courseWeek+"</td>"+"<td>"+item.courseTime+"</td>"+"<td>"+item.place+"</td>"+"</tr>");
               });
           }
       },
       error:function () {
           alert("Connection error!");
       }
   });
});

$("#but1").click(function () {
    window.location.href="/course/addSchUi";
});