package com.system.service;

import com.system.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    //登录
    User login(String username,String password,String type);

    //注册
    boolean register(User user);

    //充值
    boolean recharge(int id, BigDecimal money);

    //根据ID查询
    List selectById(int id);

    //根据ID删除
    boolean deleteById(int id);

    //查询所有用户
    List selectAll();

    //根据名称查询
    List selectByName(String name);

    //修改用户信息
    boolean updateUser(String id, String username, String password,String level,String phone,String email);
}
