package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Order类代表一个订单，包含多个订单项（OrderItem）。
 * 它提供了添加订单项、支付、发货和完成订单的行为。
 */
public class Order {
    private String orderId;
    private List<OrderItem> items = new ArrayList<>();
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "NEW"; // 初始状态为新建
    }

    /**
     * 向订单添加一个新的订单项。
     * @param item 要添加的订单项
     */
    public void addItem(OrderItem item) {
        items.add(item);
    }

    /**
     * 支付订单，将订单状态更新为已支付。
     */
    public void pay() {
        if (!"NEW".equals(this.status)) {
            throw new IllegalStateException("只有新建状态的订单可以支付");
        }
        this.status = "PAID";
    }

    /**
     * 发货，将订单状态更新为已发货。
     */
    public void ship() {
        if (!"PAID".equals(this.status)) {
            throw new IllegalStateException("只有已支付的订单可以发货");
        }
        this.status = "SHIPPED";
    }

    /**
     * 完成订单，将订单状态更新为已完成。
     */
    public void complete() {
        if (!"SHIPPED".equals(this.status)) {
            throw new IllegalStateException("只有已发货的订单可以标记为已完成");
        }
        this.status = "COMPLETED";
    }

    // Getter 方法
    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }
}
