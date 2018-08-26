package com.xh.service.impl;

import com.xh.dao.T_user_course_sectionMapper;
import com.xh.entity.T_user_course_section;
import com.xh.service.IT_orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class T_orderServiceImpl implements IT_orderService {
    @Autowired
    T_user_course_sectionMapper orderdao;
    @Override
    public boolean addorder(T_user_course_section t_user_course_section) {
        return orderdao.insert(t_user_course_section)>0?true:false;
    }

    @Override
    public boolean delorder(Integer id) {
        return orderdao.deleteByPrimaryKey(id)>0?true:false;
    }

    @Override
    public List<T_user_course_section> queryall() {
        return orderdao.selectAll();
    }

    @Override
    public T_user_course_section queryoneorder(Integer id) {
        return orderdao.selectByPrimaryKey(id);
    }

    @Override
    public List<T_user_course_section> queryOrdersbyUserid(Integer userid) {

        return orderdao.selectByUserid(userid);
    }

    @Override
    public boolean updateorder(T_user_course_section t_user_course_section) {
        return orderdao.updateByPrimaryKey(t_user_course_section)>0?true:false;
    }
}
