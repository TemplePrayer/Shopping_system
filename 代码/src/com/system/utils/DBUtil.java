package com.system.utils;

import java.sql.*;

/**
 * 数据库链接
 */
public class DBUtil {
    // 数据库地址  url   localhost:127.0.0.1  mysql端口：3306
    private String Driver_name = "jdbc:mysql://localhost:3306/web_shop?serverTimezone=Asia/Shanghai&useSSL=false&characterEncoding=utf8";
    // 数据库用户名
    private String USER = "root"; // 这里需要修改为自己的用户名和密码
    // 数据库密码
    private String PASS = "123";
    // 数据库连接
    public Connection con;

    // 构造方法
    public DBUtil() {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver"); // 这个驱动是mysql8版本的
            // 获取连接

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public Connection getConnection(){
        if (con == null) {
            try {
                con = DriverManager.getConnection(Driver_name, USER, PASS);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return con;
    }



    // 释放连接
    public void close(ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放连接
    public void close(Statement statement, Connection connection) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放连接
    public void close(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

