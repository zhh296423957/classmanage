package com.test.service.impl;

import com.test.dao.TeacherMapper;
import com.test.model.Teacher;
import com.test.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 张宏浩 on 2017/3/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService{

    @Resource
    private TeacherMapper teacherMapper;
    public Teacher getByNumber(String number) {
        return teacherMapper.getByNumber(number);
    }

    public int update(Teacher teacher) {
        return teacherMapper.updateByPrimaryKey(teacher);
    }
}
