package com.example.schedules.dto.user;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank
    @Size(max = 5)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;

    public UserRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
