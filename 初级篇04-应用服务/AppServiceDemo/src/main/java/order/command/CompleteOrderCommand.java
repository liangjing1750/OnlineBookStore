package order.command;

/**
 * 完成订单命令，用于指示将特定订单标记为已完成状态。
 */
public class CompleteOrderCommand {
    private String orderId; // 订单ID

    public CompleteOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    // 获取订单ID
    public String getOrderId() {
        return orderId;
    }
}
