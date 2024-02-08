package order.entity;

import order.command.CompleteOrderCommand;
import order.command.CreateOrderCommand;
import order.command.PayOrderCommand;
import order.command.ShipOrderCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单聚合根，负责处理订单相关的命令，并在状态变化时生成相应的事件。
 */
public class Order {
    private String orderId; // 订单ID
    private String status; // 订单当前状态
    private List<OrderItem> items = new ArrayList<>(); // 订单项

    public Order() {
        // 初始化时，订单聚合根可能不立即关联任何订单，直到处理创建订单的命令
    }

    // 处理创建订单的命令
    public void handle(CreateOrderCommand command) {
        this.orderId = command.getOrderId();
        this.status = "NEW";
        this.items.addAll(command.getItems());
    }

    // 处理支付订单的命令
    public void handle(PayOrderCommand command) {
        if (this.status.equals("NEW")) {
            this.status = "PAID";
        } else {
            throw new IllegalStateException("只有新建状态的订单才能支付");
        }
    }

    // 处理发货订单的命令
    public void handle(ShipOrderCommand command) {
        if (this.status.equals("PAID")) {
            this.status = "SHIPPED";
        } else {
            throw new IllegalStateException("只有已支付状态的订单才能发货");
        }
    }

    // 处理完成订单的命令
    public void handle(CompleteOrderCommand command) {
        if (this.status.equals("SHIPPED")) {
            this.status = "COMPLETED";
        } else {
            throw new IllegalStateException("只有已发货状态的订单才能标记为已完成");
        }
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

}
