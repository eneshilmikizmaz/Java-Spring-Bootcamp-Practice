package com.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

//Inheritance Example
public class CorporateCustomer implements ICustomer {

    private int customerId;
    private String fullName;
    private long phone;
    private String email;
    private int regDate;
    private final double discountRate = 0.30;
    private List<Order> orderList = new ArrayList<>();
    private Order order;

    public CorporateCustomer(int customerId, String fullName, long phone, String email, int regDate) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.regDate = regDate;
    }

    @Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public long getPhone() {
        return phone;
    }

    @Override
    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public void setOrder(Order order) {
        this.order = order;
    }


    @Override
    public int getRegDate() {
        return regDate;
    }

    @Override
    public void setRegDate(int regDate) {
        this.regDate = regDate;
    }

    //Polymorphism Example
    @Override
    public double discount(int value) {
        return (int) (value * (1 - discountRate));
    }
}
