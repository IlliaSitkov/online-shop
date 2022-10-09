package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.SalesmanFilterBoundsDto;
import com.example.onlineshop.mapstruct.dtos.salesman.SalesmanGetDto;
import com.example.onlineshop.mapstruct.dtos.salesman.SalesmanPostDto;
import com.example.onlineshop.models.Salesman;

public interface SalesmanService {

    Iterable<Salesman> findAll();

    Salesman findById(Long id);

    Salesman save(Salesman salesman);

    Salesman update(Long id, Salesman salesman);

    boolean existsByEmail(String email);

//    Iterable<Salesman> haveGEDoneOrderQuantity(int quantity);

    boolean delete(Long id);

    SalesmanGetDto saveSalesmanPostDto(SalesmanPostDto salesmanPostDto);

    SalesmanFilterBoundsDto getSalesmanFilterBounds();

    Iterable<Salesman> getFilteredSalesmen(double income,int orders,boolean hasAllCategories);


    Salesman findByEmail(String email);
}
