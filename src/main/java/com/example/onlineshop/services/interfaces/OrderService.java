package com.example.onlineshop.services.interfaces;


import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.OrderFilterBoundsDto;
import com.example.onlineshop.mapstruct.dtos.order.OrderPostDto;
import com.example.onlineshop.models.Order;

import java.util.List;

public interface OrderService {

//    Iterable<Customer> findAll();
//
//    Customer save(Customer customer);
//
//    Customer update(Long id, Customer salesman);
//
//    boolean delete(Long id);

//    CustomerGetDto saveCustomerPostDto(CustomerPostDto customerPostDto);

    OrderFilterBoundsDto getOrderFilterBounds(Long customerId, Long salesmanId);

    Iterable<Order> getFilteredOrders(List<String> statuses,
                                      int prodNameNum,
                                      int categNum,
                                      double orderCost,
                                      String date,
                                      boolean dateFilterEnabled,
                                      long salesmanId,
                                      long customerId,
                                      long providerIdBad,
                                      long orderId,
                                      long providerId,
                                      int prodNumK);


    Iterable<Order> findAll();

    Order findById(Long id);

    void deleteById(Long id);

    Order findByCustomerEmail(String email);

    Order buyOrder(Long orderId);

    Order save(OrderPostDto orderPostDto);

    Order markOrderAsDone(Long orderId, Long salesmanId);
}
