package com.example.bookstore.infrastructure.repository.order;

import com.example.bookstore.domain.order.entity.Order;
import com.example.bookstore.domain.order.repository.OrderRepository;
import com.example.bookstore.infrastructure.repository.order.jpa.JpaOrderRepository;
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
