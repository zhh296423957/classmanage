package com.test.service.impl;

import com.test.dao.CourseClassMapper;
import com.test.model.CourseClass;
import com.test.service.CourseClassService;
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
public class CoureClassServiceImpl implements CourseClassService {

    @Resource
    CourseClassMapper courseClassMapper;

    //根据班级id查询到所有的课程
    public List<CourseClass> listByClassId(int classId) {
        List<CourseClass> list = new ArrayList<CourseClass>();
        list = courseClassMapper.listByClassId(classId);
        if(list == null){
            return null;
        }else{
            return list;
        }
    }

    //根据课程id查询到所有的班级
    public List<CourseClass> listByCourseId(int courseId) {
        List<CourseClass> list = new ArrayList<CourseClass>();
        list = courseClassMapper.listByCourseId(courseId);
        if(list.size() == 0){
            return null;
        }else{
            return list;
        }
    }

    public int insert(CourseClass courseClass) {
        courseClassMapper.insertSelective(courseClass);
        return courseClass.getId();
    }
}
