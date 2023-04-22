package com.example.swaggerexample.web;

import com.example.swaggerexample.dto.NewUserDto;
import com.example.swaggerexample.dto.UserDto;
import com.example.swaggerexample.dto.UserInfoDto;
import com.example.swaggerexample.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Validated NewUserDto newUserDto) {
        return userService.create(newUserDto);
    }

    @GetMapping
    public List<UserInfoDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public UserDto getById(@PathVariable Long id) {
        return userService.get(id);
    }

    @DeleteMapping("/user/{id}")
    @Operation(description = "API for Delete user by userID")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
