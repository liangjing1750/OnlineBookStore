package test;

import order.command.CreateOrderCommand;
import order.entity.Order;
import order.entity.OrderItem;
import order.valueobject.BookInfo;
import order.valueobject.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * 测试Order类中定义的行为，包括添加订单项、支付、发货和完成订单。
 */
public class OrderTest {

    private OrderItem sampleOrderItem;

    @BeforeEach
    public void setUp() {
        sampleOrderItem = new OrderItem("1", "ISBN123", new BookInfo("ISBN123", "Effective Java", "Joshua Bloch"), 1, new Price(BigDecimal.ONE));
    }

    // 用例1: 创建订单
    @Test
    public void testCreateOrder() {
        CreateOrderCommand createOrderCommand = new CreateOrderCommand("order123", Collections.singletonList(sampleOrderItem));
        Order order = new Order();
        order.handle(createOrderCommand);
        Assertions.assertEquals("NEW", order.getStatus(), "订单应在创建后处于新建状态");
    }

    // 可以继续添加测试支付、发货和完成订单的场景
}
