package com.system.service.impl;

import com.system.dao.RecordDao;
import com.system.dao.impl.RecordDaoImpl;
import com.system.service.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao = new RecordDaoImpl();

    /**
     * 添加到购物车
     * @param uid
     * @param sid
     * @return
     */
    @Override
    public boolean addCar(int uid, int sid) {
        int flag = recordDao.addCar(uid,sid);
        if (flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 将商品从购物车中移出
     * @param cid
     * @return
     */
    @Override
    public boolean removeCar(int cid) {
        int flag = recordDao.removeCar(cid);
        if (flag == 1){
            return true;
        }
        return false;
    }

    /**
     * 根据用户id查找订单
     * @param id
     * @return
     */
    @Override
    public List selectByUid(int id) {
        List list = recordDao.selectByUid(id);
        return list;
    }

    /**
     * 扣除用户余额
     * @param id
     * @param sum
     * @return
     */
    @Override
    public boolean balance(int id, String sum) {
        int flag = recordDao.balance(id,sum);
        if (flag == 1){
            return true;
        }
        return false;
    }
}
