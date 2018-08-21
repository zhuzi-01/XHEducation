package com.xh.service;

import com.xh.entity.T_user;

public interface IT_userService {
    //增
    boolean adduser(T_user t_user);
    //删
    boolean deluser(Integer id);
    //查
    T_user queryoneuser(Integer id);
    T_user queryoneuserbyname(String name);
    //改
    boolean updateuser(T_user user);
}
