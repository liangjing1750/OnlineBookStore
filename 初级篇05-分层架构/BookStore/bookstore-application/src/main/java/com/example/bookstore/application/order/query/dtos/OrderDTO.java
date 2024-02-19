package com.example.bookstore.application.order.query.dtos;

import com.example.bookstore.domain.order.entity.OrderItem;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class OrderDTO {
    @ApiModelProperty(notes = "List of order items")
    private List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
