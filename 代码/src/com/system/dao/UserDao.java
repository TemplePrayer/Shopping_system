package com.system.dao;

import com.system.entity.User;

import java.math.BigDecimal;
import java.util.List;
/**
 * 用户的各个功能方法*/
public interface UserDao {
    User login(String username, String password, String type);

    int register(User user);

    int recharge(int id, BigDecimal money);

    User selectById(int id);

    int deleteById(int id);

    int updateMoney(int id, String sum);

    List selectAll();

    List selectByName(String name);

    int updateUser(String id, String username, String password,String level,String phone,String email);
}
