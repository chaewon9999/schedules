package com.example.schedules.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {

    @NotBlank(message = "제목을 입력해주세요.")
    @Size(max = 10, message = "제목은 10글자를 넘어갈 수 없습니다.")
    private final String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private final String contents;

    private final String username;

    private final LocalDateTime time;

    public ScheduleRequestDto(String title, String contents, String username, LocalDateTime time) {
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.time = time;
    }
}
