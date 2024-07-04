package com.misha.pushka.mysimpleblog.controller;

import com.misha.pushka.mysimpleblog.dto.UserCreateDto;
import com.misha.pushka.mysimpleblog.dto.UserGetDto;
import com.misha.pushka.mysimpleblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserGetDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("v1/create")
    public void createUser(@RequestBody UserCreateDto user) {
        userService.createUser(user);
    }



}
