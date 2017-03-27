package com.test.listener;

import com.test.model.Student;
import com.test.service.StudentService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 张宏浩 on 2017/3/9.
 */
public class MyContentListener implements ServletContextListener {

    private ServletContext context = null;
    private StudentService studentService;
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        context = servletContextEvent.getServletContext();
        Student student = studentService.getById(1);
        context.setAttribute("student",student);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        Student student =(Student)context.getAttribute("student");
        studentService.updatePwd(student);
        this.context = null;
    }
}
