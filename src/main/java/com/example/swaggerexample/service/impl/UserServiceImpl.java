package com.example.swaggerexample.service.impl;

import com.example.swaggerexample.dto.NewUserDto;
import com.example.swaggerexample.dto.UserDto;
import com.example.swaggerexample.dto.UserInfoDto;
import com.example.swaggerexample.entity.User;
import com.example.swaggerexample.exception.UserNotFoundException;
import com.example.swaggerexample.repository.UserRepository;
import com.example.swaggerexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto create(NewUserDto newUserDto) {
        User user = modelMapper.map(newUserDto, User.class);

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserInfoDto> getAll() {
        var users = (List<User>) userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserInfoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto get(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with this id not found!"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with this mail not found!"));
        return modelMapper.map(user, UserDto.class);
    }
}
