package test;

import order.appservice.command.OrderCommandService;
import order.command.CreateOrderCommand;
import order.entity.Order;
import order.entity.OrderItem;
import org.junit.jupiter.api.Test;
import order.repository.OrderRepository;
import order.valueobject.BookInfo;
import order.valueobject.Price;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderCommandServiceTest {

    @Test
    public void testCreateOrder() {
        OrderItem sampleOrderItem = new OrderItem("order123", "ISBN123", new BookInfo("ISBN123", "Effective Java", "Joshua Bloch"), 1, new Price(BigDecimal.ONE));
        CreateOrderCommand mockCreateOrderCommand = new CreateOrderCommand("order123", Collections.singletonList(sampleOrderItem));
        // mock资源库
        OrderRepository mockRepository = mock(OrderRepository.class);
        OrderCommandService service = new OrderCommandService(mockRepository);
        Order order = service.createOrder(mockCreateOrderCommand);
        // 验证资源库上的save(order)方法是否被调用。
        verify(mockRepository).save(order);
    }
}