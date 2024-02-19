package com.example.bookstore.infrastructure.repository.order.jpa;


import com.example.bookstore.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, String> {
    // JPA-specific methods if needed
}
