package com.example.sellup.infrastructure.repository.demo;

import com.example.sellup.domain.demo.entity.Order;
import com.example.sellup.domain.demo.repository.OrderRepository;
import com.example.sellup.infrastructure.repository.demo.jpa.JpaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    @Autowired
    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        return jpaOrderRepository.save(order);
    }

    // Implement other methods defined in the OrderRepository interface
}
