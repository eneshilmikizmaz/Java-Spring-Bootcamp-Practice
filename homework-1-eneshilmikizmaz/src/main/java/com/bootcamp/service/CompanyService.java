package com.bootcamp.service;

import com.bootcamp.model.Company;
import com.bootcamp.model.Customer;
import com.bootcamp.model.Order;

public interface CompanyService {
    void prepareCompanyList();

    void addCompany(Company company);

    void putCompanyOrderList(Company company, Customer customer, Order order);


}
