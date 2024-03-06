package com.example.bookstore.domain.order.event;

public class OrderShippedEvent implements OrderEvent {
    private final String orderId;

    public OrderShippedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}