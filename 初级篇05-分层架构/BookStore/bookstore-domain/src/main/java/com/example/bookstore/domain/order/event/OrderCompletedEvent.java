package com.example.bookstore.domain.order.event;

public class OrderCompletedEvent implements OrderEvent{
    private final String orderId;

    public OrderCompletedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}