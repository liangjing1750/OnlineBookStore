package com.example.sellup.domain.demo.service;

import com.example.sellup.domain.demo.entity.Order;

import java.math.BigDecimal;
import java.util.List;

public class OrderValidationService {
    public boolean validateOrdersForBulkProcessing(List<Order> orders) {
        return orders.stream().allMatch(this::isValidForProcessing);
    }

    private boolean isValidForProcessing(Order order) {
        BigDecimal minimumOrderAmount = new BigDecimal("50.00");
        return order.calculateTotalAmount().compareTo(minimumOrderAmount) >= 0;
    }
}
