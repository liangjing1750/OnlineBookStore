package com.example.sellup.interfaces.demo.maper;

import com.example.sellup.application.demo.command.commands.CreateOrderCommand;
import com.example.sellup.application.demo.query.dtos.OrderDTO;
import com.example.sellup.domain.demo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderControllerMapper {

    OrderControllerMapper INSTANCE = Mappers.getMapper(OrderControllerMapper.class);

    CreateOrderCommand toCreateOrderCommand(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order createdOrder);
}

