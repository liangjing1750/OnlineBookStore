package test;

import entity.Order;
import entity.OrderItem;
import org.junit.jupiter.api.Test;
import valueobject.BookInfo;
import valueobject.Price;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试Order类中定义的行为，包括添加订单项、支付、发货和完成订单。
 */
public class OrderTest {

    @Test
    public void testOrderLifecycle() {
        Order order = new Order("orderId123");
        OrderItem item = new OrderItem("orderId123",  "ISBN123", new BookInfo("ISBN123","Effective Java", "author"), 1, new Price(BigDecimal.TEN));

        // 测试添加订单项
        order.addItem(item);
        assertEquals(1, order.getItems().size(), "订单应包含1个订单项");

        // 测试支付订单
        order.pay();
        assertEquals("PAID", order.getStatus(), "订单状态应为已支付");

        // 测试发货
        order.ship();
        assertEquals("SHIPPED", order.getStatus(), "订单状态应为已发货");

        // 测试完成订单
        order.complete();
        assertEquals("COMPLETED", order.getStatus(), "订单状态应为已完成");
    }

    @Test
    public void testInvalidPayment() {
        Order order = new Order("orderId123");
        order.pay(); // 支付订单
        assertThrows(IllegalStateException.class, order::pay, "重复支付应抛出异常");
    }

    // 可以继续添加测试支付、发货和完成订单的其他无效场景
}
