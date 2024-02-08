package order.command;

/**
 * 支付订单命令，用于指示支付特定的订单。
 */
public class PayOrderCommand {
    private String orderId; // 订单ID

    public PayOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    // 获取订单ID
    public String getOrderId() {
        return orderId;
    }
}
