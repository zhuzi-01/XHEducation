package com.xh.dao;

import com.xh.entity.T_user_course_section;
import java.util.List;

public interface T_user_course_sectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_course_section
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_course_section
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int insert(T_user_course_section record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_course_section
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    T_user_course_section selectByPrimaryKey(Integer id);

    List<T_user_course_section> selectByUserid(Integer userid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_course_section
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    List<T_user_course_section> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_course_section
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int updateByPrimaryKey(T_user_course_section record);
}