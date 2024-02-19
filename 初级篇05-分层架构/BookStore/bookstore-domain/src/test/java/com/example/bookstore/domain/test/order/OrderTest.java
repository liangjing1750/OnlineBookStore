package com.example.bookstore.domain.test.order;


import com.example.bookstore.domain.order.entity.Order;
import com.example.bookstore.domain.order.entity.OrderItem;
import com.example.bookstore.domain.order.valueobject.BookInfo;
import com.example.bookstore.domain.order.valueobject.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * 测试Order类中定义的行为，包括添加订单项、支付、发货和完成订单。
 */
public class OrderTest {

    @Test
    public void testOrderLifecycle() {
        Order order = creatOrder();
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
        Order order = creatOrder();
        order.pay(); // 支付订单
        assertThrows(IllegalStateException.class, order::pay, "重复支付应抛出异常");
    }

    private Order creatOrder() {
        Order order = new Order();
        OrderItem item = new OrderItem("orderId123", "ISBN123", new BookInfo("Effective Java", "author"), 1, new Price(BigDecimal.TEN));
        order.createOrder("orderId123", Collections.singletonList(item));
        return order;
    }

    // 可以继续添加测试支付、发货和完成订单的其他无效场景
}