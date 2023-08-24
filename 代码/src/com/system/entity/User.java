package com.system.entity;

import java.math.BigDecimal;

/**
 * 用户的各个信息以及其方法
 */
public class User {
    /**
     *  id    用户id
     *  username  用户名
     *  password 密码
     *  type  型号
     *  money 余额
     *  level 用户级别
     *  time  注册日期
     *  phone 用户手机号
     *  email 用户邮箱
     */
    private int id;
    private String username;
    private String password;
    private String type;
    private BigDecimal money;
    private String level;
    private String time;
    private String phone;
    private String email;

    public User() {} //空方法
    /**
     * 初始化方法*
     * **/
    public User(int id, String username, String password, String type, BigDecimal money,
                String level,String time, String phone, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.money = money;
        this.level =level;
        this.time = time;
        this.phone = phone;
        this.email = email;
    }

    /**
     * 修改与返回方法
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level =level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time =time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email =email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", money=" + money + '\'' +
                ", level=" + level + '\'' +
                ", time=" + time + '\'' +
                ", phone=" + phone + '\'' +
                ", email=" + email +
                '}';
    }
}
