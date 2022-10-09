package com.example.onlineshop.mapstruct.mappers;

import com.example.onlineshop.mapstruct.dtos.user.UserGetDto;
import com.example.onlineshop.models.Customer;
import com.example.onlineshop.models.Salesman;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserGetDto salesmanToUserGetDto(Salesman salesman);
    UserGetDto customerToUserGetDto(Customer salesman);


}
