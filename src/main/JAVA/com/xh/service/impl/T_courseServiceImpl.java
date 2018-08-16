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

}
