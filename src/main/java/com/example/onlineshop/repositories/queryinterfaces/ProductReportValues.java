package com.example.onlineshop.repositories.queryinterfaces;

public interface ProductReportValues {

    Long getArticul();
    String getName();
    int getSoldQuantity();
    double getSoldCost();
    int getAverageQuantityInOrder();
    int getQuantityOfCustomers();
}
