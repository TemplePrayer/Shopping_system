package com.system.dao.impl;

import com.system.dao.RecordDao;
import com.system.dao.ShopDao;
import com.system.entity.Record;
import com.system.entity.Shop;
import com.system.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品的操作的各个方法
 */
public class ShopDaoImpl implements ShopDao {

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        String sql = "delete from shop where id = ?";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            connection.setAutoCommit(false);
            RecordDao recordDao = new RecordDaoImpl();
            flag = recordDao.deleteBySid(id);

            PreparedStatement ps_user = connection.prepareStatement(sql);
            ps_user.setInt(1, id);
            flag = ps_user.executeUpdate();

            connection.commit();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 显示所有商品
     * @return
     */
    @Override
    public List selectAll() {
        String sql = "select * from shop";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        Shop result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                result = new Shop();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setFactory(rs.getString("factory"));
                result.setDate(rs.getString("date"));
                result.setForm(rs.getString("form"));
                result.setPreprice(rs.getBigDecimal("preprice"));
                result.setPrice(rs.getBigDecimal("price"));
                result.setNum(rs.getInt("num"));
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
     * 用ID查找
     * @param id
     * @return
     */
    @Override
    public Shop selectById(int id) {
        String sql = "select * from shop where id = ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        Shop result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Shop();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setFactory(rs.getString("factory"));
                result.setDate(rs.getString("date"));
                result.setForm(rs.getString("form"));
                result.setPreprice(rs.getBigDecimal("preprice"));
                result.setPrice(rs.getBigDecimal("price"));
                result.setNum(rs.getInt("num"));
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用商品名查找
     * @param shopname
     * @return
     */
    @Override
    public List selectByName(String shopname) {
        String sql = "select * from shop where name like ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        Shop result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"%" + shopname + "%");
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                result = new Shop();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setFactory(rs.getString("factory"));
                result.setDate(rs.getString("date"));
                result.setForm(rs.getString("form"));
                result.setPreprice(rs.getBigDecimal("preprice"));
                result.setPrice(rs.getBigDecimal("price"));
                result.setNum(rs.getInt("num"));

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
     * 通过ID修改更新商品信息
     * @param shop
     * @return
     */
    @Override
    public int updateById(Shop shop) {
        String sql_user = "update shop  set name = ?,factory = ?,date = ?,form = ?,preprice = ?,price = ? ,num = ? where id = ? ";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql_user);
            ps_user.setString(1, shop.getName());
            ps_user.setString(2, shop.getFactory());
            ps_user.setString(3, shop.getDate());
            ps_user.setString(4, shop.getForm());
            ps_user.setBigDecimal(5, shop.getPreprice());
            ps_user.setBigDecimal(6, shop.getPrice());
            ps_user.setInt(7, shop.getNum());
            ps_user.setInt(8, shop.getId());

            flag = ps_user.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 添加新的商品
     * @param shop
     * @return
     */
    @Override
    public int add(Shop shop) {
        String sql = "insert into shop(name,factory,date,form,preprice,price,num) values(?,?,?,?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql);
            ps_user.setString(1, shop.getName());
            ps_user.setString(2, shop.getFactory());
            ps_user.setString(3, shop.getDate());
            ps_user.setString(4, shop.getForm());
            ps_user.setBigDecimal(5, shop.getPreprice());
            ps_user.setBigDecimal(6, shop.getPrice());
            ps_user.setInt(7, shop.getNum());

            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
