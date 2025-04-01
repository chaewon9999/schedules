package com.example.schedules.dto.schedule;

import com.example.schedules.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    private final String username;

    private final LocalDateTime createTime;

    public ScheduleResponseDto(Long id, String title, String contents, String username, LocalDateTime createTime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.createTime = createTime;
    }

    public static ScheduleResponseDto allDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUsername(),
                schedule.getCreatedAt()
        );
    }
}
