package com.bootcamp.service;

import com.bootcamp.model.Order;

public interface OrderService {
    void addOrder(Order order);

    void prepareOrderList();

    void getSumOfBillsFilteredByRegDate(int startDate, int endDate);

    void getAllBills();

    void getBillsOfGreaterThan(int value);

    void calcBillsAvgOfGreaterThan(int value);

    void getBillsLessThan(int value);

    void getSectorsOfLessThanBillsAvg(int value, String month);

}
