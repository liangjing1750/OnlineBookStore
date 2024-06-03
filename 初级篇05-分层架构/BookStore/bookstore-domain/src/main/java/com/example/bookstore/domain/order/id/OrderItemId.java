package com.example.bookstore.domain.order.id;

import java.io.Serializable;

public class OrderItemId implements Serializable {
    private String orderId;
    private Integer itemId;

    public OrderItemId() {
    }

    public OrderItemId(String orderId, Integer itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
