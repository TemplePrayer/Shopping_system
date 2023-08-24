package com.system.service.impl;

import com.system.dao.UserDao;
import com.system.dao.impl.UserDaoImpl;
import com.system.entity.User;
import com.system.service.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 对于用户的各种操作方法
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 登录
     * @param username
     * @param password
     * @param type
     * @return
     */
    @Override
    public User login(String username, String password, String type) {
        User user = userDao.login(username,password,type);
        return user;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        int flag = userDao.register(user);
        if(flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 充值余额
     * @param id
     * @param money
     * @return
     */
    @Override
    public boolean recharge(int id, BigDecimal money) {
        int  flag = userDao.recharge(id,money);
        if (flag == 1) {
            return true;
        }
        return false;
    }

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    @Override
    public List selectById(int id) {
        User user = userDao.selectById(id);
        List list = new ArrayList();
        if (user != null){
            list.add(user);
        }
        return list;
    }

    /**
     * 删除用户数据
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(int id) {
        int  flag = userDao.deleteById(id);
        if (flag == 1) {
            return true;
        }
        return false;
    }

    /**
     * 显示所有用户
     * @return
     */
    @Override
    public List selectAll() {
        List list = userDao.selectAll();
        return list;
    }

    /**
     * 根据用户名查找显示
     * @param name
     * @return
     */
    @Override
    public List selectByName(String name) {
        List list = userDao.selectByName(name);
        return list;
    }

    /**
     * 修改更新用户
     * @param id
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean updateUser(String id, String username, String password,String level,String phone,String email) {
        int  flag = userDao.updateUser(id,username,password,level,phone,email);
        if (flag == 1) {
            return true;
        }
        return false;
    }
}
