package com.example.onlineshop.services.interfaces;

import com.example.onlineshop.mapstruct.dtos.user.UserGetDto;

public interface UserService {


    UserGetDto findUserByEmail(String email);

}
