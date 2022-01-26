package com.resttemplate.springresttemplate.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class RestClientController {

    private static final String urlForRunningDocker = "http://localhost:8080/message";

    private final RestTemplate restTemplate;

    @GetMapping("/test")
    public ResponseEntity<String> getPersonList(){
        ResponseEntity<String> result = restTemplate.getForEntity(urlForRunningDocker,String.class);
        System.out.println(result);
        return result;
    }

}
