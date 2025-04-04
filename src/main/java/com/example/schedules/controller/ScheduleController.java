package com.example.schedules.controller;

import com.example.schedules.dto.schedule.ScheduleRequestDto;
import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.service.ScheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 할일 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@Valid @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto responseDto = scheduleService.save(requestDto);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    //전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    //특정 id 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findByUsername(@PathVariable Long id) {

        ScheduleResponseDto responseDto = scheduleService.findById(id);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //특정 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @Valid @RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto updatedSchedule = scheduleService.update(id, requestDto);

        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }

    //할일 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }
}
