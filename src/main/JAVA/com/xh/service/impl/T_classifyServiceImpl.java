package com.xh.service.impl;

import com.xh.dao.T_course_classifyMapper;
import com.xh.entity.T_course_classify;
import com.xh.service.IT_classifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class T_classifyServiceImpl implements IT_classifyService {
    @Autowired
    T_course_classifyMapper classifydao;
    @Override
    public boolean addclassify(T_course_classify classify) {
        return classifydao.insert(classify)>0?true:false;
    }

    @Override
    public boolean delclassify(Integer id) {
        return classifydao.deleteByPrimaryKey(id)>0?true:false;
    }

    @Override
    public T_course_classify queryclassify(Integer id) {
        return classifydao.selectByPrimaryKey(id);
    }

    @Override
    public List<T_course_classify> querybyparentcode(Integer code) {
        return classifydao.selectByparents(code);
    }

    @Override
    public boolean updateorder(T_course_classify classify) {
        return classifydao.updateByPrimaryKey(classify)>0?true:false;
    }
}
