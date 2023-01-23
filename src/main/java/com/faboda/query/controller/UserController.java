package com.faboda.query.controller;

import com.faboda.query.model.User;
import com.faboda.query.repository.UserRepository;
import com.faboda.query.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("signup")
    public ResponseEntity<String> signUp(@RequestBody @Validated User user){
        userService.saveUser(user);
        return ResponseEntity.ok(user.getUserName());
    }

    @PostMapping("signin")
    public ResponseEntity<String> signIn(@RequestBody @Validated User user){

        return ResponseEntity.ok(userService.getUser(user));
    }

}
