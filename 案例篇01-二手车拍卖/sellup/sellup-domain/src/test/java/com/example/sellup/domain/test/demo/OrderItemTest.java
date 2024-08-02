package com.example.sellup.domain.test.demo;


import com.example.sellup.domain.demo.entity.OrderItem;
import com.example.sellup.domain.demo.valueobject.BookInfo;
import com.example.sellup.domain.demo.valueobject.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemTest {

    @Test
    public void testOrderItemCreation() {
        // 创建BookInfo值对象
        BookInfo bookInfo = new BookInfo("Effective Java", "Joshua Bloch", "123");
        // 创建Price值对象
        Price price = new Price(new BigDecimal("29.99"));

        // 创建OrderItem实体
        OrderItem orderItem = new OrderItem("orderId123", 1, bookInfo, 1, price);

        // 验证OrderItem的属性
        assertEquals("orderId123", orderItem.getOrderId());
        assertEquals(1, orderItem.getItemId());
        assertEquals(1, orderItem.getQuantity());
        assertEquals(new BigDecimal("29.99"), orderItem.getPrice().getAmount());

        // 验证BookInfo的属性
        assertEquals("Effective Java", orderItem.getBookInfo().getTitle());
        assertEquals("Joshua Bloch", orderItem.getBookInfo().getAuthor());
    }

}
