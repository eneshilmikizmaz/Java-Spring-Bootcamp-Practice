package com.bootcamp.service;

import com.bootcamp.model.Customer;
import com.bootcamp.model.Order;

import java.util.List;

public interface CustomerService {
    void putCustomerOrderList(Customer customer, Order order);

    void prepareCustomerList();

    void addCustomer(Customer customer);

    void getAllCustomers();

    void getCustomersContainsLetterInName(String name);

    List<Customer> getCustomerByRegDate(int startDate, int endDate);


}
