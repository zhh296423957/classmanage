package com.test.controller;

import com.test.model.Student;
import com.test.model.TbClass;
import com.test.model.Teacher;
import com.test.service.StudentService;
import com.test.service.TbClassService;
import com.test.service.TeacherService;
import com.test.utils.CreateMD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 张宏浩 on 2017/2/23.
 */
@Controller
public class LoginController {

    @Resource
    private StudentService studentService;

    @Resource
    private TbClassService classService;


    @RequestMapping("/")
    public String loginUi() {
        return "login";
    }

 /*   @RequestMapping("/loginJudge")
    @ResponseBody
    public Boolean LoginJudge(@RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request){
        Student student = new Student();
        System.out.println("username="+username+"    password="+password);
       student = studentService.getByNumber(username);
       System.out.println(student);
       if(student == null || !(student.getPwd().equals(CreateMD5.getMd5(password)))){
           return false;
       }else if(student.getPwd().equals(CreateMD5.getMd5(password))){
           HttpSession session = request.getSession();
           session.setAttribute("student",student);
           return true;
       }else {
           return false;
       }
    }*/

    /**
     * 登录判断用户名是老师还是学生
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/loginJudge", method = RequestMethod.POST)
    public String loginJudge(@RequestParam("username")String username, @RequestParam("password")String password,HttpServletRequest request){
        int length = username.length();
        String  pass = CreateMD5.getMd5(password);
        HttpSession session = request.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",pass);
        if(length >= 10) {
            return "redirect:/login";
        }else {
            return "redirect:/teacher/loginForTeacher";
        }
    }

    /**
     * 使用该映射返回session的值
     * 将用户的主要登录信息放在session中
     */
    @RequestMapping(value = "/login")
    public String login(ModelMap modelMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        Student student =new Student();
        student = studentService.getByNumber(username);
        if(student == null || !(student.getPwd().equals(password))){
           modelMap.addAttribute("msg","用户名或密码错误！");
           return "/login";
        }else{
            TbClass cla = classService.getById(student.getClassId());
            session.setAttribute("student",student);
            modelMap.addAttribute("student",student);
            modelMap.addAttribute("cla",cla);
            return "index";
        }

    }




/*    @RequestMapping("/session")
    @ResponseBody
    public JSONObject getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        JSONObject json = new JSONObject();
        Student student =(Student)session.getAttribute("student");
        List<Student> list = new ArrayList<Student>();
        list = studentService.list();
        json.put("student",student);
        json.put("list",list);
        return json;
    }*/


    /**
     * 跳转到index界面中的右侧显示界面
     * @return
     */
    @RequestMapping("/message")
    public String message(){
        return "message";
    }

    //退出，清除session
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request,ModelMap modelMap){
        modelMap.remove("student");
        modelMap.remove("teacher");
        HttpSession session = request.getSession();
        session.removeAttribute("student");
        session.removeAttribute("teacher");
        return "redirect:/";
    }
}
