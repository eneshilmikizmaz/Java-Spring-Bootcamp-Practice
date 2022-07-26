package com.bootcamp;

import com.bootcamp.model.CustomerFactory;
import com.bootcamp.model.enums.CustomerType;
import com.bootcamp.service.CompanyServiceImp;
import com.bootcamp.service.CustomerServiceImp;
import com.bootcamp.service.OrderServiceImp;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //Singleton Example
        CustomerServiceImp customerService = CustomerServiceImp.getInstance();
        CompanyServiceImp companyService = CompanyServiceImp.getInstance();
        OrderServiceImp orderService = OrderServiceImp.getInstance();

        customerService.prepareCustomerList();
        companyService.prepareCompanyList();
        orderService.prepareOrderList();
        //Factory DP Example
        customerService.addCustomer(CustomerFactory.createCustomer(CustomerType.RETAIL, 7, "Cem Dirman", 12345, "cemdirman@bootcamp", 20220615));
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
