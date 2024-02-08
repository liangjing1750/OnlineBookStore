package order.command;

import order.entity.OrderItem;

import java.util.List;

/**
 * 创建订单命令，用于指示创建一个新的订单。
 */
public class CreateOrderCommand {
    /**
     * 订单ID
     */
    private final String orderId;
    /**
     * 订单中的商品项列表
     */
    private final List<OrderItem> items;

    public CreateOrderCommand(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
    }

    // 获取订单ID
    public String getOrderId() {
        return orderId;
    }

    // 获取订单中的商品项列表
    public List<OrderItem> getItems() {
        return items;
    }
}
