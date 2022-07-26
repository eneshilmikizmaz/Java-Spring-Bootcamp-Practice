package com.logo.controller;

import com.logo.model.Customer;
import com.logo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customerRequest) {
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @PutMapping
    public Customer updateCustomer(Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteCustomer(@PathParam("customerId") int customerId) {
        customerService.deleteCustomerById(customerId);
    }


}
