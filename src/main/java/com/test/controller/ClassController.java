package com.test.controller;

import com.test.controller.tool.ReadExcelData;
import com.test.model.TbClass;
import com.test.model.Teacher;
import com.test.service.TbClassService;
import com.test.utils.ReadExcel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 张宏浩 on 2017/3/24.
 */
@RequestMapping("/tbClass")
@Controller
public class ClassController {

    @Resource
    private ReadExcelData readExcelData;
    @Resource
    private TbClassService classService;

    /**
     * 跳转到新增班级界面
     * @return
     */
    @RequestMapping("/addClassUi")
    public String newClass(){
        return "teacher/addClass";
    }

    @RequestMapping("/addClass")
    public String addClass( @RequestParam("claName")String claName, @RequestParam("claTeacher")String claTeacher, @RequestParam("introducation")String introducation,
                           @RequestParam("file")MultipartFile file, HttpServletRequest request, RedirectAttributesModelMap modelMap) throws Exception {

        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        TbClass tbClass = new TbClass();
        tbClass.setClaName(claName);
        tbClass.setClaTeacher(claTeacher);
        tbClass.setGmtCreate(new Date());
        tbClass.setIntroducation(introducation);
        tbClass.setGradeId(teacher.getGradeId());

        int flag = classService.insertClass(tbClass);
        System.out.println(flag+"  0为数据未插入， 1 为已经插入");                        //记录数据是否插入


        int number =0;  //记录班级人数
        //找到项目的根目录下的upload文件夹
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        //取文件后缀名
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        // System.out.println(path);
        File targetFile  = new File(path,fileName);
        //判断上传的文件是否为excel
        if(!prefix.equals("xlsx")&&!prefix.equals("xls"))
        {
            modelMap.addFlashAttribute("msg", "上传格式不正确，请重新上传!");
            return "redirect:/tbClass/addClassUi";
        }
        if(!targetFile.exists())
        {
            targetFile.mkdirs();
        }
        try{
            file.transferTo(targetFile);
            number= readExcelData.insertStudent(targetFile.toString());
        } catch (IOException e) {
            System.out.println("文件上传失败");
            e.printStackTrace();
        }

        System.out.println("插入的班级的总人数为："+number);

        return "redirect:/teacher/classMan";
    }
}
