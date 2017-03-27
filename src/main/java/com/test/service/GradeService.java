package com.test.service;

import com.test.model.Grade;

import java.util.List;

/**
 * Created by 张宏浩 on 2017/3/1.
 */
public interface GradeService {

    //根据学院id和年级姓名查找年级
    int judgeGrade(int academyId ,String name);

    //根据id查找年级
    Grade getById(int id);

    //根据学院id查找所有的grade
    List<Grade> listByAcaId(int acaId);
}
