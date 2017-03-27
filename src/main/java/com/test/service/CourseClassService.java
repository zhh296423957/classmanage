package com.test.service;

import com.test.model.CourseClass;

import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/2.
 */
public interface CourseClassService {

    //根据班级id查询到所有的课程行数
    List<CourseClass> listByClassId(int classId);

    //根据课程id查询到所有的上课的班级
    List<CourseClass> listByCourseId(int courseId);

    //插入CourseClass
    int insert(CourseClass courseClass);
}
