package com.xh.service;

import com.xh.entity.T_course;
import com.xh.entity.T_course_image;

import java.util.List;

public interface IT_courseService {
    //
    boolean addcourse(T_course course);
    boolean delcourse(Integer id);
    boolean updatecourse(T_course course);
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

    List<T_course> researchcourse(String text);
    List<T_course> researchcourseByPages(int start,int pagesize,String text);

    boolean addimage(T_course_image image);
    boolean updateimage(T_course_image image);
    T_course_image queryoneimage(Integer id);

}
