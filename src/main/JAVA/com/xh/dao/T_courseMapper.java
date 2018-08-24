package com.xh.dao;

import com.xh.entity.T_course;
import com.xh.entity.T_user;

import java.util.List;

public interface T_courseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int insert(T_course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    T_course selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    List<T_course> selectAll();

    List<T_course> selectPages(int start,int pagesize);

    List<T_course> selectByclassify(T_course course);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int updateByPrimaryKey(T_course record);
}