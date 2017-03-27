package com.test.model;

import java.util.Date;

public class Course {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.course_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String courseName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.teacher_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String teacherName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.course_week
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String courseWeek;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.course_time
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String courseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.place
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String place;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_course.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Course(Integer id, String courseName, String teacherName, String courseWeek, String courseTime, String place, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.courseWeek = courseWeek;
        this.courseTime = courseTime;
        this.place = place;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_course
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Course() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.id
     *
     * @return the value of tb_course.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.id
     *
     * @param id the value for tb_course.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.course_name
     *
     * @return the value of tb_course.course_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.course_name
     *
     * @param courseName the value for tb_course.course_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.teacher_name
     *
     * @return the value of tb_course.teacher_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.teacher_name
     *
     * @param teacherName the value for tb_course.teacher_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.course_week
     *
     * @return the value of tb_course.course_week
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getCourseWeek() {
        return courseWeek;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.course_week
     *
     * @param courseWeek the value for tb_course.course_week
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek == null ? null : courseWeek.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.course_time
     *
     * @return the value of tb_course.course_time
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getCourseTime() {
        return courseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.course_time
     *
     * @param courseTime the value for tb_course.course_time
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime == null ? null : courseTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.place
     *
     * @return the value of tb_course.place
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getPlace() {
        return place;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.place
     *
     * @param place the value for tb_course.place
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.gmt_create
     *
     * @return the value of tb_course.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.gmt_create
     *
     * @param gmtCreate the value for tb_course.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_course.gmt_modify
     *
     * @return the value of tb_course.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_course.gmt_modify
     *
     * @param gmtModify the value for tb_course.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", courseWeek='" + courseWeek + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", place='" + place + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                '}';
    }
}