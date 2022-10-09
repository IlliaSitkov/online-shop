package com.example.onlineshop.services.interfaces;


import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.CustomerFilterBoundsDto;
import com.example.onlineshop.models.Customer;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer save(Customer customer);

    Customer update(Long id, Customer salesman);

    boolean delete(Long id);

//    CustomerGetDto saveCustomerPostDto(CustomerPostDto customerPostDto);

    CustomerFilterBoundsDto getCustomerFilterBounds();

    Iterable<Customer> getFilteredCustomers(int overallProdQuant, int avgOrderCost, long customerId, long productId, int boughtTimes);


    boolean existsByEmail(String email);

    Customer findByEmail(String email);

    Customer findById(Long customerId);
}
