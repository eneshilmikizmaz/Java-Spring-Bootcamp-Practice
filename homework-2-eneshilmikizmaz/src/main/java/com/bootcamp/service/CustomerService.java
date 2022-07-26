package com.bootcamp.service;

import com.bootcamp.model.ICustomer;
import com.bootcamp.model.Order;

import java.util.List;

public interface CustomerService {
    void putCustomerOrderList(ICustomer customer, Order order);

    void prepareCustomerList();

    void addCustomer(ICustomer customer);

    void getAllCustomers();

    void getCustomersContainsLetterInName(String name);

    List<ICustomer> getCustomerByRegDate(int startDate, int endDate);


}
