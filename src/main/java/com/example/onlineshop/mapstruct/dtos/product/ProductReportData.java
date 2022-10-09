package com.example.onlineshop.mapstruct.dtos.product;

import com.example.onlineshop.repositories.queryinterfaces.ProductReportValues;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductReportData {

    @JsonProperty("productReportValues")
    private Iterable<ProductReportValues> productReportValues;

    @JsonProperty("soldProductsQuantity")
    private int soldProductsQuantity;

    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;
}
