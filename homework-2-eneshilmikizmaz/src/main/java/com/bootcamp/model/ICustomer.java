package com.bootcamp.model;


import java.util.ArrayList;
import java.util.List;

public interface ICustomer {

    int getCustomerId();

    void setCustomerId(int customerId);

    String getFullName();

    void setFullName(String fullName);

    long getPhone();

    void setPhone(long phone);

    String getEmail();


    void setEmail(String email);

    List<Order> getOrderList();

    void setOrderList(List<Order> orderList);

    Order getOrder();

    void setOrder(Order order);

    int getRegDate();

    void setRegDate(int regDate);

    double discount(int value);


}
