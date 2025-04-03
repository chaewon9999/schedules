package com.example.schedules.service;

import com.example.schedules.dto.user.LoginRequestDto;
import com.example.schedules.dto.user.UserRequestDto;
import com.example.schedules.dto.user.UserResponseDto;
import com.example.schedules.entity.User;
import com.example.schedules.exception.customException.InvalidPasswordException;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public UserResponseDto signUp(UserRequestDto requestDto) {

        User user = new User(requestDto);

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser);
    }

    //로그인
    public UserResponseDto login(LoginRequestDto requestDto) {

        User user = userRepository.findByEmailOrElseThrow(requestDto.getEmail());

        if (!user.getPassword().equals(requestDto.getPassword())) {
            throw new InvalidPasswordException("잘못된 비밀번호입니다.");
        }

        return new UserResponseDto(user);
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

        User user = userRepository.findByIdOrElseThrow(id);

        return new UserResponseDto(user);
    }

    //유저 정보 수정
    public UserResponseDto update(Long id, UserRequestDto requestDto) {

        User user = userRepository.findByIdOrElseThrow(id);

        user.update(requestDto);
        userRepository.save(user);

        return new UserResponseDto(user);
    }

    //유저 삭제
    public void delete(Long id) {

        User user = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(user);
    }
}
