package com.faboda.query.controller;

import com.faboda.query.model.Comment;
import com.faboda.query.repository.CommentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/{id}/comment")
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping
    private ResponseEntity<String> comment(@Validated @RequestBody Comment comment){
        return ResponseEntity.ok(comment.toString());
    }
}
