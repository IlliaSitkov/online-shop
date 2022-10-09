package com.example.onlineshop.services.implementations;

import com.example.onlineshop.mapstruct.dtos.order.OrderReportData;
import com.example.onlineshop.mapstruct.dtos.product.ProductReportData;
import com.example.onlineshop.repositories.OrderRepository;
import com.example.onlineshop.repositories.ProductRepository;
import com.example.onlineshop.repositories.queryinterfaces.OrderGroupReportValues;
import com.example.onlineshop.repositories.queryinterfaces.OrderReportValues;
import com.example.onlineshop.repositories.queryinterfaces.ProductReportValues;
import com.example.onlineshop.services.interfaces.ReportService;
import com.example.onlineshop.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class ReportServiceImpl implements ReportService {

    private final Utils utils;

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    @Autowired
    public ReportServiceImpl(Utils utils, OrderRepository orderRepository, ProductRepository productRepository) {
        this.utils = utils;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderReportData getOrderReportData(String dateStart, String dateEnd) {
        LocalDate localDateStart = dateStart == null || dateStart.isEmpty() ? utils.convertToLocalDateViaInstant(orderRepository.getMinDate()) : LocalDate.parse(dateStart);
        LocalDate localDateEnd = dateEnd == null || dateEnd.isEmpty() ? utils.convertToLocalDateViaInstant(orderRepository.getMaxDate()): LocalDate.parse(dateEnd);

        localDateStart = localDateStart.atStartOfDay().toLocalDate();
        localDateEnd = localDateEnd.atTime(LocalTime.MAX).toLocalDate();

        Date dStart = utils.convertToDateViaSqlTimestamp(localDateStart);
        Date dEnd = utils.convertToDateViaSqlTimestamp(localDateEnd);

        OrderReportData data = new OrderReportData();
        data.setOrderReportValues(orderRepository.getOrderReportValues(localDateStart, localDateEnd));
        data.setOrderGroupReportValues(orderRepository.getOrderGroupReportValues(localDateStart, localDateEnd));
        data.setFullIncome(orderRepository.getFullIncome(localDateStart, localDateEnd));
        data.setDateStart(dStart);
        data.setDateEnd(dEnd);
        data.setOrdersQuantity(orderRepository.getOrdersNum(localDateStart, localDateEnd));
        data.setAverageOrderCost(orderRepository.getAvgOrderCost(localDateStart, localDateEnd));

        System.out.println(data);

        return data;
    }

    public ProductReportData getProductReportData(String dateStart, String dateEnd) {
        LocalDate localDateStart = dateStart == null || dateStart.isEmpty() ? utils.convertToLocalDateViaInstant(orderRepository.getMinDate()) : LocalDate.parse(dateStart);
        LocalDate localDateEnd = dateEnd == null || dateEnd.isEmpty() ? utils.convertToLocalDateViaInstant(orderRepository.getMaxDate()): LocalDate.parse(dateEnd);

        localDateStart = localDateStart.atStartOfDay().toLocalDate();
        localDateEnd = localDateEnd.atTime(LocalTime.MAX).toLocalDate();

        Date dStart = utils.convertToDateViaSqlTimestamp(localDateStart);
        Date dEnd = utils.convertToDateViaSqlTimestamp(localDateEnd);

        ProductReportData data = new ProductReportData();
        data.setProductReportValues(productRepository.productReport(localDateStart, localDateEnd));
        data.setSoldProductsQuantity(productRepository.getSoldProductsQuant(localDateStart, localDateEnd));
        data.setDateStart(dStart);
        data.setDateEnd(dEnd);

        System.out.println(data);

        return data;
    }





}