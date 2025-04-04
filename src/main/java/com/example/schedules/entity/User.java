package com.example.schedules.entity;

import com.example.schedules.dto.user.UserRequestDto;
import com.example.schedules.dto.user.UserResponseDto;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends LocalTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    public User() {

    }

    public void update(UserRequestDto requestDto, String encodedPassword) {
        this.username = requestDto.getUsername();
        this.password = encodedPassword;
        this.email = requestDto.getEmail();
    }

    public User(UserRequestDto requestDto, String encodedPassword) {
        this.username = requestDto.getUsername();
        this.password = encodedPassword;
        this.email = requestDto.getEmail();
    }
}
