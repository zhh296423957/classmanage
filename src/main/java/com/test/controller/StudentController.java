package com.test.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.test.model.*;
import com.test.service.*;
import com.test.utils.Page;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/3.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private CourseService courseService;
    @Resource
    private AcademyService academyService;
    @Resource
    private StudentService studentService;

    @RequestMapping("/schedule")
    public String scheduleUi(HttpServletRequest servletRequest,ModelMap modelMap){
        int flag ;
        HttpSession session = servletRequest.getSession();
        Student student =(Student)session.getAttribute("student");

        List<Course> lists = courseService.listByClassId(student.getClassId());   //查询所有的课程
        List<Academy> academyList =academyService.lists(student.getSchoolId());        //查询所有的学院
        if(lists ==null){
            flag = 0;
            modelMap.addAttribute("lists","暂时没有课表信息");
        }else{
            flag = 1;
            modelMap.addAttribute("lists",lists);
        }
        modelMap.addAttribute("academyList",academyList);
        modelMap.addAttribute("student",student);
        modelMap.addAttribute("flag",flag);
        return "student/schedule";
    }

    /**
     * 根据关键字查找
     */
    @RequestMapping("/search")
    public String search(@RequestParam("keyword")String keyword,@RequestParam("classId")int classId,ModelMap modelMap){
        Page page = null;
        int count = studentService.getCount(classId,keyword);
        page = new Page(count,1);
        List<Student> lists =studentService.selectStudent(classId,keyword,page.getStartPos(),page.getPageSize());
        int flag =0;
        if(lists.size() == 0){
            flag = 0;
            modelMap.addAttribute("lists","暂时无相关信息");
        }else {
            flag =1;
            modelMap.addAttribute("lists",lists);
        }
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("keyword",keyword);
        modelMap.addAttribute("page",page);
        return "teacher/listStudent";
    }

    /**
     *分页
     **/
    @RequestMapping("/page")
    public String page(@RequestParam("pageNow")int pageNow,@RequestParam("classId")int classId,ModelMap modelMap){
        Page page = null;
        String keyword ="";
        int count  = studentService.getCount(classId,keyword);
        page = new Page(count ,pageNow);
        List<Student> lists = studentService.selectStudent(classId,keyword,page.getStartPos(),page.getPageSize());

        int flag  = 0;
        if(lists !=null){
            flag =1;
            modelMap.addAttribute("lists",lists);
        }else {
            flag = 0;
            modelMap.addAttribute("lists","暂时无学生信息");
        }
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("page",page);
        modelMap.addAttribute("classId",classId);
        return "teacher/listStudent";
    }


    /**
     * 跳转到修改学生信息界面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/modStuUi")
    public String modStuUi(@RequestParam("id")int id,@RequestParam("pageNow")int pageNow,ModelMap modelMap,HttpServletRequest request){
        HttpSession session  = request.getSession();
        Student student = studentService.getById(id);
        session.setAttribute("student",student);
        modelMap.addAttribute("student",student);
        modelMap.addAttribute("pageNow",pageNow);
        return "teacher/modStudent";
    }

    /**
     * 修改学生属性
     * @param request
     * @param number
     * @param studentName
     * @param department
     * @param email
     * @param phone
     * @param address
     * @return
     */
    @RequestMapping("/modStu")
    public String modStu(HttpServletRequest request,@RequestParam("pageNow")int pageNow,
                         @RequestParam("number")String number,
                         @RequestParam("studentName")String studentName,@RequestParam("department")String department,
                        @RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("address")String address){
        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        session.removeAttribute("student");

        student.setStudentName(studentName);
        student.setNumber(number);
        student.setDepartment(department);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);
        student.setGmtModify(new Date());
        System.out.println(student);
        studentService.updatePwd(student);
        return "redirect:/teacher/listStudent?id="+student.getClassId()+"&pageNow="+pageNow;
    }

    /**
     * 删除学生信息，删除完毕之后返回到学生列表
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(@RequestParam("id")int id,@RequestParam("pageNow")int pageNow){
        Student student =studentService.getById(id);
        int classId = student.getClassId();
        if(studentService.delete(id)>=0){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！");
        }
        return "redirect:/teacher/listStudent?id="+classId+"&pageNow="+pageNow;
    }

    //下载学生信息的模板
    @RequestMapping(value = "/download",produces = "text/html;charset=UTF-8")
    public void down(HttpServletRequest request,HttpServletResponse response,@RequestParam("fileName")String fileName) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        fileName = new String(fileName.getBytes("ISO8859-1"), "UTF-8");
        //当前文件路径  D:\apache-tomcat-6.0.20\apache-tomcat-6.0.20\webapps\BJSWT\\file\上传手机号板.xls
        String nowPath = request.getSession().getServletContext().getRealPath("/")+"\\"+"upload"+"\\"+fileName;

        String contextPath = request.getContextPath();// /BJSWT
//     String serveltPath = request.getServletPath();   // /download


        File file = new File(nowPath);

        // 清空response
        response.reset();

        // 设置response的Header
        response.addHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1"));  //转码之后下载的文件不会出现中文乱码
        response.addHeader("Content-Length", "" + file.length());

        try{
            //以流的形式下载文件
            InputStream fis = new BufferedInputStream(new FileInputStream(nowPath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}


