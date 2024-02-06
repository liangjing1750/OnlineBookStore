package appservice.command;

import command.CreateOrderCommand;
import entity.Order;
import repository.OrderRepository;

public class OrderCommandService {
    private final OrderRepository orderRepository;

    public OrderCommandService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderCommand command) {
        Order order = new Order();
        order.handle(command);
        orderRepository.save(order);
        return order;
    }
}