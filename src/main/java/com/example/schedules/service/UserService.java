package com.example.schedules.service;

import com.example.schedules.dto.schedule.ScheduleResponseDto;
import com.example.schedules.dto.user.UserRequestDto;
import com.example.schedules.dto.user.UserResponseDto;
import com.example.schedules.entity.User;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public UserResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getCreatedAt());
    }

    //유저 전체 조회
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::allDto)
                .toList();
    }

    //특정 유저 조회
    public UserResponseDto findById(Long id) {

        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Dose not exists id = " + id
                ));

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

    //유저 정보 수정
    public UserResponseDto update(Long id, UserRequestDto requestDto) {

        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Does not exists id = " + id
                )
        );

        user.update(requestDto);

        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getUpdatedAt()
        );
    }
}
