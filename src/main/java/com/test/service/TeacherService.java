package com.test.service;

import com.test.model.Teacher;

/**
 * Created by 张宏浩 on 2017/3/17.
 */
public interface TeacherService {
    //根据工号查询Teacher
    Teacher getByNumber(String number);

    //更新教师密码信息
    int update(Teacher teacher);
}
