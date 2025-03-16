package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderManager orderManager;

    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @GetMapping
    public Collection<Order> getAllOrders() {
        return orderManager.getAllOrders().values();
    }

    @PostMapping
    public Order createOrder(@RequestBody String description) {
        return orderManager.createOrder(description);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderManager.getOrderById(id);
    }

    @GetMapping("/order-service-endpoint")
    public String getOrderData() {
        return "Order Data from OrderService";
    }
}
