package com.example.onlineshop.services.interfaces;

import com.databases.shop.mapstruct.dtos.user.UserGetDto;

public interface UserService {


    UserGetDto findUserByEmail(String email);

}
