package com.example.bookstore.application.order.command.commands;

/**
 * 发货订单命令，用于指示对特定订单进行发货操作。
 */
public class ShipOrderCommand {
    private String orderId; // 订单ID

    public ShipOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    // 获取订单ID
    public String getOrderId() {
        return orderId;
    }
}
