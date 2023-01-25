package com.faboda.query.controller;

import com.faboda.query.model.Post;
import com.faboda.query.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post/{id}")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    private ResponseEntity<String> post(@PathVariable Integer id, @RequestBody @Validated Post post){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var ps = postService.publishPost(id,post);

        return ResponseEntity.ok(ps.toString()+" : "+authentication.toString());

    }
}
