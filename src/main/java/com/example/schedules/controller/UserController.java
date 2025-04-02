package com.example.schedules.controller;

import com.example.schedules.dto.user.UserRequestDto;
import com.example.schedules.dto.user.UserResponseDto;
import com.example.schedules.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserRequestDto requestDto) {

        UserResponseDto savedUser = userService.signUp(
                requestDto.getUsername(),
                requestDto.getPassword(),
                requestDto.getEmail()
        );

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //전체 유저 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll() {

        List<UserResponseDto> findAllUser = userService.findAll();

        return new ResponseEntity<>(findAllUser,HttpStatus.OK);
    }

    //특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto findedById = userService.findById(id);

        return new ResponseEntity<>(findedById, HttpStatus.OK);
    }

    //유저 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {

        UserResponseDto updatedUser = userService.update(id, requestDto);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //유저 정보 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        userService.delete(id);
    }
}
