package com.bootcamp.service;

import com.bootcamp.model.Company;
import com.bootcamp.model.Order;
import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImp implements OrderService {
    private final static List<Order> orders = new ArrayList<>(100);
    CustomerServiceImp customerService = new CustomerServiceImp();
    CompanyServiceImp companyService = new CompanyServiceImp();


    //Gelen orderı; OrderService'in order listesine,CompanyService'in order listesine ve CustomerService'in order listesine ekler.
    @Override
    public void addOrder(Order order) {
        orders.add(order);
        companyService.putCompanyOrderList(order.getCompany(), order.getCustomer(), order);
        customerService.putCustomerOrderList(order.getCustomer(), order);
    }

    @Override
    public void prepareOrderList() {
        addOrder(new Order(1, "Online Kurs", 100, "Haziran", customerService.getCustomers().get(0), companyService.getCompanies().get(0)));
        addOrder(new Order(2, "İş Başı Yazılım kurulum ücreti", 900, "Mart", customerService.getCustomers().get(1), companyService.getCompanies().get(1)));
        addOrder(new Order(3, "Görüntülü görüşme faturası", 800, "Haziran", customerService.getCustomers().get(2), companyService.getCompanies().get(2)));
        addOrder(new Order(4, "Online Kurs", 500, "Haziran", customerService.getCustomers().get(3), companyService.getCompanies().get(0)));
        addOrder(new Order(5, "İş Başı Yazılım kurulum ücreti", 2200, "Haziran", customerService.getCustomers().get(4), companyService.getCompanies().get(1)));
        addOrder(new Order(6, "Görüntülü görüşme faturası", 100, "Mayıs", customerService.getCustomers().get(5), companyService.getCompanies().get(2)));
        addOrder(new Order(7, "Online Kurs", 200, "Nisan", customerService.getCustomers().get(0), companyService.getCompanies().get(0)));
        addOrder(new Order(8, "İş Başı Yazılım kurulum ücreti", 1800, "Haziran", customerService.getCustomers().get(1), companyService.getCompanies().get(1)));
        addOrder(new Order(9, "Görüntülü görüşme faturası", 400, "Ocak", customerService.getCustomers().get(2), companyService.getCompanies().get(2)));
        addOrder(new Order(10, "Online Kurs", 750, "Haziran", customerService.getCustomers().get(3), companyService.getCompanies().get(0)));
        addOrder(new Order(11, "İş Başı Yazılım kurulum ücreti", 2300, "Haziran", customerService.getCustomers().get(4), companyService.getCompanies().get(1)));
    }

    //Belirli tarih aralıklarındaki toplam fatura tutarını hesaplar.
    @Override
    public void getSumOfBillsFilteredByRegDate(int startDate, int endDate) {
        System.out.print("Total of invoices beetween " + startDate + " and " + endDate + " : ");
        System.out.println(customerService.getCustomerByRegDate(startDate, endDate).stream()
                .mapToInt(customer -> customer.getOrderList()
                        .stream()
                        .mapToInt(Order::getTotalAmount)
                        .sum())
                .sum());

    }

    //Bütün faturaları listeler
    @Override
    public void getAllBills() {
        System.out.println("All Orders List\n");
        System.out.println("Order Id | Full Name | Company Name | Total Amount");
        List<String> bills = orders.stream()
                .map(customer -> customer.getOrderId() + " | " + customer.getCustomer().getFullName() + " | " + customer.getCompany().getName() + " | " + customer.getTotalAmount())
                .collect(Collectors.toList());
        bills.forEach(System.out::println);

    }

    //Belirli bir tutar üstündeki faturaları listeler.
    @Override
    public void getBillsOfGreaterThan(int value) {
        System.out.println("Bills Of Greater Than " + value + "\n");
        System.out.println("Full Name | Company Name | Bill Value");
        List<String> bills = orders.stream()
                .filter(billsValue -> billsValue.getTotalAmount() > value)
                .map(order -> order.getCustomer().getFullName() + " | " + order.getCompany().getName() + " | " + order.getTotalAmount())
                .collect(Collectors.toList());
        bills.forEach(System.out::println);
    }

    //Belirli bir tutar üstündeki faturaların ortalamasını hesaplar.
    @Override
    public void calcBillsAvgOfGreaterThan(int value) {
        System.out.print("Average of invoices greater than " + value + " : ");
        double average = orders.stream()
                .filter(billsValue -> billsValue.getTotalAmount() > value)
                .map(order -> order.getTotalAmount()).mapToDouble(Integer::intValue)
                .average().getAsDouble();
        System.out.println(average);

    }

    //Belirli bir tutar altındaki faturaları listeler.
    @Override
    public void getBillsLessThan(int value) {
        System.out.println("Bills Of Less Than " + value + "\n");
        System.out.println("Full Name | Company Name | Bill Value");
        List<String> bills = orders.stream()
                .filter(billsValue -> billsValue.getTotalAmount() < value)
                .map(order -> order.getCustomer().getFullName() + " | " + order.getCompany().getName() + " | " + order.getTotalAmount())
                .collect(Collectors.toList());
        bills.forEach(System.out::println);
    }

    //Aya göre faturalarının ortalaması belirli bir tutar altında kalan firmaların sektörlerini listeler.
    @Override
    public void getSectorsOfLessThanBillsAvg(int value, String month) {

        Set<Company> companiesList = orders.stream()
                .filter(order -> order.getOrderDate().equals(month))
                .map(order -> order.getCompany())
                .collect(Collectors.toSet());

        List<Order> orderList = orders.stream()
                .filter(order -> order.getOrderDate().equals(month))
                .collect(Collectors.toList());

        System.out.println("List of sectors of companies with an average invoice of less than 750 in " + month + "\n");
        System.out.println("Company Name | Sector | Average");
        for (Company company : companiesList) {
            double avg = orderList.stream()
                    .filter(order -> order.getCompany().getName().equals(company.getName()))
                    .mapToDouble(order -> order.getTotalAmount())
                    .average()
                    .getAsDouble();
            if (avg < value) {
                System.out.println(company.getName() + " | " + company.getSector() + " | " + avg);
            }
        }


    }


}



