package com.example.onlineshop.controllers;

import com.example.onlineshop.mapstruct.dtos.order.OrderReportData;
import com.example.onlineshop.mapstruct.dtos.product.ProductReportData;
import com.example.onlineshop.repositories.OrderRepository;
import com.example.onlineshop.repositories.queryinterfaces.OrderReportValues;
import com.example.onlineshop.services.interfaces.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Date;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@Validated
@RequestMapping("/statistics")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/orders")
    public OrderReportData getOrdersReportData(@RequestParam(value = "dateStart", required = false) String dateStart, @RequestParam(value = "dateEnd",required = false) String dateEnd) {
        return reportService.getOrderReportData(dateStart, dateEnd);
    }

    @GetMapping("/products")
    public ProductReportData getProductReportData(@RequestParam(value = "dateStart", required = false) String dateStart, @RequestParam(value = "dateEnd",required = false) String dateEnd) {
        return reportService.getProductReportData(dateStart, dateEnd);
    }


}
