package com.bootcamp.service;

import com.bootcamp.model.Company;
import com.bootcamp.model.Customer;
import com.bootcamp.model.Order;

import java.util.*;

public class CompanyServiceImp implements CompanyService {

    private final static List<Company> companies = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    @Override
    public void putCompanyOrderList(Company company, Customer customer, Order order) {
        company.getCompanyOrderList().put(customer, order);
    }

    @Override
    public void addCompany(Company company) {
        companies.add(company);
    }

    @Override
    public void prepareCompanyList() {
        addCompany(new Company(1, "Patika.dev", "Eğitim"));
        addCompany(new Company(2, "Logo Yazılım", "Bilişim"));
        addCompany(new Company(3, "Google Meet", "Teknoloji"));
    }


}
