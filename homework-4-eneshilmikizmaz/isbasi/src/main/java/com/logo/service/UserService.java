package com.logo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.logo.repository.CustomerRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logo.dto.EmailDto;
import com.logo.model.Address;
import com.logo.model.Customer;
import com.logo.model.User;
import com.logo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;
	@Autowired
	private CustomerRepository customerRepository;

    @Autowired
    private RabbitMQService rabbitMQService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public User createUser(User user) {
		rabbitTemplate.convertAndSend("isbasi.email", new EmailDto("admin@admin.com", "Listener Test" ,"OK"));


		userRepository.save(user);
		customerRepository.saveAll(user.getCustomerList());

		return user;
    }

    public void deleteUserById(int id) {
        User foundUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userRepository.delete(foundUser);
    }


    public User updateUser(User user) {
        User foundUser = userRepository.findById(user.getId()).get();

        foundUser.setEmail(user.getEmail());
        foundUser.setSurname(user.getSurname());
		foundUser.setFirmType(user.getFirmType());
		foundUser.setName(user.getName());
        foundUser.setAddress(user.getAddress());
		foundUser.setCustomerList(user.getCustomerList());
		foundUser.setPassword(user.getPassword());

		return userRepository.save(foundUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
