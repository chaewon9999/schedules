package com.example.schedules.service;

import com.example.schedules.dto.comment.CommentRequestDto;
import com.example.schedules.dto.comment.CommentResponseDto;
import com.example.schedules.entity.Comment;
import com.example.schedules.entity.Schedule;
import com.example.schedules.entity.User;
import com.example.schedules.repository.CommentRepository;
import com.example.schedules.repository.ScheduleRepository;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto create(CommentRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(requestDto.getUserId());
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(requestDto.getScheduleId());


        Comment comment = new Comment(requestDto);
        comment.setUser(user);
        comment.setSchedule(schedule);

        Comment savedComment = commentRepository.save(comment);

        return new CommentResponseDto(savedComment);
    }
}
