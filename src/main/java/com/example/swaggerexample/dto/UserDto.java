package com.example.swaggerexample.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private int age;
    private boolean isMarried;
    private String job;
}
