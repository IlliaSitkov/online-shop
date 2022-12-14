package com.example.onlineshop.mapstruct.dtos.order;

import com.example.onlineshop.mapstruct.dtos.customer.CustomerGetDto;
import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderGetDto;
import com.example.onlineshop.mapstruct.dtos.salesman.SalesmanGetDto;
import com.example.onlineshop.models.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Setter
public class OrderGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("salesman")
    @Nullable
    private SalesmanGetDto salesman;

    @JsonProperty("customer")
    @NotNull
    private CustomerGetDto customer;

    @JsonProperty("order_lines")
    @NotNull
    private Set<ProductInOrderGetDto> products;

    @JsonProperty("date")
    @NotNull
    private Date date;

    @JsonProperty("status")
    @NotNull
    private OrderStatus status;

    @JsonProperty("order_cost")
    @NotNull
    private double cost;

    public void setProducts(Set<ProductInOrderGetDto> products) {
        this.products = products;
        this.products.forEach(p -> this.cost += p.getCost());
    }
}
