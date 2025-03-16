package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderManager {
    private final Map<Integer, Order> orderCache = new HashMap<>();
    private int currentId = 1;

    public Order createOrder(String description) {
        Order order = new Order(currentId, description);
        orderCache.put(currentId, order);
        currentId++;
        return order;
    }

    public Order getOrderById(int id) {
        return orderCache.get(id);
    }

    public Map<Integer, Order> getAllOrders() {
        return orderCache;
    }
}
