package com.logo.service;

import java.util.List;

import com.logo.model.User;
import com.logo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;


	public Customer createCustomer(Customer customerRequest) {

		return customerRepository.save(customerRequest);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer updateCustomer(Customer customer) {
		Customer foundCustomer = customerRepository.findById(customer.getId()).get();
		foundCustomer.setName(customer.getName());
		foundCustomer.setAge(customer.getAge());
		foundCustomer.setCustomerType(customer.getCustomerType());
		return customerRepository.save(foundCustomer);
	}

	public void deleteCustomerById(int customerId) {
		Customer foundCustomer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
		customerRepository.delete(foundCustomer);
	}
}
