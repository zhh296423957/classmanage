package com.test.dao;

import com.test.model.Course;

import java.util.List;

public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKey(Course record);

}