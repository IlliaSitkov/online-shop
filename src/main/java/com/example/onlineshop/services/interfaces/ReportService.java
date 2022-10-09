package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.order.OrderReportData;
import com.example.onlineshop.mapstruct.dtos.product.ProductReportData;

public interface ReportService {

    OrderReportData getOrderReportData(String dateStart, String dateEnd);
    public ProductReportData getProductReportData(String dateStart, String dateEnd);

}
