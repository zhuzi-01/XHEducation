package com.xh.dao;

import com.xh.entity.T_course_image;
import java.util.List;

public interface T_course_imageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_image
     *
     * @mbg.generated Sun Aug 26 22:03:04 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_image
     *
     * @mbg.generated Sun Aug 26 22:03:04 CST 2018
     */
    int insert(T_course_image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_image
     *
     * @mbg.generated Sun Aug 26 22:03:04 CST 2018
     */
    T_course_image selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_image
     *
     * @mbg.generated Sun Aug 26 22:03:04 CST 2018
     */
    List<T_course_image> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_course_image
     *
     * @mbg.generated Sun Aug 26 22:03:04 CST 2018
     */
    int updateByPrimaryKey(T_course_image record);
}