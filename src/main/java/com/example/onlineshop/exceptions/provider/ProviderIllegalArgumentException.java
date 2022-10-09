package com.example.onlineshop.exceptions.provider;

public class ProviderIllegalArgumentException extends RuntimeException{

    public ProviderIllegalArgumentException(String explanation) {
        super(explanation);
    }
}
