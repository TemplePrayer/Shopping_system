package com.system.dao.impl;

import com.system.dao.UserDao;
import com.system.entity.User;
import com.system.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 登录
     * @param username
     * @param password
     * @param type
     * @return
     */
    @Override
    public User login(String username, String password, String type) {
        String sql = "select * from user where username = ? and password = ? and type = ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        User result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,type);
            rs = ps.executeQuery();
            while(rs.next()){
                result = new User();
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setType(rs.getString("type"));
                result.setMoney(rs.getBigDecimal("money"));

            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 注册用户实现*/
    @Override
    public int register(User user) {
        /***/
        String sql_user = "insert into user(username,password,type,money,level,time,phone,email) values(?,?,?,?,?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql_user);
            ps_user.setString(1, user.getUsername());
            ps_user.setString(2, user.getPassword());
            ps_user.setString(3, user.getType());
            ps_user.setBigDecimal(4,new BigDecimal(0.00)); /**设置初始余额为0*/
            ps_user.setString(5, user.getLevel());
            ps_user.setString(6, user.getTime());
            ps_user.setString(7, user.getPhone());
            ps_user.setString(8, user.getEmail());

            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 实现充值
     * @param id
     * @param money
     * @return
     */
    @Override
    public int recharge(int id, BigDecimal money) {
        String sql_user = "update user set money = ? where id = ?";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            User user = new UserDaoImpl().selectById(id);
            PreparedStatement ps_user = connection.prepareStatement(sql_user);
            ps_user.setBigDecimal(1, user.getMoney().add(money));
            ps_user.setInt(2, user.getId());
            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    @Override
    public User selectById(int id) {
        String sql = "select * from user where id = ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        User result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new User();
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setType(rs.getString("type"));
                result.setMoney(rs.getBigDecimal("money"));
                /***/
                result.setLevel(rs.getString("level"));
                result.setTime(rs.getString("time"));
                result.setPhone(rs.getString("phone"));
                result.setEmail(rs.getString("email"));
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 根据用户名查找
     * @param name 用户名
     * @return
     */
    @Override
    public List selectByName(String name) {
        String sql = "select * from user where type = '顾客' and username like ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        User result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%" + name + "%");
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new User();
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                /***/
                result.setLevel(rs.getString("level"));
                result.setTime(rs.getString("time"));
                result.setPhone(rs.getString("phone"));
                result.setEmail(rs.getString("email"));

                list.add(result);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        String sql = "delete from user where id = ?";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql);
            ps_user.setInt(1, id);
            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更新余额
     * @param id 用户id
     * @param sum 余额
     * @return
     */
    @Override
    public int updateMoney(int id, String sum) {
        String sql_user = "update user  set money = ? where id = ? ";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            User user = new UserDaoImpl().selectById(id);
            PreparedStatement ps_user = connection.prepareStatement(sql_user);
            ps_user.setBigDecimal(1,user.getMoney().subtract(new BigDecimal(sum)));
            ps_user.setInt(2, id);
            flag = ps_user.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * 显示所有用户
     */
    @Override
    public List selectAll() {
        String sql = "select * from user where type = '顾客'";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        User result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new User();
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setLevel(rs.getString("level"));
                result.setTime(rs.getString("time"));
                result.setPhone(rs.getString("phone"));
                result.setEmail(rs.getString("email"));

                list.add(result);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 修改更新用户信息
     * @param id
     * @param username
     * @param password
     * @return
     */
    @Override
    public int updateUser(String id, String username, String password,String level,String phone,String email) {
        String sql_user = "update user  set username = ?,password = ?,level = ? ,phone = ?,email = ? where id = ? ";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql_user);
            ps_user.setString(1, username);
            ps_user.setString(2, password);
            ps_user.setString(3, level);
            ps_user.setString(4, phone);
            ps_user.setString(5, email);
            ps_user.setInt(6, new Integer(id));

            flag = ps_user.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
