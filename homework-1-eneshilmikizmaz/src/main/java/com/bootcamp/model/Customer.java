package com.bootcamp.model;


import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String fullName;
    private long phone;
    private String email;
    private int regDate;
    protected double discountRate;
    private List<Order> orderList = new ArrayList<>();

    private Order order;

    public Customer(int customerId, String fullName, long phone, String email, int regDate) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.regDate = regDate;

    }

    public Customer(int customerId, String fullName, long phone, String email, List<Order> orderList, Order order) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.orderList = orderList;
        this.order = order;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getRegDate() {
        return regDate;
    }

    public void setRegDate(int regDate) {
        this.regDate = regDate;
    }

    public double discount(int value) {
        return 0;
    }


}
