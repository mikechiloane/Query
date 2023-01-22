package com.faboda.query.controller;

import com.faboda.query.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {


    @GetMapping
    private ResponseEntity<String> post(@RequestBody @Validated Post post){

        return ResponseEntity.ok("hey this is the post");

    }
}
