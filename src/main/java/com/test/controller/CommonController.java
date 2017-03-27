package com.test.controller;

import com.test.model.*;
import com.test.service.*;
import com.test.service.impl.SchoolServiceImpl;
import com.test.utils.CreateMD5;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张宏浩 on 2017/3/7.
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Resource
    private StudentService studentService;

    @Resource
    private SchoolService schoolService;

    @Resource
    private AcademyService academyService;

    @Resource
    private GradeService gradeService;

    @Resource
    private TbClassService classService;

    private Student student;
    private School school;
    private Academy academy;
    private Grade grade;
    private TbClass tbClass;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-mm");


    @RequestMapping("/infoUi")
    public String info(ModelMap modelMap, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        student =(Student)session.getAttribute("student");
        Date time= new java.sql.Date(student.getBirth().getTime());
        student.setBirth(time);
        //System.out.println(student.getBirth());
        modelMap.addAttribute("student",student);
        school = schoolService.getById(student.getSchoolId());
        if(school ==null){
            modelMap.addAttribute("school","未分配学校");
        }else
        {
            modelMap.addAttribute("school",school);
        }
        academy = academyService.getById(student.getAcademyId());
        if(academy ==null){
            modelMap.addAttribute("academy","未分配学院");
        }else {
            modelMap.addAttribute("academy",academy);
        }
        grade =gradeService.getById(student.getGradeId());
        if(grade ==null){
            modelMap.addAttribute("grade","未分配年级");
        }else {
            modelMap.addAttribute("grade",grade);
        }
        tbClass = classService.getById(student.getClassId());
        if(tbClass ==null){
            modelMap.addAttribute("tbClass","未分配班级");
        }else {
            modelMap.addAttribute("tbClass",tbClass);
        }
        /*student = studentService.getById(id);
        modelMap.addAttribute("student",student);*/
        return "student/info";
    }

    @RequestMapping("/passUi")
    public String passUi(HttpServletRequest request,ModelMap modelMap){
        HttpSession session = request.getSession();
        student = (Student)session.getAttribute("student");
        modelMap.addAttribute("student",student);
        return "student/pass";
    }


    @RequestMapping("/pass")
    @ResponseBody
    public Boolean pass(@RequestParam("newpass")String newpass,@RequestParam("renewpass")String renewpass, HttpServletRequest request){
        HttpSession session  = request.getSession();
        student =(Student)session.getAttribute("student");
        if(newpass.equals(renewpass)){
            student.setPwd(CreateMD5.getMd5(newpass));
            int flag = studentService.updatePwd(student);
            System.out.println(flag);
            if(flag >=0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
