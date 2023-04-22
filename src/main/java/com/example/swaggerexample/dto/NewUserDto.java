package com.example.swaggerexample.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewUserDto {
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Size(min = 6)
    private String password;
    private String phoneNumber;
    @Min(1)
    private int age;
    private boolean isMarried;
    private String job;
}
