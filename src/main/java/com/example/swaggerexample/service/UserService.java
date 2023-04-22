package com.example.swaggerexample.service;

import com.example.swaggerexample.dto.NewUserDto;
import com.example.swaggerexample.dto.UserDto;
import com.example.swaggerexample.dto.UserInfoDto;

import java.util.List;

public interface UserService {

    UserDto create(NewUserDto newUserDto);

    List<UserInfoDto> getAll();

    UserDto get(Long id);

    void delete(Long id);

    UserDto getByEmail(String email);
}
