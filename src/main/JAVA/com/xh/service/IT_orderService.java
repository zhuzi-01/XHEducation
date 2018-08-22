package com.xh.service;

import com.xh.entity.T_user;
import com.xh.entity.T_user_course_section;

import java.util.List;

public interface IT_orderService {
    //增
    boolean addorder(T_user_course_section t_user_course_section);
    //删
    boolean delorder(Integer id);
    //查
    T_user_course_section queryoneorder(Integer id);
    //查一个用户所有
    List<T_user_course_section> queryOrdersbyUserid(Integer userid);
    //改
    boolean updateorder(T_user_course_section t_user_course_section);
}
