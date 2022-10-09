package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.product.ProductGetDto;
import com.example.onlineshop.mapstruct.dtos.product.ProductPostDto;
import com.example.onlineshop.mapstruct.dtos.product.ProductPutDto;
import com.example.onlineshop.mapstruct.dtos.product.ProductSlimGetDto;
import com.example.onlineshop.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductGetDto productToProductGetDto(Product product);

    Iterable<ProductGetDto> productsToProductsGetDto(Iterable<Product> products);

    Product productPutDtoToProduct(ProductPutDto productPutDto);

    Product productPostDtoToProduct(ProductPostDto productPostDto);

    ProductSlimGetDto productToProductSlimGetDto(Product product);
    Iterable<ProductSlimGetDto> productsToProductsSlimGetDto(Iterable<Product> products);
}
