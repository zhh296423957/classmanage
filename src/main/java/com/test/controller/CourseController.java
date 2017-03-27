package com.test.controller;

import com.alibaba.fastjson.JSONObject;
import com.test.model.*;
import com.test.service.CourseClassService;
import com.test.service.CourseService;
import com.test.service.GradeService;
import com.test.service.TbClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by 张宏浩 on 2017/3/2
 * 课程表的相关情况.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    private Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Resource
    private GradeService gradeService;

    @Resource
    private TbClassService tbClassService;

    @Resource
    private CourseService courseService;

    @Resource
    private CourseClassService courseClassService;

    /**
     * 根据学院id查找所有的年级
     * @param acaId
     * @return
     */
    @RequestMapping("/getGrade")
    @ResponseBody
    public JSONObject getGrade(@RequestParam("acaId")int acaId){
        JSONObject json = new JSONObject();
        System.out.println(acaId);
        List<Grade>  list = gradeService.listByAcaId(acaId);
        if(list ==null){
            json.put("msg","无年级信息");
        }else {
            json.put("list",list);
        }
        return json;
    }

    /**
     * 根据年级id查找所有的班级
     * @param graId
     * @return
     */
    @RequestMapping("/getCla")
    @ResponseBody
    public JSONObject getCla(@RequestParam("graId")int graId){
        JSONObject json = new JSONObject();
        System.out.println(graId);
        List<TbClass> list = tbClassService.listByGraId(graId);
        if(list ==null){
            json.put("msg","无年级信息");
        }else {
            json.put("list",list);
        }
        return json;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public JSONObject getList(@RequestParam("acaId")int acaId,@RequestParam("graId")int graId,@RequestParam("claId")int claId){
        JSONObject json = new JSONObject();

        List<Course> list = courseService.listByClassId(claId);
        if(list == null){
            json.put("msg","无相关课程");
        }else {
            json.put("list",list);
        }
        return json;
    }


    /**
     *跳转到添加课表界面
     * @return
     */
    @RequestMapping("/addSchUi")
    public String addSchUi(){
        return "student/addSchedule";
    }

    /**
     * 获得添加课程的所有数据，跳转到课表list界面
     * @return
     */
    @RequestMapping("/addSch")
    public String addSch(@ModelAttribute Course course, HttpServletRequest request){
        System.out.println(course);
        course.setGmtCreate(new Date());
        int index = courseService.insert(course);   //将课表插入到 tb_course 中
        System.out.println(index);


        HttpSession session = request.getSession();
        Student student = (Student)session.getAttribute("student");
        System.out.println(student);
        CourseClass courseClass  = new CourseClass();
        courseClass.setCourseId(index);                            //将课表信息与班级信息关联
        courseClass.setClassId(student.getClassId());
        courseClass.setGmtCreate(new Date());
        int tag = courseClassService.insert(courseClass);
        System.out.println(tag);
        return "redirect:/student/schedule";
    }


    /**
     * 跳转到修改课表的界面
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/modUi")
    public String modUi(@RequestParam("id")int id, ModelMap modelMap){
        Course course = courseService.getById(id);
        modelMap.addAttribute("course",course);
        return "student/modSchedule";
    }


    @RequestMapping("/modSch")
    public String modSch(@ModelAttribute Course course){
        course.setGmtModify(new Date());
        int tag = courseService.update(course);
        logger.info(String.valueOf(tag));
        return "redirect:/student/schedule";
    }
}
