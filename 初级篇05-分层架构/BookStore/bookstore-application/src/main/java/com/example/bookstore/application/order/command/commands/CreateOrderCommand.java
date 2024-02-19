package com.example.bookstore.application.order.command.commands;

import com.example.bookstore.domain.order.entity.OrderItem;

import java.util.List;

/**
 * 创建订单命令，用于指示创建一个新的订单。
 */
public class CreateOrderCommand {
    /**
     * 订单中的商品项列表
     */
    private final List<OrderItem> items;

    public CreateOrderCommand(List<OrderItem> items) {
        this.items = items;
    }

    // 获取订单中的商品项列表
    public List<OrderItem> getItems() {
        return items;
    }
}
