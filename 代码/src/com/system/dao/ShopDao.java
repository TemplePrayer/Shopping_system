package com.system.dao;

import com.system.entity.Shop;

import java.util.List;
/**
 * 商品的各个功能方法*/
public interface ShopDao {


    int deleteById(int id);

    List selectAll();

    Shop selectById(int id);

    int updateById(Shop shop);

    List selectByName(String shopname);

    int add(Shop shop);
}
