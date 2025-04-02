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

    public UserResponseDto(Long id, String username, String email, LocalDateTime time) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.time = time;
    }

    public static UserResponseDto allDto(User user) {

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
