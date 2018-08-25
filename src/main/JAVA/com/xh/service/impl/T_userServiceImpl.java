package com.xh.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.xh.dao.T_userMapper;
import com.xh.entity.T_user;
import com.xh.service.IT_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class T_userServiceImpl implements IT_userService {
    @Autowired
    T_userMapper userdao;
    @Override
    public boolean adduser(T_user t_user) {
        return userdao.insert(t_user)>0?true:false;
    }

    @Override
    public boolean deluser(Integer id) {
        return userdao.deleteByPrimaryKey(id)>0?true:false;
    }

    @Override
    public T_user queryoneuser(Integer id) {
        return userdao.selectByPrimaryKey(id);
    }

    @Override
    public T_user queryoneuserbyname(String name) {
        return userdao.selectByusername(name);
    }

    @Override
    public List<T_user> queryall() {
        return userdao.selectAll();
    }

    @Override
    public boolean updateuser(T_user user) {
        return userdao.updateByPrimaryKey(user)>0?true:false;
    }

    @Override
    public boolean updatepwd(T_user user) {
        return userdao.updatepwd(user)>0?true:false;
    }
}
