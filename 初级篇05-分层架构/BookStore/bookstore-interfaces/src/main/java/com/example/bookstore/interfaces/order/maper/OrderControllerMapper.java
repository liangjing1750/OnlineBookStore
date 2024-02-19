package com.example.bookstore.interfaces.order.maper;

import com.example.bookstore.application.order.command.commands.CreateOrderCommand;
import com.example.bookstore.application.order.query.dtos.OrderDTO;
import com.example.bookstore.domain.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderControllerMapper {

    OrderControllerMapper INSTANCE = Mappers.getMapper(OrderControllerMapper.class);

    CreateOrderCommand toCreateOrderCommand(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order createdOrder);
}

