package com.xh.dao;

import com.xh.entity.T_course_classify;
import java.util.List;

public interface T_course_classifyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_classify
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_classify
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int insert(com.xh.entity.T_course_classify record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_classify
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
     T_course_classify selectByPrimaryKey(Integer id);
     List<T_course_classify> selectByparents(Integer code);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_classify
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    List<T_course_classify> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_classify
     *
     * @mbg.generated Wed Aug 15 20:15:46 CST 2018
     */
    int updateByPrimaryKey(T_course_classify record);
}