package com.system.entity;

import java.math.BigDecimal;

/**
 * 购物车内的商品
 */

public class Record {
    /**
     *  id     车内id
     *  uId    用户id
     *  sId    商品id
     *  price   价格
     *  num     数量
     */
    private int id;     //车内id
    private int uId;    //用户id
    private int sId;    //商品id
    private BigDecimal price;   //价格
    private int num;        //数量
    /**
     * 初始化方法*
     * **/
    public Record() {
    }//空

    public Record(int id, int uId, int sId, BigDecimal price, int num) {
        this.id = id;
        this.uId = uId;
        this.sId = sId;
        this.price = price;
        this.num = num;
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

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", uId=" + uId +
                ", sId=" + sId +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
