package com.test.interceptor;

import com.test.model.Student;
import com.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 张宏浩 on 2017/3/1.
 */
//登录认证的拦截器
public class LoginInterceptor implements HandlerInterceptor
{

    @Autowired
    StudentService studentService;
    //执行Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        if(url.indexOf("/")>= 0){
            //身份不存在直接放行
            return true;
            //return false表示拦截，不向下执行
            //return true表示放行
        }
            //判断session
            HttpSession session = httpServletRequest.getSession();
            //从session中取出用户份信息
            Student student = (Student) session.getAttribute("student");
            System.out.println(student);
            if (student != null) {
                //身份存在放行
               return true;
            }

        //执行到这里说明没有session,需要拦截
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.html").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    //进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发；将公用的模型数据在这里
    //传到视图，也可以在这里统一指定视图
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //判断session

    }


    //执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
