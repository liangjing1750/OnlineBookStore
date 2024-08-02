package com.example.sellup.application.test.demo;


import com.example.sellup.application.demo.command.OrderCommandService;
import com.example.sellup.application.demo.command.commands.CreateOrderCommand;
import com.example.sellup.domain.demo.entity.Order;
import com.example.sellup.domain.demo.entity.OrderItem;
import com.example.sellup.domain.demo.repository.OrderRepository;
import com.example.sellup.domain.demo.valueobject.BookInfo;
import com.example.sellup.domain.demo.valueobject.Price;
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
        // 验证资源库上的save(demo)方法是否被调用。
        verify(mockRepository).save(order);
    }
}