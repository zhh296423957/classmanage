package com.test.model;

import java.util.Date;

public class CourseClass {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_class.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_class.course_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Integer courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_class.class_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Integer classId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_class.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column course_class.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public CourseClass(Integer id, Integer courseId, Integer classId, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.courseId = courseId;
        this.classId = classId;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public CourseClass() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_class.id
     *
     * @return the value of course_class.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_class.id
     *
     * @param id the value for course_class.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_class.course_id
     *
     * @return the value of course_class.course_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_class.course_id
     *
     * @param courseId the value for course_class.course_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_class.class_id
     *
     * @return the value of course_class.class_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_class.class_id
     *
     * @param classId the value for course_class.class_id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_class.gmt_create
     *
     * @return the value of course_class.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_class.gmt_create
     *
     * @param gmtCreate the value for course_class.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column course_class.gmt_modify
     *
     * @return the value of course_class.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column course_class.gmt_modify
     *
     * @param gmtModify the value for course_class.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }


    @Override
    public String toString() {
        return "CourseClass{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", classId=" + classId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                '}';
    }
}