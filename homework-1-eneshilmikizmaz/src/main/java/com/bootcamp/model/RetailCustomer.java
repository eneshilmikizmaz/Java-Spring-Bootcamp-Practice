package com.bootcamp.model;
//Inheritance Example

public class RetailCustomer extends Customer {

    public RetailCustomer(int customerId, String fullName, long phone, String email,int regDate) {
        super(customerId, fullName, phone, email, regDate);
        discountRate = 0.15;
    }
    //Polymorphism Example
    @Override
    public double discount(int value) {
        return (int) (value * (1 - discountRate));
    }
}
