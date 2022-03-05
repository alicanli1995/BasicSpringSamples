package com.jwt.demo.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class JwtTokenFiler extends OncePerRequestFilter {

    private final TokenManager tokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        /**
         *  "Bearer 123123123"
         */
        final String authHeader = httpServletRequest.getHeader("Authorization");

        String token = null;
        String username = null;

        if(authHeader!=null && authHeader.contains("Bearer")){
            token = authHeader.substring(7);
            try{
                 username = tokenManager.getUsernameToken(token);
            } catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
        if(username != null && token != null && SecurityContextHolder.getContext().getAuthentication() == null){
            if(tokenManager.tokenValidate(token)){
                UsernamePasswordAuthenticationToken upassToken =
                        new UsernamePasswordAuthenticationToken(username,null,new ArrayList<>());
                upassToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(upassToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
