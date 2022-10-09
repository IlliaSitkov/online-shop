package com.example.reportgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Getter
@ToString
public class OrderReportData {

    @JsonProperty(value = "fullIncome")
    private double fullIncome;

    @JsonProperty(value = "ordersQuantity")
    private int ordersQuantity;

    @JsonProperty("averageOrderCost")
    private double averageOrderCost;

    @JsonProperty("averageOrderCost")
    private Collection<OrderGroupReportValues> orderGroupReportValues;

    @JsonProperty("orderReportValues")
    private Collection<OrderReportValues> orderReportValues;

    @JsonProperty("dateStart")
    private Date dateStart;

    @JsonProperty("dateEnd")
    private Date dateEnd;

}
