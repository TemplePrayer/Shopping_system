package com.system.service.impl;

import com.system.dao.ShopDao;
import com.system.dao.impl.ShopDaoImpl;
import com.system.entity.Shop;
import com.system.service.ShopService;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于商品的各个操作方法
 */
public class ShopServiceImpl implements ShopService {

    private ShopDao shopDao = new ShopDaoImpl();

    /**
     * 显示所有
     * @return
     */
    @Override
    public List selectAll() {
        List list = shopDao.selectAll();
        return list;
    }

    /**
     * 用id查找显示
     * @param id
     * @return
     */
    @Override
    public List selectById(int id) {
        Shop shop = shopDao.selectById(id);
        List list = new ArrayList();
        if(shop != null){
            list.add(shop);
        }
        return list;
    }

    /**
     * 根据ID修改更新商品信息
     * @param shop
     * @return
     */
    @Override
    public boolean updateById(Shop shop) {
        int flag = shopDao.updateById(shop);
        if(flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(int id) {
        int flag = shopDao.deleteById(id);
        if(flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 用名字查找
     * @param shopname
     * @return
     */
    @Override
    public List selectByName(String shopname) {
        List list = shopDao.selectByName(shopname);
        return list;
    }

    /**
     * 添加商品
     * @param shop
     * @return
     */
    @Override
    public boolean add(Shop shop) {
        int flag = shopDao.add(shop);
        if(flag == 1){
            return true;
        }
        return false;
    }
}
