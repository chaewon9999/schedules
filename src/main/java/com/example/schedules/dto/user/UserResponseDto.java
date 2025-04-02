package com.example.schedules.dto.user;

import com.example.schedules.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String username;

    private final String email;

    private final LocalDateTime time;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.time = user.getCreatedAt();
    }

    public static UserResponseDto allDto(User user) {
        return new UserResponseDto(user);
    }
}
