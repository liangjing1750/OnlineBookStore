package com.example.sellup.domain.demo.event;

public class OrderPaidEvent implements OrderEvent {
    private final String orderId;

    public OrderPaidEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}