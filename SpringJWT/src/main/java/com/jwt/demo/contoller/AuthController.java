package com.jwt.demo.contoller;

import com.jwt.demo.auth.TokenManager;
import com.jwt.demo.contoller.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try {
            authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()));
        }catch (Exception e){
            throw e;
        }
    }

}
