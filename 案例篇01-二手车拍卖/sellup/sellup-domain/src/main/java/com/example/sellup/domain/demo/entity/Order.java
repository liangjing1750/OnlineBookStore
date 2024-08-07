package com.example.sellup.domain.demo.entity;

import com.example.sellup.domain.demo.event.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单聚合根，负责处理订单相关的命令，并在状态变化时生成相应的事件。
 */
@Entity
@Table(name = "ORDER_TABLE") // 更改表名以避免使用保留关键字
public class Order implements Serializable {
    @Id
    private String orderId; // 订单ID
    private String status; // 订单当前状态

    @OneToMany(mappedBy = "demo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>(); // 订单项
    @Transient
    private List<OrderEvent> events = new ArrayList<>(); // 存储生成的事件

    public Order() {
        // 初始化时，订单聚合根可能不立即关联任何订单，直到处理创建订单的命令
    }

    // 创建订单
    public void createOrder(String orderId, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.items.addAll(orderItems);
        this.items.forEach(s -> s.setOrderId(orderId));
        this.status = "NEW";
        events.add(new OrderCreatedEvent(this.orderId, this.items));
    }

    // 支付订单
    public void pay() {
        if (this.status.equals("NEW")) {
            this.status = "PAID";
        } else {
            throw new IllegalStateException("只有新建状态的订单才能支付");
        }
        events.add(new OrderPaidEvent(this.orderId));
    }

    // 发货订单
    public void ship() {
        if (this.status.equals("PAID")) {
            this.status = "SHIPPED";
        } else {
            throw new IllegalStateException("只有已支付状态的订单才能发货");
        }
        events.add(new OrderShippedEvent(this.orderId));
    }

    // 完成订单
    public void complete() {
        if (this.status.equals("SHIPPED")) {
            this.status = "COMPLETED";
        } else {
            throw new IllegalStateException("只有已发货状态的订单才能标记为已完成");
        }
        events.add(new OrderCompletedEvent(this.orderId));
    }

    // 获取订单ID
    public String getOrderId() {
        return orderId;
    }

    // 获取订单当前状态
    public String getStatus() {
        return status;
    }

    // 获取订单项
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * @return 订单的总金额
     */
    public BigDecimal calculateTotalAmount() {
        return this.getItems().stream().map(OrderItem::calculateAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
