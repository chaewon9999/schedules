package com.example.schedules.dto.comment;

import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.entity.Comment;
import com.example.schedules.entity.Schedule;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private final Long id;

    private final String comment;

    private final Long userid;

    private final Long scheduleid;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.userid = comment.getUser().getId();
        this.scheduleid = comment.getSchedule().getId();
    }

    public static CommentResponseDto allDto(Comment comment) {
        return new CommentResponseDto(comment);
    }
}
