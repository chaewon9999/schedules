package com.example.schedules.dto.user;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final LocalDateTime createTime;

    public UserResponseDto(Long id, String username, String email, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createTime = createTime;
    }

}
