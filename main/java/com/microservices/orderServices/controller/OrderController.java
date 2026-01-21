package com.microservices.orderServices.controller;

import com.microservices.orderServices.common.TransactionRequest;
import com.microservices.orderServices.common.TransactionResponse;
import com.microservices.orderServices.entity.Order;
import com.microservices.orderServices.service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return orderServices.saveOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderServices.getAllOrders();
    }
}
