package com.faboda.query.service;

import com.faboda.query.auth.AuthenticationResponse;
import com.faboda.query.model.User;
import com.faboda.query.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    private  JwtService jwtService;


    public AuthenticationResponse saveUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);


        } catch (Exception e) {
            System.out.println(user.toString());
        }

        var jwToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwToken)
                .build();
    }

    public String getUser(User user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return SecurityContextHolder.getContext().toString();

    }

    public User getByUsername(String username) {
        User user = userRepository.findByUserName(username);
        if (username == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;

    }

}
