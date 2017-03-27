package com.test.model;

import java.util.Date;

public class School {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.sch_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String schName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.location
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String location;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.introducation
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private String introducation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_school.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    private Date gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_school
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public School(Integer id, String schName, String location, String introducation, Date gmtCreate, Date gmtModify) {
        this.id = id;
        this.schName = schName;
        this.location = location;
        this.introducation = introducation;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_school
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public School() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.id
     *
     * @return the value of tb_school.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.id
     *
     * @param id the value for tb_school.id
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.sch_name
     *
     * @return the value of tb_school.sch_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getSchName() {
        return schName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.sch_name
     *
     * @param schName the value for tb_school.sch_name
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setSchName(String schName) {
        this.schName = schName == null ? null : schName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.location
     *
     * @return the value of tb_school.location
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getLocation() {
        return location;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.location
     *
     * @param location the value for tb_school.location
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.introducation
     *
     * @return the value of tb_school.introducation
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public String getIntroducation() {
        return introducation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.introducation
     *
     * @param introducation the value for tb_school.introducation
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setIntroducation(String introducation) {
        this.introducation = introducation == null ? null : introducation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.gmt_create
     *
     * @return the value of tb_school.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.gmt_create
     *
     * @param gmtCreate the value for tb_school.gmt_create
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_school.gmt_modify
     *
     * @return the value of tb_school.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_school.gmt_modify
     *
     * @param gmtModify the value for tb_school.gmt_modify
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}