package com.bootcamp.service;

import com.bootcamp.model.Company;
import com.bootcamp.model.ICustomer;
import com.bootcamp.model.Order;

import java.util.*;

public class CompanyServiceImp implements CompanyService {
    private static CompanyServiceImp companyService;
    private final static List<Company> companies = new ArrayList<>();

    public List<Company> getCompanies() {
        return companies;
    }

    public static CompanyServiceImp getInstance() {
        if (companyService == null) {
            companyService = new CompanyServiceImp();
        }
        return companyService;
    }

    @Override
    public void putCompanyOrderList(Company company, ICustomer customer, Order order) {
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
