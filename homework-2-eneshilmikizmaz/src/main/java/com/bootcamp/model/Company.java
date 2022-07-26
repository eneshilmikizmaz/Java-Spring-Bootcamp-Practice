package com.bootcamp.model;

import java.util.HashMap;
import java.util.Map;

public class Company {
    private int companyId;
    private String name;
    private String sector;
    private Order order;
    private Map<ICustomer, Order> companyOrderList = new HashMap<>();

    public Company(int companyId, String name, String sector) {
        this.companyId = companyId;
        this.name = name;
        this.sector = sector;
    }


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Map<ICustomer, Order> getCompanyOrderList() {
        return companyOrderList;
    }

    public void setCompanyOrderList(Map<ICustomer, Order> companyOrderList) {
        this.companyOrderList = companyOrderList;
    }


}
