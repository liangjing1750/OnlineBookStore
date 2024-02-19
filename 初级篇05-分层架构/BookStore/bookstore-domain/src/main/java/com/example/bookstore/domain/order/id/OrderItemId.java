package com.example.bookstore.domain.order.id;

import java.io.Serializable;

public class OrderItemId implements Serializable {
    private String orderId;
    private String isbn;

    public OrderItemId() {
    }

    public OrderItemId(String orderId, String isbn) {
        this.orderId = orderId;
        this.isbn = isbn;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
