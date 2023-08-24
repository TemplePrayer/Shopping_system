package com.system.dao.impl;

import com.system.dao.RecordDao;
import com.system.dao.ShopDao;
import com.system.entity.Record;
import com.system.entity.Shop;
import com.system.entity.User;
import com.system.utils.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 关于购物车的多种操作方法
 */
public class RecordDaoImpl implements RecordDao {

    /**
     * 添加此商品到购物车中
     * @param uid  用户id
     * @param sid  商品id
     * @return
     */
    @Override
    public int addCar(int uid, int sid) {
        String sql = "insert into record(u_id,s_id,price,num) values(?,?,?,?)";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            ShopDao shopDao = new ShopDaoImpl();
            Shop shop = shopDao.selectById(sid);
            PreparedStatement ps_user = connection.prepareStatement(sql);
            ps_user.setInt(1, uid);
            ps_user.setInt(2, sid);
            ps_user.setBigDecimal(3, shop.getPrice());
            ps_user.setInt(4, shop.getNum());
            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 将商品从购物车中移除
     * @param cid 订单编号id
     * @return
     */
    @Override
    public int removeCar(int cid) {
        String sql = "delete from record where id = ?";
        Connection connection = new DBUtil().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps_user = connection.prepareStatement(sql);
            ps_user.setInt(1,cid);
            flag = ps_user.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List selectByUid(int id) {
        String sql = "select * from record where u_id = ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        Shop shop = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                Shop s = new ShopDaoImpl().selectById(rs.getInt("s_id"));
                Record record = new Record();
                record.setId(rs.getInt("id"));
                s.setRecord(record);
                list.add(s);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int balance(int id, String sum) {
        String sql = "delete from record where u_id = ?";
        Connection connection = new DBUtil().getConnection();
        ResultSet rs = null;
        Shop shop = null;
        int flag = 0;
        try {
            User user = new UserDaoImpl().selectById(id);

            if (user.getMoney().compareTo(new BigDecimal(sum)) == -1){
                flag = 0;
            }else {
                //开启事务
                connection.setAutoCommit(false);
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1,id);
                flag = ps.executeUpdate();

                flag = new UserDaoImpl().updateMoney(id,sum);
                connection.commit();
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteBySid(int id) {
        String sql = "delete from record where s_id = ?";
        Connection connection = new DBUtil().getConnection();
        int flag = 0;
        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            flag = ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
