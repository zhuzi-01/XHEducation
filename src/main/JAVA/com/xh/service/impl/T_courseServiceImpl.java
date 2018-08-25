package com.xh.service.impl;

import com.xh.dao.T_courseMapper;
import com.xh.entity.T_course;
import com.xh.service.IT_courseService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class T_courseServiceImpl implements IT_courseService {
    @Autowired
    T_courseMapper coursedao;
    @Override
    public List<T_course> getCourses() {
        return coursedao.selectAll();
    }

    @Override
    public List<T_course> getCoursesByPages(int start, int pagesize) {
        return coursedao.selectPages(start,pagesize);
    }

    @Override
    public int numofcourse() {
        List<T_course> courses=coursedao.selectAll();

        return courses.size();
    }

    @Override
    public T_course getOnecourse(Integer id) {
        return coursedao.selectByPrimaryKey(id);
    }

    @Override
    public List<T_course> getCoursesbyclassifywithPages(int start,int pagesize,T_course course) {
        return coursedao.selectByclassifywithPages(start,pagesize,course);
    }

    @Override
    public List<T_course> getCoursesbyclassify(T_course course) {
        return coursedao.selectByclassify(course);
    }

    @Override
    public List<T_course> researchcourse(String text) {
        return coursedao.research(text);
    }

    @Override
    public List<T_course> researchcourseByPages(int start, int pagesize, String text) {
        return coursedao.researchbypages(start,pagesize,text);
    }

}
