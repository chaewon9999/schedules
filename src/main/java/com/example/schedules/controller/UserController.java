package com.example.schedules.controller;

import com.example.schedules.dto.user.UserRequestDto;
import com.example.schedules.dto.user.UserResponseDto;
import com.example.schedules.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserRequestDto requestDto) {

        UserResponseDto savedUser = userService.signUp(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail()
        );

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
