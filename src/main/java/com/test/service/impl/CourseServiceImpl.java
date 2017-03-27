package com.test.service.impl;

import com.test.dao.CourseClassMapper;
import com.test.dao.CourseMapper;
import com.test.model.Course;
import com.test.model.CourseClass;
import com.test.service.CourseClassService;
import com.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张宏浩 on 2017/3/2.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseClassService courseClassService;

    @Resource
    private CourseMapper classMapper;

    @Resource
    private CourseMapper courseMapper;

    //根据班级id查询所有的课程
    public List<Course> listByClassId(int classId) {
        List<CourseClass> list = new ArrayList<CourseClass>();
        List<Course> lists = new ArrayList<Course>();
        list = courseClassService.listByClassId(classId);
        if(list ==null) {
            return null;
        }else {
            for(CourseClass ls:list){
                Course course = classMapper.selectByPrimaryKey(ls.getCourseId());
                lists.add(course);
            }
            return lists;
        }
    }

    public int insert(Course course) {
        int index = courseMapper.insertSelective(course);
        return course.getId();
    }

    public Course getById(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public int update(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }
}
