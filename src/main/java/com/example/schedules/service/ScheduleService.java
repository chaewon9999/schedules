package com.example.schedules.service;

import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.entity.Schedule;
import com.example.schedules.entity.User;
import com.example.schedules.repository.ScheduleRepository;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents(), savedSchedule.getUsername());
    }

    //전체 조회
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::allDto)
                .toList();
    }
}
