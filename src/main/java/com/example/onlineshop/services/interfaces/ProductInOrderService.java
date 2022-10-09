package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderPostDto;
import com.example.onlineshop.models.ProductInOrder;

public interface ProductInOrderService {

    ProductInOrder updateProductQuantityInOrder(Long orderId, Long productId, int quantity);

    void deleteById(Long orderId, Long productId);

    ProductInOrder save(ProductInOrderPostDto productInOrderPostDto);
}
