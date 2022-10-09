package com.example.onlineshop.exceptions.category;

public class NoCategoryWithSuchId extends RuntimeException {

    public NoCategoryWithSuchId(Long id) {
        super("Category with id '"+ id +"' has not been found!");
    }
}
