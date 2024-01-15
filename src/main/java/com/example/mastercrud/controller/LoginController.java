package com.example.mastercrud.controller;

import com.example.mastercrud.classes.Token;
import com.example.mastercrud.model.LoginRequest;
import com.example.mastercrud.model.LoginResponse;
import com.example.mastercrud.model.User;
import com.example.mastercrud.repository.TokenRepository;
import com.example.mastercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());

        if (user != null && user.getPassword().equals(request.getPassword())) {
            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setUserId(user.getId());
            tokenRepository.save(token);
            return ResponseEntity.ok(new LoginResponse(user.getName()));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}