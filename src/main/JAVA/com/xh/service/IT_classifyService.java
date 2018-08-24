package com.xh.service;

import com.xh.entity.T_course_classify;

import java.util.List;

public interface IT_classifyService {
    boolean addclassify(T_course_classify classify);
    //删
    boolean delclassify(Integer id);
    //查
    T_course_classify queryclassify(Integer id);
    //查一个用户所有
    List<T_course_classify> querybyparentcode(Integer code);
    //改
    boolean updateorder(T_course_classify classify);
}
