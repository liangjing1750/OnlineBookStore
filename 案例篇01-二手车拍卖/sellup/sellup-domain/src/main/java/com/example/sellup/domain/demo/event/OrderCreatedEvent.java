package com.example.sellup.domain.demo.event;


import com.example.sellup.domain.demo.entity.OrderItem;

import java.util.List;

public class OrderCreatedEvent implements OrderEvent{
    private final String orderId;
    private final List<OrderItem> items;

    public OrderCreatedEvent(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}