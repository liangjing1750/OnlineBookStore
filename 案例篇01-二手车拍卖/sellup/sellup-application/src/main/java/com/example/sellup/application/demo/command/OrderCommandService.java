package com.example.sellup.application.demo.command;

import com.example.sellup.application.demo.command.commands.CreateOrderCommand;
import com.example.sellup.domain.demo.entity.Order;
import com.example.sellup.domain.demo.repository.OrderRepository;
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