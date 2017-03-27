package com.test.service;

import com.test.model.Course;

import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/2.
 */
public interface CourseService {

    //根据班级的id查询班级的所有课程
    List<Course>  listByClassId(int classId);

    //插入课程返回主键id
    int insert(Course course);

    //根据课表id查找课表
    Course getById(int id);

    //修改课程表信息
    int update(Course course);
}
