package com.xh.dao;

import com.xh.entity.T_user_follows;
import java.util.List;

public interface T_user_followsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follows
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follows
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int insert(T_user_follows record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follows
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    T_user_follows selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follows
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    List<T_user_follows> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follows
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int updateByPrimaryKey(T_user_follows record);
}