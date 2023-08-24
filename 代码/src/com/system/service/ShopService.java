package com.system.service;

import com.system.entity.Shop;

import java.util.List;

public interface ShopService {

    //查询所有商品
    List selectAll();

    //根据ID查询商品
    List selectById(int id);

    //根据ID修改商品
    boolean updateById(Shop shop);

    //根据ID删除商品
    boolean deleteById(int id);

    //根据商品名称查询
    List selectByName(String shopname);

    //添加商品
    boolean add(Shop shop);
}
