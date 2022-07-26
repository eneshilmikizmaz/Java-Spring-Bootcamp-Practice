package com.bootcamp.model;

public class Order {
    private int orderId;
    private String description;
    private int totalAmount;
    private String orderDate;
    private ICustomer customer;
    private Company company;

    public Order(int orderId, String description, int totalAmount, String orderDate, ICustomer customer, Company company) {
        this.orderId = orderId;
        this.description = description;
        this.totalAmount = (int) customer.discount(totalAmount);
        this.orderDate = orderDate;
        this.customer = customer;
        this.company = company;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public ICustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ICustomer customer) {
        this.customer = customer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
