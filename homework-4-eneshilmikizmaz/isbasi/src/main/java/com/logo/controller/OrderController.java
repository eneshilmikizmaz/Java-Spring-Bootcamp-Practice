package com.logo.controller;

import com.logo.model.Customer;
import com.logo.model.Order;
import com.logo.model.User;
import com.logo.service.CustomerService;
import com.logo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping
    public Order createOrder(@RequestBody Order orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getAllOrder() {
        return orderService.getAllOrders();
    }

    @PutMapping
    public Order updateOrder(Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteCustomer(@PathParam("orderId") int customerId) {
        orderService.deleteOrderById(customerId);
    }


}
