package com.example.schedules.controller;

import com.example.schedules.dto.schedule.ScheduleRequestDto;
import com.example.schedules.dto.schedule.ScheduleResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @PathVariable ScheduleRequestDto dto) {

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
