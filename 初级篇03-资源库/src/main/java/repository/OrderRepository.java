package repository;

import entity.Order;

public interface OrderRepository {
    void save(Order order); // 保存整个Order聚合
    // 可以定义其他针对Order聚合的操作，如findByCustomerId等
}
