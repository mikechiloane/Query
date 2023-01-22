package com.faboda.query.controller;

import com.faboda.query.model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @PostMapping
    private ResponseEntity<String> comment(@Validated @RequestBody Comment comment){

        return ResponseEntity.ok(comment.toString());
    }
}
