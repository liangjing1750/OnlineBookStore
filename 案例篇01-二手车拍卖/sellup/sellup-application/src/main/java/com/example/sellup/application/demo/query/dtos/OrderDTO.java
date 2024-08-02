package com.example.sellup.application.demo.query.dtos;

import com.example.sellup.domain.demo.entity.OrderItem;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class OrderDTO {
    @ApiModelProperty(notes = "List of demo items")
    private List<OrderItem> items;

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
