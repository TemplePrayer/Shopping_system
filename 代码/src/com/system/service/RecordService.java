package com.system.service;

import java.util.List;

public interface RecordService {

    //加入购物车
    boolean addCar(int uid,int sid);

    //从购物车移除
    boolean removeCar(int cid);

    //根据用户id查询已购买的商品
    List selectByUid(int id);

    //结算
    boolean balance(int id, String sum);
}
