package com.test.dao;

import com.test.model.Fee;

public interface FeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insert(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int insertSelective(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    Fee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKeySelective(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_fee
     *
     * @mbggenerated Tue Feb 21 19:58:30 CST 2017
     */
    int updateByPrimaryKey(Fee record);
}