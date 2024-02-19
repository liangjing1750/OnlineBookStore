package com.example.bookstore.interfaces.order;


import com.example.bookstore.application.order.command.OrderCommandService;
import com.example.bookstore.application.order.command.commands.CreateOrderCommand;
import com.example.bookstore.application.order.query.OrderQueryService;
import com.example.bookstore.application.order.query.dtos.OrderDTO;
import com.example.bookstore.domain.order.entity.Order;
import com.example.bookstore.interfaces.order.maper.OrderControllerMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    @Autowired
    public OrderController(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    @PostMapping
    @ApiOperation("创建订单")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        CreateOrderCommand createOrderCommand = OrderControllerMapper.INSTANCE.toCreateOrderCommand(orderDTO);
        Order createdOrder = orderCommandService.createOrder(createOrderCommand);
        OrderDTO dto = OrderControllerMapper.INSTANCE.toOrderDTO(createdOrder);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    @ApiOperation("查询订单")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long orderId) {
        OrderDTO order = orderQueryService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }
}
