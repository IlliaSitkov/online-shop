package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderGetDto;
import com.example.onlineshop.models.ProductInOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductInOrderMapper {

    ProductInOrderGetDto productInOrderToProductInOrderGetDto(ProductInOrder productInOrder);



}
