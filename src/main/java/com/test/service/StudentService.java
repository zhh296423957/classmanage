package com.test.service;

import com.test.model.Student;

import java.util.List;

/**
 * Created by 张宏浩 on 2017/2/20.
 */
public interface StudentService {

    /**
     * 插入学生
     * @param
     * @return
     */
    int insert(String path);

    /**
     * 查询所有学生名单
     */
    List<Student> list();

    /**
     * 根据班级id查询所有的学生
     */
    List<Student> listForClassId(int classId);

    /**
     * 根据学号或者邮箱登录
     */
    Student getByNumber(String number);

    /**
     * 根据学生主键查找学生
     */
    Student getById(int id);

    /**
     * 更新学生密码
     */
    int updatePwd(Student student);

    //根据关键字查找学生
    List<Student> listByKeyword(String keyword);


    //根据关键字查找学生
    List<Student> selectStudent(int classId,String keyword,int startPos,int pageSize);

    //根据关键字查找数量
    int getCount(int classId,String keyword);

    //根据id删除学生
    int delete(int id);

    int insert(Student student);
}
