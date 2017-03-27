package com.test.service.impl;

import com.test.dao.SchoolMapper;
import com.test.model.School;
import com.test.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 张宏浩 on 2017/3/1.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SchoolServiceImpl implements SchoolService {

    @Resource
    SchoolMapper schoolMapper;

    private School school;

    public int judgeSchool(String name){
        school = schoolMapper.selectBySchoolName(name);
        return school.getId();
    }

    public School getById(int id){
        school =schoolMapper.selectByPrimaryKey(id);
        return school;
    }

    public School selectSchoolByName(String name) {
        return schoolMapper.selectBySchoolName(name);
    }


}
