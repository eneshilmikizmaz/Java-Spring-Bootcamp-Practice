package com.bootcamp;

import com.bootcamp.model.Order;
import com.bootcamp.service.CompanyServiceImp;
import com.bootcamp.service.CustomerServiceImp;
import com.bootcamp.model.RetailCustomer;
import com.bootcamp.service.OrderServiceImp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        CustomerServiceImp customerService = new CustomerServiceImp();
        CompanyServiceImp companyService = new CompanyServiceImp();
        OrderServiceImp orderService = new OrderServiceImp();

        customerService.prepareCustomerList();
        companyService.prepareCompanyList();
        orderService.prepareOrderList();

        customerService.addCustomer(new RetailCustomer(7, "Cem Dirman", 12345, "cemdirman@bootcamp", 20220615));
        customerService.getAllCustomers();
        System.out.println("---------------");
        customerService.getCustomersContainsLetterInName("c");
        System.out.println("---------------");
        orderService.getSumOfBillsFilteredByRegDate(20220601, 20220630);
        System.out.println("---------------");
        orderService.getAllBills();
        System.out.println("---------------");
        orderService.getBillsOfGreaterThan(1500);
        System.out.println("---------------");
        orderService.calcBillsAvgOfGreaterThan(1500);
        System.out.println("---------------");
        orderService.getBillsLessThan(500);
        System.out.println("---------------");
        orderService.getSectorsOfLessThanBillsAvg(750, "Haziran");


    }
}
