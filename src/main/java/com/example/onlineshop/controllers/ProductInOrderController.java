package com.example.onlineshop.controllers;

import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderGetDto;
import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderPostDto;
import com.example.onlineshop.mapstruct.mappers.ProductInOrderMapper;
import com.example.onlineshop.services.interfaces.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/order_lines")
public class ProductInOrderController {


    @Autowired
    private ProductInOrderService productInOrderService;

    @Autowired
    private ProductInOrderMapper mapper;


    @PutMapping("/productQuantity")
    public ProductInOrderGetDto updateProductQuantityInOrder(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity) {
        return mapper.productInOrderToProductInOrderGetDto(productInOrderService.updateProductQuantityInOrder(orderId,productId,quantity));
    }

    @DeleteMapping("/{orderId}/{productId}")
    public void deleteProductInOrderById(@PathVariable Long orderId, @PathVariable Long productId) {
        productInOrderService.deleteById(orderId,productId);
    }

    @PostMapping
    public ProductInOrderGetDto saveProductInOrder(@RequestBody ProductInOrderPostDto productInOrderPostDto) {
        return mapper.productInOrderToProductInOrderGetDto(productInOrderService.save(productInOrderPostDto));
    }








}
