package com.xh.service;

import com.xh.entity.T_course;

import java.util.List;

public interface IT_courseService {
    //显示课程列表
    List<T_course> getCourses();
    //分页显示
    List<T_course> getCoursesByPages(int start,int pagesize);
    //课程总数
    int numofcourse();
    //查询单个课程
    T_course getOnecourse(Integer id);
    //分类查询
    List<T_course> getCoursesbyclassifywithPages(int start,int pagesize,T_course course);

    List<T_course> getCoursesbyclassify(T_course course);
}
