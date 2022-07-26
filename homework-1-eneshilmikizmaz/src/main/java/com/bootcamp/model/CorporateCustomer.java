package com.bootcamp.model;
//Inheritance Example
public class CorporateCustomer extends Customer {
    public CorporateCustomer(int customerId, String fullName, long phone, String email,int regDate) {
        super(customerId, fullName, phone, email, regDate);
        discountRate = 0.30;
    }
    //Polymorphism Example
    @Override
    public double discount(int value) {
        return (int) (value * (1 - discountRate));
    }
}
