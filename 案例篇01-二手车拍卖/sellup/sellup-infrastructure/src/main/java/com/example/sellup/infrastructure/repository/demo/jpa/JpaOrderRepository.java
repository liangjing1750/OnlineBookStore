package com.example.sellup.infrastructure.repository.demo.jpa;


import com.example.sellup.domain.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderRepository extends JpaRepository<Order, String> {
    // JPA-specific methods if needed
}
