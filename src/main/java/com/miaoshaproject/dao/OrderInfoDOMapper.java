package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.OrderInfoDO;

public interface OrderInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    int insert(OrderInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    int insertSelective(OrderInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    OrderInfoDO selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    int updateByPrimaryKeySelective(OrderInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_info
     *
     * @mbg.generated Thu Sep 03 20:52:05 CST 2020
     */
    int updateByPrimaryKey(OrderInfoDO record);
}