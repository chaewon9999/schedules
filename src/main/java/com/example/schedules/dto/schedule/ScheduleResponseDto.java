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

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.username = schedule.getUsername();
        this.createTime = schedule.getCreatedAt();
    }

    public static ScheduleResponseDto allDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule);
    }
}
