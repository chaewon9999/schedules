package com.example.schedules.repository;

import com.example.schedules.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);

    default User findByNameOrElseThrow(String username) {
        return findByName(username).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "존재하지 않는 아이디입니다."
                )
        );
    }
}
