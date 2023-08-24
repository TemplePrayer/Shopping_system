package com.system.dao;

import java.util.List;

public interface RecordDao {


    int addCar(int uid, int sid);

    int removeCar(int cid);

    List selectByUid(int id);

    int balance(int id, String sum);

    int deleteBySid(int id);
}


