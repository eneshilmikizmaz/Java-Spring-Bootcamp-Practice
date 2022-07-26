package com.bootcamp.service;

import com.bootcamp.model.CorporateCustomer;
import com.bootcamp.model.Customer;
import com.bootcamp.model.Order;
import com.bootcamp.model.RetailCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImp implements CustomerService {
    private final static List<Customer> customers = new ArrayList<>();


    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void putCustomerOrderList(Customer customer, Order order) {
        customer.getOrderList().add(order);
    }

    @Override
    public void prepareCustomerList() {
        addCustomer(new RetailCustomer(1, "Enes Kızmaz", 1234, "eneshk@bootcamp", 20220615));
        addCustomer(new RetailCustomer(2, "Onur Özbay", 1234, "onur@bootcamp", 20220613));
        addCustomer(new RetailCustomer(3, "Ufuk Dikkülah", 1234, "ufuk@bootcamp", 20220622));
        addCustomer(new CorporateCustomer(4, "Ümit Taş", 1234, "ümit@bootcamp", 20220311));
        addCustomer(new CorporateCustomer(5, "Cem Dirman", 1234, "cem@bootcamp", 20220606));
        addCustomer(new CorporateCustomer(6, "Ceylan Akyürek", 1234, "ceylan@bootcamp", 20220112));
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void getAllCustomers() {
        System.out.println("Customer List\n");
        List<String> customerNames = customers.stream()
                .map(customer -> customer.getFullName() + " | " + customer.getClass().getSimpleName())
                .collect(Collectors.toList());
        customerNames.forEach(System.out::println);
    }
    //İsminde belirtilen harf bulunan müşterilerin isimlerini listeler.
    @Override
    public void getCustomersContainsLetterInName(String letter) {
        System.out.println("List of customers with " + letter + " in their name \n");
        List<String> customerNames = customers.stream()
                .map(customer -> customer.getFullName().toLowerCase())
                .filter(customerName -> customerName.contains("c"))
                .collect(Collectors.toList());
        customerNames.forEach(System.out::println);
    }
    //Müşterilerin kayıt tarihine göre filtreleyip listeler.
    @Override
    public List<Customer> getCustomerByRegDate(int startDate, int endDate) {
        return customers.stream()
                .filter(customer -> customer.getRegDate() >= startDate)
                .filter(customer -> customer.getRegDate() <= endDate)
                .collect(Collectors.toList());
    }


}
