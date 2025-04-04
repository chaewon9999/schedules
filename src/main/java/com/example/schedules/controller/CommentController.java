package com.example.schedules.controller;

import com.example.schedules.dto.comment.CommentRequestDto;
import com.example.schedules.dto.comment.CommentResponseDto;
import com.example.schedules.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //댓글 생성
    @PostMapping
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentRequestDto requestDto) {

        CommentResponseDto commentResponseDto = commentService.create(requestDto);

        return new ResponseEntity<>(commentResponseDto, HttpStatus.CREATED);
    }

    //전체 댓글 조회
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> findAll() {

        List<CommentResponseDto> findedAll = commentService.findAll();

        return new ResponseEntity<>(findedAll, HttpStatus.OK);
    }

    //특정 댓글 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id) {

        CommentResponseDto findedById = commentService.findById(id);

        return new ResponseEntity<>(findedById, HttpStatus.OK);
    }

    //댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> update(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {

        CommentResponseDto update = commentService.update(id, requestDto);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    //댓글 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        commentService.delete(id);
    }
}
