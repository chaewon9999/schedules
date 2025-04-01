package com.example.schedules.controller;

import com.example.schedules.dto.schedule.ScheduleRequestDto;
import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 할일 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto responseDto = scheduleService.save(
                requestDto.getTitle(),
                requestDto.getContents(),
                requestDto.getUsername()
        );

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

}
