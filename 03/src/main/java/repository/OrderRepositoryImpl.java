package repository;

import entity.Order;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void save(Order order) {
        // 使用JPA、Hibernate等ORM框架来简化聚合的持久化操作
        // 这里的save操作针对整个Order聚合，而不仅仅是单个实体
    }
}
