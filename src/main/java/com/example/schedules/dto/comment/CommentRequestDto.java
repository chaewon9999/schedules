package com.example.schedules.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {

    private Long userId;

    private Long scheduleId;

    @NotBlank(message = "내용을 입력해주세요.")
    private final String comment;

    private final LocalDateTime time;

    public CommentRequestDto(Long userId, Long scheduleId, String comment, LocalDateTime time) {
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.comment = comment;
        this.time = time;
    }
}
