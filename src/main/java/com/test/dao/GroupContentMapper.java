package com.test.dao;

import com.test.model.GroupContent;

public interface GroupContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insert(GroupContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insertSelective(GroupContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    GroupContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeySelective(GroupContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeyWithBLOBs(GroupContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_groupcontent
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKey(GroupContent record);
}