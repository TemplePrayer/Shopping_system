package com.system.entity;

import java.math.BigDecimal;
/**
 * 商品的各个信息
 */
public class Shop {
    /**
     *  id    商品id
     *  name  商品名
     *  factory   生产厂家
     *  date  生产日期
     *  form  型号
     *  preprice  进货价
     *  price     售价
     *  num   数目
     */
    private int id;
    private String name;
    private String factory;
    private String date;
    private String form;
    private BigDecimal preprice;
    private BigDecimal price;
    private int num;

    private Record record;

    public Shop() {} //空

    /**
     * 初始化方法
     * @param id    商品id
     * @param name  商品名
     * @param factory   生产厂家
     * @param date  生产日期
     * @param form  型号
     * @param preprice  进货价
     * @param price     售价
     * @param num   数目
     */
    public Shop(int id, String name, String factory, String date, String form, BigDecimal preprice, BigDecimal price, int num) {
        this.id = id;
        this.name = name;
        this.factory = factory;
        this.date = date;
        this.form = form;
        this.preprice = preprice;
        this.price = price;
        this.num = num;
    }
    /**
     * 修改与返回方法
     */
    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public BigDecimal getPreprice() {
        return preprice;
    }

    public void setPreprice(BigDecimal preprice) {
        this.preprice = preprice;
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
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", factory='"+ factory + '\'' +
                ", date=" + date + '\'' +
                ", form=" + form + '\'' +
                ", preprice" + preprice + '\'' +
                ", price=" + price + '\'' +
                ", num=" + num +
                '}';
    }
}
