package com.example.schedules.entity;

import com.example.schedules.dto.comment.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "comment")
public class Comment extends LocalTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String comment;

    @Setter
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Comment(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }

    public Comment() {

    }

    public Comment update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}
