package com.test.dao;

import com.test.model.Student;

import java.util.List;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insertSelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_student
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKey(Student record);

    List<Student> list(); //查询所有学生名单

    Student getByNumber(String number); //根据学号查找学生

    List<Student> listForClassId(int classId); //根据班级id查询学生名单

    List<Student> listByKeyword(String keyword);  //根据关键字查找学生

    int getCount(int classId,String keyword);  //根据关键字查找学生

    List<Student> selectStudent(int classId,String keyword,int startPos,int pageSize);
}