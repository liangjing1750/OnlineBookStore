package com.example.bookstore.application.test.order;


import com.example.bookstore.application.order.command.OrderCommandService;
import com.example.bookstore.application.order.command.commands.CreateOrderCommand;
import com.example.bookstore.domain.order.entity.Order;
import com.example.bookstore.domain.order.entity.OrderItem;
import com.example.bookstore.domain.order.repository.OrderRepository;
import com.example.bookstore.domain.order.valueobject.BookInfo;
import com.example.bookstore.domain.order.valueobject.Price;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderCommandServiceTest {

    @Test
    public void testCreateOrder() {
        OrderItem sampleOrderItem = new OrderItem("order123", 1, new BookInfo("Effective Java", "Joshua Bloch", "ISBN123"), 1, new Price(BigDecimal.ONE));
        CreateOrderCommand mockCreateOrderCommand = new CreateOrderCommand(Collections.singletonList(sampleOrderItem));
        // mock资源库
        OrderRepository mockRepository = mock(OrderRepository.class);
        OrderCommandService service = new OrderCommandService(mockRepository);
        Order order = service.createOrder(mockCreateOrderCommand);
        // 验证资源库上的save(order)方法是否被调用。
        verify(mockRepository).save(order);
    }
}