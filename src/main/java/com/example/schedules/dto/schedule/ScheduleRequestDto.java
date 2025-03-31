package com.example.schedules.dto.schedule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    @NotBlank
    @Size(max = 10)
    private final String title;

    @NotBlank
    private final String contents;

    private final String username;

    public ScheduleRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}
