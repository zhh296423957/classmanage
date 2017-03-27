package com.test.dao;

import com.test.model.TbClass;

import java.util.List;

public interface TbClassMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insert(TbClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insertSelective(TbClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    TbClass selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeySelective(TbClass record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_class
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKey(TbClass record);

    /**
     * 根据班级姓名和学院id查找班级
     */
    TbClass selectByIdAndName(String name,int gradeid);


    /**
     * 根据年级id查找所有的班级
     */
    List<TbClass> listByGraId(int graId);

    /**
     * 根据关键字查找班级
     */
    List<TbClass> listByKeyword(String keyword);

    /**
     * 班级分页
     * @param gradeId
     * @param startPos
     * @param pageSize
     * @return
     */
    List<TbClass> selectByPage(int gradeId,int startPos,int pageSize);

    /**
     * 班级数量总数
     * @param gradeId
     * @return
     */
     int getCount(int gradeId);

    /**
     * 根据关键字查找班级数量
     */
    int getClassCount(int gradeId,String keyword);

    /**
     * 根据关键字查找班级
     */
    List<TbClass> selectClass(int gradeId,String keyword,int startPos,int pageSize);
}