package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.customer.CustomerGetDto;
import com.example.onlineshop.mapstruct.dtos.customer.CustomerPostDto;
import com.example.onlineshop.mapstruct.dtos.customer.CustomerPutDto;
import com.example.onlineshop.mapstruct.dtos.customer.CustomerSlimGetDto;
import com.example.onlineshop.models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerGetDto customerToCustomerGetDto(Customer customer);

    Iterable<CustomerGetDto> customersToCustomersGetDto(Iterable<Customer> customers);

    CustomerSlimGetDto customerToCustomerSlimGetDto(Customer customer);

    Iterable<CustomerSlimGetDto> customersToCustomersSlimGetDto(Iterable<Customer> customers);

    Customer customerPostDtoToCustomer(CustomerPostDto customerPostDto);

    Customer customerPutDtoToCustomer(CustomerPutDto customerPutDto);

}
