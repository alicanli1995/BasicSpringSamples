package com.flyway.springflyway.controller;


import com.flyway.springflyway.dto.UserDto;
import com.flyway.springflyway.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDto userDto;

    @GetMapping
    public List<User> getAllUsers(){
        return userDto.findAll();
    }
}
