package com.test.service;

import com.test.model.Academy;

import java.util.List;


/**
 * Created by 张宏浩 on 2017/3/1.
 */
public interface AcademyService {

    //根据学校id和学院姓名查找学院
    int judgeAcademy(int schoolId,String name);

    //根据学院id查找学院
    Academy getById(int id);

    //根据学校id查询所有的学院
    List<Academy> lists(int schoolId);
}
