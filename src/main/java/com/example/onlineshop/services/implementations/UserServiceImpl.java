package com.example.onlineshop.services.implementations;

import com.example.onlineshop.exceptions.user.NoUserWithSuchEmailException;
import com.example.onlineshop.mapstruct.dtos.user.UserGetDto;
import com.example.onlineshop.mapstruct.mappers.UserMapper;
import com.example.onlineshop.services.interfaces.CustomerService;
import com.example.onlineshop.services.interfaces.SalesmanService;
import com.example.onlineshop.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private SalesmanService salesmanService;

    private CustomerService customerService;

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(SalesmanService salesmanService, CustomerService customerService,UserMapper userMapper) {
        this.salesmanService = salesmanService;
        this.customerService = customerService;
        this.userMapper = userMapper;
    }

    @Override
    public UserGetDto findUserByEmail(String email) {

        if (salesmanService.existsByEmail(email)) {
            return userMapper.salesmanToUserGetDto(salesmanService.findByEmail(email));
        } else if (customerService.existsByEmail(email)) {
            return userMapper.customerToUserGetDto(customerService.findByEmail(email));
        }
        throw new NoUserWithSuchEmailException(email);
    }
}
