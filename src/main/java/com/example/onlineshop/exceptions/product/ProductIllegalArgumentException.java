package com.example.onlineshop.exceptions.product;

public class ProductIllegalArgumentException extends RuntimeException{

    public ProductIllegalArgumentException(String explanation) {
        super(explanation);
    }
}
