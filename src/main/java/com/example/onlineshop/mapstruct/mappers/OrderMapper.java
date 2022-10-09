package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.order.OrderBasketGetDto;
import com.example.onlineshop.mapstruct.dtos.order.OrderGetDto;
import com.example.onlineshop.mapstruct.dtos.order.OrderSlimGetDto;
import com.example.onlineshop.models.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderSlimGetDto orderToOrderSlimGetDto(Order order);

    Iterable<OrderSlimGetDto> ordersToOrdersSlimGetDto(Iterable<Order> orders);

    OrderGetDto orderToOrderGetDto(Order order);

    Iterable<OrderGetDto> ordersToOrdersGetDto(Iterable<Order> orders);

    OrderBasketGetDto orderToOrderBasketGetDto(Order order);



}
