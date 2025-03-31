package com.example.schedules.dto.user;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank(message = "이름을 입력해주세요.")
    @Size(max = 5, message = "이름은 5글자 이내여야합니다")
    private String username;

    @NotBlank (message = "비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 값에 오류가 있습니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",message = "이메일 값에 오류가 있습니다.")
    private String email;

    public UserRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
