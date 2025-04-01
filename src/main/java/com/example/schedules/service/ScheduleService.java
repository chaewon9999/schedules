package com.example.schedules.service;

import com.example.schedules.dto.schedule.ScheduleRequestDto;
import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;
import com.example.schedules.entity.User;
import com.example.schedules.repository.ScheduleRepository;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    /**
     * 할일 생성
     * user 레파지토리를 통해 등록되어있는 유저인지 검증 후 등록되지 않는 회원이라면 로그인 화면 유도
     */
    public ScheduleResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findByNameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents, username);
        schedule.setUser(findUser);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getUsername()
        );
    }

    //전체 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::allDto)
                .toList();
    }

    //특정 id로 조회
    public ScheduleResponseDto findById(Long id) {
        Schedule findSchedule = scheduleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Does not exists id = " + id
                ));

        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getContents(),
                findSchedule.getUsername()
        );
    }

    //할일 수정
    public ScheduleResponseDto update(Long id, ScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Does not exists id = " + id
                )
        );

        schedule.update(requestDto.getTitle(), requestDto.getContents(), requestDto.getUsername());

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getUsername()
        );
    }

    //할일 삭제
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Does not exists id = " + id
                )
        );

        scheduleRepository.delete(schedule);
    }
}
