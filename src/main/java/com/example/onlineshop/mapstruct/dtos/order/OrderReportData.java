package com.example.onlineshop.mapstruct.dtos.order;

import com.example.onlineshop.repositories.queryinterfaces.OrderGroupReportValues;
import com.example.onlineshop.repositories.queryinterfaces.OrderReportValues;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderReportData {

    @JsonProperty(value = "fullIncome")
    private double fullIncome;

    @JsonProperty(value = "ordersQuantity")
    private int ordersQuantity;

    @JsonProperty("averageOrderCost")
    private double averageOrderCost;

    @JsonProperty("orderGroupReportValues")
    private Iterable<OrderGroupReportValues> orderGroupReportValues;

    @JsonProperty("orderReportValues")
    private Iterable<OrderReportValues> orderReportValues;

    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;

}
