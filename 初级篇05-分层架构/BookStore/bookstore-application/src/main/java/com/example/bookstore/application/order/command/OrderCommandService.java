package com.example.bookstore.application.order.command;

import com.example.bookstore.application.order.command.commands.CreateOrderCommand;
import com.example.bookstore.domain.order.entity.Order;
import com.example.bookstore.domain.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderCommandService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderCommandService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderCommand command) {
        Order order = new Order();
        order.createOrder(UUID.randomUUID().toString(), command.getItems());
        orderRepository.save(order);
        return order;
    }

}