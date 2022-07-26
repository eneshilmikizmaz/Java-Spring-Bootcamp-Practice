package com.bootcamp.model;

import com.bootcamp.model.enums.CustomerType;

public class CustomerFactory {
    //Factory Design Pattern Example
    public static ICustomer createCustomer(CustomerType customerType, int customerId, String fullName, long phone, String email, int regDate) {

        ICustomer customer;

        if (customerType == CustomerType.RETAIL) {
            customer = new RetailCustomer(customerId, fullName, phone, email, regDate);
        } else if (customerType == CustomerType.CORPORATE) {
            customer = new CorporateCustomer(customerId, fullName, phone, email, regDate);
        } else {
            throw new RuntimeException(customerType + " is invalid customer type !");
        }

        return customer;
    }
}
