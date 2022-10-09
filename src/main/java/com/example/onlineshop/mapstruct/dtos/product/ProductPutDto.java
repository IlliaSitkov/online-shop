package com.example.onlineshop.mapstruct.dtos.product;

import com.example.onlineshop.mapstruct.dtos.category.CategoryGetDto;
import com.example.onlineshop.mapstruct.dtos.provider.ProviderGetDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductPutDto {

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("description")
    @NotNull
    private String description;

    @JsonProperty("quantity")
    @NotNull
    private int quantity;

    @JsonProperty("price")
    @NotNull
    private double price;

    @JsonProperty("provider")
    private ProviderGetDto provider;

    @JsonProperty("category")
    private CategoryGetDto category;
}
