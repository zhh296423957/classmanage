package com.test.service;

import com.test.model.School;

/**
 * Created by 张宏浩 on 2017/3/1.
 */
public interface SchoolService {

    //根据姓名查找学校
    int judgeSchool(String name);

    //根据学校id查找学校
    School getById(int id);

    //根据学校姓名查找学校
    School selectSchoolByName(String name);
}
