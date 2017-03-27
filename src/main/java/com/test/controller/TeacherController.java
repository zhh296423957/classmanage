package com.test.controller;


import com.test.controller.tool.ExportExcelDataTool;
import com.test.model.*;
import com.test.service.*;
import com.test.utils.CreateMD5;
import com.test.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.List;


/**
 * Created by 张宏浩 on 2017/2/28.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;
    @Resource
    private SchoolService schoolService;
    @Resource
    private AcademyService academyService;
    @Resource
    private GradeService gradeService;
    @Resource
    private TbClassService tbClassService;
    @Resource
    private StudentService studentService;
    @Resource
    private ExportExcelDataTool exportExcelDataTool;


    private School school;
    private Academy academy;
    private Grade grade;
    /**
     * 跳转到教师登陆
     * @return
     */
    @RequestMapping(value = "/loginForTeacher")
    public String  loginForTeacher(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        String username =(String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        Teacher teacher = teacherService.getByNumber(username);   //根据用户名查找到老师实体
        if(teacher == null || !(teacher.getPwd().equals(password))){
            modelMap.addAttribute("msg","用户名或密码错误！");
            return "/login";
        }else{
            School school = schoolService.getById(teacher.getSchoolId());
            Academy academy = academyService.getById(teacher.getAcademyId());
            Grade grade = gradeService.getById(teacher.getGradeId());
            session.setAttribute("teacher",teacher);
            modelMap.addAttribute("teacher",teacher);
            modelMap.addAttribute("school",school);
            modelMap.addAttribute("academy",academy);
            modelMap.addAttribute("grade",grade);
            return "teacher/index";
        }
    }

    /**
     * 跳转到个人信息主页
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/infoUi")
    public String info(HttpServletRequest request,ModelMap modelMap){
        HttpSession session = request.getSession();   //通过session获得教师实体
        Teacher teacher = (Teacher)session.getAttribute("teacher");

        Date hireDate  = new java.sql.Date(teacher.getHireDate().getTime());
        teacher.setHireDate(hireDate);                  //修改数据库时间属性

        school = schoolService.getById(teacher.getSchoolId());
        if(school ==null){
            modelMap.addAttribute("school","未分配学校");
        }else
        {
            modelMap.addAttribute("school",school);
        }
        academy = academyService.getById(teacher.getAcademyId());
        if(academy ==null){
            modelMap.addAttribute("academy","未分配学院");
        }else {
            modelMap.addAttribute("academy",academy);
        }
        grade =gradeService.getById(teacher.getGradeId());
        if(grade ==null){
            modelMap.addAttribute("grade","未分配年级");
        }else {
            modelMap.addAttribute("grade",grade);
        }

        modelMap.addAttribute("teacher",teacher);
        return "teacher/info";
    }

    /**
     * 跳转到修改密码界面
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping("/passUi")
    public String pass(HttpServletRequest request,ModelMap modelMap){
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        modelMap.addAttribute("teacher",teacher);
        return "teacher/pass";
    }

    @RequestMapping("/pass")
    @ResponseBody
    public Boolean pass(@RequestParam("newpass")String newpass,@RequestParam("renewpass")String renewpass, HttpServletRequest request){
        HttpSession session  = request.getSession();
        Teacher teacher =(Teacher)session.getAttribute("teacher");
        if(newpass.equals(renewpass)){
            teacher.setPwd(CreateMD5.getMd5(newpass));
            int flag = teacherService.update(teacher);
            if(flag >=0){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @RequestMapping("/classMan")
    public String classMan(HttpServletRequest request, ModelMap modelMap){
        HttpSession session =request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");

        Page page = null;
        int total = tbClassService.getCount(teacher.getGradeId());
        page = new Page(total,1);
        List<TbClass> lists =tbClassService.selectByPage(teacher.getGradeId(),page.getStartPos(),page.getPageSize());  //根据分管年级id查找所有的年级

        int flag  = 0;
        if(lists ==null){
            flag = 0;
            modelMap.addAttribute("lists","暂时无班级信息");
        }else {
            flag =1;
            for(TbClass list:lists){
                if(list.getIntroducation().length()>8){
                    String  introduction = list.getIntroducation();
                    list.setIntroducation(introduction.substring(0,7)+"...");
                }
            }
            modelMap.addAttribute("lists",lists);
        }
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("page",page);
        return "teacher/classMan";
    }

    @RequestMapping("/page")
    public String page(HttpServletRequest request, ModelMap modelMap,@RequestParam("pageNow")int pageNow){
        HttpSession session =request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Page page = null;
        int total = tbClassService.getCount(teacher.getGradeId());
        page = new Page(total,pageNow);
        List<TbClass> lists =tbClassService.selectByPage(teacher.getGradeId(),page.getStartPos(),page.getPageSize());  //根据分管年级id查找所有的年级

        int flag  = 0;
        if(lists.size() !=0){
            flag =1;
            for(TbClass list:lists){
                if(list.getIntroducation().length()>8){
                    String  introduction = list.getIntroducation();
                    list.setIntroducation(introduction.substring(0,7)+"...");
                }
            }
            modelMap.addAttribute("lists",lists);
        }else {
            flag = 0;
            modelMap.addAttribute("lists","暂时无班级信息");
        }
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("page",page);
        return "teacher/classMan";
    }

   /* @RequestMapping("/classMan")
    public String classMan(HttpServletRequest request, ModelMap modelMap){
        HttpSession session =request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");

        Page page = null;
        List<TbClass> lists =tbClassService.listByGraId(teacher.getGradeId());  //根据分管年级id查找所有的年级

        int flag  = 0;
        if(lists ==null){
            flag = 0;
            modelMap.addAttribute("lists","暂时无班级信息");
        }else {
            flag =1;
            for(TbClass list:lists){
                if(list.getIntroducation().length()>8){
                    String  introduction = list.getIntroducation();
                    list.setIntroducation(introduction.substring(0,7)+"...");
                }
            }
            modelMap.addAttribute("lists",lists);
        }
        modelMap.addAttribute("flag",flag);
        return "teacher/classMan";
    }
*/

    /**
     * 跳转到学生界面
     * @param classId
     * @param modelMap
     * @return
     */
    @RequestMapping("/listStudent")
    public String listStudent(@RequestParam("id")int classId,@RequestParam("pageNow")int pageNow,ModelMap modelMap){
        Page page = null;
        String keyword = "";
        int count = studentService.getCount(classId,keyword);
        page = new Page(count,pageNow);
        List<Student> lists =studentService.selectStudent(classId,keyword,page.getStartPos(),page.getPageSize());
        int flag = 0;
        if(lists.size() ==0){
            flag = 0;
            modelMap.addAttribute("lists","暂无学生信息");
        }else {
            flag = 1;
            modelMap.addAttribute("lists",lists);
        }
        modelMap.addAttribute("classId",classId);
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("page",page);
        return "teacher/listStudent";
    }









    /**
     * 根据关键字查找
     */
    @RequestMapping("/search")
    public String search(@RequestParam("keyword")String keyword,ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        Teacher teacher  = (Teacher)session.getAttribute("teacher");
        Page page = null;
        int count = tbClassService.getClassCount(teacher.getGradeId(),keyword);
        page = new Page(count,1);
        List<TbClass> lists = tbClassService.selectClass(teacher.getGradeId(),keyword,page.getStartPos(),page.getPageSize());
        int flag =0;
        if(lists.size() != 0){
            flag =1;
            modelMap.addAttribute("lists",lists);
        }else {
            flag = 0;
            modelMap.addAttribute("lists","暂时无相关信息");
        }
        modelMap.addAttribute("flag",flag);
        modelMap.addAttribute("keyword",keyword);
        modelMap.addAttribute("page",page);
        return "teacher/classMan";
    }

    @RequestMapping("/download")
    public void down(HttpServletRequest request, HttpServletResponse response,@RequestParam("id")int id) throws IOException {

        exportExcelDataTool.exportExcel(response,id);
        /*ContextLoader.getCurrentWebApplicationContext().getBean("名称");*/
    }
}


