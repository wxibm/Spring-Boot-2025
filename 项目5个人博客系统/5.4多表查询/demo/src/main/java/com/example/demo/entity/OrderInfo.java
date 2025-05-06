package com.example.demo.entity;

import java.util.List;

public class OrderInfo {
    private Integer productId;
    private String productName;
    private String producePrice;

    //    定义一对多的List对象
    private List<Order> orderList;
    private List<User> userList;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducePrice() {
        return producePrice;
    }

    public void setProducePrice(String producePrice) {
        this.producePrice = producePrice;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
