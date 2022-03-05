package com.jwt.demo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private Map<String ,String > users = new HashMap<>();
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDetailsService(@Lazy BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostConstruct
    public void init() {
        var pass =
                bCryptPasswordEncoder.encode("123");
        users.put("alicanli1995",pass);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)){
            return new User(username,users.get(username), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }

}

